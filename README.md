
# colegioSpringBoot
Ejercicio práctico de un DAO con Spring Boot


# RUTAS BACK:

************ LISTAR ESTUDIANTES ******

@GetMapping("estudiantes")

************ INSERTAR *****************
	
@GetMapping("addEstudiante")

@PostMapping("nuevo")

*********** MODIFICAR *****************

@GetMapping("editar/{id}")

@PostMapping("update/{id}")
	
************** BORRAR ******************

@GetMapping("borrar/{id}") 





# RUTAS FRONT:

********** WELCOME PAGE *****************

@GetMapping("")

************* ADD ***********************

@GetMapping("addEstudiante")

@PostMapping("nuevo")

************** READ **********************

@GetMapping(value="perfil/{id}")

*************** UPDATE ********************

@GetMapping("perfil/{id}/editar")

@PostMapping("perfil/{id}/update")

****************** DELETE ******************

@GetMapping("perfil/{id}/borrar}")

