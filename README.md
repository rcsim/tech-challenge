# tech-challenge
### Repositório para o Tech Challenge - Grupo 30

<<<<<<< HEAD
# Dependentes [/dependent]
=======

#### ---- INSTÂNCIA DE ENTIDADES PARA BD EM MEMÓRIA ----

<img src = "./image/createdTable.png" />

<img src = "./image/createdTable_H2console.png" />


#### ---- DEPENDENTES ----
>>>>>>> feature/reviewAddress

Pessoas relacionadas ao nosso cliente, com algum nível de parentesco.

<<<<<<< HEAD
### Dependente [POST]

+ Atributos (object)
    
    + name: nome do parente (string, required).
    + dateOfBirth: data de nascimento do parente - dd/MM/yyyy (LocalDate, required). 
    + gender: gênero do parente (string, required).
    + parentage: grau de parentesco do cliente (string, required).

+ Request - 200 (application/json)
=======
- Json da classe de Dependentes para o Postman com todos os campos preenchidos. 
```json
{
    "name":"Victor",
    "dateOfBirth":"28/12/1998",
    "gender":"Masculino",
    "parentage":"Teste"
}
```
- Resposta da requisição
![image](https://github.com/rcsim/tech-challenge/assets/71778151/4da03697-9013-4135-a471-758a1a057947)

- Dados inseridos no banco
<img src = "image/createdDependent_BD.png" />


- Json da classe de Dependentes para o Postman com todos os campos nulos. 
>>>>>>> feature/reviewAddress

    + Body

<<<<<<< HEAD
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
=======
- Json da classe de Dependentes para o Postman com todos os campos vazios. 

![image](https://github.com/rcsim/tech-challenge/assets/71778151/6fb2c201-9f1f-41d2-8d81-4f59f736c294)



#### ---- ENDEREÇOS ----

URL: http://localhost:8080/address

- Json da classe de Endereços para o Postman com todos os campos preenchidos.

```json
{
  "street":"Avenida Augusto de Lima",
  "number":"486",
  "district":"Centro",
  "city":"Belo Horizonte",
  "estate":"Minas Gerais"
}

```
- Resposta da requisição
<img src = "image/createdAddressPostman_status201.png" />

- Dados inseridos no banco
<img src = "image/createdAddress_BD.png" />


- Json da classe de Endereços para o Postman com todos os campos nulos.
<img src = "image/addressError_Nulo.png" />

- Json da classe de Endereços para o Postman com todos os campos vazios.
<img src = "image/addressError_Vazio.png" />



#### ---- ELETRODOMÉSTICOS ----

URL: http://localhost:8080/appliance

- Json da classe de Eletrodomésticos para o Postman com todos os campos preenchidos. 

```json
{
  "name":"HP",
  "model":"G42",
  "power":"90w",
  "manufacturer":"Hewlett-Packard"
}

```
- Resposta da requisição
<img src = "image/createdApplience_Postman_status201.png" />

- Dados inseridos no banco
<img src = "image/createdApplience_BD.png" />


- Json da classe de Eletrodomésticos para o Postman com todos os campos nulos.
<img src = "image/applienceError_Nulo.png" />


- Json da classe de Eletrodomésticos para o Postman com todos os campos vazios.
<img src = "image/applienceError_Vazio.png" />










>>>>>>> feature/reviewAddress
