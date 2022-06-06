# Le Petite Chef goes takeaway

Restauranten Le Petite Chef har tilpassa seg dei nye tidene. Dei lagar matretter som så blir selde for å nytast heime. På grunn av stadige tilbod for å lokka til seg kundar har dei gått over til variable prisar på matrettene. Til dei som tok eksamen i vår: Det er ingen kodemessig kopling mellom dei to eksamenane, anna enn i namnet.

Dette dokumentet beskriv klassane i korte trekk. Vi refererer til dokumentasjonen av metodar og klassar i sjølve koden for dei verkelege krava om spesifikke metodar etc.

**Viktig**: i pakken *food* vil de finna ein underpakke *food.def*. Her ligg det nokre grensesnitt som du berre skal bruka, men ikkje endra på. Du vil til dømes sjå at klassane *Customer* og Kitchen implementerer grensesnitt som ligg her - dette påverkar ikkje løysinga deira av oppgåvene 2.1 og 2.2. Du vil òg finna grensesnittet *PriceProvider* som skal brukast i oppgåve 2.3.

**Også viktig**: Oppgåve 2.4 - observatør-observert omhandlar delvis å implementera ein klasse *ObserveToPrintTopRevenue*. Denne klassen kan implementerast utan å ha løyst nokon av oppgåvene 2.1 - 2.3, eller å ha gjort sjølve observatør-inngrepa i Kitchen. 

## Oppgåve 2.1: Dei enklaste delane: MealOrder og Customer (10%)
- [MealOrder](MealOrder.java): Denne klassen inneheld informasjon om eit sal. Han lagrar namnet på retten, og kva pris retten vart seld for. Desse verdiane må kunna hentast ut med metodane *String getMeal()* og double *getPrice()*.

- [Customer](Customer.java): Ein som kjøper rettar. Kunden har eit namn, ei oversikt over kva rettar denne har kjøpt og til kva pris. Sjå javadoc i kjeldekoden for dei definerte krava.

## Oppgåve 2.2: Kitchen (20%)
Kjøkket har som nemnt tidlegare forenkla oppskriftene sidan sist. [Kitchen](Kitchen.java)-objekt har følgjande tilstand:
- Ei samling av oppskrifter. Desse vil innimellom bli refererte til som matretter.
- Ei samling av kundar (frå oppgåve 2.1).
- Omsetninga så langt - det betyr summen av alle sal som er gjort til no.

Følgjande metodar eksisterer i Kitchen:
- *provideMeal(String meal, double price, String name)*: Kunden *name* skal registrera kjøp av rett *meal* til pris *price*.
- *addCustomer(Customer customer)*: Legga til ein ny kunde. 
- *addRecipe(String recipe)*: Legga til ei ny oppskrift.
- *getRecipes()*: Returnera ein kopi av oppskriftene som er lagra.
- *getTurnover()*: Returnera omsetninga så langt.
- *getCustomer(String name)*: Returnera kunden med namnet *name*, eller *null* viss kunden ikkje finst i systemet.

## Oppgåve 2.3: Delegering: implements PriceDelegate (15%)
For å finna nye kundar har *Le Petite Chef* byrja med eit avansert rabattsystem. Det finst ulike typar rabattar, som gir prosentavslag på prisen. Tanken er at rabattar kan utløysast av mange faktorar, basert på elementa ved salet: pris*, kunde* og *oppskrift*. Dei ulike rabattane tel saman på følgjande måte:
- Gitt at eit produkt eigentleg skal seljast for 100 kroner.
- Rabatt1 gir 20% avslag. Prisen blir då 100 \* 0.8 = 80 kroner.
- Rabatt2 gir 50% avslag. Sluttprisen blir då 80 \* 0.5 = 40 kroner. Legg merke til at rabatt2 tar utgangspunkt i prisen frå rabatt1. Dei verkar altså *oppå kvarandre*.


Du skal laga følgjande:

- Rabattklassane skal implementera grensesnittet [PriceProvider](def/PriceProvider.java) som du vil finna i pakken *food.def*. Denne skal ikkje endrast.
- Rabattklassen [RebateEveryFifthBuyFromSameCustomer](RebateEveryFifthBuyFromSameCustomer.java) gir 50% rabatt på kvart femte kjøp, men med rabatt på første kjøp (lokkemiddel). Det betyr at kunden skal få rabatt på kjøp nummer 0, 5, 10, 15 osb.
- Rabattklassen [RebateFreeEveryThousandSale](RebateFreeEveryThousandSale.java) skal gi full rabatt kvart tusande sal, uavhengig av kva kunde som har kjøpt rettane. Han skal *ikkje* gi rabatt til første sal, men altså for sal 1000, 2000 og så vidare.
- Kitchen skal no kunna legga til og fjerne ei vilkårleg mengde rabattar. 
- *KitchencomputeActualPrice(String meal, double price, Customer customer)*: Denne metoden skal gå igjennom alle moglege rabattar som finst, og returnera faktisk sluttpris. Ein viktig faktor er at viss eit sal utløyser to rabattar, ein med 20% avslag og ein med 50% avslag, så gangast desse faktorane med kvarandre og metoden returnerer 0.4 \* innpris. Døme: Ein matrett til 200 kroner som har to rabattar på 30% og 50% vil enda opp med ein sluttpris på 70 kroner. Legg merke til at denne metoden er ein hjelpemetode for *provideMeal*. 
- Gjer dei nødvendige endringane som trengst i [Kitchen](Kitchen.java) for at vurdering av alle rabattar blir tatte med i registrering av sal.

## Oppgåve 2.4: Observatør-observert: (15%)
No skal Kitchen utvidast til å støtta lyttarar:
- Lyttarar må implementera grensesnittet *KitchenObserver* som du finn i pakken *food.def*. Dette grensesnittet skal ikkje endrast!
- Kitchen skal kunna legga til og fjerne lyttarar som følgjer grensesnittet [KitchenObserver](def/KitchenObserver.java), som ligg i pakken 'food.def'.
- Ved eit sal* i Kitchen skal alle lyttarane kallast med metoden MealOrder(meal, price). Det er altså berre matrett og faktisk pris etter eventuelle rabattar som skal sendast vidare til lyttarane.

Du skal òg implementera ein lyttar: klassen [ObserveToPrintTopRevenue](ObserveToPrintTopRevenue.java), med metodane *mealOrder(String meal, double price)* og *getTopSellers()*. Denne klassen skal skriva ut detaljar om den* eller dei* matrettene som har selt for høgast totalsum (omsetning) kvar gong det skjer eit nytt sal.

Viktig*: Det er ikkje nødvendig å ha klart Kitchen eller Recipe-oppgavene for å gjera denne siste oppgåva - den forheld seg berre til matretter/oppskrifter som strengar og priser som double