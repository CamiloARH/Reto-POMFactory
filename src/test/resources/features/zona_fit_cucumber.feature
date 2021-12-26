Feature: Compra de productos
  Como cliente quiero ingresar a la pagina principal de Zonafit
  y comprar productos segun las ofertas y/o en outlet
  con el fin de comprar dos productos en cada categoria

  @buy1
  Scenario: Productos en Oferta
    Given El usuario esta en la pagina principal de ZonaFit
    When el cliente da click en la categoria de Oferta donde filtra y escoge dos productos
    And en el carrito de compra agrega otro pruducto y presiona finalizar compra
    And llena los campos para realizar la compra y realiza su pedido
    Then el cliete debera ver un mensaje de confirmacion

  @buy2
  Scenario: Productos en Outlet
    Given El usuario entra en la pagina principal de ZonaFit
    When el cliente da click en la categoria de Outlet donde filtra y escoge 2 productos
    And en el carrito de compra presiona finalizar compra
    And llena los campos para realizar la compra y realiza sus pedidos
    Then el cliete debera ve un mensaje de confirmacion