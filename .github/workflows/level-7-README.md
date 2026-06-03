# Level 7 — Star Road

Doel (verhaal): Navigeer Star Road: echte productie‑pipelines worden groot, complex en lastig te lezen. Jij gaat een monoliet ontrafelen tot iets leesbaars en onderhoudbaars.

Wat je leert:
- Grote workflows lezen en begrijpen
- Refactoren naar meerdere, duidelijke jobs met `needs`
- Hergebruik via composite actions en (optioneel) reusable workflows (`workflow_call`)
- Best practices: duidelijke namen, minimale permissies, conditionals, artifacts, caching, concurrency

Voorbereiding (zoals in Level 3):
- Zorg dat in `build.gradle` de JaCoCo plugin en XML/HTML rapporten zijn geconfigureerd (zie `level-3-README.md`).

Opdracht:
1. Open `.github/workflows/level-7.yml`. Dit is bewust één grote job met alle stappen (build, test, coverage, artifact, image build/push, caching).
2. Draai de workflow handmatig 1x om gevoel te krijgen bij de stappen en logs.
3. Splits de workflow op in meerdere jobs, bijvoorbeeld:
   - `build-test`: checkout + setup + build + test + JaCoCo rapport + coverage‑gate (via Gradle `jacocoTestCoverageVerification`, bv. met env `JACOCO_MINIMUM_COVERAGE`) + upload van test/coverage rapporten
   - `artifact`: JAR bouwen (zonder tests, bv. `bootJar -x test`) + uploaden als artifact
   - `image`: container image bouwen met een Dockerfile op basis van het artifact; push alléén op `main`
   Gebruik `needs` om de volgorde/afhankelijkheden te bepalen.
   - Opmerking: Een aparte `quality-gate` job mag ook, maar de oplossing voert de coverage‑check uit binnen `build-test`.
4. Verminder duplicatie. Factoriseer gedeelde setup (checkout + JDK + caching + Gradle) in een composite action in `.github/actions/...` en gebruik die in alle jobs.
   - Tip: Kijk naar `actions/checkout@v4`, `actions/setup-java@v4`, `actions/cache@v4`, `gradle/actions/setup-gradle@v4`.
   - Voorbeeldnaam: `.github/actions/setup-java-gradle` (zie oplossing).
5. Implementeer de coverage gate (zoals in Level 3). Je mag óf het JaCoCo XML parsen, óf Gradle’s `jacocoTestCoverageVerification` gebruiken met een drempel (bijv. via env `JACOCO_MINIMUM_COVERAGE`). Upload altijd de rapporten (`if: always()`).
6. Houd permissies minimaal. Voor GHCR push is `packages: write` nodig. Overweeg permissies op job‑niveau alleen voor de image‑job.
7. Zorg dat caching werkt met stabiele keys op basis van `hashFiles(...)` en dat vervolgruns cache hits laten zien.
8. Push de image alléén op `main` (conditioneel via `if: github.ref == 'refs/heads/main'`).

Acceptatiecriteria:
- Functioneel gelijkwaardig aan de monoliet: build + test + coverage gate (≥ drempel) + JAR artifact + image build; push gebeurt alleen op `main`.
- Minder duplicatie door hergebruik (composite action of reusable workflows).
- Workflow is opgesplitst in logische jobs met duidelijke namen en `needs`.
- Caching toont hits op vervolgruns en verkort de buildtijd indicatief.
- Permissies zijn minimaal noodzakelijk; geen onnodige writes.

Hints:
- Caching keys:
  - Wrapper: `${{ runner.os }}-gradle-wrapper-${{ hashFiles('**/gradle/wrapper/gradle-wrapper.properties') }}`
  - Caches: `${{ runner.os }}-gradle-caches-${{ hashFiles('**/*.gradle*', '**/gradle/wrapper/gradle-wrapper.properties', '**/gradle/libs.versions.toml') }}`
- Coverage XML pad: `build/reports/jacoco/test/jacocoTestReport.xml` (`<counter type="LINE" missed=".." covered=".."/>`).
- Artifacts uploaden met `actions/upload-artifact@v4` en `if: always()` voor rapporten.
- Overweeg `concurrency` om dubbele runs op dezelfde branch te annuleren.
 - Image build (zoals in de oplossing): download het JAR‑artifact met `actions/download-artifact@v4` naar de `docker/` map en kopieer naar een vaste naam (bijv. `docker/app.jar`) zodat de Dockerfile eenvoudig kan `COPY`‑en.
 - Coverage gate alternatief: stel `JACOCO_MINIMUM_COVERAGE` in (bijv. `0.60`) en laat Gradle falen onder de drempel.

Stretch goals:
- Reusable workflows: maak `.github/workflows/reusable-*.yml` met `on: workflow_call` en roep ze aan vanuit Level 7.
- Voeg een matrix toe (OS/Java versies) voor `build-test`.
- Voeg environments en approvals toe voor image push (bijv. `staging`/`production`).
- Publiceer ook een `latest` tag naast de SHA‑tag of gebruik semver tags.
- Voeg een eenvoudige SBOM/scan stap toe (bijv. Trivy) als extra kwaliteitscontrole.

Vergelijken met de oplossing:
- Zie `.github/workflows/level-7-solution.yml` voor een concreet voorbeeld met:
  - Jobs: `build-test`, `artifact`, `image` (geen aparte `quality-gate` job; de gate draait binnen `build-test`).
  - Gedeelde setup via composite action: `.github/actions/setup-java-gradle` (JDK + Gradle + caching).
  - Coverage gate via Gradle met `JACOCO_MINIMUM_COVERAGE` (in de oplossing op 60%).
  - Concurrency die gelijktijdige runs op dezelfde branch annuleert.
  - Minimale permissies op workflow‑niveau, met `packages: write` alléén bij de image‑job.
  - Docker image build met een Dockerfile op basis van het gedownloade JAR‑artifact; push gebeurt alleen op `main` en publiceert ook een `latest` tag.