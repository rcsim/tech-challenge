# tech-challenge
## Repositório para o Tech Challenge - Grupo 30

### 1.1- Relatório Técnico - Grupo 30 - Fase 1
Inicialmente foram definidas as versões que seriam utilizadas no projeto:
+ Maven
+  Java 11
+  Spring Boot 2.7.12

Também realizamos a definição das bibliotecas que seriam utilizadas:
+  Spring Web
+  Lombok
+  H2 Database

Quanto à versão utilizada do Java, decidimos utilizar a versão 11 por entender que hoje esta versão é mais utilizada no mercado e também consideramos a mais estável.

Optamos por utilizar um banco de dados em memória, apesar de não ser requisito, por entendermos que facilitaria a evolução do projeto na próxima etapa sem adicionar complexidade.

Também optamos pelo Spring Starter Validation para validar os dados de entrada.

Essas tecnologias e ferramentas contribuíram para o desenvolvimento eficiente e robusto do sistema, que em conjunto com reuniões semanais e distribuição de tarefas para cada integrante do grupo, possibilitou atingirmos os objetivos propostos no desafio.

A principal dificultade encontrada foi a necessidade de se realizar algumas refatorações afim de padronizar o código das 3 APIs, já que estavam significativamente diferentes em seu formato devido as preferências individuais de cada desenvolverdor.


### 1.2- Relatório Técnico - Grupo 30 - Fase 2

No início da fase 02 decidimos atualizar a versão do Java e Spring Boot para termos a possibilidade de utilizarmos novas funcionalidades da linguagem:
+  Java 17
+  Spring Boot 3.1.2

Além das bibliotecas já utilizadas na fase 1, adicionamos também as bibliotecas abaixo:
+  PostgreSQL
+  SpringDoc OpenAPI Starter WebMVC UI

Na fase 1 utilizamos um banco de dados em memória (H2 Database), nesta fase adicionamos a possibilidade de conectar a aplicação a um banco de dados real utilizando a biblioteca do PostgreSQL. A configuração para a aplicação conectar-se no H2 ou PostgreSQL deve ser feita no arquivo application.properties, onde deve ser definido qual profile a aplicação vai rodar, test para rodar o banco em memória H2 ou dev para rodar o banco PostgreSQL:
https://github.com/rcsim/tech-challenge/blob/0fcd8e3b718870e622972ce1b11d62cb7c5bbd81/src/main/resources/application.properties#L1 

Configuração do H2:
https://github.com/rcsim/tech-challenge/blob/0fcd8e3b718870e622972ce1b11d62cb7c5bbd81/src/main/resources/application-test.properties#L1-L15

Configuração do PostgreSQL:
https://github.com/rcsim/tech-challenge/blob/0fcd8e3b718870e622972ce1b11d62cb7c5bbd81/src/main/resources/application-dev.properties#L1-L7

Nesta fase adicionamos a possibilidade de geração automática da documentação através da biblioteca SpringDoc OpenAPI, a documentação pode ser acessada enquanto a aplicação estiver rodando em http://localhost:8080/swagger-ui/index.html#/:

