#!/bin/bash
#recomiendo instalar tree para que funcione bien el script // apt install tree

#Me dirije a la ruta /home/user desde cualquier otra ruta
echo "Ejercicio1"
cd ~
#Muestra la ruta actual
echo "La ruta actual"
pwd
echo "Ejercicio2"
ls
#Crea la carpeta Peliculas
echo "Ejercicio3"
mkdir peliculas
#Comando para acceder a al directoria peliculas
cd peliculas
#Crear el resto de directorios
mkdir accion aventura otras romance terror thriller
#Mostrar la jerarquia creada
cd ..
tree peliculas
#Crear directorio series
echo "Ejercicio4"
mkdir series
#Mostrar los dos directorios peliculas y series
echo "Los directorios actuales"
tree
#Mover directorio peliculas a series
mv peliculas series
tree series
#Entro al directorio series
cd series
#Borro el directorio terror
echo "Ejercicio5"
rm -r peliculas/terror
#Salgo del directorio series
cd ..
tree series
#Entro en videos y muestra lo que empiece por a
echo "Ejercicio6"
cd Vídeos
ls | grep a*
#Borro todo lo echo en este script
cd ~
rm -r series
echo "Borrado todo lo echo"
