# Level 6 — Rainbow Road

#### Doel: Scheur over Rainbow Road.

#### Daadwerkelijk doel:
- Caching toepassen om builds te versnellen (Gradle wrapper + caches)

#### Opdracht:
1. Open `.github/workflows/level-6.yml`.
2. Vervang de TODO's zodat de workflow succesvol draait.
3. Cache zo veel mogelijk van Gradle.
4. Run de workflow minimaal 2x en vergelijk de build tijd met en zonder cache hit.

#### Acceptatiecriteria:
- Tweede (en volgende) runs tonen een cache‑hit in de Actions logs.
- Build tijd is merkbaar korter bij cache‑hits (indicatief).

#### Hints:
- Gebruik `actions/cache@v4` met stabiele keys en `restore-keys` prefixes.
- Cache paden:
  - `~/.gradle/wrapper`
  - `~/.gradle/caches`, `~/.gradle/daemon`, `~/.gradle/native`, `~/.gradle/notifications`