# Level 2 — Koopa's Fortress

#### Doel: Versla de Koopa‑bewakers met je test‑skills.

#### Daadwerkelijk doel:
- Het uitvoeren van tests in CI.
- Resultaten van de testen verwerken in een test rapport en uploaden ter analyse
- Pipeline failures oplossen middels debugging

#### Opdracht:
1. Open `.github/workflows/level-2.yml`.
2. Vervang de TODO's, zodat de workflow bouw met java 21 & Gradle en dat er een test rapport wordt geupload.
3. Pas de `MarioControllerTest.mario_shouldReturnCatchPhrase()` test aan, zodat deze faalt. 
4. Draai de workflow handmatig via het Actions tab (de workflow zou nu moeten falen).
5. Bekijk het test-rapport, pas de test weer aan, zodat deze slaagt en draai de workflow opnieuw (deze moet nu slagen).

#### Acceptatiecriteria:
- Workflow voert een gradle test command uit.
- Een failing test zorgt dat de job faalt.
- Test rapporten zijn te bekijken/downloaden uit de Actions run (XML + HTML reports).