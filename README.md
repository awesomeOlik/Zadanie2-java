# Zadanie 2 - Veža v bludisku
B-OOP 2021

Vašou úlohou je naprogramovať oknovú aplikáciu v jazyku Java s pomocou knižnice Swing. Používateľské rozhranie aplikácie má pozostávať z:

* canvasu
* bočného menu (jeho umiestnenie si zvoľte sami)

Po spustení aplikácie vygenerujte pomocou algoritmu [náhodného prehľadávania do hĺbky](https://www.baeldung.com/cs/maze-generation#dfs-maze) bludisko a vykreslite ho na canvas.
Mriežka v ktorej generujete bludisko nemôže byť menšia ako 11x11 políčok (vrátane stien), pričom bludisko musí byť obohnané stenou (žiadna cesta v bludisku sa nemôže dotýkať okraju okna).

Vo vygenerovanom bludisku zvoľte ľubovoľným spôsobom jeden začiatočný a jeden cieľový bod. Na začiatočný bod umiestnite hráčovu figúrku. Hráč sa môže v bludisku pohybovať 3 spôsobmi:
* pomocou šípok na klávesnici, vždy o jedno políčko určeným smerom, pričom nemôže vsúpiť na políčko obsahujúce stenu.
* pomocou myši. Po kliknutí na figúrku je ňou možné pohnúť ako vežou v šachu (t.j. ľubovoľný počet políčok zvyslo, alebo vodorovne). Cieľ cesty zvolí hráč druhým kliknutím myši, pričom je potrebné zvýrazniť políčka na ktoré sa hráč môže presunúť keď sa nad nimi nachádza myš. Pri pohybe takýmto spôsobom nie je možné preskočiť stenu bludiska.
* pomocou tlačidiel na bočnom menu, predstavujúcich šípky. Pre tento pohyb platia rovnaké pravidlá, ako pre pohyb pomocou klávesnice

Keď hráč dosiahne cieľ, vygenerujte nové bludisko a hra začína od začiatku.

Bočné menu musí obsahovať:
* počítadlo úspešne vyriešených bludísk
* tlačidlo na reštartovanie hry, ktoré vyresetuje počítadlo a vygeneruje nové bludisko
* tlačidlá reprezentujúce šípky, pomocou ktorých je možné pohybovať hráčovou figúrkov. Tieto tlačidlá musia byť rozmiestnené tak, ako sú rozmiestnené šípky na bežnej klávesnici.



## Hodnotenie

Zadanie je hodnotené 15 bodmi. **Odovzdaný program musí byť skompilovateľný, inak je
hodnotený 0 bodmi**. Skompilovateľnosť zadania kontroluje aj github pipeline. Hlavný dôraz v hodnotení sa kladie na objektový prístup a princípy OOP,
okrem iného:

* vhodné pomenovanie tried, metód a premenných v jednotnom jazyku (názvy tried s veľkým počiatočným písmenom, názvy metód s malým),
* vhodné použitie modifikátorov prístupu (public, private, poprípade protected) na obmedzenie prístupu k metódam a atribútom,
* využitie dedenia a polymorfizmu,
* použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* nepoužívajte nested classy,
* vo vašich triedach nevytvárajte statické metódy ani nekonštantné statické premenné (v zadaní nie sú potrebné),
* v hlavnej triede (main) nevytvárajte žiadnu logiku, iba vytvorte nový objekt,
* vo svojom riešení môžete použiť knižnicu lombok a jej anotácie. Potrebná dependencia je už pridaná v _pom.xml_ súbore.

## Odovzdávanie
Zadanie si naklonujte z repozitára zadania výhradne pomocou poskytnutej linky cez GitHub Classroom (pokiaľ si vygenerujete vlastný repozitár pomocou tlačidla "Use this template" z template repozitára, my váš repozitár neuvidíme a nebudeme ho hodnotiť!). Svoje vypracovanie nahrajte do pre vás vytvoreného repozitára pre toto zadanie pomocou programu Git (git commit + git push).
Skontrolujte si, či sa váš repozitár nachádza pod skupinov **Interes-Group**, inak nemáme prístup ku vášmu repozitáru a zadanie sa nepovažuje za odovzdané. Vypracovanie môžete "pusho-vať" priebežne. Hodnotiť sa bude iba _master_ branch. Zadanie je nutné vypracovať do **23.4.2021 23:00**.

V projekte upravujte iba súbory v priečinku _src/main_ a jeho podpriečinkoch. Ostatné súbory je upravovať zakázané (predovšetkým súbory _pom.xml_ a súbory obsahujúce github pipeline-y).

Vo svojom github účte si nastavte svoje meno (settings > profile > name), aby bolo možné priradiť riešenie ku študentovy. **Pokiaľ nebude možné spárovať študenta s riešením je zadanie hodnotené 0 bodmi!**
