# Viikkoraportti 3

Tällä viikolla olen valinnut luolaston generointi algoritmiksi BSP:n, eli binary space partitioning. Algoritmin ideana on ottaa koko pelialue, jakaa sitä osiin luoden tästä puun, jossa lehdet ovat eri alueita kartassa. Tässä kohtaa ei kuitenkaan vielä olla luotu huoneita tai käytäviä, vaan alueita, joihin huoneet luodaan. Siis yksi huone per alue.

Olen koodannut ohjelmaan tämän puun luonti algoritmin, sekä toteuttanut algoritmia visualisoivan ominaisuuden, joka on hyödyllinen kehitysvaiheessa. Olen myös muuttanut projektin Maven projektiksi, koska se jäi alussa vahingossa luomatta. 

BSP toi sinänsä haasteita mukanaan, sillä joudun nyt tekemään uuden tietorakenteen korvaamaan Javan ArrayList tietorakennetta, mutta tämä varmaankin onnistuu parhaiten muuttuvalla yksiulotteisella taulukolla. 

Eli kiteytettynä tällä viikolla ohjelma on muuttunut:

* Projekti muunnettu maven projektiksi

* Lisätty algoritmi kartan puun ja lehtien luomiseksi

* Lisätty algoritmi, joka luo lehtiin huoneita

* Kirjoitettu testit olemassaolevalle koodille, joka hoitaa karttaa

* Koodin kommentointi jäänyt hieman taka-alalle.

* Testikattavuusraportin kirjoittaminen aloitettu

Olen myös viikon aikana miettinyt, että miten projektista saa kurssin laajuuteen menevän projektin, ja olen päätynyt, että varmaankin joku vihollisalgoritmi tai polunetsintäalgoritmi voisi olla hyvä lisäys projektiin.

Seuraavalla viikolla pitää muokata Javan vaalmiista tietorakenteista itselle sopivat mallit, eli päästä Javan ArrayList eroon. Myöskin pitää huoneiden väliset käytävät ohjelmoida ja miten kartta näytetään käyttäjälle (seinät, käytävät, huoneet ym. Nyt näyttää vain huoneet ilman seiniä, eli pelkkiä pisteitä)

Testailin myös, kuinka pitkään algoritmilla menee luoda erikokoisia karttoja, ja olen tyytyväinen tässäkohdassa saavutettuun tulokseen, joka on 100x100 kartalla alta 20ms ja 1000x1000 kartalla noin 50ms. Kuitenkin projektiin tulee vielä ominaisuuksia, jotka tulevat hidastamaan toimintaa.

Tällä viikolla olen oppinut, miten BSP toimii ja päässyt palauttelemaan puurakennetta mieleen. BSP on siitä hyödyllinen tälläisen kartan luomisessa, että lehtien luominen on osittain randomia. 

Tässä kohtaa ei ole oikein ollut mitään haasteita kurssin ja projektin suhteen, muuta kuin hieman pitäisi lisää motivaatiota kaivaa/aikatauluttaa projektin tekeminen paremmin ympäri viikkoa ettei torstaina ja perjantaina tule koodattua hirveessä hädässä palautusta. Tämä on taivoite ensiviikolle.

Tällä viikolla aikaa meni noin 10 tuntia.
