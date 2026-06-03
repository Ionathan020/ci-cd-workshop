# Level 4 — Toad's Treasure House

#### Doel: Verzamel Toad's schatten en leg ze veilig weg in de Mushroom Central Bank.

#### Daadwerkelijk doel:
- Een build artifact (JAR) produceren met Gradle.
- Het artifact uploaden als GitHub Actions artifact.
- Build parameters gebruik (om dingen zoals de artifact naam te bepalen).

#### Opdracht:
1. Open `.github/workflows/level-4.yml`.
2. Zorg dat je met gradle een JAR produceert in `build/libs/`.
3. Upload de JAR als artifact met een zelf mee te geven naam.

#### Acceptatiecriteria:
- De run bevat een downloadbaar artifact met de JAR.

#### Hints:
- Gebruik van `workflow_dispatch inputs` kan je helpen voor build parameters.
- Spring Boot maakt doorgaans een fat JAR aan: `build/libs/<project>-<version>.jar`.