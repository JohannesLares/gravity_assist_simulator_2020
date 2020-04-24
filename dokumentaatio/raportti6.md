# 6. Viikkoraportti

### Mitä tuli tehtyä?
Koodin kaikki kommentointia tarvitsevat luokat ja metodit on nyt kommentoitu. Kommentointi on toteutettu Javadocilla. Yksikkötestaus ja suorituskykytestaus on myös toteutettu. Yksikkötestaus on kirjoitettu n. 60% ohjelmakoodista ja kun päälle lisätään suorituskykytestaus, nousee testikattavuus reiluun 90%. Myös testausdokumentti on kirjoitettu ja toteutusdokumenttia on aloitettu. Itse koodissa ei testauksen lisäksi ole tapahtunut paljoa muutoksia, paitsi javan ArrayList tietorakenne on muutettu omaan Array tietorakenteeseen, joka toimii suurimmalti osalti ajassa O(1). 

### Mitä seuraavaksi tehdään?
Koodin ydintoiminnassa on vielä hieman puutteita (ei yhdistä kaikkia huoneita toisiinsa), niin tämä pitää viimeistellä. Myös käyttöohje pitää tehdä ja toteutusdokumentti tehdä loppuun.

### Paljonko aikaa kului tällä viikolla?
Tällä viikolla en ehtinyt tekemään niin poaljoa, tein n. 5h. Tavoite on kuitenkin seuraavalla viikolla saada projektin ydintoiminnallisuus loppuun.

### Kysymyksiä
Saako käyttä ThreadLocalRandom luomaan wsatunnaisuutta, vai pitääkö tähän koodata joku oma funktio keksimään satunnaislukuja?

Saako käyttää System.arraycopy metodia kopiodakseen arrayta isomapaan arrayhyn?