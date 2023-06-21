# tech-challenge
Repositório para o Tech Challenge - Grupo 30

# Dependentes [/dependent]

Pessoas relacionadas ao nosso cliente, com algum nível de parentesco.

### Dependente [POST]

+ Atributos (object)
    
    + name: nome do parente (string, required).
    + dateOfBirth: data de nascimento do parente - dd/MM/yyyy (LocalDate, required). 
    + gender: gênero do parente (string, required).
    + parentage: grau de parentesco do cliente (string, required).

+ Request - 200 (application/json)

    + Body

            {
                "name": "Victor",
                "dateOfBirth": "01/01/2023",
                "gender": "Masculino",
                "parentage": "Filho"
            }
+ Response - 200 (application/json)

    + Body

            {
                	"id": 1,
				"name": "Victor",
                	"dateOfBirth": "2023-01-01",
                	"gender": "Masculino",
                	"parentage": "Filho"
            }


+ Request - 400 - sem nome (application/json)

    + Body

            {
                "name": "",
                "dateOfBirth": "01/01/2023",
                "gender": "Masculino",
                "parentage": "Filho"
            }
+ Response - 400 (application/json)

    + Body

            {
                	"errors": [
				"O nome é obrigatório"
      			]
            }

+ Request - 400 - sem data de nascimento (application/json)

    + Body

            {
                "name": "Victor",
                "dateOfBirth": "",
                "gender": "Masculino",
                "parentage": "Filho"
            }
+ Response - 400 (application/json)

    + Body

            {
                	"errors": [
				"A data de nascimento é obrigatória. Padrão dd/MM/yyyy"
      			]
            }


+ Request - 400 - sem gênero (application/json)

    + Body

            {
                "name": "Victor",
                "dateOfBirth": "01/01/2023",
                "gender": "",
                "parentage": "Filho"
            }
+ Response - 400 (application/json)

    + Body

            {
                	"errors": [
				"O gênero é obrigatório."
      			]
            }


+ Request - 400 - sem parentesco (application/json)

    + Body

            {
                "name": "Victor",
                "dateOfBirth": "01/01/2023",
                "gender": "Masculino",
                "parentage": ""
            }
+ Response - 400 (application/json)

    + Body

            {
                	"errors": [
				"O parentesco é obrigatório."
      			]
            }
