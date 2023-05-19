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
return concat($profesor/nombre,' ',$profesor/apellidos),

("10.	Saca los datos del último profesor. "),
for $profesor in doc("Listado")//profesor[last()]
return concat($profesor/nombre,' ',$profesor/apellidos),

("11.	Obtén todos los datos de los dos primeros profesores. "),
let $profesor:= //profesor
return $profesor[position()<3],

("12.	Muestra el número de horas que tiene asignada la asignatura de Biología. "),
for $asignatura in doc("Listado")//asignatura
where $asignatura[nombre="Biologia"]
return data($asignatura/num_horas),

("13.	Calcula la media de horas de todas las asignaturas."),
let  $asignatura := //asignatura
return avg($asignatura/num_horas),

("14.	Muestra el nombre, sin etiquetas, de todos los tutores."),
for $profesor in doc("Listado")//profesor[tutor]
return concat($profesor/nombre,' ',$profesor/apellidos),

("15.	Saca el nombre de todas las asignaturas que imparte el profesor Antonio."),
for $asignatura in doc("Listado")//asignatura
where $asignatura[@prof=(//profesor[nombre='Antonio']/@id)]
return data($asignatura/nombre),

("16.	Muestra el nombre de las asignaturas que tengan más de 3 horas de docencia. "),
for $asignatura in doc("Listado")//asignatura
where $asignatura[num_horas>3]
return data($asignatura/nombre),

("17.	Obtén el nivel y el grupo de los cursos en los que se da alguna asignatura, sin repeticiones."),
for $curso in doc("Listado")//curso
where $curso[@id=(//asignatura/@curso)]
return concat('Nivel: ',$curso/nivel,' Grupo: ', $curso/grupo),

("18.	Muestra el nombre y los apellidos de todos los profesores, sin las etiquetas y separando el nombre de los apellidos con un espacio. "),
for $profesor in doc("Listado")//profesor
return concat($profesor/nombre,' ',$profesor/apellidos),

("19.	Calcula el número total de asignaturas que hay en el documento. "),
let $asignatura := //asignatura
return count($asignatura),

("20.	Indica cuantos caracteres tiene el nombre de la segunda asignatura. "),
let $asignatura := //asignatura[2]
return string-length($asignatura/nombre),

("21.	Calcula la media de alumnos que hay en 4º de la ESO."),
let $curso :=//curso[nivel='4º ESO']
return avg($curso/alumnos),

("22.	Obtén el nombre de la asignatura que imparte la profesora Cristina en 4º de la ESO grupo A."),

for $asignatura in doc("Listado")//asignatura
where $asignatura/@prof = //profesor[nombre="Cristina"]/@id and $asignatura/@curso = //curso[nivel="4º ESO" and grupo="A"]/@id
return data($asignatura/nombre),

("23.	Muestra el nombre de todos los profesores en mayúsculas."),
for $profesor in doc("Listado")//profesor
return upper-case($profesor/nombre),

("24.	Calcula el número total de alumnos que están cursando bachillerato. "),

let $curso := //curso[contains(nivel,'BACHILLER')]
return sum($curso/alumnos),

("25.	Obtén el nivel del curso en el que se da música. "),

let $curso := //curso[@id=(//asignatura[nombre='Musica']/@curso)]
return data($curso/nivel)

