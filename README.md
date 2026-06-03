# CI/CD workshop Code Foundry

## Build Your Own Pipeline (Mario & Luigi Style)
In deze kennissessie ga je zelfstandig (of samen, you can self bepil) een pipeline opzetten voor een bestaande applicatie.
Het doel is niet alleen om "iets werkend te krijgen", maar om inzicht te krijgen in:
- hoe een CI/CD pipeline is opgebouwd
- welke stappen essentieel zijn
- hoe feedbackloops het beste vormgegeven kunnen worden
- hoe je pipelines onderhoudbaar en betrouwbaar houdt.

De workshop is opgebouwd uit meerdere levels. Elk level bouwt verder op de vorige, maar voel je te allen tijde vrij om zelf los te gaan en te experimenteren. Alle levels en hun voorbeeldoplossingen zijn Mario‑themed, met echte level‑namen uit het Mushroom Kingdom.

### Doel aan het einde
Je pipeline:
- draait automatisch bij een push of PR
- buildt de applicatie
- voert tests uit en faalt bij fouten
- hanteert een quality gate (coverage)
- bouwt en archiveert een artifact
- bouwt een Docker image en pushed conditioneel vanaf `main`
- maakt slim gebruik van caching voor snelheid

### Technische context
#### Applicatie
Dit project bevat een eenvoudige backend applicatie gebouwd met:
- Java 21
- Spring Boot
- Gradle
- (optioneel) Docker

De applicatie bevat o.a.:
- REST endpoints
- Unit tests
- Integration(-like) tests

#### Applicatie lokaal draaien
```shell
./gradlew bootRun
```

#### Tests uitvoeren
```shell
./gradlew test
```

#### Docker image builden (optioneel)
```shell
docker build -t cicd-workshop .
```

---

### Workshop Levels (Mario‑themed)
Alle opdrachten en voorbeeldoplossingen staan in `.github/workflows`.

- Level 1 — Yoshi's Island: Pipeline starten en build draaien
  - Stub: `.github/workflows/level-1.yml`
  - Uitleg: `.github/workflows/level-1-README.md`
  - Oplossing: `.github/workflows/level-1-solution.yml`

- Level 2 — Koopa's Fortress: Tests moeten de build laten falen
  - Stub: `.github/workflows/level-2.yml`
  - Uitleg: `.github/workflows/level-2-README.md`
  - Oplossing: `.github/workflows/level-2-solution.yml`

- Level 3 — Boo's Haunted Mansion: Quality gate met JaCoCo coverage
  - Stub: `.github/workflows/level-3.yml`
  - Uitleg: `.github/workflows/level-3-README.md`
  - Oplossing: `.github/workflows/level-3-solution.yml`

- Level 4 — Toad's Treasure House: Artifact builden en uploaden
  - Stub: `.github/workflows/level-4.yml`
  - Uitleg: `.github/workflows/level-4-README.md`
  - Oplossing: `.github/workflows/level-4-solution.yml`

- Level 5 — Bowser's Castle: Docker image builden (push alleen vanaf main)
  - Stub: `.github/workflows/level-5.yml`
  - Uitleg: `.github/workflows/level-5-README.md`
  - Oplossing: `.github/workflows/level-5-solution.yml`

- Level 6 — Rainbow Road: Speed‑run met caching (Gradle + Docker layers)
  - Stub: `.github/workflows/level-6.yml`
  - Uitleg: `.github/workflows/level-6-README.md`
  - Oplossing: `.github/workflows/level-6-solution.yml`

- Level 7 — Star Road: Monoliet lezen en refactoren naar herbruikbare onderdelen
  - Stub: `.github/workflows/level-7.yml`
  - Uitleg: `.github/workflows/level-7-README.md`
  - Oplossing: `.github/workflows/level-7-solution.yml`

Opmerking: De stub‑workflows zijn opzettelijk incompleet en draaien alleen via `workflow_dispatch` zodat ze niet per ongeluk starten. De oplossing‑workflows gebruiken ook `workflow_dispatch`, met commentaar hoe je een "echte" trigger toevoegt.

### Zo gebruik je de workshop
1. Open per level de `level-x-README.md` voor doel, criteria en hints.
2. Vul de stub `level-x.yml` aan totdat de criteria gehaald worden.
3. Draai de workflow handmatig via het Actions‑tab ("Run workflow").
4. Vergelijk met `level-x-solution.yml` als je vastloopt.