![image](https://github.com/rcsim/tech-challenge/assets/30301531/8191e3fc-2f0e-48ab-b655-44bd53532209)
![image](https://github.com/rcsim/tech-challenge/assets/30301531/297ffdc8-967a-4218-84b9-81c87a4c5bec)
![image](https://github.com/rcsim/tech-challenge/assets/30301531/e4481bca-5476-4f70-9ddf-b851b085eb27)


**Docker**

Nesta fase foi adicionado a possibilidade de utilização de containers através do Docker-Compose. Criamos um container para aplicação e outro para o banco de dados e uma rede no modo bridge para ter acesso ao containers via localhost:

https://github.com/rcsim/tech-challenge/blob/0fcd8e3b718870e622972ce1b11d62cb7c5bbd81/docker-compose.yml#L1-L33

Também adicionamos o arquivo Dockerfile que gerencia o processo de build da aplicação através do Maven e JDK, já inicializando a aplicação:

https://github.com/rcsim/tech-challenge/blob/0fcd8e3b718870e622972ce1b11d62cb7c5bbd81/Dockerfile#L1-L15

Para criação dos container, compilar e rodar a applicação é necessário apenas o comando:

docker-compose up -d

![image](https://github.com/rcsim/tech-challenge/assets/30301531/4d4e76fe-c1eb-40f9-afd9-7b71e9a3bc99)



### 2- Documentação API

# Pos-Tech API

This is the documentation for the Pos-Tech API version 2.00.

## Endpoints

### Dependent

#### Get Dependent by ID

<<<<<<< HEAD
=======
- **Endpoint**: `/dependent/{id}`
- **Method**: GET
- **Description**: Retrieves a dependent by ID from the database.
- **Response**:
  - 200: Returns the dependent corresponding to the provided ID and registered in the system.
  - 404: Dependent not found.

#### Update Dependent

- **Endpoint**: `/dependent/{id}`
- **Method**: PUT
- **Description**: Updates the registration of a dependent in the database. All parameters are mandatory.
- **Request Body**: Dependent data in JSON format.
- **Response**:
  - 200: Dependent updated.
  - 422: Parameter cannot be null.
  - 400: Incorrect request.
  - 404: Dependent not found.
>>>>>>> 2174433 (Atualizado documentação da API)

#### Remove Dependent

<<<<<<< HEAD
<img src = "./image/deleteDependentID.png" />

<img src = "./image/getDependent.png" />

<img src = "./image/getDependentId.png" />

<img src = "./image/getDependentIDAppliances.png" />

<img src = "./image/postDependent.png" />

<img src = "./image/putDependentID.png" />
=======
- **Endpoint**: `/dependent/{id}`
- **Method**: DELETE
- **Description**: Removes a dependent from the database.
- **Response**:
  - 200: Dependent deleted successfully.
  - 404: Dependent not found.

#### Get All Dependents

- **Endpoint**: `/dependent`
- **Method**: GET
- **Description**: Retrieves all dependents from the database.
- **Response**:
  - 200: List of dependents registered in the system. Returns an empty list if there are no dependents.

#### Add Dependent

- **Endpoint**: `/dependent`
- **Method**: POST
- **Description**: Adds a dependent to the database. All parameters are mandatory.
- **Request Body**: Dependent data in JSON format.
- **Response**:
  - 201: Dependent added.
  - 422: Parameter cannot be null.
  - 400: Incorrect request.
  - 404: Cannot register in a non-existent address.
>>>>>>> 2174433 (Atualizado documentação da API)

#### Get Appliances of a Dependent

- **Endpoint**: `/dependent/{id}/appliances`
- **Method**: GET
- **Description**: Retrieves a list of appliances associated with a dependent.
- **Response**:
  - 200: List of appliances registered in the system and associated with a dependent. Returns an empty list if there are no appliances.
  - 404: Dependent not found.

### Appliance

<<<<<<< HEAD
<img src = "./image/deleteAddressId.png" />

<img src = "./image/getAddress.png" />

<img src = "./image/getAddressId.png" />

<img src = "./image/getAddressIdAppliances.png" />

<img src = "./image/getAddressIdDependent.png" />

<img src = "./image/postAddress.png" />

<img src = "./image/putAddressId.png" />
=======
#### Get Appliance by ID

- **Endpoint**: `/appliance/{id}`
- **Method**: GET
- **Description**: Retrieves an appliance by ID from the database.
- **Response**:
  - 200: Returns the appliance corresponding to the provided ID and registered in the system.
  - 404: Appliance not found.

#### Update Appliance

- **Endpoint**: `/appliance/{id}`
- **Method**: PUT
- **Description**: Updates the registration of an appliance in the database. All parameters are mandatory.
- **Request Body**: Appliance data in JSON format.
- **Response**:
  - 200: Appliance updated.
  - 422: Parameter cannot be null.
  - 404: Appliance not found.
  - 400: Incorrect request.

#### Remove Appliance

- **Endpoint**: `/appliance/{id}`
- **Method**: DELETE
- **Description**: Removes an appliance from the database.
- **Response**:
  - 200: Appliance deleted successfully.
  - 404: Appliance not found.

#### Get

 All Appliances
>>>>>>> 2174433 (Atualizado documentação da API)

- **Endpoint**: `/appliance`
- **Method**: GET
- **Description**: Retrieves all appliances from the database.
- **Response**:
  - 200: List of appliances registered in the system. Returns an empty list if there are no appliances.

#### Add Appliance

- **Endpoint**: `/appliance`
- **Method**: POST
- **Description**: Adds an appliance to the database. All parameters are mandatory.
- **Request Body**: Appliance data in JSON format.
- **Response**:
  - 201: Appliance added.
  - 422: Parameter cannot be null.
  - 400: Incorrect request.
  - 404: Cannot register in a non-existent address.

<<<<<<< HEAD

<img src = "./image/deleteApplianceID.png" />

<img src = "./image/getAppliance.png" />

<img src = "./image/getApplianceID.png" />

<img src = "./image/getApplianceDepedent.png" />

<img src = "./image/postAppliance.png" />

<img src = "./image/putApplianceID.png" />

=======
#### Get Dependents of an Appliance

- **Endpoint**: `/appliance/{id}/dependents`
- **Method**: GET
- **Description**: Retrieves a list of dependents associated with an appliance.
- **Response**:
  - 200: List of dependents registered in the system and associated with an appliance. Returns an empty list if there are no dependents.
  - 404: Appliance not found.

### Address

#### Get Address by ID

- **Endpoint**: `/address/{id}`
- **Method**: GET
- **Description**: Retrieves an address by ID from the database.
- **Response**:
  - 200: Returns the address corresponding to the provided ID and registered in the system.
  - 404: Address not found.

#### Update Address

- **Endpoint**: `/address/{id}`
- **Method**: PUT
- **Description**: Updates the registration of an address in the database. All parameters are mandatory.
- **Request Body**: Address data in JSON format.
- **Response**:
  - 200: Address updated.
  - 422: Parameter cannot be null.
  - 404: Address not found.
  - 400: Incorrect request.

#### Remove Address
>>>>>>> 2174433 (Atualizado documentação da API)

- **Endpoint**: `/address/{id}`
- **Method**: DELETE
- **Description**: Removes an address from the database.
- **Response**:
  - 200: Address deleted successfully.
  - 404: Address not found.

#### Get All Addresses

- **Endpoint**: `/address`
- **Method**: GET
- **Description**: Retrieves all addresses from the database.
- **Response**:
  - 200: List of addresses registered in the system. Returns an empty list if there are no addresses.

#### Add Address

- **Endpoint**: `/address`
- **Method**: POST
- **Description**: Adds an address to the database. All parameters are mandatory.
- **Request Body**: Address data in JSON format.
- **Response**:
  - 201: Address added.
  - 422: Parameter cannot be null.
  - 400: Incorrect request.

#### Get Dependents of an Address

- **Endpoint**: `/address/{id}/dependents`
- **Method**: GET
- **Description**: Retrieves a list of dependents associated with an address.
- **Response**:
  - 200: List of dependents registered in the system and associated with an address. Returns an empty list if there are no dependents.
  - 404: Address not found.

#### Get Appliances of an Address

- **Endpoint**: `/address/{id}/appliances`
- **Method**: GET
- **Description**: Retrieves a list of appliances associated with an address.
- **Response**:
  - 200: List of appliances registered in the system and associated with an address. Returns an empty list if there are no appliances.
  - 404: Address not found.

## Data Models

### DependentDTO

- **Required Fields**: addressId, dateOfBirth, gender, name, parentage, userId
- **Properties**:
  - id (integer, format: int64)
  - name (string)
  - dateOfBirth (string, format: date)
  - gender (string)
  - parentage (string)
  - addressId (integer, format: int64)
  - userId (integer, format: int64)

### ApplianceDTO

- **Required Fields**: addressId, manufacturer, model, name, power, userId
- **Properties**:
  - id (integer, format: int64)
  - name (string)
  - model (string)
  - power (string)
  - manufacturer (string)
  - addressId (integer, format: int64)
  - userId (integer, format: int64)

### AddressDTO

- **Required Fields**: city, district, number, state, street, userId
- **Properties**:
  - id (integer, format: int64)
  - street (string)
  - number (string)
  - district (string)
  - city (string)
  - state (string)
  - userId (integer, format: int64)

### Pageable

- **Properties**:
  - page (integer, minimum: 0, format: int32)
  - size (integer, minimum: 1, format: int32)
  - sort (array of strings)

### PageDependentDTO

- **Properties**:
  - totalElements (integer, format: int64)
  - totalPages (integer, format: int32)
  - size (integer, format: int32)
  - content (array of DependentDTO)
  - number (integer, format: int32)
  - sort (reference to SortObject)
  - first (boolean)
  - last (boolean)
  - numberOfElements (integer, format: int32)
  - pageable (reference to PageableObject)
  - empty (boolean)

### PageableObject

- **Properties**:
  - offset (integer, format: int64)
  - sort (reference to SortObject)
  - pageNumber (integer, format: int32)
  - pageSize (integer, format: int32)
  - unpaged (boolean)
  - paged (boolean)

### SortObject

- **Properties**:
  - empty (boolean)
  - sorted (boolean)
  - unsorted (boolean)

### PageApplianceDTO

- **Properties**:
  - totalElements (integer, format: int64)
  - totalPages (integer, format: int32)
  - size (integer, format: int32)
  - content (array of ApplianceDTO)
  - number (integer, format: int32)
  - sort (reference to SortObject)
  - first (boolean)
  - last (boolean)
  - numberOfElements (integer, format: int32)
  - pageable (reference to PageableObject)
  - empty (boolean)

### PageAddressDTO

- **Properties**:
  - totalElements (integer, format: int64)
  - totalPages (integer, format: int32)
  - size (integer, format: int32)
  - content (array of AddressDTO)
  - number (integer, format: int32)
  - sort (reference to SortObject)
  - first (boolean)
  - last (boolean)
  - numberOfElements (integer, format: int32)
  - pageable (reference to PageableObject)
  - empty (boolean)
