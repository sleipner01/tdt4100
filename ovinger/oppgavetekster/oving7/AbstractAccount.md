# Arv - AbstractAccount-oppgave
Denne oppgaven handler om å lage en felles abstrakt superklasse `AbstractAccount`
for `CreditAccount`, `DebitAccount`- og `SavingsAccount2`-klassene.

Denne oppgaven er en annen variant av
[SavingsAccount](./SavingsAccount.md)-oppgaven, med fokus
på bruk av abstrakte klasser og arv.

### Del 1 - Abstrakt klasse AbstractAccount
En bank består av mange ulike type kontoer: sparekontoer, brukskontoer,
depositumskontoer, støttekontoer etc. Siden disse har mye felles, f.eks.
har alle en balanse, så er det praktisk å samle så mye som mulig av den
felles logikken i en superklasse, som alle kan arve fra. Denne superklassen
er imidlertid ikke noen egen type konto, og derfor gjør vi den abstrakt,
slik at den ikke kan instansieres. De konkrete konto-klassene som arver
fra den, må selvsagt være instansierbare.

Metodene i `AbstractAccount`-klassen, er omtrent de samme som dem vi definerte
i `Account`-grensesnittet i [SavingsAccount](./SavingsAccount.md)-oppgaven,
og er som følger:

* `void deposit(double)` - øker kontobalansen med innskutt beløp. Merk at det
innskutte beløpet må være positivt. Ved ulovlig innskudd skal en
`IllegalArgumentException` utløses.
* `void withdraw(double)` -  Metoden kaller <code>internalWithdraw(<i>uttaksbeløp</i>)</code>,
som implementeres i hver subklasse. Hvis uttaksbeløpet er negativt skal
metoden utløse en `IllegalArgumentException`.
* `abstract void internalWithdraw(double)` - minsker kontobalansen med beløpet
som blir tatt ut. Merk at reglene for uttak er ulik for klassene som
implementerer `AbstractAccount`, og må derfor implementeres i hver klasse.
Hvis det ikke er mulig å ta ut det angitte beløpet skal metoden utløse en
`IllegalStateException`.
* `double getBalance()` - returnerer kontobalansen.

Alle metodene utenom den absktrakte må implementeres. I tillegg må
`AbstractAccount` ha en tilstand *balance* for saldo på kontoen.
Saldoen skal settes til 0 i konstruktøren.

Vær oppmerksom på at du i Del 2 skal lage subklasser av `AbstractAccount`
og at du ved å bruke rett innkapsling (hint: `protected`-modifikatoren) skal
la *subklassene* nyttiggjøre seg *superklassen* i størst mulig grad.


### Del 2 - DebitAccount extends AbstractAccount
En debetkonto er den enkleste formen for konto, hvor det eneste kravet er at
saldoen til enhver tid må være større eller lik 0. `DebitAccount` skal utvide
(arve fra med `extends`) `AbstractAccount` og sikre at saldoen aldri blir
lavere enn 0.

Testkode for oppgavene finner du her: [oving7/DebitAccountTest.java](../../src/test/java/oving7/DebitAccountTest.java). 

### Del 3 - CreditAccount extends AbstractAccount
En `CreditAccount` har i tillegg til *balance* en tilstand for *creditLine*,
altså tilgjengelig kreditt på kontoen. Denne kredittlinjen tillater at kontoen
kan overtrekkes (at saldoen er negativ) innenfor kredittlinjen. Klassen må ha
*tilgangsmetoder* (getters and setters) for *creditLine*. Merk at
kredittlinjen alltid må være større eller lik 0, hvis ikke skal det utløses
en `IllegalArgumentException`. Hvis en ny kredittlinje settes og balansen er
negativ, må den nye kredittlinjen dekke den eksisterende balansen. Ellers skal
det utløses en `IllegalStateException` og ingen endring i kredittlinjen.

Konstruktøren `CreditAccount(double)` skal sette kredittlinjen.

Testkode for oppgavene finner du her: [oving7/CreditAccountTest.java](../../src/test/java/oving7/CreditAccountTest.java). 

### Del 4 - SavingsAccount2 extends AbstractAccount
En `SavingsAccount2` (*merk at navnet er endret, for ikke å kræsje med
SavingsAccount-klassen fra den tidligere oppgaven!*) kan kun ha positiv saldo.
I tillegg har kontoen uttaksbegrensinger. En `SavingsAccount2` har *x* antall
*uttak* (**withdrawals**). Dersom man ønsker å ta ut penger etter alle uttak er
brukt opp, skal saldoen belastes med et *gebyr* (**fee**). Både **withdrawals**
(antall) og **fee** (beløp) settes i konstruktøren `SavingsAccount2(int, double)`.

Testkode for oppgavene finner du her: [oving7/SavingsAccount2Test.java](../../src/test/java/oving7/SavingsAccount2Test.java). 