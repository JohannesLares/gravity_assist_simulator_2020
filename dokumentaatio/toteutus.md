# Toteutusdokumentti

### Ohjelman rakenne
Ohjelma koostuu kolmesta java-paketista, joista yksi on tietorakenteita varten, yksi on käyytöliittymää ja ohjelman ajamista varten ja viimeinen ohjelman ydintoiminnallisuutta varten. Ohjelma toimii siis siten, että käynnistettäessä App.javan main metodi käynnistää sovelluksen kysyen ensiksi käyttäjältä haluttavan luolaston korkeuden ja leveyden. 

### Aika- ja tilavaativuudet
Alueen jakavan puun luonti tapahtuu ajassa O(nlogn) (n = alueiden yhteismäärä lopuksi), huoneiden luonti toimii ajassa O(n), jossa n = alueiden yhteismäärä ja käytävien luonti tapahtuu ajassa O(n*m), jossa n = huoeniden määrä ja m = käytävän pituus (tämä siis voi muuttua). Tilavaativuudelta ohjelma on O(n), missä n on jaettujen alueiden lukumäärä. 

### Lähteet
http://www.roguebasin.com/index.php?title=Basic_BSP_Dungeon_generation
https://en.wikipedia.org/wiki/Binary_space_partitioning