
### Objetivo
Validar a funcionalidade de busca do Blog do Agi, garantindo que os artigos relevantes sejam exibidos corretamente e que a aplicação se comporte como esperado em cenários positivos e negativos.

A aplicação testada: [https://blogdoagi.com.br/](https://blogdoagi.com.br/)

---

## Tecnologias Utilizadas
- Java 17
- Maven
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Git/GitHub

---

## Estrutura do Projeto

blog-do-agi-automation/
├── src/
│ ├── main/java/ # Classes utilitárias (helpers)
│ └── test/java/ # Steps definitions e runners
├── features/ # Arquivos .feature com cenários de teste
├── pom.xml # Configuração Maven
├── .gitignore
└── README.md


---

## Cenários de Teste Automatizados

### Feature: Busca de artigos no Blog do Agi
**Como** um usuário do blog  
**Quero** buscar por conteúdos  
**Para** encontrar artigos relevantes

#### Cenário 1 – Busca com termo válido (automatizado)

Scenario: Deve retornar artigos ao buscar um termo válido
Given que o usuário acessa o Blog do Agi
When o usuário clica no ícone de busca
And informa o termo "finanças"
And executa a busca
Then deve visualizar uma lista de artigos
And cada artigo deve conter um título visível


#### Cenário 2 – Busca sem resultados (automatizado)

Scenario: Deve exibir mensagem ao buscar termo inexistente
Given que o usuário acessa o Blog do Agi
When o usuário clica no ícone de busca
And informa o termo "asdfgh123"
And executa a busca
Then deve visualizar uma mensagem de nenhum resultado encontrado
Or deve visualizar uma lista vazia de artigos

## Cenários de Teste identificados

#### Cenário 3 – Busca usando Enter

Scenario: Deve permitir busca utilizando a tecla Enter
Given que o usuário acessa o Blog do Agi
When o usuário clica no ícone de busca
And informa o termo "investimentos"
And pressiona a tecla Enter
Then deve visualizar uma lista de artigos relacionados ao termo buscado


#### Cenário 4 – Validação de relevância dos resultados

Scenario: Os resultados devem conter o termo pesquisado
Given que o usuário acessa o Blog do Agi
When o usuário busca pelo termo "cartão de crédito"
Then os títulos ou descrições dos artigos devem conter o termo buscado


#### Cenário com Outline

Scenario Outline: Busca com diferentes termos válidos
Given que o usuário acessa o Blog do Agi
When o usuário busca pelo termo "<termo>"
Then deve visualizar resultados relacionados

Examples:
| termo |
| finanças |
| investimentos |
| cartão de crédito |

---

## Como Executar os Testes
1. Clonar o repositório:  
```bash
git clone https://github.com/rsilvaff-ai/blog-do-agi-automation.git
Instalar dependências com Maven:
mvn clean install
Executar os testes via Maven:
mvn test
