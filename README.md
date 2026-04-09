# qa-agi-blog-test
Automação de testes da busca do Blog do Agi utilizando Java, Selenium WebDriver e Cucumber (BDD)

Teste técnico QA – Web
1. Entendendo o desafio
Você precisa:
•	Acessar: https://blogdoagi.com.br/ 
•	Usar a busca (lupa) 
•	Identificar cenários relevantes 
•	Automatizar pelo menos 2 cenários 
•	Subir no GitHub com boas práticas 

Feature: Busca de artigos no Blog do Agi
  Como um usuário do blog
  Quero buscar por conteúdos
  Para encontrar artigos relevantes

Cenário 1 – Busca com termo válido (principal - automatizado)
Scenario: Deve retornar artigos ao buscar um termo válido
 	Given que o usuário acessa o Blog do Agi
  	When o usuário clica no ícone de busca
 	 And informa o termo "finanças"
  	And executa a busca
  	Then deve visualizar uma lista de artigos
  	And cada artigo deve conter um título visível

Cenário 2 – Busca sem resultados (negativo - automatizado)
Scenario: Deve exibir mensagem ao buscar termo inexistente
  	Given que o usuário acessa o Blog do Agi
  	When o usuário clica no ícone de busca
  	And informa o termo "asdfgh123"
  	And executa a busca
 	 Then deve visualizar uma mensagem de nenhum resultado encontrado
  	Or deve visualizar uma lista vazia de artigos


Cenário 3 – Busca usando Enter
Scenario: Deve permitir busca utilizando a tecla Enter
  	Given que o usuário acessa o Blog do Agi
  	When o usuário clica no ícone de busca
  	And informa o termo "investimentos"
  	And pressiona a tecla Enter
 	 Then deve visualizar uma lista de artigos relacionados ao termo buscado

Cenário 4 – Validação de relevância dos resultados
Scenario: Os resultados devem conter o termo pesquisado
  	Given que o usuário acessa o Blog do Agi
  	When o usuário busca pelo termo "cartão de crédito"
  	Then os títulos ou descrições dos artigos devem conter o termo buscado

Cenário com Outline 
Scenario Outline: Busca com diferentes termos válidos
  	Given que o usuário acessa o Blog do Agi
  	When o usuário busca pelo termo "<termo>"
  	Then deve visualizar resultados relacionados
Examples:
  | termo              	|
  | finanças          	|
  | investimentos     	|
  | cartão de crédito 	|
