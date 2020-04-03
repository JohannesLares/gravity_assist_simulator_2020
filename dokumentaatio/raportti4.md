# Viikkoraportti 4

Tällä viikolla aloion toteuttamaan käytävien luomista, mutta se jäi vielä kesken, mutta pohja toimii. Toimintaperiaate siis, että katsotaan, onko huoneita jotka "overlap", ja näitä sitten alkaa yhdistelemään suorilla käytävillä. Täähn olisi ehkä hyvä lisätä erimuotoisia käytäviä. Kuitenkaan tällä viikolla uusien testien kirjoittaminen jäi vajaaksi ja uutta dokumentaatiota ei vielä tullut, mutta nämä pitäisi olla hoidettu seuraavaan palautukseen mennessä.

Seuraavaksi siis tehdään noiden käytävien luominen loppuun ja kirjoitetaan eri raportit. Viikkoaikataulun testausraportti on jo aloitettu edellisellä viikolla. Myöskin käytävien generoimisesta pitää tehdä siinä mielessä parempi, että nyt käytävä voi mennä yhden huoneen "läpi" suoraan, koska ohjelma ei havaitse, että välissä on huone. Myöskin esim ArrayList tietorakenteesta pitäisi päästä eroon seuraavaan palautukseen mennessä, ja koodata joku vastaava tietorakenne, johon on helppo lisätä ja poistaa yksittäisiä elementtejä. Ehkä joku perus Arrayskin voisi toimia, pitää ottaa selvää.

Huoneiden luomisessa käytetään siis BSP algoritmia, mutta käytävien luomisessa tarkastellaan huoneita ja huoneiden sijainteja kartalla, ja tästä luodaan tarvittavat käytävät huoneille.

Itse koodissa on tällä hetkellä paljon loppuvaiheessa "turhaa" koodia, jota on käytetty vain debuggaamiseen, kuten useat sysoutit ja mahdollisuus värittää huoneet unix konsoliin eri värisiksi.

Itse perusidean luolastogeneraattoriohjelmasta puuttuu siis enää käytävien generointi ja koodin siistiminen, niin olisi ehkä hyvä koodata se pikimmiten loppuun, niin voisi miettiä mahdollisia reitinhakualgoja tms. Kuitenkin vaikka huoneeseen ei olisi niin suoraa reittiä, on käytävän luominen silti melko simppeliä, napataan vain kaksi pistettä yhdistettävistä huoneista (eri akseleilla kuitenkin). vedetään suorat viivat ja lopetetaan missä viivat kohtaavat. Myöskin tarkoituksena on, ettei välttämättä joka huoneesta pääse joka huoneeseen, vaan välillä pitää myös kiertää pidempiä matkoja.

Koodissa on myös sellainen ongelma tällä hetkellä, että akselit ovat väärinpäin. Tästä seuraa, että jos koodissa on leveys, on se oikeassti korkeus ym. Tämä on kuitenkin aika nopea fixata, muuttaa vaan metodien ja muuttujien nimiä.

Ja siis ideana varmaan voisi reitinhakualgolle olla, että valitaan jostain huoneesta lähtöruutu ja jonnekin huoneeseen maaliruutu, ja tämä väli mahdollisimman tehokkaasti. Toinen vaihtoehto on tosiaan pelattava peli, johon voisi lisätä jotain vihollisia simppelillä AI:lla.
