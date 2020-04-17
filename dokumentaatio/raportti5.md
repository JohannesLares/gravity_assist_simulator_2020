# Viikkoraportti 5

### Mitä on tullut tehtyä

Olen työstänyt käytäviä tekevää algortimia, mutta se ei ole ihan 100% toimiva. Algoritmi luo tällä hetkellä välillä haamukäytäviä, ja kulman sisältäviä käytäviä generoiva algoritmi on toteutettu puolelle tapauksista. Olen pohtinut, että olisiko sittenkin järkevämpää ottaa mallia jostain internetistä löytyvästä ohjeesta, mutta olen ainakin vielä luottavaisin mielin tämän hetken omasta algoritmista. Koodia on myös kommentoitu lisää. Olen myös tutkinut ohjelman aikavaativuutta. Tähän ei ole niin yksinkertaista vastausta, sillä tässä on periaatteessa kolme algoritmia yhdessä. Itse alueen jakavan puun luonti tapahtuu ajassa O(nlogn) (n = alueiden yhteismäärä lopuksi) (ainakin oman laskemiseni perusteella), huoneiden luonti toimii ajassa O(n), jossa n = alueiden yhteismäärä ja käytävien luonti tapahtuu ajassa O(n*m), jossa n = huoeniden määrä ja m = käytävän pituus (tämä siis voi muuttua). Kuitenkin pelattavan kokoisen kartan luonti (esim 300\*100) kestää keskimäärin alta 6 ms, niin mielestäni projekti toimii tarpeeksi noeasti, ainakin vielä. 

### Mikä on hankaloittanut tekemistä

Suurinta hämmennystä vieläkin aiheuttaa se, että projektin koordinaatit on flipattu, X on vertikaaliakseli ja Y on horisontaali. Y on myöskin ylhäällä, joka ei sinänsä haittaa, mutta hämmentää vain.

### Deadline lähestyy, saadaanko valmiiksi?

Suunnitellun reitinhakualgoritmin tekeminen saattaa jäädä hieman viimetippaan, mutta varmaankin onnistuu ennen projektin loppupalautusta. Tähän kuitenkin pitäisi miettiä, onko se A* vai Djirksta vai mikä. Luolastongenerointi kyllä saadaan valmiiksi testattuna ja kommentoituna ennen projektipalautusta.

### Kysymyksiä

Ei ole

### Käytetty aika

Tällä viikolla meni n. 8 tuntia projektin parissa.