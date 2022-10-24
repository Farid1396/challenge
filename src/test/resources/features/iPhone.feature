#language: es
@Funcionalidad:iPhone
Característica: iPhone

  @iPhone
  Escenario: Búsqueda de iPhone en AliExpress
    Dado el usuario se encuentra en la página AliExpress
    Entonces el usuario visualiza el logo de AliExpress
    Cuando el usuario ingresa 'iPhone' en el campo de búsqueda y da enter
    Y el usuario espera '2' segundos
    Entonces el usuario visualiza la lista de resultados
    Cuando el usuario scrollea hasta el final de la página
    Y el usuario espera '2' segundos
    Entonces el usuario puede ver en lista el paginado de resultados
    Cuando el usuario hace click en el botón de la segunda página
    Y el usuario espera '2' segundos
    Entonces el usuario visualiza la lista de resultados
    Cuando el usuario hace click en la tarjeta del segundo producto
    Y el usuario cambia a la nueva ventana
    Entonces el usuario visualiza la información del producto
    Y el usuario visualiza la información de la cantidad de productos disponibles
