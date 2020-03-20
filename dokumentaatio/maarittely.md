# Luolageneraattori määrittelydokumentti

### Yleistä

Ohjelman tehtävänä on generoida rogue tyylisiä luolastoja. Luolastoon liittyy huoneita ja käytäviä huoneiden välissä. Luolastoon voi liittyä myös tasoja. 

Ohjelma siis luo pelialueen, joka näytetään käyttäjälle tekstimuotoisena pelinä. Käyttäjä ei kuitenkaan näe koko pelialuetta kerralla, vaan joutuu itse etsimään huoneita ja reittejä huoneiden välille.

Ohjelma voi myös mahdollisesti luoda luolastoon erilaisia vihollisia. Tämä ei kuitenkaan ns. prio1.

### Kieli

Ohjelma tullaan toteuttamaan Java-ohjelmointikielellä ja koodataan englanniksi.

### Syötteet

Alkuun ohjelma saa syötteenä käyttäjältä pelialueen koon, johon kaikkien huoneiden ja käytävien on mahduttava. Koko annetaan leveytenä ja korkeutena. Tämän jälkeen pelaaja pääsee peliin, jossa liikutaan joko nuolinäppäimin tai WASD-näppäimin. Alkuun on myös mahdollista saada syötteenä huoneiden määrä, mutta tämäkään ei prio1.

### Algoritmit ja tietorakenteet

Pääalgoritmi, on luolaston generointi. Mutta myöskin huoneiden generoimiseen saatetaan joutua käyttämään jotain algoritimia. Luolasto tullaan luomaan kaksiulotteisella taulukolla joko merkkipohjaisesti tai objektein. Luolaston generointialgoritmin tulisi toimia O(n) ajassa, jossa n on luolaston koko, sillä algoritmin pitäisi käydä taulukon jokaisessa pisteessä vain kerran ja päättää, mitä siihen pisteeseen tulee ympäröivien pisteiden perusteella (huone, käytävä, seinä, ei mitään (tänne pelaaja ei pääse siis)). 

Tilavaativuuden tulisi olla n, jossa n on yksittäisen taulukkopisteen koko.
