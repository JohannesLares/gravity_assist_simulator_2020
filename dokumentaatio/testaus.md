# Testausdokumentti


### Yleistä
Testauksen osalta kaikkia metodeita on pyritty testaamaan. Kuitenkin esim. itse luolaston luonti on ollut haastava testata, sillä siinä on niin monta erilaista sattunnaisesti muuttuvaa osaa.
Testauksessa on otettu huomioon niin luokkien ja metodien yleistoimivuus, kuin itse koko projektin tehokkuuden testaaminen. Myös omille tietorakenteille (joita tällä hetkellä on ollut vain ArrayList vastaava tietorakenne Array) on toteutettu kattavat metodien ja suorituskyvyn testaus. Testaus on toteutettu JUnit testein.

### Suorituskykytestauksesta tarkemmin
Suorituskykytestauksessa on käytetty hyväksi Javan System.nanoTime() metodia, ja ohjelman yleisessä suorituskyky testauksessa on luotu 100x100, 1000x100, 1000x1000, 10000x1000 ja 10000x10000 kokoisille luolastoille testit. Luolaston generoimiseen menee pienimmällä syötteellä aikaa alta 100ms ja suuremmilla noin 1-25 sekuntia. Tässä on erona kuitenkin 99990000 ruudun ero. Suorituskykytestit on luotu siten, että luodaan vain yhdet luolastot, ja otetaan niiden nopeudet. Luolaston generoimisen suorituskykytestit voi ajaa:

```mvn -Dtest=PerformanceTest test```

PerformanceTest tulokset suunnilleen seuraavat:
koko | aika (ms)
-----|------
100x100 | 1
1000x100| 9
1000x1000 |59
10000x1000|776
10000x10000|25728

Array testauksessa on käytetty 1000 alkion kokoista taulukkoa. Array aikavaativuus on add ja get operaatioissa O(1), mutta remove operaatiossa O(n), jossa n on listan pituus.
ArrayList vastaavan tietorakenteen Array suorituskykytestit voi ajaa:

```mvn -Dtest=ArrayTest test```

Tämä kuitenkin ajaa myös Arrayn muut testit läpi.

A* suorituskykytestauksessa on luotu yksi iso huone, jonka vastakkaisiin kulmiin on asetettu lähtö- ja maalipisteet. Testit on toteutettu 100x100, 1000x1000 ja 10000x10000 kokoisille huoneille. A* suorituskykytestit voi ajaa:

```mvn -Dtest=AStarPerformance test```

A* suorituskykytestauksen tulokset suunnilleen seuraavat:
koko | aika (ms)
-----|-----
100x100 | 17
1000x1000 | 200
10000x10000 | 50246



### Metodien ja luokkien testauksesta tarkemmin
Projektin luokille ja metodeille on toteutettu JUnit yksikkötestit. Testikattavuus on noin 90%, mutta tämä lukema on vääristynyt, sillä osa projektista testataan vain tehokkuuden kannalta. Näin ollen koodin testikattavuus on todellisuudessa lähempänä 60%. Kuitenkin yleiset tietorakenteet ja ydintoiminta on testattuna. Projektin kaikki testit voi ajaa:

```mvn test```