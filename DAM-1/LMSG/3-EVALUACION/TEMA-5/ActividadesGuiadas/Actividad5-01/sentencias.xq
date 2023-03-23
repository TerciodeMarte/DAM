("1. Obtén todos los elementos asignatura del documento."),
//asignatura,
("2. Obtén todos los elementos nombre del documento."),
//nombre,
("3. Muestra los nombres de las asignaturas."),
//asignatura/nombre/text(),
("4. Saca todos los elementos hijos de cada asignatura."),
//asignatura/node(),
("5. Obtén todos los atributos de cada asignatura.")
//asignatura/@node(),
("6. Muestra el id de todos los cursos."),
//curso/@id,
("7. Saca el nombre y los apellidos de cada profesor."),
//profesor/nombre|//prosefor/apellidos,
("8. Muestra la misma información sin que aparezcan las 
etiquetas, solo deben salir los datos."),
//profesor/node()/text(),
("9. Obtén los datos del segundo profesor."),
//profesor[2]/node()/text(),
("10. Saca los datos del último profesor."),
//profesor[last()]/node()/text(),
("11. Obtén todos los datos de los dos primeros profesores."),
//profesor[1]/node()/text()|//profesor[2]/node()/text(),
//profesor[position()<=2]/node()/text(),
("12. Muestra el número de horas que tiene asignada la asignatura 
de Biología."),
//asignatura/nombre[.="Biologia"]/../num_horas/number(),
("13. Calcula la media de horas de todas las asignaturas."),
avg(//num_horas/number()),
("14. Muestra el nombre, sin etiquetas, de todos los tutores."),
//profesor[tutor]/nombre/text(),
("15. Saca el nombre de todas las asignaturas que imparte el profesor Antonio."),
//asignatura[@prof=[//profesor[nombre="Antonio"]/@id]]/nombre/text(),
("16. Muestra el nombre de las asignaturas que tengan más de 3 
horas de docencia."),
//asignatura[num_horas>3]/nombre/text(),
("17. Obtén el código de los cursos en los que se da alguna 
asignatura, sin repeticiones."),
//curso[@id=//@curso]/@id,
(:Con funcion de xpath:)
distinct-values(//@curso),
("18. Muestra el nombre y los apellidos del último profesor, sin 
las etiquetas y separando el nombre de los apellidos con un 
espacio."),
(:Forma larga:)
concat(//profesor[last()]/nombre/text()," ",//profesor[last()]/apellidos/text()),
(:Forma corta:)
//profesor[last()]/concat(nombre," ",apellidos),
("19. Calcula el número total de asignaturas que hay en el 
documento."),
count(//asignatura),
("20. Indica cuantos caracteres tiene el nombre de la segunda 
asignatura."),
string-length(//asignatura[2]/nombre),
("21. Calcula la media de alumnos que hay en 4º de la ESO."),
avg(//curso[nivel="4º ESO"]/alumnos),
("22. Obtén el nombre de la asignatura que imparte la profesora 
Cristina en 4º de la ESO grupo A."),
//asignatura[@prof=[//profesor[nombre="Carmen"]/@id] and @curso=[//curso[nivel="4º ESO" and grupo="A"]/@id]]/nombre/text(),
("23. Muestra el nombre del tercer profesor en mayúsculas."),
upper-case(//profesor[3]/nombre/text()),
("24. Calcula el número total de alumnos que están cursando 
bachillerato."),
sum(//curso[contains(nivel,"BACHILLER")]/alumnos/number()),
("25. Obtén el nivel del curso en el que se da música."),
//curso[@id=[//asignatura[nombre="Musica"]/@curso]]/nivel/text()
