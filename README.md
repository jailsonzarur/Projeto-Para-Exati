# **Projeto Exati - Documentação Incompleta(O Front-End está em desenvolvimento)**

Este projeto é composto por duas aplicações: um back-end desenvolvido em **Java com Spring Boot** e um front-end construído em **Vue.js** utilizando **Tailwind CSS** para estilização e **Vue Router** para gerenciamento de rotas.

---

## **Back-End**

O back-end foi desenvolvido em **Java** utilizando o framework **Spring Boot**.

### **Configuração Inicial**
1. Navegue até o diretório do back-end:
   ```bash
   cd java-springboot-exati(BACK-END)/springboot

2. Configure o arquivo application.properties localizado em src/main/resources/. Um exemplo de configuração para PostgreSQL(No código estão configurados minhas próprias chaves, então trate de trocar):

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

## **Executar o Back-End**

1. Compile e execute o projeto com Maven:
   ```bash
   ./mvnw spring-boot:run

2. O servidor será iniciado e estará acessível em:
   ```bash
   http://localhost:8080

## Funcionalidades (Back-End) do Sistema de Vagas

Este sistema permite o gerenciamento de vagas de emprego, com as seguintes funcionalidades:

### 1. Cadastrar um Job/Vaga
- **Descrição:** Permite registrar uma nova vaga no catálogo, incluindo informações como título, descrição e requisitos.
- **Endpoints:**
  - `POST /jobs`
  - **Parâmetros necessários:**
    - Título (title)
    - Descrição (job_description)
    - Salário (salary)
    - Sobre a Empresa (company_info)

### 2. Retornar uma vaga pelo ID
- **Descrição:** Busca informações detalhadas de uma vaga específica utilizando o ID.
- **Endpoints:**
  - `GET /jobs/{id}`
  - **Parâmetro necessário:**
    - `id`: ID da vaga

### 3. Retornar todas as vagas
- **Descrição:** Lista todas as vagas cadastradas no sistema.
- **Endpoints:**
  - `GET /jobs`

### 4. Atualizar uma vaga
- **Descrição:** Atualiza as informações de uma vaga já existente no catálogo, com base no ID.
- **Endpoints:**
  - `PUT /jobs/{id}`
  - **Parâmetro necessário:**
    - `id`: ID da vaga a ser atualizada
  - **Parâmetros editáveis:**
    - Título (title)
    - Descrição (job_description)
    - Salário (salary)
    - Sobre a Empresa (company_info)

### 5. Deletar uma vaga
- **Descrição:** Remove uma vaga específica do catálogo utilizando o ID.
- **Endpoints:**
  - `DELETE /jobs/{id}`
  - **Parâmetro necessário:**
    - `id`: ID da vaga a ser removida


---

## **Front-End(Ainda em desenvolvimento)**

## **Executar o Front-End**

1. Instale as dependências do Projeto:
   ```bash
   npm install

2. Inicialize o projeto:
   ```bash
   npm run dev

3. O projeto ficará acessível nesse endereço:
   ```bash
   http://localhost:3000

### Imagens: 
![Captura de tela de 2024-12-23 09-39-22](https://github.com/user-attachments/assets/bfe14155-a047-4a52-9994-0f1dcabe7292)

![Captura de tela de 2024-12-23 09-39-47](https://github.com/user-attachments/assets/7220e997-3689-42ed-af69-034d561bf69f)

![Captura de tela de 2024-12-23 09-47-23](https://github.com/user-attachments/assets/89e291b9-6698-4741-adae-60a3651245c5)

![image](https://github.com/user-attachments/assets/f2ce2b83-22b0-49ce-af76-87ef7c7a06ab)






