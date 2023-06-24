# tech-challenge
### Repositório para o Tech Challenge - Grupo 30


#### ---- INSTÂNCIA DE ENTIDADES PARA BD EM MEMÓRIA ----

<img src = "./image/createdTable.png" />

<img src = "./image/createdTable_H2console.png" />


#### ---- DEPENDENTES ----

URL: http://localhost:8080/dependent

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

![image](https://github.com/rcsim/tech-challenge/assets/71778151/895ef567-ca60-4cdf-b496-415dcae26a58)

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










