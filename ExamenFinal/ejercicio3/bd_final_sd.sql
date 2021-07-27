-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-07-2021 a las 03:23:14
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_final_sd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombres` varchar(48) NOT NULL,
  `apellidos` varchar(48) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(48) NOT NULL,
  `celular` varchar(16) NOT NULL,
  `cu` char(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombres`, `apellidos`, `sexo`, `fecha_nacimiento`, `direccion`, `celular`, `cu`) VALUES
(1, 'juan', 'perez', 'masculino', '1999-06-01', 'junin # 3', '76543210', '35-4266'),
(2, 'anita', 'perez', 'femenino', '2005-06-13', 'junin # 100', '78965241', '35-4111'),
(3, 'hortencia', 'lopez', 'femenino', '2003-05-09', 'loa# 501', '7543123', '35-100');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(10) UNSIGNED NOT NULL,
  `fullname` varchar(48) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(128) NOT NULL,
  `nivel` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `fullname`, `username`, `password`, `nivel`) VALUES
(1, 'Luis Fernando Salgado Miguez', 'fermelli', '12345', 1),
(2, 'Juan Perez', 'user', '54321', 0),
(3, 'Ana Perez', 'anita', '123', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cu` (`cu`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
