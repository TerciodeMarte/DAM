("Ejercicio1"),
/biblioteca/libro/autor,

/biblioteca/libro/autor/@fechaNacimiento,

("Ejercicio2"),
//autor,

("Ejercicio3"),
/biblioteca/libro/autor/@fechaNacimiento/..,
//@fechaNacimiento/../.., 

("Ejercicio4"),

//titulo|//@año,

("Ejercicio5"),
//autor[@fechaNacimiento],

("Ejercicio6"),
//libro[last()],

("Ejercicio7"),
(:Título de los libros publicados en 1973:)
//fechaPublicacion[@año=1973]/../titulo,

("Ejercicio8"),
(:Autor de los libros publicados antes del 73:)
//fechaPublicacion[@año<1973]/../autor,

("Ejercicio9"),
(:El primer libro escrito por Mario Vargas Llosa:)
//libro[autor="Mario Vargas Llosa" and fechaPublicacion/@año=1969]/titulo