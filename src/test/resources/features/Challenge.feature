#language: es
@Funcionalidad:Challenge
Característica:Challenge

  @Challenge
  Escenario: Challenge
    Dado el usuario se encuentra en la página Home
    Entonces el usuario visualiza el logo
    Cuando el usuario hace click en el botón con el texto 'Cotizá en un click'
    Entonces el usuario observa el mensaje en pantalla 'Falta completar este campo.'
    Cuando el usuario ingresa 'Farid' en el campo 'txtNameStep1'
    Y el usuario hace click en el combo 'ProvinceStep1' y selecciona la opción 'Córdoba'
    Y el usuario ingresa '351' en el campo 'PhoneCodeStep1'
    Y el usuario ingresa '35125880' en el campo 'PhoneNumberStep1'
    Y el usuario hace click en el botón con el texto 'Cotizá en un click'
    Entonces el usuario observa el título en pantalla 'Elegí el plan que más te conviene'
    Cuando el usuario ingresa '1' en el campo 'txtPersons'
    Y el usuario ingresa '0' en el campo 'txtChildren'
    Y el usuario scrollea hasta el elemento 'Plan Senior 30'
    Y el usuario hace click en el botón con el texto 'Plan Senior 30'
    Y el usuario hace click en el botón con el texto 'Siguiente'
    Entonces el usuario observa el título en pantalla 'Completá tus datos... Ya casi terminamos'
    Cuando el usuario hace click en el botón con el texto 'Siguiente'
    Entonces el usuario observa el mensaje en pantalla 'Falta completar este campo.'
    Cuando el usuario ingresa 'Atala' en el campo 'Surname'
    Y el usuario ingresa '04/03/1996' en el campo 'Birthday'
    Y el usuario ingresa '11222333' en el campo 'ID_Number'
    Y el usuario hace click en el combo 'Gender' y selecciona la opción 'Masculino'
    Y el usuario hace click en el combo 'IdentificationGenderType' y selecciona la opción 'Masculino'
    Y el usuario ingresa 'farid.atala96@gmail.com' en el campo 'txtEmail'
    Y el usuario ingresa 'Calle' en el campo 'Street'
    Y el usuario ingresa '1234' en el campo 'HouseNumber'
    Y el usuario ingresa '5000' en el campo 'zipCode'
    Y el usuario hace click en el botón con el texto 'Siguiente'
    Entonces el usuario observa el título en pantalla 'Por favor, ingresá los datos de tu tarjeta de crédito'