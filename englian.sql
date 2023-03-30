-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Már 30. 22:06
-- Kiszolgáló verziója: 10.4.27-MariaDB
-- PHP verzió: 8.2.0

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
-- Tábla szerkezet ehhez a táblához `eredmenyek`
--

CREATE TABLE `eredmenyek` (
  `id` int(10) UNSIGNED NOT NULL,
  `felhasznalo_id` int(10) UNSIGNED NOT NULL,
  `temakor_id` int(10) UNSIGNED NOT NULL,
  `eredmeny` int(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `eredmenyek`
--

INSERT INTO `eredmenyek` (`id`, `felhasznalo_id`, `temakor_id`, `eredmeny`) VALUES
(1, 1, 3, 100),
(2, 1, 3, 67),
(3, 1, 3, 33),
(4, 1, 3, 67),
(5, 1, 1, 71),
(9, 1, 16, 0),
(10, 1, 16, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `felhasznalok`
--

CREATE TABLE `felhasznalok` (
  `id` int(10) UNSIGNED NOT NULL,
  `email` varchar(128) DEFAULT NULL,
  `felhasznalonev` varchar(32) DEFAULT NULL,
  `jelszo` varchar(64) DEFAULT NULL,
  `regisztracio_datuma` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `felhasznalok`
--

INSERT INTO `felhasznalok` (`id`, `email`, `felhasznalonev`, `jelszo`, `regisztracio_datuma`) VALUES
(1, 'martakrisztian97@gmail.com', 'admin', '21232f297a57a5a743894a0e4a801fc3', '2022-11-25 16:43:56'),
(23, 'test@test.hu', 'test', 'ba8e8c3e23d2e0418ced895c2b31a125', '2023-03-04 23:02:56');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szavak`
--

CREATE TABLE `szavak` (
  `id` int(10) UNSIGNED NOT NULL,
  `temakor_id` int(10) UNSIGNED NOT NULL,
  `angol` varchar(128) DEFAULT NULL,
  `magyar` varchar(128) DEFAULT NULL,
  `kep` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `szavak`
--

INSERT INTO `szavak` (`id`, `temakor_id`, `angol`, `magyar`, `kep`) VALUES
(1, 1, 'almond', 'mandula', 'almond.png'),
(2, 1, 'apple', 'alma', 'apple.png'),
(3, 1, 'apricot', 'sárgabarack', 'apricot.png'),
(4, 1, 'avocado', 'avokádó', 'avocado.png'),
(5, 1, 'banana', 'banán', 'banana.png'),
(6, 1, 'blackberry', 'szeder', 'blackberry.png'),
(7, 1, 'blackcurrant', 'feketeribizli', 'blackcurrant.png'),
(8, 1, 'blueberry', 'fekete áfonya', 'blueberry.png'),
(9, 1, 'cantaloupe', 'sárgadinnye', 'cantaloupe.png'),
(10, 1, 'cherry', 'cseresznye', 'cherry.png'),
(11, 1, 'chestnut', 'gesztenye', 'chestnut.png'),
(12, 1, 'coconut', 'kókuszdió', 'coconut.png'),
(13, 1, 'cranberry', 'áfonya', 'cranberry.png'),
(14, 1, 'date', 'datolya', 'date.png'),
(15, 1, 'dragon fruit', 'sárkánygyümölcs', 'dragon_fruit.png'),
(16, 1, 'elderberry', 'bodza', 'elderberry.png'),
(17, 1, 'fig', 'füge', 'fig.png'),
(18, 1, 'gooseberry', 'egres', 'gooseberry.png'),
(19, 1, 'grape', 'szőlő', 'grape.png'),
(20, 1, 'grapefruit', 'gréfrút', 'grapefruit.png'),
(21, 1, 'hazelnut', 'mogyoró', 'hazelnut.png'),
(22, 1, 'kiwi', 'kivi', 'kiwi.png'),
(23, 1, 'lemon', 'citrom', 'lemon.png'),
(24, 1, 'lime', 'zöldcitrom', 'lime.png'),
(25, 1, 'lychee', 'licsi', 'lychee.png'),
(26, 1, 'mango', 'mangó', 'mango.png'),
(27, 1, 'nectarine', 'nektarin', 'nectarine.png'),
(28, 1, 'orange', 'narancs', 'orange.png'),
(29, 1, 'passion fruit', 'maracuja', 'passion_fruit.png'),
(30, 1, 'peach', 'őszibarack', 'peach.png'),
(31, 1, 'peanut', 'földimogyoró', 'peanut.png'),
(32, 1, 'pear', 'körte', 'pear.png'),
(33, 1, 'pineapple', 'ananász', 'pineapple.png'),
(34, 1, 'pistachio', 'pisztácia', 'pistachio.png'),
(35, 1, 'plum', 'szilva', 'plum.png'),
(36, 1, 'pomegranate', 'gránátalma', 'pomegranate.png'),
(37, 1, 'quince', 'birs', 'quince.png'),
(38, 1, 'raisin', 'mazsola', 'raisin.png'),
(39, 1, 'raspberry', 'málna', 'raspberry.png'),
(40, 1, 'redcurrant', 'ribizli', 'redcurrant.png'),
(41, 1, 'rosehip', 'csipkebogyó', 'rosehip.png'),
(42, 1, 'sour cherry', 'meggy', 'sour_cherry.png'),
(43, 1, 'starfruit', 'csillaggyümölcs', 'starfruit.png'),
(44, 1, 'strawberry', 'eper', 'strawberry.png'),
(45, 1, 'tangerine', 'mandarin', 'tangerine.png'),
(46, 1, 'walnut', 'dió', 'walnut.png'),
(47, 1, 'watermelon', 'görögdinnye', 'watermelon.png'),
(48, 16, 'TESZT', '1', 'proba.png'),
(49, 16, '11111', '111111', 'proba.png'),
(54, 16, 'wwqqwwq', 'qwwqqwqw', 'proba.png');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tananyag`
--

CREATE TABLE `tananyag` (
  `id` int(10) UNSIGNED NOT NULL,
  `felhasznalo_id` int(10) UNSIGNED NOT NULL,
  `temakor_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `tananyag`
--

INSERT INTO `tananyag` (`id`, `felhasznalo_id`, `temakor_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(20, 23, 1),
(21, 23, 2),
(22, 23, 3),
(23, 23, 4),
(24, 23, 5),
(32, 1, 16);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `temakorok`
--

CREATE TABLE `temakorok` (
  `id` int(10) UNSIGNED NOT NULL,
  `megnevezes` varchar(20) DEFAULT NULL,
  `kep` varchar(32) DEFAULT NULL,
  `mappa` varchar(32) DEFAULT NULL,
  `beepitett` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `temakorok`
--

INSERT INTO `temakorok` (`id`, `megnevezes`, `kep`, `mappa`, `beepitett`) VALUES
(1, 'Gyümölcsök', 'fruits.png', 'fruits', 1),
(2, 'Zöldségek', 'vegetables.png', 'vegetables', 1),
(3, 'Színek', 'colors.png', 'colors', 1),
(4, 'Állatok', 'animals.png', 'animals', 1),
(5, 'Anyagok', 'materials.png', 'materials', 1),
(16, 'teszt1', 'proba.png', '', 0);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `eredmenyek`
--
ALTER TABLE `eredmenyek`
  ADD PRIMARY KEY (`id`),
  ADD KEY `felhasznalo_kapcsolat2` (`felhasznalo_id`),
  ADD KEY `temakor_kapcsolat2` (`temakor_id`);

--
-- A tábla indexei `felhasznalok`
--
ALTER TABLE `felhasznalok`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`,`felhasznalonev`);

--
-- A tábla indexei `szavak`
--
ALTER TABLE `szavak`
  ADD PRIMARY KEY (`id`),
  ADD KEY `temakor_idegen_kulcs` (`temakor_id`) USING BTREE;

--
-- A tábla indexei `tananyag`
--
ALTER TABLE `tananyag`
  ADD PRIMARY KEY (`id`),
  ADD KEY `felhasznalo_kapcsolat` (`felhasznalo_id`),
  ADD KEY `temakor_kapcsolat` (`temakor_id`) USING BTREE;

--
-- A tábla indexei `temakorok`
--
ALTER TABLE `temakorok`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `eredmenyek`
--
ALTER TABLE `eredmenyek`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT a táblához `felhasznalok`
--
ALTER TABLE `felhasznalok`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT a táblához `szavak`
--
ALTER TABLE `szavak`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT a táblához `tananyag`
--
ALTER TABLE `tananyag`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT a táblához `temakorok`
--
ALTER TABLE `temakorok`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `eredmenyek`
--
ALTER TABLE `eredmenyek`
  ADD CONSTRAINT `felhasznalo_kapcsolat2` FOREIGN KEY (`felhasznalo_id`) REFERENCES `felhasznalok` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `temakor_kapcsolat2` FOREIGN KEY (`temakor_id`) REFERENCES `temakorok` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `szavak`
--
ALTER TABLE `szavak`
  ADD CONSTRAINT `temakor_idegen_kulcs` FOREIGN KEY (`temakor_id`) REFERENCES `temakorok` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `tananyag`
--
ALTER TABLE `tananyag`
  ADD CONSTRAINT `felhasznalo_kapcsolat` FOREIGN KEY (`felhasznalo_id`) REFERENCES `felhasznalok` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tematika_kapcsolat` FOREIGN KEY (`temakor_id`) REFERENCES `temakorok` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
