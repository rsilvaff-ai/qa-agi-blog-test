Feature: Busca de artigos no Blog do Agi

  Scenario: Busca com termo válido
    Given que o usuário acessa o Blog do Agi
    When o usuário busca por "finanças"
    Then deve visualizar resultados

  Scenario: Busca com termo inválido
    Given que o usuário acessa o Blog do Agi
    When o usuário busca por "asdfgh123"
    Then não deve haver resultados