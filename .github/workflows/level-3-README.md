# Level 3 — Boo's Haunted Mansion

#### Doel: Ontsnap aan Boo's spookhuis met de kracht van Quality Gates.

#### Daadwerkelijk doel:
- Code coverage meten met JaCoCo.
- Een minimale coverage-drempel afdwingen (quality gate)

#### Voorbereiding in Gradle:

Open `build.gradle` en voeg JaCoCo toe:
```
plugins {
    ...
    id 'jacoco'
}
```

Zorg ervoor dat de `gradle test` step eindigt met een TestReport en TestCoverageVerification.

```
tasks.named('test') {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    finalizedBy(tasks.jacocoTestCoverageVerification)
}
```

Opdracht level 3a:
1. Open `.github/workflows/level-3a.yml`.
2. Vervang de TODO's zodat de workflow succesvol draait.
3. Hanteer een Quality Gate in de vorm van een minimale code coverage van **60%** line coverage.
4. Upload de HTML en XML coverage rapporten als artifact voor inspectie.

Opdracht level 3b:
1. Open `.github/workflows/level-3b.yml`.
2. Pas de Quality Gate aan naar een minimale code coverage van net boven het in het rapport vermelde percentage.
3. Run de GitHub Action voor level 3b -> deze zou moeten falen.
4. Schrijf een Unit Test in de `PeachControllerTest` om de nieuwe minimale coverage te halen.
5. Run de GitHub Action voor level 3b opnieuw -> Pipeline slaagt.

Acceptatiecriteria:
- De job faalt wanneer de coverage onder de ingestelde drempel ligt.
- Coverage rapporten zijn te downloaden als artifact.

Hints:
- Maak gebruik van `jacocoTestReport` voor het genereren van rapporten.
- Maak gebruik van `jacocoTestCoverageVerification` voor het bepalen van violationRules
- De `build.gradle` dient uitgebreid te worden met bovenstaande items.
- Exclude de Spring Boot entrypoint van de coverage verificatie (dit kan in `jacocoTestCoverageVerification`).