# Testausdokumentti


### Yleistä
Testauksen osalta kaikkia metodeita on pyritty testaamaan. Kuitenkin esim. itse luolaston luonti on ollut haastava testata, sillä siinä on niin monta erilaista sattunnaisesti muuttuvaa osaa.
Testauksessa on otettu huomioon niin luokkien ja metodien yleistoimivuus, kuin itse koko projektin tehokkuuden testaaminen. Myös omille tietorakenteille (joita tällä hetkellä on ollut vain ArrayList vastaava tietorakenne Array) on toteutettu kattavat metodien ja suorituskyvyn testaus. Testaus on toteutettu JUnit testein.

### Suorituskykytestauksesta tarkemmin
Suorituskykytestauksessa on käytetty hyväksi Javan System.nanoTime() metodia, ja ohjelman yleisessä suorituskyky testauksessa on luotu 100x100, 1000x100, 1000x1000, 10000x1000 ja 10000x10000 kokoisille luolastoille testit. Luolaston generoimiseen menee pienimmällä syötteellä aikaa noin 6ms ja suurimmalla noin 3 sekuntia. Tässä on erona kuitenkin 99990000 ruudun ero. Suorituskykytestit on luotu siten, että luodaan vain yhdet luolastot, ja otetaan niiden nopeudet. Luolaston generoimisen suorituskykytestit voi ajaa:

```mvn -Dtest=PerformanceTest test```

PerformanceTest tulokset suunnilleen seuraavat:
koko | aika (ms)
-----|------
100x100 | 3
1000x100| 4
1000x1000 |10
10000x1000|36
10000x10000|3558

ArrayList vastaavan tietorakenteen Array suorituskykytestit voi ajaa:

```mvn -Dtest=ArrayTest test```

Tämä kuitenkin ajaa myös Arrayn muut testit läpi.

### Metodien ja luokkien testauksesta tarkemmin
Projektin luokille ja metodeille on toteutettu JUnit yksikkötestit. Testikattavuus on hieman yli 90%, mutta tämä lukema on vääristynyt, sillä osa projektista testataan vain tehokkuuden kannalta. Näin ollen koodin testikattavuus on todellisuudessa lähempänä 60%. Kuitenkin yleiset tietorakenteet ja ydintoiminta on testattuna. Projektin kaikki testit voi ajaa:

```mvn test```