# **Projeto Exati - Documentação Completa**

Este projeto é composto por duas aplicações: um back-end desenvolvido em **Java com Spring Boot** e um front-end construído em **Vue.js** utilizando **Tailwind CSS** para estilização e **Vue Router** para gerenciamento de rotas.

---

## **Back-End**

O back-end foi desenvolvido em **Java** utilizando o framework **Spring Boot**.

### **Configuração Inicial**
1. Navegue até o diretório do back-end:
   ```bash
   cd java-springboot-exati(BACK-END)/springboot

2. Configure o arquivo application.properties (ou application.yml) localizado em src/main/resources/. Um exemplo de configuração para PostgreSQL(No código estão configurados minhas próprias chaves, então trate de trocar):

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

