# App its_adn
#### Author : Vinni 2021
### DNA verification app

This solution determines by DNA if a human is a mutant.
It was developed in java language, using the Sprint framework. The persistence used for this solution is in the postgreSql database.

|Task              | Description                      |
|--------------------|-----------------------------|
|Documentation    | The github wiki is used can be seen in the following url: [https://github.com/VinniK4m/its_adn/wiki](https://github.com/VinniK4m/its_adn/wiki)  |
|Code  | The last version:   [https://github.com/VinniK4m/its_adn/tree/master](https://github.com/VinniK4m/its_adn/tree/master/)  | 
|Release  | Version 2:   [https://github.com/VinniK4m/its_adn/releases/tag/ItsMutant_v2](https://github.com/VinniK4m/its_adn/releases/tag/ItsMutant_v2)  | 
|deployment  | The cloud deployment URL is at:   [http://itsdna.herokuapp.com/](http://itsdna.herokuapp.com/)  | 

### Implemented services HEROKU
|URL              | Description                      | Method | Example |
|--------------------|-----------------------------|-----|-----|
|[http://itsdna.herokuapp.com/itsdna/mutant](http://itsdna.herokuapp.com/itsdna/mutant)    | Determine if the human is mutant  | Post |body: { "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"] }|
|[http://itsdna.herokuapp.com/itsdna/stats](http://itsdna.herokuapp.com/itsdna/stats)  | Query the statistics   | Get ||
|[http://itsdna.herokuapp.com/itsdna/](http://itsdna.herokuapp.com/itsdna/)  | Check all records in bd Dna   | Get ||


### Implemented services AWS
|URL              | Description                      | Method | Example |
|--------------------|-----------------------------|-----|-----|
|[http://54.86.226.234:8862/itsdna/mutant](http://54.86.226.234:8862/itsdna/mutant)    | Determine if the human is mutant  | Post |body: { "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"] }|
|[http://54.86.226.234:8862/itsdna/stats](http://54.86.226.234:8862/itsdna/stats)  | Query the statistics   | Get ||
|[http://54.86.226.234:8862/itsdna/](http://54.86.226.234:8862/itsdna/)  | Check all records in bd Dna   | Get ||





