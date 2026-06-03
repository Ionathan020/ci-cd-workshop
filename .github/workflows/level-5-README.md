# Level 5 — Bowser's Castle

#### Doel: Bestorm Bowser’s kasteel met een Dockerized applicatie.

#### Daadwerkelijk doel:
- Een container image bouwen.
- Image pushen naar GHCR (GitHub Container Registry).
- Uit voeren steps enkel laten draaien op bepaalde branches (`main`).

#### Opdracht:
1. Open `.github/workflows/level-5.yml`.
2. Vervang de TODO's zodat de workflow succesvol draait.
3. Zorg dat je kan inloggen op GHCR, maar doe dit alleen voor de `main` branch.
4. Push de image (wederom enkel op de `main` branch).

#### Acceptatiecriteria:
- De workflow bouwt en pusht een image succesvol (terug te vinden onder Packages in GitHub UI).
- Push vindt alleen plaats op `main` (controleer de logs; op andere branches mag push niet gebeuren).

#### Hints
- Voor GHCR push heb je `packages: write` permissie nodig.
- `GITHUB_TOKEN` is voldoende voor authenticatie naar GHCR binnen dezelfde repo/org.
