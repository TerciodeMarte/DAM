#!/bin/bash
 
OLDIFS=$IFS
IFS=","
 
while read firstname lastname userid 
do
       
     useradd -c "${firstname} ${lastname}"  -d /home/"${userid}" -s /bin/bash "${userid}"           
     echo "Usuario: ${userid} " >> resultado.txt 
done < usuarios.csv