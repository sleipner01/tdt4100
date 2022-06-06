# Le Petite Chef goes takeaway

Restauranten Le Petite Chef har tilpasset seg de nye tidene. De lager matretter som så selges for å nytes hjemme. På grunn av stadige tilbud for å lokke til seg kunder har de gått over til variable priser på matrettene. Til de som tok eksamen i vår: Det er ingen kodemessig kobling mellom de to eksamenene, annet enn i navnet.

Dette dokumentet beskriver klassene i korte trekk. Vi refererer til dokumentasjonen av metoder og klasser i selve koden for de virkelige kravene om spesifikke metoder etc.

**Viktig**: i pakken *food* vil dere finne en underpakke *food.def*. Her ligger det noen grensesnitt som du bare skal bruke, men ikke endre på. Du vil for eksempel se at klassene *Customer* og Kitchen implementerer grensesnitt som ligger her - dette påvirker ikke deres løsning av oppgavene 2.1 og 2.2. Du vil også finne grensesnittet *PriceProvider* som skal brukes i oppgave 2.3.

**Også viktig**: Oppgave 2.4 - observatør-observert omhandler delvis å implementere en klasse *ObserveToPrintTopRevenue*. Denne klassen kan implementeres uten å ha løst noen av oppgavene 2.1 - 2.3, eller å ha gjort selve observatør-inngrepene i Kitchen. 

## Oppgave 2.1: De enkleste delene: MealOrder og Customer (10%)
- [MealOrder](MealOrder.java): Denne klassen inneholder informasjon om et salg. Den lagrer navnet på retten, og hvilken pris retten ble solgt for. Disse verdiene må kunne hentes ut med metodene *String getMeal()* og *double getPrice()*.

- [Customer](Customer.java): En som kjøper retter. Kunden har et navn, en oversikt over hvilke retter denne har kjøpt og til hvilken pris. Se javadoc i kildekoden for de definerte kravene.

## Oppgave 2.2: Kitchen (20%)
Kjøkket har som nevnt tidligere forenklet oppskriftene siden sist. [Kitchen](Kitchen.java)-objekt har følgende tilstand:
- En samling av oppskrifter. Disse vil innimellom bli referert til som matretter.
- En samling av kunder (fra oppgave 2.1).
- Omsetningen så langt - det betyr summen av alle salg som er gjort til nå.

Følgende metoder eksisterer i Kitchen:
- *provideMeal(String meal, double price, String name)*: Kunden *name* skal registrere kjøp av rett *meal* til pris *price*.
- *addCustomer(Customer customer)*: Legge til en ny kunde. 
- *addRecipe(String recipe)*: Legge til en ny oppskrift.
- *getRecipes()*: Returnere en kopi av oppskriftene som er lagret.
- *getTurnover()*: Returnere omsetningen så langt.
- *getCustomer(String name)*: Returnere kunden med navnet *name*, eller *null* hvis kunden ikke finnes i systemet.

## Oppgave 2.3: Delegering: implements PriceDelegate (15%)
For å finne nye kunder har *Le Petite Chef* begynt med et avansert rabattsystem. Det finnes ulike typer rabatter, som gir prosentavslag på prisen. Tanken er at rabatter kan utløses av mange faktorer, basert på elementene ved salget: *pris*, *kunde* og *oppskrift*. De ulike rabattene teller sammen på følgende måte:
- Gitt at et produkt egentlig skal selges for 100 kroner.
- Rabatt1 gir 20% avslag. Prisen blir da 100 \* 0.8 = 80 kroner.
- Rabatt2 gir 50% avslag. Sluttprisen blir da 80 \* 0.5 = 40 kroner. Legg merke til at rabatt2 tar utgangspunkt i prisen fra rabatt1. De virker altså *oppå hverandre*.


Du skal lage følgende:

- Rabattklassene skal implementere grensesnittet [PriceProvider](def/PriceProvider.java) som du vil finne i pakken *food.def*. Denne skal ikke endres.
- Rabattklassen [RebateEveryFifthBuyFromSameCustomer](RebateEveryFifthBuyFromSameCustomer.java) gir 50% rabatt på hvert femte kjøp, men med rabatt på første kjøp (lokkemiddel). Det betyr at kunden skal få rabatt på kjøp nummer 0, 5, 10, 15 osv.
- Rabattklassen [RebateFreeEveryThousandSale](RebateFreeEveryThousandSale.java) skal gi full rabatt hvert tusende salg, uavhengig av hvilken kunde som har kjøpt rettene. Den skal *ikke* gi rabatt til første salg, men altså for salg 1000, 2000 og så videre.
- Kitchen skal nå kunne legge til og fjerne et vilkårlig antall rabatter. 
- *Kitchen.computeActualPrice(String meal, double price, Customer customer)*: Denne metoden skal gå igjennom alle mulige rabatter som finnes, og returnere faktisk sluttpris. En viktig faktor er at hvis et salg utløser to rabatter, en med 20% avslag og en med 50% avslag, så ganges disse faktorene med hverandre og metoden returnerer 0.4 \* innpris. Eksempel: En matrett til 200 kroner som har to rabatter på 30% og 50% vil ende opp med en sluttpris på 70 kroner. Legg merke til at denne metoden er en hjelpemetode for *provideMeal*. 
- Gjør de nødvendige endringene som trengs i [Kitchen](Kitchen.java) for at vurdering av alle rabatter tas med i registrering av salg.

## Oppgave 2.4: Observatør-observert: (15%)
Nå skal Kitchen utvides til å støtte lyttere:
- Lyttere må implementere grensesnittet *KitchenObserver* som du finner i pakken *food.def*. Dette grensesnittet skal ikke endres!
- Kitchen skal kunne legge til og fjerne lyttere som følger grensesnittet [KitchenObserver](def/KitchenObserver.java), som ligger i pakken 'food.def'.
- Ved et *salg* i Kitchen skal alle lytterne kalles med metoden MealOrder(meal, price). Det er altså kun matrett og faktisk pris etter eventuelle rabatter som skal sendes videre til lytterne.

Du skal også implementere en lytter: klassen [ObserveToPrintTopRevenue](ObserveToPrintTopRevenue.java), med metodene *mealOrder(String meal, double price)* og *getTopSellers()*. Denne klassen skal skrive ut detaljer om *den* eller *de* matrettene som har solgt for høyest totalsum (omsetning) hver gang det skjer et nytt salg.

*Viktig*: Det er ikke nødvendig å ha klart Kitchen eller Recipe-oppgavene for å gjøre denne siste oppgaven - den forholder seg kun til matretter/oppskrifter som strenger og priser som double.
