Feature: Gerenciamento de produtos

  Scenario: Buscar produto existente
    Given que eu possuo um produto válido
    When eu buscar o produto
    Then o status code deve ser 200

  Scenario: Buscar produto existente
    Given que eu possuo um produto válido
    When eu buscar o produto
    Then o status code deve ser 200
    And os campos obrigatorios devem estar presentes

  Scenario: Criar produto
    Given que eu tenho dados de produto válidos
    When eu criar um produto
    Then o status code deve ser 201

  Scenario: Atualizar produto
    Given que eu criei um produto
    When eu atualizar o produto
    Then o status code deve ser 200 ou 404

  Scenario: Deletar produto
    Given que eu criei um produto
    When eu deletar o produto
    Then o status code deve ser 200 ou 404