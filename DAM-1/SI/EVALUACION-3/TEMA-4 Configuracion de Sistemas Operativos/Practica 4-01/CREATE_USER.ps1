#Creacion de Usuarios a traves de un script
#Importar usuarios desde el csv(Especificar ruta)
$usuarios=import-csv -Path C:\Users\Admin\Desktop\usuarios.csv
#Bucle para crear todos los usuarios
foreach ($i in $usuarios)
{
    #Buscar clave de usuario
    $clave=ConvertTo-SecureString $i.contra -AsPlainText -Force
    #Comando para crear usuario
    New-LocalUser $i.nombre -Password $clave -AccountNeverExpires -PasswordNeverExpires
    Add-LocalGroupMember -Group usuarios -Member $i.nombre
}