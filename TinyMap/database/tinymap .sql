-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-04-27 17:28:33
-- 服务器版本： 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tinymap`
--

-- --------------------------------------------------------

--
-- 表的结构 `detail`
--

CREATE TABLE `detail` (
  `address` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `point_x` double NOT NULL,
  `point_y` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `detail`
--

INSERT INTO `detail` (`address`, `point_x`, `point_y`) VALUES
('拉萨', 91.199703, 29.618416),
('甘孜', 99.58, 31.38),
('阿坝', 101.43, 31.56),
('海北', 100.907395, 36.9607);

-- --------------------------------------------------------

--
-- 表的结构 `optionlist`
--

CREATE TABLE `optionlist` (
  `NID` tinyint(4) NOT NULL,
  `Ethnic` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `province` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `population` double NOT NULL,
  `empRate` tinyint(4) NOT NULL,
  `eduRate` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `optionlist`
--

INSERT INTO `optionlist` (`NID`, `Ethnic`, `province`, `address`, `population`, `empRate`, `eduRate`) VALUES
(5, '藏族', '云南', '大理', 12, 5, 2),
(5, '藏族', '西藏', '拉萨', 3, 50, 50),
(5, '藏族', '青海', '海北', 3, 30, 10),
(5, '藏族', '四川', '甘孜', 4, 10, 20),
(5, '藏族', '四川', '阿坝', 5, 10, 20);

-- --------------------------------------------------------

--
-- 表的结构 `outline`
--

CREATE TABLE `outline` (
  `nid` tinyint(4) NOT NULL,
  `ethnic` char(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mj_name` char(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `majority_x` double NOT NULL,
  `majority_y` double NOT NULL,
  `mapOffset_x` tinyint(4) NOT NULL,
  `mapOffset_y` tinyint(4) NOT NULL,
  `mapSize_x` tinyint(4) NOT NULL,
  `mapSize_y` tinyint(4) NOT NULL,
  `mapAnchor_x` tinyint(4) NOT NULL,
  `mapAnchor_y` tinyint(4) NOT NULL,
  `imgPath` char(100) NOT NULL,
  `sightPath` char(100) NOT NULL,
  `brief` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `outline`
--

INSERT INTO `outline` (`nid`, `ethnic`, `mj_name`, `majority_x`, `majority_y`, `mapOffset_x`, `mapOffset_y`, `mapSize_x`, `mapSize_y`, `mapAnchor_x`, `mapAnchor_y`, `imgPath`, `sightPath`, `brief`) VALUES
(1, '阿昌族', '梁河县风光', 98.3, 24.82, -3, -28, 10, 50, 30, 40, 'img/Achang.png', 'sights/Achang.jpg', '阿昌族大部分聚居在 云南,是中国云南境内最早的世居民族之一.因居住地的不同,还有“蒙撒”、“蒙 撒禅”、“对撒”、“汉撒”等自称.解放后统称为阿昌族.会街,是阿昌族人民的 传统集会,多在每年农历九月中旬举行.阿昌族信仰小乘佛教,会街原属宗教集会. 主要宗教节日有进洼（关门）、出洼（开门）、烧白柴、泼水节等.除宗教节日外 ,还有许多本民族特有的传统节日.如：火把节、窝罗节、浇花节和春节. '),
(2, '白族', '洱海风光', 100.19, 25.69, 5, -45, 30, 40, 10, 55, 'img/Bai.png', 'sights/Bai.jpg', '主要聚居在云南省大理白族自治州,其余分布于云南各地、贵州省毕节地区及四川凉山州.白族自称“白伙”、“白尼”、“白子”等,汉语意为“白人”.1956年,根据本民族人民的意愿正式定名为白族.白族的传统节日很多,已有上千年历史的“三月街”是白族一年一度最盛大的节日,现被定名“三月街民族节”.另外还有“火把节”（又称星回节）等民族节日.'),
(3, '保安族', '甘肃省积石山县风光', 102.85, 35.74, 20, -40, 45, 60, 5, 48, 'img/Bao.png', 'sights/Bao.jpg', '保安族因信仰伊斯兰教和风俗习惯与当地回族略同,又被称为“保安回”.1950年根据本民族人民意愿,定名保安族.保安族主要分布在中国西北甘肃省一带.保安族通用汉文,多信仰伊斯兰教.著名的保安腰刀的生产已有一百多年的历史,尤为藏族人民所喜爱.保安族的节日同许多信奉伊斯兰教的民族相同,如开斋节、古尔邦节、圣祀日等,家家都要炸馓子、油餜、蜜圈圈和油香.</p><br><p>甘肃积石山保安族族迁移路线如图中绿色实线所示——青海省同仁县保安城->青海循化撒拉族自治县->甘肃积石山保安族东乡族撒拉族自治县(即为图标所在处)');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `view_option`
--
CREATE TABLE `view_option` (
`ethnic` char(100)
,`province` char(100)
,`totalpopulation` double
);

-- --------------------------------------------------------

--
-- 视图结构 `view_option`
--
DROP TABLE IF EXISTS `view_option`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_option`  AS  select `optionlist`.`Ethnic` AS `ethnic`,`optionlist`.`province` AS `province`,sum(`optionlist`.`population`) AS `totalpopulation` from `optionlist` group by `optionlist`.`province`,`optionlist`.`Ethnic` order by sum(`optionlist`.`population`) desc limit 0,3 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail`
--
ALTER TABLE `detail`
  ADD KEY `detail_option` (`address`);

--
-- Indexes for table `optionlist`
--
ALTER TABLE `optionlist`
  ADD PRIMARY KEY (`address`);

--
-- Indexes for table `outline`
--
ALTER TABLE `outline`
  ADD PRIMARY KEY (`nid`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `outline`
--
ALTER TABLE `outline`
  MODIFY `nid` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 限制导出的表
--

--
-- 限制表 `detail`
--
ALTER TABLE `detail`
  ADD CONSTRAINT `detail_option` FOREIGN KEY (`address`) REFERENCES `optionlist` (`address`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
