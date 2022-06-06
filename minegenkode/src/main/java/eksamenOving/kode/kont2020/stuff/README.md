# Småoppgaver
I pakken *stuff* vil du finne en del mindre oppgaver. Disse henger ikke sammen.
De tre deloppgavene gir 10-15%, totalt 40% av eksamen.

## Oppgave 1: Enkel klasseoppbygging og predikater 
I *stuff* finner du skallet til to klasser, Movie og MovieRegister. Les klassebeskrivelsen under nøye.

[Movie](Movie.java) har følgende interne tilstand *(her vil du ikke finne noe beskrivelse i javadocen)*:
- tittelen til filmen. Denne kan ikke være *null*, og skal kunne hentes ut med metoden *getTitle()*.
- hvor mange ganger den er sett, skal kunne hentes ut med metoden *getTimesWatched()*. Økes med en hver gang man har sett filmen, oppdatert med metoden *watch()*.
- hvor god var filmen, heltall fra 1-6. Alle filmer trenger ikke ha en rating. Skal kunne hentes ut med metoden *getRating()*

Det er ikke nødvendig å implementere flere metoder enn de som trengs for fylle kravene gitt over. Main-metoden i Movie viser noen eksempler på bruk av tester mot passende kode.


[MovieRegister](MovieRegister.java) inneholder en samling med *Movie*-objekter. Følgende metoder finnes:
- *addMovie(Movie movie)*: Mulighet til å legge til nytt *Movie*-objekt
- *filterMovies(Predicate pred)*: Returnere filmene som tilfredsstiller kravene beskrevet i predikatet pred.
- *findMovie(String title)*: Returnere filmen med denne tittelen, eller *null* hvis filmen ikke finnes.
- *watch(String title)*: Se filmen med denne tittelen. Øker antallet ganger filmen er sett med 1. Hvis tittelen ikke finnes i registeret skal metoden utløse en *IllegalStateException*.

## Oppgave 2 - testing 
Klassen [AverageComputer](AverageComputer.java) lar en registrere mange heltallsverdier og beregne gjennomsnittet av dem. Det følger med en testklasse, [AverageComputerTest](AverageComputerTest.java), som tester et enkelt tilfelle (beregning av snittet av tallene 3, 4 og 5).

Tilsynelatende virker klassen fint, men den inneholder to feil, den ene knyttet til beregning av gjennomsnitt, den andre til innkapslingen. Ingen av disse fanges opp av testklassen. Oppgaven går ut på å forbedre testklassen slik at begge feilene rapporteres på en hensiktsmessig måte. Du kan endre den eksisterende testmetoden og evt. legge til nye.

## Oppgave 3 - fxml 
Filen [Math.fxml](Math.fxml) definerer et grensesnitt der brukeren skal kunne:
- skrive inn to flyttall i to tekstfelt
- velge en regningsmetode fra en nedtrekksmeny (pluss, minus, gange, dele) 
- trykke på en knapp som så beregner resultatet av regnestykket og skriver svaret inn i et felt
- trykke på en annen knapp som legger inn tilfeldige heltall mellom 1 og 100 i begge tekstfeltene

Du skal gjøre utvidelser og endringer i filen *MathController.java* som gjør at kravene nevnt over oppfylles. Er alle metoder som må finnes allerede definert? Grensesnittet kan sees ved å kjøre filen *MathApp.java*. 

Slik ser FXML-applikasjonen ut:

<img src="Math.jpg" alt="drawing" width="600"/>
