# tech-challenge
Repositório para o Tech Challenge - Grupo 30

+ As  tecnologias e ferramentas utilizadas no desenvolvimento do sistema do desafio proposto.
 + Utilizamos Java como linguagem principal, JPA para persistência dos dados, Lombok para reduzir a verbosidade do código, H2 como banco de dados em memória e Spring Starter Validation para validar os dados de entrada. Essas tecnologias e ferramentas contribuíram para o desenvolvimento eficiente e robusto do sistema, atingindo os objetivos propostos no desafio.




Endpoints disponiveis para acesso :
* [**Dependentes**](#dependentes-dependent)
* [**Eletrodomesticos**](#eletrodomesticos-appliance)
* [**Enderecos**](#tech-challenge)





# Dependentes [/dependent]

Pessoas relacionadas ao nosso cliente, com algum nível de parentesco.

### Dependente [POST]

+ Atributos (object)
    
    + name: nome do parente (string, required).
    + dateOfBirth: data de nascimento do parente - dd/MM/yyyy (LocalDate, required). 
    + gender: gênero do parente (string, required).
    + parentage: grau de parentesco do cliente (string, required).

+ Request - 201 (application/json)

    + Body

            {
                "name": "Victor",
                "dateOfBirth": "01/01/2023",
                "gender": "Masculino",
                "parentage": "Filho"
            }
+ Response - 201 (application/json)

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
				    "O nome e obrigatório"
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

# Eletrodomesticos [/appliance]

    Aparelhos eletrônicos dos usuários cadastrados em nosso sistema.


+ Atributos (object)
    
    + nome: nome do eletrodomestico (string, required).
    + modelo: Modelo do eletrodomestico -  (string, required). 
    + potencia: potencia do eletrodomestico (string, required).
    + fabricante:Fabricante do eletrodomestico (string, required).

    + Request - 201(application/json)

        + Body

            {
                "nome":"112",
                "modelo":"asda",
                "potencia":"122",
                "fabricante":"asdas"
            }
    + Response - 201(application/text)

        + Body

           Eletrodoméstico cadastrado com sucesso!

    + Request - 400(application/json)

        + Body

            {
                "nome":"",
                "modelo":"H12EJB1",
                "potencia":"120",
                "fabricante":"Brastemp"
            }
    + Response - 400(application/text)

        + Body

           {
                "errors": [
                    "O nome é obrigatório"
                 ]
            }      
    + Request - 400(application/json)

        + Body

            {
                "nome":"Liquidificador brastremp H12",
                "modelo":"",
                "potencia":"120",
                "fabricante":"Brastemp"
            }
    + Response - 400(application/text)

        + Body

           {
                "errors": [
                    "O modelo é obrigatório"
                 ]
            }       
        + Request - 400(application/json)

        + Body

            {
                "nome":"Liquidificador brastremp H12",
                "modelo":"H12EJB1",
                "potencia":"",
                "fabricante":"Brastemp"
            }
    + Response - 400(application/text)

        + Body

           {
                "errors": [
                    "A potencia é obrigatória"
                 ]
            }       + Request - 400(application/json)

        + Body

            {
                "nome":"Liquidificador brastremp H12",
                "modelo":"H12EJB1",
                "potencia":"120",
                "fabricante":""
            }
    + Response - 400(application/text)

        + Body

           {
                "errors": [
                    "O fabricante é obrigatório"
                 ]
            }   



