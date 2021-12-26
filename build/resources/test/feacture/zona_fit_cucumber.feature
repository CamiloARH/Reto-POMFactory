Feature: Compra de productos
  Como cliente quiero ingresar a la pagina principal de Zonafit
  y comprar productos segun las ofertas y/o en outlet
  con el fin de comprar dos productos en cada categoria

  Background:
    Given El usuario esta en la pagina principal de ZonaFit
    Then el cliete debera ver un mensaje de confirmacion

  @buy1
  Scenario: Productos en Oferta
    When el cliente da click en la categoria de Oferta donde filtra y escoge dos productos
    And en el carrito de compra presiona finalizar compra
    And llena los campos para realizar la compra
    And realiza su pedido


  @buy2
  Scenario: Productos en Outlet
    When el cliente da click en la categoria de Outlet donde filtra y escoge dos productos
    And en el carrito de compra presiona finalizar compra
    And llena los campos para realizar la compra
    And realiza su pedido