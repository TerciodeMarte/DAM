-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-01-2020 a las 22:57:04
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Examen_Tema5`
--
CREATE DATABASE IF NOT EXISTS `Examen_Tema5` DEFAULT CHARACTER SET latin1 ;
USE `Examen_Tema5`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

DROP TABLE IF EXISTS `articulos`;
CREATE TABLE `articulos` (
  `Id_articulo` int(11) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`Id_articulo`, `Descripcion`, `Precio`) VALUES
(1, 'ASUS GEFORCE RTX-4060 8GB', '352.99'),
(2, 'ASUS GEFORCE RTX-3050 8GB', '258.99'),
(3, 'MSI NVIDIA RTX-4070 12GB GDDR6X', '630.81'),
(4, 'Asus NVIDIA GeForce RTX-4090 24GB GDDR6X', '2290.00'),
(5, 'GIGABYTE GeForce RTX-4060 Ti 8GB', '490.32'),
(6, 'AMD Radeon RX-6750 XT 12GB', '424.74'),
(7, 'Asus AMD Radeon RX-6600 8GB', '286.52');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `ID_Cliente` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Direccion` varchar(80) NOT NULL,
  `Ciudad` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ID_Cliente`, `Nombre`, `Direccion`, `Ciudad`) VALUES
(1, 'Error 404: Genius Not Found Tech Solutions S.L', 'Carretera de Badajoz, no. 181', 'Almendralejo'),
(2, 'Tech-a-lot: Where Geeks Rule S.L', 'Parque del Principe, no.18', 'Caceres'),
(3, 'No hay Palitos Pa Tanto Cafe, S.L.U', 'Calle Canarias, No.89', 'Madrid'),
(4, 'GeekyIbai IT Adventures', 'Calle Pizarro, no.78', 'Sevilla'),
(5, 'En Casa Me Funciona, S.A', 'Calle La Piedad, no.5', 'Salamanca'),
(6, 'Becarios Solo Puede Quedar 1,S.L', 'Calle Gran Via, no.13', 'Madrid'),
(7, 'CRTL+P Solution, S.L.U', 'Avenida Almonte, no.59', 'Santander');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedidos`
--

DROP TABLE IF EXISTS `detalle_pedidos`;
CREATE TABLE `detalle_pedidos` (
  `ID_Venta` int(11) NOT NULL,
  `ID_Articulo` int(11) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Unidades` int(11) NOT NULL,
  `ID_Pedido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_pedidos`
--

INSERT INTO `detalle_pedidos` (`ID_Venta`, `ID_Articulo`, `Precio`, `Unidades`, `ID_Pedido`) VALUES
(1, 1, '1352.99', 102, 1),
(2, 2, '258.995', 405, 1),
(3, 7, '286.52', 1080, 1),
(4, 1, '352.99', 395, 2),
(5, 3, '630.81', 99, 2),
(6, 6, '424.74', 125, 2),
(7, 4, '2290.00', 580, 3),
(8, 5, '490.32', 76, 3),
(9, 6, '424.74', 87, 4),
(10, 7, '286.52', 58, 4),
(11, 7, '286.52', 10, 5),
(12, 3, '630.81', 66, 5),
(13, 1, '352.99', 75, 4),
(14, 7, '286.52', 45, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emails`
--

DROP TABLE IF EXISTS `emails`;
CREATE TABLE `emails` (
  `Id_cliente` int(11) NOT NULL,
  `Email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `emails`
--

INSERT INTO `emails` (`Id_cliente`, `Email`) VALUES
(1, 'ibai.llanos@ibaillanos.com'),
(2, 'elrubius@elrubius.com'),
(3, 'contacto@auronplay.com'),
(4, 'contacto@willyrex.com'),
(6, 'hola@thegrefg.com'),
(6, 'info@vegetta777.com'),
(7, 'contact@thewildproject.com'),
(7, 'nategentile@email.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos` (
  `ID_Pedido` int(11) NOT NULL,
  `ID_Cliente` int(11) DEFAULT NULL,
  `Fecha_Pedido` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`ID_Pedido`, `ID_Cliente`, `Fecha_Pedido`) VALUES
(1, 1, '2023-12-09 10:17:00'),
(2, 1, '2023-01-01 08:06:00'),
(3, 2, '2023-11-12 13:13:00'),
(4, 2, '2023-01-02 17:09:00'),
(5, 3, '2023-11-04 10:09:00'),
(6, 4, '2023-11-04 15:05:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
CREATE TABLE `telefonos` (
  `Id_Cliente` int(11) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  `Persona_Contacto` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `telefonos`
--

INSERT INTO `telefonos` (`Id_Cliente`, `Telefono`, `Persona_Contacto`) VALUES
(1, '924660001', 'Ibai Llanos '),
(2, '924314959', 'ElRubius'),
(3, '91333444', 'AuronPlay'),
(4, '955123987', 'Willyrex'),
(4, '955123988', 'TheGrefg'),
(6, '91340340', 'Vegetta777'),
(6, '91341341', 'TheWildProject'),
(7, '942661570', 'Nate Gentile'),
(7, '942661571', 'Linus Tech Tips');

--
-- indices para tablas volcadas
--

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`Id_articulo`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ID_Cliente`);

--
-- Indices de la tabla `detalle_pedidos`
--
ALTER TABLE `detalle_pedidos`
  ADD PRIMARY KEY (`ID_Venta`),
  ADD KEY `ID_PEDIDO_FK` (`ID_Pedido`),
  ADD KEY `ID_ARTICULO_FK` (`ID_Articulo`);

--
-- Indices de la tabla `emails`
--
ALTER TABLE `emails`
  ADD PRIMARY KEY (`Id_cliente`,`Email`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`ID_Pedido`),
  ADD KEY `ID_Cliente` (`ID_Cliente`);

--
-- Indices de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD PRIMARY KEY (`Id_Cliente`,`Telefono`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulos`
--
ALTER TABLE `articulos`
  MODIFY `Id_articulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ID_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `detalle_pedidos`
--
ALTER TABLE `detalle_pedidos`
  MODIFY `ID_Venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `ID_Pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedidos`
--
ALTER TABLE `detalle_pedidos`
  ADD CONSTRAINT `ID_ARTICULO_FK` FOREIGN KEY (`ID_Articulo`) REFERENCES `articulos` (`Id_articulo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `ID_PEDIDO_FK` FOREIGN KEY (`ID_Pedido`) REFERENCES `pedidos` (`ID_Pedido`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `emails`
--
ALTER TABLE `emails`
  ADD CONSTRAINT `ID_cliente_email_FK` FOREIGN KEY (`Id_cliente`) REFERENCES `clientes` (`ID_Cliente`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `ID_CLIENTES_FK` FOREIGN KEY (`ID_Cliente`) REFERENCES `clientes` (`ID_Cliente`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD CONSTRAINT `ID_Cliente_FK` FOREIGN KEY (`Id_Cliente`) REFERENCES `clientes` (`ID_Cliente`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
