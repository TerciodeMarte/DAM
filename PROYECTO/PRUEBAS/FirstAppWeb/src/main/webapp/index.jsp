<%-- 
    Document   : index
    Created on : 1 ene 2024, 18:08:32
    Author     : TerciodeMarte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Prueba</title>
    </head>
    <body>
        <h1>Datos del usuario</h1>
        <form action="SVUser" method="POST">
            <p><label>DNI: </label><input type="text" name="dni"</p>
            <p><label>Nombre: </label><input type="text" name="nombre"</p>
            <p><label>Apellido: </label><input type="text" name="apellido"</p>
            <p><label>Apellido 2: </label><input type="text" name="apellido2"</p>
            <button type="submit">Enviar</button>
        </form>
        
    </body>
</html>
