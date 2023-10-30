<h1 align="center">Gestão de dispositivos</h1>

<h4 align="center"> 
	🚀 Em construção...  🚧
</h4>

Índice
=================
* [Sobre](#sobre)
* [Instalação](#instalação)
* [Como usar](#como-usar)
    * [Pré-requisito](#pré-requisitos)
* [Tecnologias](#tecnologias)

### Sobre
É uma aplicação para abertura e controle de chamados


### Instalação
```bash
# Clone este repositório no diretório de sua preferência
$ git clone https://github.com/danizin/projeto-fiap

# Acesse a pasta do projeto no terminal/cmd
$ cd projeto-fiap

# Instale as dependências
$ mvn clean package

# Observação
Executar o projeto pela IDE de sua preferência
```

## Como usar
### Pré-requisitos
Ter na máquina o Git, JDK 17 e Maven

### Variáveis do sistema
A aplicação hoje possui uma integração com Vault e Consul que é responsável por guardar as credências e informações sensíveis do projeto.

**Observação**

Todas as novas credências devem ser incluídas no Vault.

### Tecnologias
As seguintes ferramentas foram usadas na construção do projeto:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data(Spring JPA)](https://pt-br.reactjs.org/)
- [Lombok](https://projectlombok.org/)
- [MapStruct](https://mapstruct.org/)


## Estrutura de pastas
A arquitetura do projeto é organizada em camadas. Veja abaixo a estrutura de pastas:

- **Raiz:**
    - Arquivos de configuração global e de construção (`pom.xml`)

- **src/main/java:**
    - `br.com.projetofiap`: pacote raiz do app
        - `ProjetoFiapApplication.java`: classe principal da aplicação Spring Boot
        - `model`: classes de entidade / tabelas do BD
        - `repositories`: repositórios Spring Data JPA, operações CRUD
        - `services`: lógica de negócios e ponte entre os controladores e os repositórios
        - `controller`: manipular as solicitações HTTP e retornar respostas
        - `config`: classes de configuração, configuração do Spring Security/ JWT, configuração do banco de dados
        - `exception`: classes de exceções personalizadas
        - `dto`: transferência de dados (Data Transfer Objects), usadas para transferir dados entre subprocessos ou entre a rede.

- **src/test/java:**
    - `br.com.projetofiap`: testes, e deve refletir a estrutura em `src/main/java`.
