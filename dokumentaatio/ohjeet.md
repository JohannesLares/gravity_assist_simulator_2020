# Käyttöohje

### Suorittaminen
Ohjelma ajetaan komentoriviltä java -jar komentoa käyttäen seuraavasti:

```java -jar luolastogeneraattori.jar```

```java -jar luolastogeneraattori.jar 1 2 3 4```

Ensimmäisessä komennossa ilman parametrejä ohjelma käynnistyy komentoriville ja kysyy tarvittavat tiedot käyttäjältä ohjelman suorituksen aikana. Tiedot voidaan kuitenkin antaa parametreina jo siinä vaiheessa, kun ohjelmaa aletaan suorittamaan alemman komennon mukaisesti.

Alemman komennon parametrit ovat seuraavat: 1 = Luolaston leveys, 2 = luolaston korkeus, 3 = luodaanko lähtö- ja maalipiste (y/n), 4 = Suoritetaanko A* reitinhaku (y/n).

Kun ohjelma käynnistetään parametreilla, pitää kaikki parametrit olla annettuina. Parametreilla ajo mahdollistaa myös esim. luolaston tallentamisen tiedostoon seuraavasti (unix/linux):

```java -jar luolastogeneraattori.jar 1000 1000 y y >> test.txt```

### Syötteet
Luolaston leveys ja korkeus ovat kokonaislukuja, joiden on oltava yli 30 ohjelman toiminnan takia. Tämä siis johtuu siitä, että yhden alueen minimikoko on 30x30. Lähtö- ja maalipisteen luonnin vastaus on joko y tai Y suorittamista varten tai mitä tahansa muuta, vaikka tyhjä rivi, suorittamatta jättämistä varten.

### suoritettava JAR tiedosto löytyy github releasena ja repositorion juuresta.