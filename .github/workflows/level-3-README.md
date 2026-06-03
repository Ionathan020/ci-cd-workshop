# Level 3 — Boo's Haunted Mansion

Doel: Ontsnap aan Boo's spookhuis met de kracht van Quality Gates.

Wat je leert:
- Coverage meten met JaCoCo
- Een minimale coverage‑drempel afdwingen (quality gate)

Voorbereiding in Gradle (opdracht):

Open `build.gradle` en voeg JaCoCo toe:
```
plugins {
    ...
    id 'jacoco'
}

tasks.named('test') {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}
```

Opdracht level 3a:
1. Open `.github/workflows/level-3a.yml`.
2. Zorg dat `./gradlew test` succesvol draait en faal de job onder **60%** line coverage.
3. Upload de HTML en XML rapporten als artifact voor inspectie.

Opdracht level 3b:
1. Run de GitHub Action voor level 3b -> Pipeline faalt.
2. Zorg ervoor dat de testen dusdanig worden aangepast dat de **80%** line coverage wordt behaald.
3. Run de GitHub Action voor level 3b opnieuw -> Pipeline slaagt.

Acceptatiecriteria:
- De job faalt wanneer de coverage onder de ingestelde drempel ligt.
- Coverage rapporten zijn te downloaden als artifact.

Hints:
- Maak gebruik van `jacocoTestReport` voor het genereren van rapporten.
- Maak gebruik van `jacocoTestCoverageVerification` voor het bepalen van violationRules
- De `build.gradle` dient uitgebreid te worden met bovenstaande items.
- Exclude the Spring Boot entrypoint from coverage verification