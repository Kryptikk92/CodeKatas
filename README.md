# CodeKatas

## [Roman Numbers](src/main/java/de/kryptikk/codekatas/roman)
Small library to convert roman numbers (e.g. "MCMXI") to arabian numbers ("1911").

Roman numbers need to follow conventions, no checking for illegal constellations.

Rules for Roman numbers:
* There are 7 roman literals that correspond to arabian numbers:

	| Roman | Arabian |
	|-------|---------|
	| I     | 1       |
	| V     | 5       |
	| X     | 10      |
	| L     | 50      |
	| C     | 100     |
	| D     | 500     |
	| M     | 1000    |

* Bigger number before smaller number add up, equal numbers also add up:
    *  "CX" => 110
    * "XX" => 20
* Smaller number before bigger number subtract:
    * "XC" => 90
    * "IV" => 4 
* Only 3 of the same kind can be put together: 
    * "MMM" => 3000 (allowed)
    * "XXXX" => 40 (not allowed, use "XL" for that)