-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-09-2023 a las 16:48:07
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `arriendos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arriendoproductos`
--

CREATE TABLE `arriendoproductos` (
  `id` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `inicio` varchar(20) NOT NULL,
  `fin` varchar(20) NOT NULL,
  `estado` int(11) NOT NULL DEFAULT 1,
  `id_ejemplar` int(11) NOT NULL,
  `id_reserva` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `arriendoproductos`
--

INSERT INTO `arriendoproductos` (`id`, `precio`, `cantidad`, `inicio`, `fin`, `estado`, `id_ejemplar`, `id_reserva`) VALUES
(1, '10.00', 1, '2023-08-11', '2023-08-12', 1, 1, 1),
(2, '10.00', 1, '2023-08-11', '2023-08-12', 1, 2, 1),
(3, '10.00', 1, '2023-08-15', '2023-08-16', 1, 2, 2),
(4, '10.00', 1, '2023-08-15', '2023-08-16', 1, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arriendos`
--

CREATE TABLE `arriendos` (
  `id` int(11) NOT NULL,
  `fecha` varchar(30) NOT NULL,
  `obs` text DEFAULT NULL,
  `estado` varchar(150) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_reserva` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `arriendos`
--

INSERT INTO `arriendos` (`id`, `fecha`, `obs`, `estado`, `id_usuario`, `id_reserva`) VALUES
(1, '2023-08-11', '', 'Arrendado', 1, 2),
(2, '2023-08-11', '', 'Arrendado', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bit_arriendos`
--

CREATE TABLE `bit_arriendos` (
  `id` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `accion` varchar(150) NOT NULL,
  `campo` varchar(150) NOT NULL,
  `valor_ant` varchar(150) NOT NULL,
  `valor_nuevo` varchar(150) NOT NULL,
  `id_arriendo` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bit_arriendos`
--

INSERT INTO `bit_arriendos` (`id`, `fecha_hora`, `accion`, `campo`, `valor_ant`, `valor_nuevo`, `id_arriendo`, `id_usuario`) VALUES
(1, '2023-08-11 15:16:08', 'Nuevo Arriendo', 'estado', '', 'Arrendado', 1, 1),
(2, '2023-08-11 15:18:14', 'Nuevo Arriendo', 'estado', '', 'Arrendado', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bit_clientes`
--

CREATE TABLE `bit_clientes` (
  `id` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `accion` varchar(100) NOT NULL,
  `campo` varchar(200) NOT NULL,
  `valor_ant` varchar(150) NOT NULL,
  `valor_nuevo` varchar(150) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bit_ejemplares`
--

CREATE TABLE `bit_ejemplares` (
  `id` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `accion` varchar(100) NOT NULL,
  `campo` varchar(150) NOT NULL,
  `valor_ant` varchar(200) NOT NULL,
  `valor_nuevo` varchar(200) NOT NULL,
  `id_ejemplar` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bit_productos`
--

CREATE TABLE `bit_productos` (
  `id` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `accion` varchar(200) NOT NULL,
  `campo` varchar(100) NOT NULL,
  `valor_ant` varchar(255) NOT NULL,
  `valor_nuevo` varchar(255) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bit_reservas`
--

CREATE TABLE `bit_reservas` (
  `id` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `accion` varchar(100) NOT NULL,
  `campo` varchar(150) NOT NULL,
  `valor_ant` varchar(200) NOT NULL,
  `valor_nuevo` varchar(200) NOT NULL,
  `id_reserva` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bit_reservas`
--

INSERT INTO `bit_reservas` (`id`, `fecha_hora`, `accion`, `campo`, `valor_ant`, `valor_nuevo`, `id_reserva`, `id_usuario`) VALUES
(1, '2023-08-11 15:12:50', 'Registro de Nuevo Reserva', '', '', '', 1, 1),
(2, '2023-08-11 15:15:52', 'Registro de Nuevo Reserva', '', '', '', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `ap_paterno` varchar(150) NOT NULL,
  `ap_materno` varchar(150) NOT NULL,
  `f_nac` varchar(30) NOT NULL,
  `correo` varchar(150) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `movil` varchar(50) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `barrio` varchar(200) NOT NULL,
  `ciudad` varchar(150) NOT NULL,
  `pais` varchar(100) NOT NULL,
  `estado` varchar(150) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `doc_dni` varchar(150) DEFAULT NULL,
  `doc_boleta` varchar(150) DEFAULT NULL,
  `comentarios` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `dni`, `nombre`, `ap_paterno`, `ap_materno`, `f_nac`, `correo`, `telefono`, `movil`, `direccion`, `barrio`, `ciudad`, `pais`, `estado`, `fecha`, `doc_dni`, `doc_boleta`, `comentarios`) VALUES
(1, '312312321', 'PRIMER', 'CLIENTE', 'APELLIDO', '04-08-2000', 'CORREO@GMAIL.COM', '986897879', '9789887987', 'PERU', 'PERU', 'Buenos Aires', 'Argentina', 'Aprobado', '2023-08-11 14:25:23', '312312321', NULL, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `geolocalizacion` varchar(200) NOT NULL,
  `estado` varchar(200) NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`id`, `nombre`, `geolocalizacion`, `estado`, `id_producto`) VALUES
(1, 'PRIMER EJEMPLAR', 'Parchero 1', 'Disponible', 1),
(2, 'SEGUNDO PRODUCTO', 'Parchero 2', 'Disponible', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `otroscargos`
--

CREATE TABLE `otroscargos` (
  `id` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `monto` decimal(10,2) NOT NULL,
  `comentarios` text NOT NULL,
  `id_arriendo` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `descripcion` text NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `ficha_tecnica` varchar(150) DEFAULT NULL,
  `comentarios` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `estado`, `ficha_tecnica`, `comentarios`) VALUES
(1, 'PRIMER PRODUCTO', 'HOLO QUE TAL', '10.00', 0, 'Aprobado', 'ficha', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `fecha` varchar(30) NOT NULL,
  `f_inicio` varchar(30) NOT NULL,
  `f_fin` varchar(30) NOT NULL,
  `f_devolucion` varchar(30) DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `otros` decimal(10,2) NOT NULL DEFAULT 0.00,
  `obs` text DEFAULT NULL,
  `estado` varchar(150) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `fecha`, `f_inicio`, `f_fin`, `f_devolucion`, `total`, `otros`, `obs`, `estado`, `id_cliente`, `id_usuario`) VALUES
(1, '2023-08-11', '2023-08-11', '2023-08-12', '2023-08-12', '20.00', '0.00', '', 'Arrendado', 1, 1),
(2, '2023-08-11', '2023-08-15', '2023-08-16', '2023-08-16', '20.00', '0.00', '', 'Arrendado', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `ap_paterno` varchar(100) NOT NULL,
  `ap_materno` varchar(100) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `correo` varchar(150) NOT NULL,
  `clave` varchar(200) NOT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `estado` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `nombre`, `ap_paterno`, `ap_materno`, `telefono`, `direccion`, `correo`, `clave`, `codigo`, `fecha`, `estado`) VALUES
(1, 'admin', 'ADMINISTRADOR', 'PATERNO', 'MATERNO n', '980786543', 'PERU', 'info@angelsifuentes.net', 'admin', NULL, '2023-08-04 18:36:45', 1),
(2, 'segundo', 'segundo EDITADO', 'usuario', 'apellido', '98778987987', 'peru', 'correo@gmail.com', '12345', NULL, '2023-08-04 01:35:02', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `arriendoproductos`
--
ALTER TABLE `arriendoproductos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ejemplar` (`id_ejemplar`),
  ADD KEY `id_reserva` (`id_reserva`);

--
-- Indices de la tabla `arriendos`
--
ALTER TABLE `arriendos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_reserva` (`id_reserva`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `bit_arriendos`
--
ALTER TABLE `bit_arriendos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_arriendo` (`id_arriendo`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `bit_clientes`
--
ALTER TABLE `bit_clientes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `bit_ejemplares`
--
ALTER TABLE `bit_ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ejemplar` (`id_ejemplar`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `bit_productos`
--
ALTER TABLE `bit_productos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `bit_reservas`
--
ALTER TABLE `bit_reservas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_arriendo` (`id_reserva`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `otroscargos`
--
ALTER TABLE `otroscargos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_arriendo` (`id_arriendo`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `arriendoproductos`
--
ALTER TABLE `arriendoproductos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `arriendos`
--
ALTER TABLE `arriendos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `bit_arriendos`
--
ALTER TABLE `bit_arriendos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `bit_clientes`
--
ALTER TABLE `bit_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `bit_ejemplares`
--
ALTER TABLE `bit_ejemplares`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `bit_productos`
--
ALTER TABLE `bit_productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `bit_reservas`
--
ALTER TABLE `bit_reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `otroscargos`
--
ALTER TABLE `otroscargos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `arriendoproductos`
--
ALTER TABLE `arriendoproductos`
  ADD CONSTRAINT `arriendoproductos_ibfk_1` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplares` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `arriendoproductos_ibfk_2` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `arriendos`
--
ALTER TABLE `arriendos`
  ADD CONSTRAINT `arriendos_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `arriendos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bit_arriendos`
--
ALTER TABLE `bit_arriendos`
  ADD CONSTRAINT `bit_arriendos_ibfk_1` FOREIGN KEY (`id_arriendo`) REFERENCES `arriendos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bit_arriendos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bit_clientes`
--
ALTER TABLE `bit_clientes`
  ADD CONSTRAINT `bit_clientes_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bit_clientes_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bit_ejemplares`
--
ALTER TABLE `bit_ejemplares`
  ADD CONSTRAINT `bit_ejemplares_ibfk_1` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplares` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bit_ejemplares_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bit_productos`
--
ALTER TABLE `bit_productos`
  ADD CONSTRAINT `bit_productos_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bit_productos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bit_reservas`
--
ALTER TABLE `bit_reservas`
  ADD CONSTRAINT `bit_reservas_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bit_reservas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `ejemplares_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `otroscargos`
--
ALTER TABLE `otroscargos`
  ADD CONSTRAINT `otroscargos_ibfk_1` FOREIGN KEY (`id_arriendo`) REFERENCES `arriendos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `otroscargos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
