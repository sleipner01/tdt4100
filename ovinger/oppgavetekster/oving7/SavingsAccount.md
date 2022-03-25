# Arv - SavingsAccount-oppgave

Denne oppgaven handler om å lage en felles superklasse `SavingsAccount` for
`BSU`- og `ForeldreSpar`-klassene. `SavingsAccount` skal dessuten implementere
`Account`-grensesnittet.

Denne oppgaven bygger videre på `Account`-oppgavene fra
[øving 2](../oving2/Account.md) og [øving 1](../oving1/Account.md).

### Del 1 - SavingsAccount implements Account

En bank består av mange ulike type kontoer: sparekontoer, brukskontoer,
depositumskontoer, støttekontoer etc. Felles for alle kontoer er
`Account`-grensesnittet, som er definert under:

```java
package oving7;

public interface Account {
    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();
}
```

Vi skal i denne oppgaven fokusere på sparekontoer og du skal nå lage en
`SavingsAccount`-superklasse, som implementerer `Account`-grensesnittet.
Funksjonaliteten som hver av metodene definert i grensesnittet over skal
støtte er:

- `void deposit(double)` - øker kontobalansen med innskutt beløp. Merk at det
  innskutte beløpet må være positivt. Ved ulovlig innskudd skal en
  `IllegalArgumentException` utløses.
- `void withdraw(double)` - minsker kontobalansen med beløpet som blir tatt ut.
  Merk at uttaksbeløpet må være positivt, ellers skal et unntak av typen
  `IllegalArgumentException` utløses. Dersom det ikke er dekning på kontoen
  (en `SavingsAccount` kan ikke ha negativ balanse) skal et unntak av typen
  `IllegalStateException` utløses.
- `double getbalance()` - returnerer kontobalansen.

I tillegg til å støtte `Account`-grensesnittet over, som er felles for alle
kontoer, skal sparekontoer ha en rentefot og en metode som forrenter kontoen.
Denne kalles av bankene for hver sparekonto på slutten av året slik at alle
dets kunder opptjener renter (ikke tenk på at banker egentlig holder styr på
hvor stor balansen har vært gjennom hele året eller forrenter kontoen
kontinuerlig - her skal vi bare anta at innestående kontobalanse ved årsslutt
forrentes i sin helhet) - derfor heter metoden `endYearUpdate()`. I tillegg
skal `SavingsAccount`-klassen ha en konstruktør som tvinger alle objekter
av denne typen til å bli instansiert med en rentefot. Dette er oppsummert her:

- `SavingsAccount(double)` - konstruktør som tar inn rentefoten på kontoen
  (et desimaltall, f.eks. 0.05 tilsvarer en rente på 5 %). Åpningsbalansen
  skal være 0.
- `void endYearUpdate()` - forrenter kontobalansen basert på rentefoten.
  Vi tenker oss at denne kalles av kode utenfor denne klassen, f.eks. resten
  av et tenkt banksystem ved årsoppgjør, som et signal på at nå er et nytt år
  over.

Vær oppmerksom på at du i Del 2 og 3 skal lage _subklasser_ av `SavingsAccount`
og at du ved å bruke rett innkapsling (hint: `protected`-modifikatoren) kan la
_subklassene_ nyttiggjøre seg _superklassen_ i størst mulig grad.

Testkode for oppgavene finner du her: [oving7/SavingsAccountTest.java](../../src/test/java/oving7/SavingsAccountTest.java).

### Del 2 - BSU extends SavingsAccount

I tillegg til generelle sparekontoer finnes det en spesiell type sparekonto
som heter BSU. Du skal nå lage en `BSU`-klasse som arver fra
`SavingsAccount`-superklassen. Her er målet at du skal gjenbruke mest mulig
av _superklassen_ og samtidig støtte BSU-spesifikk oppførsel. En BSU-konto er,
i tillegg til å være en sparekonto, spesiell i den forstand at det kun er
lovlig å sette inn inntil et forhåndsbestemt beløp per år
(den gamle regjeringen fastslo at BSU-kontoer i 2014 skulle ha en
innskuddsgrense på kr 25 000, men din kode skal ha støtte for å ha en vilkårlig
grense) og at det kun er lovlig å ta ut av det beløpet som er satt inn siste
år. M.a.o. vil en ved årsskifte få mulighet til å sette inn nye innskudd
innenfor innskuddsgrensen, men en har ikke lenger mulighet til å ta ut hele
balansen (innskudd fra tidligere år låses). Dessuten gir en vanlig BSU-konto
20% skattefradrag for årets innskudd.

Du må selv avgjøre hvilke felt som må legges til for å støtte den beskrevne
oppførsel. I tillegg stilles følgende krav til klassen:

- `BSU(double, double)` - konstruktør som tar inn rentefoten på kontoen og et
  desimaltall som angir hvor mye det er tillatt å sette inn på kontoen per år.
- `double getTaxDeduction()` - returnerer skattefradrag for inneværende år.
  Dette vil være 20% av innskutt(e) beløp siste år.

Testkode for oppgavene finner du her: [oving7/BSUTest.java](../../src/test/java/oving7/BSUTest.java).

### Del 3 - ForeldreSpar extends SavingsAccount

En annen spesiell type sparekonto, her kalt ForeldreSpar, har et begrenset
antall lovlige uttak per år (ofte i bytte mot en høyere rente). Du skal nå
lage en slik `ForeldreSpar`-klasse som arver fra `SavingsAccount`-superklassen.
Her er igjen målet at du skal gjenbruke mest mulig av _superklassen_ og
samtidig støtte ForeldreSpar-spesifikk oppførsel. Denne klassen skal sikre at
kun det lovlige antallet uttak gjøres i løpet av et år.

Du må selv avgjøre hvilke felt som må legges til før å støtte den beskrevne
oppførsel. I tillegg stilles følgende krav til klassen:

- `ForeldreSpar(double, int)` - konstruktør som tar inn rentefoten på kontoen
  og et heltall som angir antall lovlige uttak per år.
- `int getRemainingWithdrawals()` - returnerer antall gjenstående uttak fra
  sparekontoen.

Testkode for oppgavene finner du her: [oving7/ForeldreSparTest.java](../../src/test/java/oving7/ForeldreSparTest.java).
