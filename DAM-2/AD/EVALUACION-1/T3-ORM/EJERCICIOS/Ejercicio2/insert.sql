use tienda;

insert into cliente (nombre, password) values
('Ana', 'ana123'),
('Pedro', 'pedro456'),
('Luis', 'luis789'),
('Marta', 'marta101'),
('Carlos', 'carlos202'),
('Sofía', 'sofia303'),
('Juan', 'juan404'),
('Elena', 'elena505'),
('David', 'david606'),
('Laura', 'laura707');

insert into categoria (nombre) values
('Electrónica'),
('Libros'),
('Ropa'),
('Deportes'),
('Juguetes'),
('Música'),
('Cine'),
('Belleza'),
('Hogar'),
('Mascotas');

insert into producto (nombre, fkcategoria, pvp, stock) values
('iPhone 12', 1, 999.99, 20),
('El principito', 2, 9.99, 50),
('Camiseta Nike', 3, 19.99, 30),
('Balón de fútbol', 4, 14.99, 40),
('Lego Star Wars', 5, 49.99, 15),
('Guitarra eléctrica', 6, 199.99, 10),
('Harry Potter y la piedra filosofal', 7, 12.99, 25),
('Crema hidratante', 8, 7.99, 60),
('Sartén antiadherente', 9, 24.99, 35),
('Collar para perro', 10, 4.99, 45);

insert into carrito (fkcliente, fecha) values
(1, '2023-11-22'),
(2, '2023-11-21'),
(3, '2023-11-20'),
(4, '2023-11-19'),
(5, '2023-11-18'),
(6, '2023-11-17'),
(7, '2023-11-16'),
(8, '2023-11-15'),
(9, '2023-11-14'),
(10, '2023-11-13');

insert into lineacarrito (fkcarrito, fkproducto, unidades) values
(1, 1, 2),
(2, 2, 1),
(3, 3, 3),
(4, 4, 2),
(5, 5, 1),
(6, 6, 2),
(7, 7, 3),
(8, 8, 1),
(9, 9, 2),
(10, 10, 3);

