-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Nov 11. 22:55
-- Kiszolgáló verziója: 10.4.24-MariaDB
-- PHP verzió: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `englian`
--
CREATE DATABASE IF NOT EXISTS `englian` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci;
USE `englian`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szavak`
--

CREATE TABLE `szavak` (
  `id` int(10) UNSIGNED NOT NULL,
  `tematika_id` int(10) UNSIGNED NOT NULL,
  `angol` varchar(32) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `magyar` varchar(32) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `kep_fajlnev` varchar(32) COLLATE utf8mb4_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `szavak`
--

INSERT INTO `szavak` (`id`, `tematika_id`, `angol`, `magyar`, `kep_fajlnev`) VALUES
(1, 1, 'almond', 'mandula', 'almond.png'),
(2, 1, 'apple', 'alma', 'apple.png'),
(3, 1, 'apricot', 'sárgabarack', 'apricot.png'),
(4, 1, 'avocado', 'avokádó', 'avocado.png'),
(5, 1, 'banana', 'banán', 'banana.png'),
(6, 1, 'bilberry', 'áfonya', 'bilberry.png'),
(7, 1, 'blackberry', 'szeder', 'blackberry.png'),
(8, 1, 'blackcurrant', 'feketeribizli', 'blackcurrant.png'),
(9, 1, 'blackthorn', 'kökény', 'blackthorn.png'),
(10, 1, 'blueberry', 'fekete áfonya', 'blueberry.png'),
(11, 1, 'cantaloupe', 'sárgadinnye', 'cantaloupe.png'),
(12, 1, 'cherry', 'cseresznye', 'cherry.png'),
(13, 1, 'chestnut', 'gesztenye', 'chestnut.png'),
(14, 1, 'coconut', 'kókuszdió', 'coconut.png'),
(15, 1, 'cranberry', 'áfonya', 'cranberry.png'),
(16, 1, 'date', 'datolya', 'date.png'),
(17, 1, 'dragon fruit', 'sárkánygyümölcs', 'dragon_fruit.png'),
(18, 1, 'elderberry', 'bodza', 'elderberry.png'),
(19, 1, 'fig', 'füge', 'fig.png'),
(20, 1, 'gooseberry', 'egres', 'gooseberry.png'),
(21, 1, 'grape', 'szőlő', 'grape.png'),
(22, 1, 'grapefruit', 'gréfrút', 'grapefruit.png'),
(23, 1, 'hazelnut', 'mogyoró', 'hazelnut.png'),
(24, 1, 'kiwi', 'kivi', 'kiwi.png'),
(25, 1, 'lemon', 'citrom', 'lemon.png'),
(26, 1, 'lime', 'zöldcitrom', 'lime.png'),
(27, 1, 'lychee', 'licsi', 'lychee.png'),
(28, 1, 'mango', 'mangó', 'mango.png'),
(29, 1, 'nectarine', 'nektarin', 'nectarine.png'),
(30, 1, 'orange', 'narancs', 'orange.png'),
(31, 1, 'passion fruit', 'maracuja', 'passion_fruit.png'),
(32, 1, 'peach', 'őszibarack', 'peach.png'),
(33, 1, 'peanut', 'földimogyoró', 'peanut.png'),
(34, 1, 'pear', 'körte', 'pear.png'),
(35, 1, 'pineapple', 'ananász', 'pineapple.png'),
(36, 1, 'pistachio', 'pisztácia', 'pistachio.png'),
(37, 1, 'plum', 'szilva', 'plum.png'),
(38, 1, 'pomegranate', 'gránátalma', 'pomegranate.png'),
(39, 1, 'quince', 'birs', 'quince.png'),
(40, 1, 'raisin', 'mazsola', 'raisin.png'),
(41, 1, 'raspberry', 'málna', 'raspberry.png'),
(42, 1, 'redcurrant', 'ribizli', 'redcurrant.png'),
(43, 1, 'rosehip', 'csipkebogyó', 'rosehip.png'),
(44, 1, 'sour cherry', 'meggy', 'sour_cherry.png'),
(45, 1, 'starfruit', 'csillaggyümölcs', 'starfruit.png'),
(46, 1, 'strawberry', 'eper', 'strawberry.png'),
(47, 1, 'tangerine', 'mandarin', 'tangerine.png'),
(48, 1, 'walnut', 'dió', 'walnut.png'),
(49, 1, 'watermelon', 'görögdinnye', 'watermelon.png');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tematikak`
--

CREATE TABLE `tematikak` (
  `id` int(10) UNSIGNED NOT NULL,
  `megnevezes` varchar(32) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `mappa_utvonal` varchar(32) COLLATE utf8mb4_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `tematikak`
--

INSERT INTO `tematikak` (`id`, `megnevezes`, `mappa_utvonal`) VALUES
(1, 'gyümölcs', 'images/fruits/');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `szavak`
--
ALTER TABLE `szavak`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ketogria_idegen_kulcs` (`tematika_id`);

--
-- A tábla indexei `tematikak`
--
ALTER TABLE `tematikak`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `szavak`
--
ALTER TABLE `szavak`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT a táblához `tematikak`
--
ALTER TABLE `tematikak`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `szavak`
--
ALTER TABLE `szavak`
  ADD CONSTRAINT `ketogria_idegen_kulcs` FOREIGN KEY (`tematika_id`) REFERENCES `tematikak` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
