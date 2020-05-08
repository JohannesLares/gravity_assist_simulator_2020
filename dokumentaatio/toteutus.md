# Toteutusdokumentti

### Ohjelman rakenne
Ohjelma koostuu neljästä java-paketista, joista yksi on tietorakenteita varten, yksi on käyytöliittymää ja ohjelman ajamista varten, yksi A* varten ja viimeinen ohjelman ydintoiminnallisuutta varten. luolastogeneraattori.map paketti on "ohjelman aivot", ja kaikki interaktio esim. A* kanssa tapahtuu tämän luokan metodeja käyttäen.

Ohjelman alkutoteutuksessa oli pelkkä luolastogenerointi, mutta aivan loppuvaiheessa lisättiin vielä A\* reitinhakualgoritmi. A\* käyttää hyväkseen siirron parametrien laskemiseen pythagoraan teoriaa, jonka vuoksi ohjelmassa käytetään Javan Math kirjastoa neliöjuuren laskemiseen.

Ohjelmaan on toteutettu tietorakenteena javan ArrayList vastaava tietorakenne ja lisäksi random numeroita antava luokka, joka hyödyntää System.nanoTime() metodia. Tähän lisättiin mahdollisuus muuttaa moduloa, jotta saadaan erittäin lähekkäin suoritettaviin randomhakuihin tarpeeksi eroavaisuutta.

### Aika- ja tilavaativuudet
Alueen jakavan puun luonti tapahtuu ajassa O(nlogn) (n = alueiden yhteismäärä lopuksi), huoneiden luonti toimii ajassa O(n), jossa n = alueiden yhteismäärä ja käytävien luonti tapahtuu ajassa O(n\*m), jossa n = huoeniden määrä ja m = käytävän pituus (tämä siis voi muuttua). Tilavaativuudelta ohjelma on O(n), missä n on jaettujen alueiden lukumäärä. 

A\* aikavaativuus huonoimmassa tilanteessa on O(n\*m) (n = luolaston leveys, m = luolaston korkeus), jossa A* pitää käydä joka ikinen piste yksitellen läpi etsiessään parasta reittiä. Optimi tilanteessa, jossa mennään vaaka- tai pystysuunnassa suoraan, ilman esteitä, lähdöstä maaliin, on O(n)(n = pisteiden välinen etäisyys), koska A\* ei pidä käydä missään muussa, kuin reitillä olevissa pisteissä. A* vie tilaa kaksi kertaa luolaston koon verran, koska luolaston tiedot tallennetaan kahteen kaksiuloitteiseen taulukkoon. Toiseen tulee, missä ruuduissa on käyty ja toisessa on perustiedot pisteistä.

### Puutteet ja parannukset
Käytävien luonnissa otetaan kaksi listassa vierekkäistä huonetta, jotka voivat olla kartalla aivan eri puolilla, ja näiden huoneiden väliin vedetään käytävä. Näin ollen käytävä voi kulkea usean huoneen läpi, josta johtuen yhdestä huoneesta voi lähteä useampia käytäviä.

### Lähteet
http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation
https://en.wikipedia.org/wiki/Binary_space_partitioning
https://www.youtube.com/watch?v=icZj67PTFhc