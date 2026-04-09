Feature: Busca de artigos no Blog do Agi

Scenario: Busca com termo valido
  Dado que o usuario acessa o Blog do Agi
  Quando o usuario busca por "financas"
  Entao deve visualizar resultados

Scenario: Busca com termo invalido
  Dado que o usuario acessa o Blog do Agi
  Quando o usuario busca por "asdfgh123"
  Entao nao deve haver resultados