("Obtener todos los datos de los perros de raza Fox Terrier."),
for $perros in doc("protectora")//perro
where $perros/raza='Fox Terrier'
return $perros,

("Obtener el nombre de los perros de 10Kg de peso o más."),
for $perros in doc("protectora")//perro
where $perros/peso>10
return data($perros/nombre),

("Obtener la raza de los perros que pesan entre 3 y 15 Kg de peso, ordenados por raza."),
for $perros in doc("protectora")//perro
where $perros/peso>=3 and $perros/peso<=15
order by $perros/raza
return data($perros/raza)