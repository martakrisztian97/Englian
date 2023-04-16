-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Ápr 17. 00:42
-- Kiszolgáló verziója: 10.4.28-MariaDB
-- PHP verzió: 8.2.4

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
(5, 1, 1, 71);

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
(2, 'teszt@elek.hu', 'tesztelek', 'f9bc9298daf9e0c426b55bd899e5ea9d', '2022-12-19 23:10:14');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szavak`
--

CREATE TABLE `szavak` (
  `id` int(10) UNSIGNED NOT NULL,
  `temakor_id` int(10) UNSIGNED NOT NULL,
  `angol` varchar(32) DEFAULT NULL,
  `magyar` varchar(32) DEFAULT NULL,
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
(8, 1, 'blueberry', 'kék áfonya', 'blueberry.png'),
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
(29, 1, 'papaya', 'papaja', 'papaya.png'),
(30, 1, 'passion fruit', 'maracuja', 'passion_fruit.png'),
(31, 1, 'peach', 'őszibarack', 'peach.png'),
(32, 1, 'peanut', 'földimogyoró', 'peanut.png'),
(33, 1, 'pear', 'körte', 'pear.png'),
(34, 1, 'pineapple', 'ananász', 'pineapple.png'),
(35, 1, 'pistachio', 'pisztácia', 'pistachio.png'),
(36, 1, 'plum', 'szilva', 'plum.png'),
(37, 1, 'pomegranate', 'gránátalma', 'pomegranate.png'),
(38, 1, 'quince', 'birs', 'quince.png'),
(39, 1, 'raisin', 'mazsola', 'raisin.png'),
(40, 1, 'raspberry', 'málna', 'raspberry.png'),
(41, 1, 'redcurrant', 'ribizli', 'redcurrant.png'),
(42, 1, 'rosehip', 'csipkebogyó', 'rosehip.png'),
(43, 1, 'sour cherry', 'meggy', 'sour_cherry.png'),
(44, 1, 'starfruit', 'csillaggyümölcs', 'starfruit.png'),
(45, 1, 'strawberry', 'eper', 'strawberry.png'),
(46, 1, 'tangerine', 'mandarin', 'tangerine.png'),
(47, 1, 'walnut', 'dió', 'walnut.png'),
(48, 1, 'watermelon', 'görögdinnye', 'watermelon.png'),
(49, 2, 'artichoke', 'articsóka', 'artichoke.png'),
(50, 2, 'asparagus', 'spárga', 'asparagus.png'),
(51, 2, 'aubergine', 'padlizsán', 'aubergine.png'),
(52, 2, 'bean', 'bab', 'bean.png'),
(53, 2, 'beetroot', 'cékla', 'beetroot.png'),
(54, 2, 'broccoli', 'brokkoli', 'broccoli.png'),
(55, 2, 'brussels sprouts', 'kelbimbó', 'brussels_sprouts.png'),
(56, 2, 'cabbage', 'káposzta', 'cabbage.png'),
(57, 2, 'carrot', 'répa', 'carrot.png'),
(58, 2, 'cauliflower', 'karfiol', 'cauliflower.png'),
(59, 2, 'celery', 'zeller', 'celery.png'),
(60, 2, 'cherry tomato', 'koktélparadicsom', 'cherry_tomato.png'),
(61, 2, 'chickpea', 'csicseriborsó', 'chickpea.png'),
(62, 2, 'chili', 'csilipaprika', 'chili.png'),
(63, 2, 'courgette', 'cukkini', 'courgette.png'),
(64, 2, 'cucumber', 'uborka', 'cucumber.png'),
(65, 2, 'French beans', 'zöldbab', 'French_beans.png'),
(66, 2, 'garlic', 'fokhagyma', 'garlic.png'),
(67, 2, 'ginger', 'gyömbér', 'ginger.png'),
(68, 2, 'kale', 'fodros kel', 'kale.png'),
(69, 2, 'kohlrabi', 'karalábé', 'kohlrabi.png'),
(70, 2, 'leek', 'póréhagyma', 'leek.png'),
(71, 2, 'lentil', 'lencse', 'lentil.png'),
(72, 2, 'lettuce', 'saláta', 'lettuce.png'),
(73, 2, 'mushroom', 'gomba', 'mushroom.png'),
(74, 2, 'onion', 'hagyma', 'onion.png'),
(75, 2, 'parsley', 'petrezselyem', 'parsley.png'),
(76, 2, 'pea', 'borsó', 'pea.png'),
(77, 2, 'pepper', 'paprika', 'pepper.png'),
(78, 2, 'potato', 'burgonya', 'potato.png'),
(79, 2, 'pumpkin', 'sütőtök', 'pumpkin.png'),
(80, 2, 'radish', 'retek', 'radish.png'),
(81, 2, 'rhubarb', 'rebarbara', 'rhubarb.png'),
(82, 2, 'sorrel', 'sóska', 'sorrel.png'),
(83, 2, 'spinach', 'spenót', 'spinach.png'),
(84, 2, 'split peas', 'sárgaborsó', 'split_peas.png'),
(85, 2, 'spring onion', 'újhagyma', 'spring_onion.png'),
(86, 2, 'squash', 'tök', 'squash.png'),
(87, 2, 'sweet corn', 'csemegekukorica', 'sweet_corn.png'),
(88, 2, 'sweet potato', 'édesburgonya', 'sweet_potato.png'),
(89, 2, 'tomato', 'paradicsom', 'tomato.png'),
(90, 2, 'turnip', 'petrezselyemgyökér', 'turnip.png'),
(91, 3, 'black', 'fekete', 'black.png'),
(92, 3, 'white', 'fehér', 'white.png'),
(93, 3, 'red', 'piros', 'red.png'),
(94, 3, 'green', 'zöld', 'green.png'),
(95, 3, 'blue', 'kék', 'blue.png'),
(96, 3, 'yellow', 'citromsárga', 'yellow.png'),
(97, 3, 'orange', 'narancssárga', 'orange.png'),
(98, 3, 'beige', 'bézs', 'beige.png'),
(99, 3, 'bronze', 'bronz', 'bronze.png'),
(100, 3, 'brown', 'barna', 'brown.png'),
(101, 3, 'cyan', 'ciánkék', 'cyan.png'),
(102, 3, 'gold', 'arany', 'gold.png'),
(103, 3, 'grey', 'szürke', 'grey.png'),
(104, 3, 'khaki', 'khaki', 'khaki.png'),
(105, 3, 'olive', 'olíva', 'olive.png'),
(106, 3, 'pink', 'rózsaszín', 'pink.png'),
(107, 3, 'purple', 'lila', 'purple.png'),
(108, 3, 'silver', 'ezüst', 'silver.png'),
(109, 3, 'turquoise', 'türkizkék', 'turquoise.png'),
(110, 4, 'bear', 'medve', 'bear.png'),
(111, 4, 'bird', 'madár', 'bird.png'),
(112, 4, 'butterfly', 'lepke', 'butterfly.png'),
(113, 4, 'camel', 'teve', 'camel.png'),
(114, 4, 'cat', 'macska', 'cat.png'),
(115, 4, 'chicken', 'csirke', 'chicken.png'),
(116, 4, 'cow', 'tehén', 'cow.png'),
(117, 4, 'crocodile', 'krokodil', 'crocodile.png'),
(118, 4, 'deer', 'szarvas', 'deer.png'),
(119, 4, 'dog', 'kutya', 'dog.png'),
(120, 4, 'dolphin', 'delfin', 'dolphin.png'),
(121, 4, 'duck', 'kacsa', 'duck.png'),
(122, 4, 'elephant', 'elefánt', 'elephant.png'),
(123, 4, 'fish', 'hal', 'fish.png'),
(124, 4, 'fox', 'róka', 'fox.png'),
(125, 4, 'frog', 'béka', 'frog.png'),
(126, 4, 'giraffe', 'zsiráf', 'giraffe.png'),
(127, 4, 'horse', 'ló', 'horse.png'),
(128, 4, 'kangaroo', 'kenguru', 'kangaroo.png'),
(129, 4, 'koala', 'koala', 'koala.png'),
(130, 4, 'lion', 'oroszlán', 'lion.png'),
(131, 4, 'monkey', 'majom', 'monkey.png'),
(132, 4, 'mouse', 'egér', 'mouse.png'),
(133, 4, 'octopus', 'polip', 'octopus.png'),
(134, 4, 'panda', 'panda', 'panda.png'),
(135, 4, 'parrot', 'papagáj', 'parrot.png'),
(136, 4, 'penguin', 'pingvin', 'penguin.png'),
(137, 4, 'pig', 'disznó', 'pig.png'),
(138, 4, 'rabbit', 'nyúl', 'rabbit.png'),
(139, 4, 'shark', 'cápa', 'shark.png'),
(140, 4, 'sheep', 'birka', 'sheep.png'),
(141, 4, 'snail', 'csiga', 'snail.png'),
(142, 4, 'snake', 'kígyó', 'snake.png'),
(143, 4, 'spider', 'pók', 'spider.png'),
(144, 4, 'tiger', 'tigris', 'tiger.png'),
(145, 4, 'turtle', 'teknős', 'turtle.png'),
(146, 4, 'wasp', 'darázs', 'wasp.png'),
(147, 4, 'whale', 'bálna', 'whale.png'),
(148, 4, 'wolf', 'farkas', 'wolf.png'),
(149, 4, 'zebra', 'zebra', 'zebra.png'),
(150, 5, 'aluminium', 'alumínium', 'aluminium.png'),
(151, 5, 'brick', 'tégla', 'brick.png'),
(152, 5, 'carbon dioxide', 'szén-dioxid', 'carbon_dioxide.png'),
(153, 5, 'cement', 'cement', 'cement.png'),
(154, 5, 'clay', 'agyag', 'clay.png'),
(155, 5, 'coal', 'szén', 'coal.png'),
(156, 5, 'copper', 'réz', 'copper.png'),
(157, 5, 'cotton', 'pamut', 'cotton.png'),
(158, 5, 'gas', 'gáz', 'gas.png'),
(159, 5, 'glass', 'üveg', 'glass.png'),
(160, 5, 'hydrogen', 'hidrogén', 'hydrogen.png'),
(161, 5, 'ice', 'jég', 'ice.png'),
(162, 5, 'leather', 'bőr', 'leather.png'),
(163, 5, 'marble', 'márvány', 'marble.png'),
(164, 5, 'nitrogen', 'nitrogén', 'nitrogen.png'),
(165, 5, 'oxygen', 'oxigén', 'oxygen.png'),
(166, 5, 'paper', 'papír', 'paper.png'),
(167, 5, 'petrol', 'benzin', 'petrol.png'),
(168, 5, 'plastic', 'műanyag', 'plastic.png'),
(169, 5, 'soil', 'talaj', 'soil.png'),
(170, 5, 'steel', 'acél', 'steel.png'),
(171, 5, 'stone', 'kő', 'stone.png'),
(172, 5, 'water', 'víz', 'water.png'),
(173, 5, 'wood', 'faanyag', 'wood.png'),
(174, 6, 'accountant', 'könyvelő', 'empty.png'),
(175, 6, 'actor', 'színész', 'empty.png'),
(176, 6, 'actress', 'színésznő', 'empty.png'),
(177, 6, 'architect', 'építészmérnök', 'empty.png'),
(178, 6, 'artist', 'művész', 'empty.png'),
(179, 6, 'baker', 'pék', 'empty.png'),
(180, 6, 'barber', 'borbély', 'empty.png'),
(181, 6, 'bartender', 'csapos', 'empty.png'),
(182, 6, 'beautician', 'kozmetikus', 'empty.png'),
(183, 6, 'biologist', 'biológus', 'empty.png'),
(184, 6, 'bodyguard', 'testőr', 'empty.png'),
(185, 6, 'botanist', 'botanikus', 'empty.png'),
(186, 6, 'bricklayer', 'kőműves', 'empty.png'),
(187, 6, 'bus driver', 'buszvezető', 'empty.png'),
(188, 6, 'businessman', 'üzletember', 'empty.png'),
(189, 6, 'businesswoman', 'üzletasszony', 'empty.png'),
(190, 6, 'carpenter', 'asztalos', 'empty.png'),
(191, 6, 'cashier', 'pénztáros', 'empty.png'),
(192, 6, 'chef', 'séf', 'empty.png'),
(193, 6, 'chemist', 'vegyész', 'empty.png'),
(194, 6, 'chimney sweep', 'kéményseprő', 'empty.png'),
(195, 6, 'cleaner', 'takarító', 'empty.png'),
(196, 6, 'comedian', 'komikus', 'empty.png'),
(197, 6, 'composer', 'dalszerző', 'empty.png'),
(198, 6, 'customs officer', 'vámtisztviselő', 'empty.png'),
(199, 6, 'dancer', 'táncos', 'empty.png'),
(200, 6, 'database administrator', 'adatbázis adminisztrátor', 'empty.png'),
(201, 6, 'dentist', 'fogorvos', 'empty.png'),
(202, 6, 'detective', 'nyomozó', 'empty.png'),
(203, 6, 'doctor', 'orvos', 'empty.png'),
(204, 6, 'driving instructor', 'járművezető oktató', 'empty.png'),
(205, 6, 'economist', 'közgazdász', 'empty.png'),
(206, 6, 'electrician', 'villanyszerelő', 'empty.png'),
(207, 6, 'engineer', 'mérnök', 'empty.png'),
(208, 6, 'estate agent', 'ingatlan ügynök', 'empty.png'),
(209, 6, 'factory worker', 'gyári dolgozó', 'empty.png'),
(210, 6, 'farmer', 'gazda', 'empty.png'),
(211, 6, 'fashion designer', 'divattervező', 'empty.png'),
(212, 6, 'film director', 'filmrendező', 'empty.png'),
(213, 6, 'firefighter', 'tűzoltó', 'empty.png'),
(214, 6, 'gardener', 'kertész', 'empty.png'),
(215, 6, 'glazier', 'üveges', 'empty.png'),
(216, 6, 'graphic designer', 'grafikus tervező', 'empty.png'),
(217, 6, 'hairdresser', 'fodrász', 'empty.png'),
(218, 6, 'illustrator', 'illusztrátor', 'empty.png'),
(219, 6, 'journalist', 'újságíró', 'empty.png'),
(220, 6, 'judge', 'bíró', 'empty.png'),
(221, 6, 'lawyer', 'ügyvéd', 'empty.png'),
(222, 6, 'lecturer', 'egyetemi tanár', 'empty.png'),
(223, 6, 'librarian', 'könyvtáros', 'empty.png'),
(224, 6, 'manager', 'menedzser', 'empty.png'),
(225, 6, 'mechanic', 'szerelő', 'empty.png'),
(226, 6, 'meteorologist', 'meteorológus', 'empty.png'),
(227, 6, 'miner', 'bányász', 'empty.png'),
(228, 6, 'model', 'modell', 'empty.png'),
(229, 6, 'musician', 'zenész', 'empty.png'),
(230, 6, 'nanny', 'dada', 'empty.png'),
(231, 6, 'nurse', 'ápolónő', 'empty.png'),
(232, 6, 'office worker', ' irodai dolgozó', 'empty.png'),
(233, 6, 'optician', 'szemész', 'empty.png'),
(234, 6, 'painter', 'festő', 'empty.png'),
(235, 6, 'personal trainer', 'személyi edző', 'empty.png'),
(236, 6, 'pharmacist', 'gyógyszerész', 'empty.png'),
(237, 6, 'photographer', 'fényképész', 'empty.png'),
(238, 6, 'physicist', 'fizikus', 'empty.png'),
(239, 6, 'pilot', 'pilóta', 'empty.png'),
(240, 6, 'plumber', 'vízvezeték-szerelő', 'empty.png'),
(241, 6, 'police officer', 'rendőr', 'empty.png'),
(242, 6, 'politician', 'politikus', 'empty.png'),
(243, 6, 'postman', 'postás', 'empty.png'),
(244, 6, 'priest', 'pap', 'empty.png'),
(245, 6, 'programmer', 'programozó', 'empty.png'),
(246, 6, 'project manager', 'projektmenedzser', 'empty.png'),
(247, 6, 'railwayman', 'vasutas', 'empty.png'),
(248, 6, 'receptionist', 'recepciós', 'empty.png'),
(249, 6, 'researcher', 'kutató', 'empty.png'),
(250, 6, 'roofer', 'tetőfedő', 'empty.png'),
(251, 6, 'sailor', 'tengerész', 'empty.png'),
(252, 6, 'salesman', 'eladó', 'empty.png'),
(253, 6, 'saleswoman', 'eladónő', 'empty.png'),
(254, 6, 'scientist', 'tudós', 'empty.png'),
(255, 6, 'sculptor', 'szobrász', 'empty.png'),
(256, 6, 'secretary', 'titkárnő', 'empty.png'),
(257, 6, 'security officer', 'biztonsági őr', 'empty.png'),
(258, 6, 'shopkeeper', 'üzletvezető', 'empty.png'),
(259, 6, 'singer', 'énekes', 'empty.png'),
(260, 6, 'smith', 'kovács', 'empty.png'),
(261, 6, 'software developer', 'szoftverfejlesztő', 'empty.png'),
(262, 6, 'soldier', 'katona', 'empty.png'),
(263, 6, 'surgeon', 'sebész', 'empty.png'),
(264, 6, 'tailor', 'szabó', 'empty.png'),
(265, 6, 'tattoist', 'tetováló', 'empty.png'),
(266, 6, 'taxi driver', 'taxisofór', 'empty.png'),
(267, 6, 'teacher', 'tanár', 'empty.png'),
(268, 6, 'tiler', 'hidegburkoló', 'empty.png'),
(269, 6, 'tourist guide', 'idegenvezető', 'empty.png'),
(270, 6, 'train driver', 'vonatvezető', 'empty.png'),
(271, 6, 'translator', 'fordító', 'empty.png'),
(272, 6, 'turner', 'esztergályos', 'empty.png'),
(273, 6, 'vet', 'állatorvos', 'empty.png'),
(274, 6, 'waiter', 'pincér', 'empty.png'),
(275, 6, 'waitress', 'pincérnő', 'empty.png'),
(276, 6, 'web designer', 'webtervező', 'empty.png'),
(277, 6, 'web developer', 'webfejlesztő', 'empty.png'),
(278, 6, 'writer', 'író', 'empty.png'),
(279, 7, 'ankle', 'boka', 'empty.png'),
(280, 7, 'arm', 'kar', 'empty.png'),
(281, 7, 'back', 'hát', 'empty.png'),
(282, 7, 'backbone', 'gerinc', 'empty.png'),
(283, 7, 'beard', 'szakáll', 'empty.png'),
(284, 7, 'bone', 'csont', 'empty.png'),
(285, 7, 'brain', 'agy', 'empty.png'),
(286, 7, 'calf', 'vádli', 'empty.png'),
(287, 7, 'ear', 'fül', 'empty.png'),
(288, 7, 'elbow', 'könyök', 'empty.png'),
(289, 7, 'eye', 'szem', 'empty.png'),
(290, 7, 'eyebrow', 'szemöldök', 'empty.png'),
(291, 7, 'finger', 'ujj', 'empty.png'),
(292, 7, 'foot', 'lábfej', 'empty.png'),
(293, 7, 'hair', 'haj', 'empty.png'),
(294, 7, 'hand', 'kéz', 'empty.png'),
(295, 7, 'head', 'fej', 'empty.png'),
(296, 7, 'heart', 'szív', 'empty.png'),
(297, 7, 'hip', 'csípő', 'empty.png'),
(298, 7, 'jaw', 'állkapocs', 'empty.png'),
(299, 7, 'knee', 'térd', 'empty.png'),
(300, 7, 'leg', 'láb', 'empty.png'),
(301, 7, 'lip', 'ajak', 'empty.png'),
(302, 7, 'liver', 'máj', 'empty.png'),
(303, 7, 'lungs', 'tüdő', 'empty.png'),
(304, 7, 'moustache', 'bajusz', 'empty.png'),
(305, 7, 'mouth', 'száj', 'empty.png'),
(306, 7, 'muscle', 'izom', 'empty.png'),
(307, 7, 'nail', 'köröm', 'empty.png'),
(308, 7, 'neck', 'nyak', 'empty.png'),
(309, 7, 'nose', 'orr', 'empty.png'),
(310, 7, 'palm', 'tenyér', 'empty.png'),
(311, 7, 'rib', 'borda', 'empty.png'),
(312, 7, 'shin', 'sípcsont', 'empty.png'),
(313, 7, 'shoulder', 'váll', 'empty.png'),
(314, 7, 'skin', 'bőr', 'empty.png'),
(315, 7, 'skull', 'koponya', 'empty.png'),
(316, 7, 'sole', 'talp', 'empty.png'),
(317, 7, 'stomach', 'gyomor', 'empty.png'),
(318, 7, 'thigh', 'comb', 'empty.png'),
(319, 7, 'throat', 'torok', 'empty.png'),
(320, 7, 'thumb', 'hüvelykujj', 'empty.png'),
(321, 7, 'tongue', 'nyelv', 'empty.png'),
(322, 7, 'tooth', 'fog', 'empty.png'),
(323, 7, 'waist', 'derék', 'empty.png'),
(324, 7, 'wrist', 'csukló', 'empty.png'),
(325, 8, 'aerobics', 'aerobik', 'empty.png'),
(326, 8, 'american football', 'amerikai futball', 'empty.png'),
(327, 8, 'archery', 'íjászat', 'empty.png'),
(328, 8, 'athletics', 'atlétika', 'empty.png'),
(329, 8, 'badminton', 'tollaslabda', 'empty.png'),
(330, 8, 'baseball', 'baseball', 'empty.png'),
(331, 8, 'basketball', 'kosárlaba', 'empty.png'),
(332, 8, 'beach volleyball', 'strandröplabda', 'empty.png'),
(333, 8, 'boxing', 'boxolás', 'empty.png'),
(334, 8, 'canoeing', 'kenuzás', 'empty.png'),
(335, 8, 'championship', 'bajnokság', 'empty.png'),
(336, 8, 'chess', 'sakk', 'empty.png'),
(337, 8, 'climbing', 'hegymászás', 'empty.png'),
(338, 8, 'cricket', 'krikett', 'empty.png'),
(339, 8, 'cup', 'kupa', 'empty.png'),
(340, 8, 'cup final:kupadöntő', '', 'empty.png'),
(341, 8, 'cycling', 'kerékpározás', 'empty.png'),
(342, 8, 'darts', 'darts', 'empty.png'),
(343, 8, 'discus throw', 'diszkoszvetés', 'empty.png'),
(344, 8, 'european champion', 'európa-bajnok', 'empty.png'),
(345, 8, 'fishing', 'horgászat', 'empty.png'),
(346, 8, 'football', 'futball', 'empty.png'),
(347, 8, 'go-karting', 'gokartozás', 'empty.png'),
(348, 8, 'golf', 'golf', 'empty.png'),
(349, 8, 'gymnastics', 'torna', 'empty.png'),
(350, 8, 'hammer throw', 'kalapácsvetés', 'empty.png'),
(351, 8, 'handball', 'kézilabda', 'empty.png'),
(352, 8, 'high jump', 'magasugrás', 'empty.png'),
(353, 8, 'hiking', 'túrázás', 'empty.png'),
(354, 8, 'horse riding', 'lovaglás', 'empty.png'),
(355, 8, 'ice hockey', 'jégkorong', 'empty.png'),
(356, 8, 'javelin throw', 'gerelyhajítás', 'empty.png'),
(357, 8, 'jogging', 'kocogás', 'empty.png'),
(358, 8, 'judo', 'cselgáncs', 'empty.png'),
(359, 8, 'long jump', 'távolugrás', 'empty.png'),
(360, 8, 'marathon', 'maraton', 'empty.png'),
(361, 8, 'olympic champion', 'olimpiai bajnok', 'empty.png'),
(362, 8, 'rowing', 'evezés', 'empty.png'),
(363, 8, 'rugby', 'rögbi', 'empty.png'),
(364, 8, 'running', 'futás', 'empty.png'),
(365, 8, 'sailing', 'vitorlázás', 'empty.png'),
(366, 8, 'skateboarding', 'gördeszkázás', 'empty.png'),
(367, 8, 'skiing', 'síelés', 'empty.png'),
(368, 8, 'snooker', 'biliárd', 'empty.png'),
(369, 8, 'snowboarding', 'snowboardozás', 'empty.png'),
(370, 8, 'squash', 'fallabda', 'empty.png'),
(371, 8, 'the olympic games', 'olimpiai játékok', 'empty.png'),
(372, 8, 'volleyball', 'röplabda', 'empty.png'),
(373, 8, 'walking', 'sétálás', 'empty.png'),
(374, 8, 'water polo', 'vízilabda', 'empty.png'),
(375, 8, 'water skiing', 'vízisíelés', 'empty.png'),
(376, 8, 'weightlifting', 'súlyemelés', 'empty.png'),
(377, 8, 'world cup', 'világbajnokság', 'empty.png'),
(378, 9, 'beer', 'sör', 'empty.png'),
(379, 9, 'black coffee', 'fekete kávé', 'empty.png'),
(380, 9, 'cappuccino', 'cappuccino', 'empty.png'),
(381, 9, 'champagne', 'pezsgő', 'empty.png'),
(382, 9, 'cocoa', 'kakaó', 'empty.png'),
(383, 9, 'coffee', 'kávé', 'empty.png'),
(384, 9, 'coke', 'kóla', 'empty.png'),
(385, 9, 'cola', 'kóla', 'empty.png'),
(386, 9, 'diet cola', 'diétás kóla', 'empty.png'),
(387, 9, 'fibrous juice', 'rostos gyümölcslé', 'empty.png'),
(388, 9, 'fruit juice', 'gyümölcslé', 'empty.png'),
(389, 9, 'fruit tea', 'gyümölcstea', 'empty.png'),
(390, 9, 'green tea', 'zöld tea', 'empty.png'),
(391, 9, 'herbal tea', 'gyógytea', 'empty.png'),
(392, 9, 'hot chocolate', 'forró csokoládé', 'empty.png'),
(393, 9, 'iced tea', 'jegestea', 'empty.png'),
(394, 9, 'lemonade', 'limonádé', 'empty.png'),
(395, 9, 'mineral water', 'ásványvíz', 'empty.png'),
(396, 9, 'oramge juice', 'narancslé', 'empty.png'),
(397, 9, 'smoothie', 'smoothie', 'empty.png'),
(398, 9, 'soda', 'szóda', 'empty.png'),
(399, 9, 'sparkling water', 'szénsavmentes víz', 'empty.png'),
(400, 9, 'squash', 'szörp', 'empty.png'),
(401, 9, 'tap water', 'csapvíz', 'empty.png'),
(402, 9, 'tea', 'tea', 'empty.png'),
(403, 9, 'wine', 'bor', 'empty.png');

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
(6, 2, 1),
(7, 2, 2),
(8, 2, 3),
(9, 2, 4),
(10, 2, 5),
(11, 1, 6),
(12, 1, 7),
(13, 1, 8),
(14, 2, 9);

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
(6, 'Foglalkozások', 'englianlogo.png', '', 0),
(7, 'Testrészek', 'englianlogo.png', '', 0),
(8, 'Sportok', 'englianlogo.png', '', 0),
(9, 'Italok', 'englianlogo.png', '', 0);

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
  ADD PRIMARY KEY (`id`) USING BTREE,
  ADD UNIQUE KEY `megnevezes` (`megnevezes`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `eredmenyek`
--
ALTER TABLE `eredmenyek`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT a táblához `felhasznalok`
--
ALTER TABLE `felhasznalok`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `szavak`
--
ALTER TABLE `szavak`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=404;

--
-- AUTO_INCREMENT a táblához `tananyag`
--
ALTER TABLE `tananyag`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT a táblához `temakorok`
--
ALTER TABLE `temakorok`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
