
# colegioSpringBoot
Proyecto CRUD manejado por formularios y por un servicio REST. 
El manejo de la persistencia se hace contra una base de datos MySQL mediante Hibernate en JPA. 
Las pantallas de la aplicación se implementarán con plantillas Thymeleaf. 
El servicio deberá ejecutarse en un Apache Tomcat v.9 
- Las propiedades para la conexion a la base de datosse encuentran en el archivo 'application.properties' 
- El IDE de desarrollo empleado es Sprint Tool Suite 4.10 y se utilizó Maven para su construcción. 
- Se entregaron dos proyectos: uno para el backend y otro para el frontend. 


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

