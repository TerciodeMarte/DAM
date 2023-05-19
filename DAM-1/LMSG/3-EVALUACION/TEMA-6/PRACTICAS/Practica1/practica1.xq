("1.	Obtén todos los elementos asignatura del documento. "),
for $asignatura in doc("Listado")//asignatura
return $asignatura,

("2.	Obtén todos los elementos nombre del documento. "),
for $nombre in doc("Listado")//nombre
return $nombre,

("3.	Muestra los nombres de las asignaturas. "),
for $asignatura in doc("Listado")//asignatura
return data($asignatura/nombre),

("4.	Saca todos los elementos hijos de cada asignatura. "),
for $asignatura in doc("Listado")//asignatura
return $asignatura/*,

("5.	Obtén todos los atributos de cada asignatura. "),
for $asignatura in doc("Listado")//asignatura
return $asignatura/@*,

("6.	Muestra el id de todos los cursos. "),
for $curso in doc("Listado")//curso
return $curso/@id,

("7.	Saca el nombre y los apellidos de cada profesor. "),
for $profesor in doc("Listado")//profesor
return $profesor/*,

("8.	Muestra la misma información sin que aparezcan las etiquetas, solo deben salir los datos. "),
for $profesor in doc("Listado")//profesor
return concat($profesor/nombre,' ',$profesor/apellidos),

("9.	Obtén los datos del segundo profesor. "),
for $profesor in doc("Listado")//profesor[2]
return concat($profesor/nombre,' ',$profesor/apellidos)