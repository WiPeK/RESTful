-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 01 Cze 2017, 18:08
-- Wersja serwera: 10.1.19-MariaDB
-- Wersja PHP: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `car_rental`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cars`
--

CREATE TABLE `cars` (
  `id_car` int(11) NOT NULL,
  `producer` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mileage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `cars`
--

INSERT INTO `cars` (`id_car`, `producer`, `model`, `mileage`) VALUES
(1, 'Producent1', 'Model1', 123),
(2, 'Producent2', 'Model2', 12343223),
(3, 'Producent3', 'Model3', 12343223),
(4, 'Producent4', 'Model4', 1256453),
(5, 'Producent5', 'Model5', 12567453),
(6, 'Producent6', 'Model6', 123453),
(7, 'Producent7', 'Model7', 122423),
(8, 'Producent8', 'Model8', 125463),
(9, 'Producent9', 'Model9', 126546453),
(10, 'Producent10', 'Model10', 1435323);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `car_rent`
--

CREATE TABLE `car_rent` (
  `id_car_rent` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_car` int(11) NOT NULL,
  `rent_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `car_rent`
--

INSERT INTO `car_rent` (`id_car_rent`, `id_client`, `id_car`, `rent_date`) VALUES
(1, 1, 1, '2017-05-27 10:32:10'),
(2, 1, 2, '2017-05-29 09:48:51'),
(3, 3, 3, '2017-05-07 10:13:48'),
(4, 4, 4, '2017-05-12 11:42:23'),
(5, 5, 5, '2017-05-13 10:18:00'),
(6, 6, 6, '2017-05-21 14:44:28'),
(7, 7, 7, '2017-05-21 08:47:55'),
(8, 8, 8, '2017-05-29 11:19:00'),
(9, 9, 9, '2017-05-09 11:19:46'),
(10, 9, 10, '2017-05-16 12:23:00');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `clients`
--

CREATE TABLE `clients` (
  `id_client` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `clients`
--

INSERT INTO `clients` (`id_client`, `name`, `surname`, `email`) VALUES
(1, 'Imie1', 'Nazwisko1', 'email1@gmail.com'),
(2, 'Imie2', 'Nazwisko2', 'email2@gmail.com'),
(3, 'Imie3', 'Nazwisko3', 'email3@gmail.com'),
(4, 'Imie4', 'Nazwisko4', 'email4@gmail.com'),
(5, 'Imie5', 'Nazwisko5', 'email5@gmail.com'),
(6, 'Imie6', 'Nazwisko6', 'email6@gmail.com'),
(7, 'Imie7', 'Nazwisko7', 'email7@gmail.com'),
(8, 'Imie8', 'Nazwisko8', 'email8@gmail.com'),
(9, 'Imie9', 'Nazwisko9', 'email9@gmail.com'),
(10, 'Imie10', 'Nazwisko10', 'email10@gmail.com');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id_car`);

--
-- Indexes for table `car_rent`
--
ALTER TABLE `car_rent`
  ADD PRIMARY KEY (`id_car_rent`),
  ADD KEY `idClient` (`id_client`),
  ADD KEY `idCar` (`id_car`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `cars`
--
ALTER TABLE `cars`
  MODIFY `id_car` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT dla tabeli `car_rent`
--
ALTER TABLE `car_rent`
  MODIFY `id_car_rent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT dla tabeli `clients`
--
ALTER TABLE `clients`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `car_rent`
--
ALTER TABLE `car_rent`
  ADD CONSTRAINT `car_rent_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `car_rent_ibfk_2` FOREIGN KEY (`id_car`) REFERENCES `cars` (`id_car`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
