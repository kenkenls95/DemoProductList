-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 07, 2018 lúc 06:56 PM
-- Phiên bản máy phục vụ: 10.1.31-MariaDB
-- Phiên bản PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `mydb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_category`
--

CREATE TABLE `tbl_category` (
  `categoryid` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `shortdesc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `parentid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_category`
--

INSERT INTO `tbl_category` (`categoryid`, `name`, `shortdesc`, `parentid`) VALUES
(1, 'category 1', 'category desc 1', 0),
(2, 'category 2', 'category desc 2', 0),
(3, 'category 3', 'category desc 3', 1),
(4, 'category 4\r\n', 'category desc 4', 1),
(5, 'Category 5', 'Category desc 5', 2),
(6, 'Category 6', 'Category Desc 6', 0),
(7, 'Category 7', 'Category desc 7', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_humidity`
--

CREATE TABLE `tbl_humidity` (
  `id` int(11) NOT NULL,
  `value` float NOT NULL,
  `date` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_humidity`
--

INSERT INTO `tbl_humidity` (`id`, `value`, `date`, `status`) VALUES
(1, 0, '2018-05-10 03:13:54', 0),
(2, 0, '2018-05-10 03:14:23', 0),
(3, 0, '2018-05-10 03:14:53', 0),
(4, 0, '2018-05-10 03:15:33', 0),
(5, 0, '2018-05-10 03:16:53', 0),
(6, 0, '2018-05-10 03:17:22', 0),
(7, 0, '2018-05-10 03:17:52', 0),
(8, 0, '2018-05-10 03:18:22', 0),
(9, 0, '2018-05-10 03:18:52', 0),
(10, 0, '2018-05-10 03:19:22', 0),
(11, 0, '2018-05-10 03:19:52', 0),
(12, 0, '2018-05-10 03:20:22', 0),
(13, 0, '2018-05-10 03:20:52', 0),
(14, 0, '2018-05-10 03:21:22', 0),
(15, 0, '2018-05-10 03:21:52', 0),
(16, 0, '2018-05-10 03:22:22', 0),
(17, 0, '2018-05-10 03:22:52', 0),
(18, 0, '2018-05-10 03:23:22', 0),
(19, 0, '2018-05-10 03:23:52', 0),
(20, 0, '2018-05-10 03:24:22', 0),
(21, 0, '2018-05-10 03:24:52', 0),
(22, 0, '2018-05-10 03:25:22', 0),
(23, 0, '2018-05-10 03:25:52', 0),
(24, 0, '2018-05-10 03:26:22', 0),
(25, 0, '2018-05-10 03:26:52', 0),
(26, 0, '2018-05-10 03:27:22', 0),
(27, 0, '2018-05-10 03:27:52', 0),
(28, 0, '2018-05-10 03:28:22', 0),
(29, 0, '2018-05-10 03:28:52', 0),
(30, 0, '2018-05-10 03:29:22', 0),
(31, 0, '2018-05-10 03:29:52', 0),
(32, 0, '2018-05-10 03:30:22', 0),
(33, 0, '2018-05-10 03:30:52', 0),
(34, 0, '2018-05-10 03:31:22', 0),
(35, 0, '2018-05-10 03:31:52', 0),
(36, 0, '2018-05-10 03:32:22', 0),
(37, 0, '2018-05-10 03:32:52', 0),
(38, 0, '2018-05-10 03:33:22', 0),
(39, 0, '2018-05-10 03:33:52', 0),
(40, 0, '2018-05-10 03:34:26', 0),
(41, 0, '2018-05-10 03:34:52', 0),
(42, 0, '2018-05-10 03:37:26', 0),
(43, 0, '2018-05-10 03:37:46', 0),
(44, 0, '2018-05-10 03:38:16', 0),
(45, 0, '2018-05-10 03:38:46', 0),
(46, 0, '2018-05-10 03:39:16', 0),
(47, 0, '2018-05-10 03:39:46', 0),
(48, 0, '2018-05-10 03:40:16', 0),
(49, 0, '2018-05-10 03:40:46', 0),
(50, 0, '2018-05-10 03:41:16', 0),
(51, 0, '2018-05-10 03:41:46', 0),
(52, 0, '2018-05-10 03:42:17', 0),
(53, 0, '2018-05-10 03:42:54', 0),
(54, 0, '2018-05-10 03:43:21', 0),
(55, 0, '2018-05-10 03:44:16', 0),
(56, 0, '2018-05-10 03:44:46', 0),
(57, 0, '2018-05-10 03:45:16', 0),
(58, 0, '2018-05-10 03:45:46', 0),
(59, 0, '2018-05-10 03:46:16', 0),
(60, 0, '2018-05-10 03:46:46', 0),
(61, 0, '2018-05-10 03:47:16', 0),
(62, 0, '2018-05-10 03:47:46', 0),
(63, 0, '2018-05-10 03:48:16', 0),
(64, 0, '2018-05-10 03:48:46', 0),
(65, 0, '2018-05-10 03:49:16', 0),
(66, 0, '2018-05-10 03:49:46', 0),
(67, 0, '2018-05-10 03:50:29', 0),
(68, 0, '2018-05-10 03:50:46', 0),
(69, 0, '2018-05-10 03:52:02', 0),
(70, 0, '2018-05-10 03:52:32', 0),
(71, 0, '2018-05-10 03:53:02', 0),
(72, 0, '2018-05-10 03:53:32', 0),
(73, 0, '2018-05-10 03:54:02', 0),
(74, 0, '2018-05-10 03:54:31', 0),
(75, 0, '2018-05-10 03:55:02', 0),
(76, 0, '2018-05-10 03:55:32', 0),
(77, 0, '2018-05-10 03:56:02', 0),
(78, 0, '2018-05-10 03:56:32', 0),
(79, 0, '2018-05-10 03:57:02', 0),
(80, 0, '2018-05-10 03:57:32', 0),
(81, 0, '2018-05-10 03:58:02', 0),
(82, 0, '2018-05-10 03:58:32', 0),
(83, 0, '2018-05-10 03:59:02', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_led`
--

CREATE TABLE `tbl_led` (
  `id` int(11) NOT NULL,
  `led1` int(11) NOT NULL,
  `led2` int(11) NOT NULL,
  `led3` int(11) NOT NULL,
  `led4` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_led`
--

INSERT INTO `tbl_led` (`id`, `led1`, `led2`, `led3`, `led4`, `date`) VALUES
(1, 0, 0, 0, 0, '2018-05-10 03:13:54'),
(2, 1, 1, 1, 1, '2018-05-10 03:14:23'),
(3, 0, 0, 0, 0, '2018-05-10 03:14:53'),
(4, 0, 0, 0, 0, '2018-05-10 03:15:33'),
(5, 0, 0, 0, 0, '2018-05-10 03:16:53'),
(6, 0, 0, 0, 0, '2018-05-10 03:17:22'),
(7, 0, 0, 0, 0, '2018-05-10 03:17:52'),
(8, 0, 0, 0, 0, '2018-05-10 03:18:22'),
(9, 0, 0, 0, 0, '2018-05-10 03:18:52'),
(10, 0, 0, 0, 0, '2018-05-10 03:19:22'),
(11, 0, 0, 0, 0, '2018-05-10 03:19:52'),
(12, 0, 0, 0, 0, '2018-05-10 03:20:22'),
(13, 0, 0, 0, 0, '2018-05-10 03:20:52'),
(14, 0, 0, 0, 0, '2018-05-10 03:21:22'),
(15, 0, 0, 0, 0, '2018-05-10 03:21:52'),
(16, 0, 0, 0, 0, '2018-05-10 03:22:22'),
(17, 0, 0, 0, 0, '2018-05-10 03:22:52'),
(18, 0, 0, 0, 0, '2018-05-10 03:23:22'),
(19, 0, 0, 0, 0, '2018-05-10 03:23:52'),
(20, 0, 0, 0, 0, '2018-05-10 03:24:22'),
(21, 0, 0, 0, 0, '2018-05-10 03:24:52'),
(22, 0, 0, 0, 0, '2018-05-10 03:25:22'),
(23, 0, 0, 0, 0, '2018-05-10 03:25:52'),
(24, 0, 0, 0, 0, '2018-05-10 03:26:22'),
(25, 0, 0, 0, 0, '2018-05-10 03:26:52'),
(26, 0, 0, 0, 0, '2018-05-10 03:27:22'),
(27, 0, 0, 0, 0, '2018-05-10 03:27:52'),
(28, 0, 0, 0, 0, '2018-05-10 03:28:22'),
(29, 0, 0, 0, 0, '2018-05-10 03:28:52'),
(30, 0, 0, 0, 0, '2018-05-10 03:29:22'),
(31, 0, 0, 0, 0, '2018-05-10 03:29:52'),
(32, 0, 0, 0, 0, '2018-05-10 03:30:22'),
(33, 0, 0, 0, 0, '2018-05-10 03:30:52'),
(34, 0, 0, 0, 0, '2018-05-10 03:31:22'),
(35, 0, 0, 0, 0, '2018-05-10 03:31:52'),
(36, 0, 0, 0, 0, '2018-05-10 03:32:22'),
(37, 0, 0, 0, 0, '2018-05-10 03:32:52'),
(38, 0, 0, 0, 0, '2018-05-10 03:33:22'),
(39, 0, 0, 0, 0, '2018-05-10 03:33:52'),
(40, 0, 0, 0, 0, '2018-05-10 03:34:26'),
(41, 0, 0, 0, 0, '2018-05-10 03:34:52'),
(42, 0, 0, 0, 0, '2018-05-10 03:37:26'),
(43, 0, 0, 0, 0, '2018-05-10 03:37:46'),
(44, 0, 0, 0, 0, '2018-05-10 03:38:16'),
(45, 0, 0, 0, 0, '2018-05-10 03:38:46'),
(46, 0, 0, 0, 0, '2018-05-10 03:39:16'),
(47, 0, 0, 0, 0, '2018-05-10 03:39:46'),
(48, 0, 0, 0, 0, '2018-05-10 03:40:16'),
(49, 0, 0, 0, 0, '2018-05-10 03:40:46'),
(50, 0, 0, 0, 0, '2018-05-10 03:41:16'),
(51, 0, 0, 0, 0, '2018-05-10 03:41:46'),
(52, 0, 0, 0, 0, '2018-05-10 03:42:17'),
(53, 0, 0, 0, 0, '2018-05-10 03:42:54'),
(54, 0, 0, 0, 0, '2018-05-10 03:43:21'),
(55, 0, 0, 0, 0, '2018-05-10 03:44:16'),
(56, 0, 0, 0, 0, '2018-05-10 03:44:46'),
(57, 0, 0, 0, 0, '2018-05-10 03:45:16'),
(58, 0, 0, 0, 0, '2018-05-10 03:45:46'),
(59, 0, 0, 0, 0, '2018-05-10 03:46:16'),
(60, 0, 0, 0, 0, '2018-05-10 03:46:46'),
(61, 0, 0, 0, 0, '2018-05-10 03:47:16'),
(62, 0, 0, 0, 0, '2018-05-10 03:47:46'),
(63, 0, 0, 0, 0, '2018-05-10 03:48:16'),
(64, 0, 0, 0, 0, '2018-05-10 03:48:46'),
(65, 0, 0, 0, 0, '2018-05-10 03:49:16'),
(66, 0, 0, 0, 0, '2018-05-10 03:49:46'),
(67, 0, 0, 0, 0, '2018-05-10 03:50:29'),
(68, 0, 0, 0, 0, '2018-05-10 03:50:46'),
(69, 0, 0, 0, 0, '2018-05-10 03:52:02'),
(70, 1, 0, 1, 0, '2018-05-10 03:52:32'),
(71, 0, 0, 0, 0, '2018-05-10 03:53:02'),
(72, 0, 0, 0, 0, '2018-05-10 03:53:32'),
(73, 0, 0, 0, 0, '2018-05-10 03:54:02'),
(74, 0, 0, 0, 0, '2018-05-10 03:54:31'),
(75, 0, 0, 0, 0, '2018-05-10 03:55:02'),
(76, 1, 1, 1, 1, '2018-05-10 03:55:32'),
(77, 1, 1, 1, 1, '2018-05-10 03:56:02'),
(78, 1, 1, 1, 1, '2018-05-10 03:56:32'),
(79, 1, 1, 1, 1, '2018-05-10 03:57:02'),
(80, 1, 1, 1, 1, '2018-05-10 03:57:32'),
(81, 1, 1, 1, 1, '2018-05-10 03:58:02'),
(82, 1, 1, 1, 1, '2018-05-10 03:58:32'),
(83, 0, 0, 0, 1, '2018-05-10 03:59:02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_order`
--

CREATE TABLE `tbl_order` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `created_date` date NOT NULL,
  `statusid` int(11) NOT NULL,
  `address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `tbl_order`
--

INSERT INTO `tbl_order` (`id`, `userid`, `created_date`, `statusid`, `address`) VALUES
(1, 1, '2018-05-06', 1, 'abc'),
(2, 1, '2018-05-01', 2, 'abc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_orderproduct`
--

CREATE TABLE `tbl_orderproduct` (
  `id` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `orderid` int(11) NOT NULL,
  `orderquantity` int(11) NOT NULL,
  `orderprice` decimal(10,0) NOT NULL,
  `created_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `tbl_orderproduct`
--

INSERT INTO `tbl_orderproduct` (`id`, `productid`, `orderid`, `orderquantity`, `orderprice`, `created_date`) VALUES
(1, 3, 1, 1, '12', '2018-05-06'),
(2, 4, 1, 3, '12', '2018-05-06'),
(3, 4, 2, 12, '12', '2018-06-04');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_product`
--

CREATE TABLE `tbl_product` (
  `productid` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `shortdesc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `createddate` date NOT NULL,
  `categoryid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_product`
--

INSERT INTO `tbl_product` (`productid`, `name`, `shortdesc`, `image`, `createddate`, `categoryid`, `amount`, `price`) VALUES
(1, 'Product 1', 'Description for product 1', '/link/1528118601-logo-shop.png', '2018-05-31', 1, 80, '0'),
(2, 'Product 1', 'Description for product 1', '/link/1528118534-logo-shop.png', '2018-05-31', 2, 82, '0'),
(3, 'Product 3', 'Description for product 3', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 2, 17, '59'),
(4, 'Product 4', 'Description for product 4', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 2, 94, '33'),
(5, 'Product 5', 'Description for product 5', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 5, 68, '69'),
(6, 'Product 6', 'Description for product 6', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 6, 56, '98'),
(7, 'Product 7', 'Description for product 7', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 2, 25, '1'),
(8, 'Product 8', 'Description for product 8', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 7, 59, '41'),
(9, 'Product 9', 'Description for product 9', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 1, 50, '93'),
(10, 'Product 10', 'Description for product 10', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 7, 34, '41'),
(11, 'Product 11', 'Description for product 11', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 5, 5, '47'),
(12, 'Product 12', 'Description for product 12', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 1, 65, '33'),
(13, 'Product 13', 'Description for product 13', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 3, 61, '23'),
(14, 'Product 14', 'Description for product 14', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 3, 72, '90'),
(15, 'Product 15', 'Description for product 15', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 5, 77, '80'),
(16, 'Product 16', 'Description for product 16', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 7, 97, '53'),
(17, 'Product 17', 'Description for product 17', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 5, 2, '47'),
(18, 'Product 18', 'Description for product 18', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 2, 8, '1'),
(19, 'Product 19', 'Description for product 19', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 1, 62, '46'),
(20, 'Product 20', 'Description for product 20', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 1, 92, '17'),
(21, 'Product 21', 'Description for product 21', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 4, 53, '54'),
(22, 'Product 22', 'Description for product 22', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 5, 24, '32'),
(23, 'Product 23', 'Description for product 23', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 1, 28, '17'),
(24, 'Product 24', 'Description for product 24', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 6, 33, '74'),
(25, 'Product 25', 'Description for product 25', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 7, 61, '99'),
(26, 'Product 26', 'Description for product 26', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 5, 56, '5'),
(27, 'Product 27', 'Description for product 27', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 3, 76, '49'),
(28, 'Product 28', 'Description for product 28', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 3, 66, '92'),
(29, 'Product 29', 'Description for product 29', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 2, 22, '9'),
(30, 'Product 30', 'Description for product 30', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 4, 57, '18'),
(31, 'Product 31', 'Description for product 31', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 1, 58, '55'),
(32, 'Product 32', 'Description for product 32', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 7, 34, '41'),
(33, 'Product 33', 'Description for product 33', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 6, 1, '78'),
(34, 'Product 34', 'Description for product 34', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 3, 7, '43'),
(35, 'Product 35', 'Description for product 35', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 6, 59, '23'),
(36, 'Product 36', 'Description for product 36', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 5, 7, '12'),
(37, 'Product 37', 'Description for product 37', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 5, 57, '37'),
(38, 'Product 38', 'Description for product 38', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 1, 15, '81'),
(39, 'Product 39', 'Description for product 39', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 1, 55, '94'),
(40, 'Product 40', 'Description for product 40', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 5, 85, '82'),
(41, 'Product 41', 'Description for product 41', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 5, 49, '72'),
(42, 'Product 42', 'Description for product 42', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 1, 60, '13'),
(43, 'Product 43', 'Description for product 43', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 7, 31, '29'),
(44, 'Product 44', 'Description for product 44', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 1, 28, '68'),
(45, 'Product 45', 'Description for product 45', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 6, 50, '37'),
(46, 'Product 46', 'Description for product 46', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 1, 16, '74'),
(47, 'Product 47', 'Description for product 47', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 6, 74, '7'),
(48, 'Product 48', 'Description for product 48', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 4, 61, '89'),
(49, 'Product 49', 'Description for product 49', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 2, 76, '8'),
(50, 'Product 50', 'Description for product 50', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 6, 23, '85'),
(51, 'Product 51', 'Description for product 51', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 1, 96, '42'),
(52, 'Product 52', 'Description for product 52', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 6, 32, '28'),
(53, 'Product 53', 'Description for product 53', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 5, 37, '70'),
(54, 'Product 54', 'Description for product 54', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 6, 27, '11'),
(55, 'Product 55', 'Description for product 55', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 1, 53, '46'),
(56, 'Product 56', 'Description for product 56', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 3, 90, '99'),
(57, 'Product 57', 'Description for product 57', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 2, 44, '27'),
(58, 'Product 58', 'Description for product 58', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 1, 97, '96'),
(59, 'Product 59', 'Description for product 59', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 4, 17, '3'),
(60, 'Product 60', 'Description for product 60', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 7, 60, '23'),
(61, 'Product 61', 'Description for product 61', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 4, 10, '7'),
(62, 'Product 62', 'Description for product 62', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 3, 97, '85'),
(63, 'Product 63', 'Description for product 63', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 3, 95, '90'),
(64, 'Product 64', 'Description for product 64', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 6, 93, '82'),
(65, 'Product 65', 'Description for product 65', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 7, 43, '96'),
(66, 'Product 66', 'Description for product 66', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 1, 81, '63'),
(67, 'Product 67', 'Description for product 67', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 4, 88, '7'),
(68, 'Product 68', 'Description for product 68', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 5, 59, '3'),
(69, 'Product 69', 'Description for product 69', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 7, 73, '61'),
(70, 'Product 70', 'Description for product 70', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 3, 20, '77'),
(71, 'Product 71', 'Description for product 71', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 1, 99, '24'),
(72, 'Product 72', 'Description for product 72', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 7, 5, '63'),
(73, 'Product 73', 'Description for product 73', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 1, 71, '67'),
(74, 'Product 74', 'Description for product 74', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 5, 32, '60'),
(75, 'Product 75', 'Description for product 75', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 2, 67, '95'),
(76, 'Product 76', 'Description for product 76', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 4, 73, '11'),
(77, 'Product 77', 'Description for product 77', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 7, 66, '95'),
(78, 'Product 78', 'Description for product 78', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 6, 4, '61'),
(79, 'Product 79', 'Description for product 79', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 5, 86, '43'),
(80, 'Product 80', 'Description for product 80', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 3, 71, '31'),
(81, 'Product 81', 'Description for product 81', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 3, 62, '34'),
(82, 'Product 82', 'Description for product 82', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 3, 85, '25'),
(83, 'Product 83', 'Description for product 83', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 2, 3, '79'),
(84, 'Product 84', 'Description for product 84', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 6, 47, '3'),
(85, 'Product 85', 'Description for product 85', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 4, 93, '94'),
(86, 'Product 86', 'Description for product 86', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 3, 47, '11'),
(87, 'Product 87', 'Description for product 87', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 5, 49, '79'),
(88, 'Product 88', 'Description for product 88', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 7, 74, '40'),
(89, 'Product 89', 'Description for product 89', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 3, 1, '62'),
(90, 'Product 90', 'Description for product 90', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 6, 89, '84'),
(91, 'Product 91', 'Description for product 91', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 3, 69, '90'),
(92, 'Product 92', 'Description for product 92', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 3, 92, '71'),
(93, 'Product 93', 'Description for product 93', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 7, 97, '62'),
(94, 'Product 94', 'Description for product 94', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 1, 0, '10'),
(95, 'Product 95', 'Description for product 95', 'https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg', '2018-05-31', 5, 2, '62'),
(96, 'Product 96', 'Description for product 96', 'https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg', '2018-05-31', 1, 42, '0'),
(97, 'Product 97', 'Description for product 97', 'https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg', '2018-05-31', 3, 0, '42'),
(98, 'Product 98', 'Description for product 98', 'https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg', '2018-05-31', 6, 95, '43'),
(99, 'Product 99', 'Description for product 99', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 4, 35, '56'),
(100, 'Product 100', 'Description for product 100', 'https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg', '2018-05-31', 4, 25, '67');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_role`
--

CREATE TABLE `tbl_role` (
  `id` int(11) NOT NULL,
  `rolename` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `desc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` date NOT NULL,
  `updated_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_role`
--

INSERT INTO `tbl_role` (`id`, `rolename`, `desc`, `created_date`, `updated_date`) VALUES
(1, 'ROLE_ADMIN', 'admin', '2018-04-09', '2018-04-10'),
(2, 'ROLE_USER', 'user', '2018-04-02', '2018-04-12');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_soilmoisture`
--

CREATE TABLE `tbl_soilmoisture` (
  `id` int(11) NOT NULL,
  `value` float NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_soilmoisture`
--

INSERT INTO `tbl_soilmoisture` (`id`, `value`, `date`) VALUES
(1, 99.7067, '2018-05-10 03:13:54'),
(2, 99.8045, '2018-05-10 03:14:23'),
(3, 99.7067, '2018-05-10 03:14:53'),
(4, 99.7067, '2018-05-10 03:15:33'),
(5, 99.609, '2018-05-10 03:16:53'),
(6, 99.609, '2018-05-10 03:17:22'),
(7, 99.609, '2018-05-10 03:17:52'),
(8, 99.7067, '2018-05-10 03:18:22'),
(9, 99.609, '2018-05-10 03:18:52'),
(10, 99.7067, '2018-05-10 03:19:22'),
(11, 99.7067, '2018-05-10 03:19:52'),
(12, 99.7067, '2018-05-10 03:20:22'),
(13, 99.609, '2018-05-10 03:20:52'),
(14, 99.609, '2018-05-10 03:21:22'),
(15, 99.609, '2018-05-10 03:21:52'),
(16, 99.609, '2018-05-10 03:22:22'),
(17, 99.609, '2018-05-10 03:22:52'),
(18, 99.7067, '2018-05-10 03:23:22'),
(19, 99.7067, '2018-05-10 03:23:52'),
(20, 99.609, '2018-05-10 03:24:22'),
(21, 99.7067, '2018-05-10 03:24:52'),
(22, 99.609, '2018-05-10 03:25:22'),
(23, 99.609, '2018-05-10 03:25:52'),
(24, 99.609, '2018-05-10 03:26:22'),
(25, 99.7067, '2018-05-10 03:26:52'),
(26, 99.7067, '2018-05-10 03:27:22'),
(27, 99.7067, '2018-05-10 03:27:52'),
(28, 99.7067, '2018-05-10 03:28:22'),
(29, 99.609, '2018-05-10 03:28:52'),
(30, 99.609, '2018-05-10 03:29:22'),
(31, 99.609, '2018-05-10 03:29:52'),
(32, 99.5112, '2018-05-10 03:30:22'),
(33, 99.609, '2018-05-10 03:30:52'),
(34, 99.7067, '2018-05-10 03:31:22'),
(35, 99.7067, '2018-05-10 03:31:52'),
(36, 99.609, '2018-05-10 03:32:22'),
(37, 99.7067, '2018-05-10 03:32:52'),
(38, 99.7067, '2018-05-10 03:33:22'),
(39, 99.7067, '2018-05-10 03:33:52'),
(40, 99.609, '2018-05-10 03:34:26'),
(41, 99.7067, '2018-05-10 03:34:52'),
(42, 99.7067, '2018-05-10 03:37:26'),
(43, 99.609, '2018-05-10 03:37:46'),
(44, 99.609, '2018-05-10 03:38:16'),
(45, 99.7067, '2018-05-10 03:38:46'),
(46, 99.609, '2018-05-10 03:39:16'),
(47, 99.609, '2018-05-10 03:39:46'),
(48, 99.7067, '2018-05-10 03:40:16'),
(49, 99.7067, '2018-05-10 03:40:46'),
(50, 99.7067, '2018-05-10 03:41:16'),
(51, 99.7067, '2018-05-10 03:41:46'),
(52, 99.7067, '2018-05-10 03:42:17'),
(53, 99.7067, '2018-05-10 03:42:54'),
(54, 99.7067, '2018-05-10 03:43:21'),
(55, 99.609, '2018-05-10 03:44:16'),
(56, 99.609, '2018-05-10 03:44:46'),
(57, 99.7067, '2018-05-10 03:45:16'),
(58, 99.7067, '2018-05-10 03:45:46'),
(59, 99.7067, '2018-05-10 03:46:16'),
(60, 99.609, '2018-05-10 03:46:46'),
(61, 99.609, '2018-05-10 03:47:16'),
(62, 99.609, '2018-05-10 03:47:46'),
(63, 99.7067, '2018-05-10 03:48:16'),
(64, 99.7067, '2018-05-10 03:48:46'),
(65, 99.609, '2018-05-10 03:49:16'),
(66, 99.7067, '2018-05-10 03:49:46'),
(67, 99.609, '2018-05-10 03:50:29'),
(68, 99.609, '2018-05-10 03:50:46'),
(69, 99.609, '2018-05-10 03:52:02'),
(70, 99.609, '2018-05-10 03:52:32'),
(71, 99.609, '2018-05-10 03:53:02'),
(72, 99.7067, '2018-05-10 03:53:32'),
(73, 99.7067, '2018-05-10 03:54:02'),
(74, 99.609, '2018-05-10 03:54:31'),
(75, 99.7067, '2018-05-10 03:55:02'),
(76, 99.7067, '2018-05-10 03:55:32'),
(77, 99.7067, '2018-05-10 03:56:02'),
(78, 99.7067, '2018-05-10 03:56:32'),
(79, 99.7067, '2018-05-10 03:57:02'),
(80, 99.609, '2018-05-10 03:57:32'),
(81, 99.609, '2018-05-10 03:58:02'),
(82, 99.7067, '2018-05-10 03:58:32'),
(83, 99.7067, '2018-05-10 03:59:02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_status`
--

CREATE TABLE `tbl_status` (
  `id` int(11) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `tbl_status`
--

INSERT INTO `tbl_status` (`id`, `name`, `desc`) VALUES
(1, 'đã giao hàng', ''),
(2, 'đang giao hàng', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_temperature`
--

CREATE TABLE `tbl_temperature` (
  `id` int(11) NOT NULL,
  `value` float NOT NULL,
  `date` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_temperature`
--

INSERT INTO `tbl_temperature` (`id`, `value`, `date`, `status`) VALUES
(1, 0, '2018-05-10 03:13:54', 0),
(2, 0, '2018-05-10 03:14:23', 0),
(3, 0, '2018-05-10 03:14:53', 0),
(4, 0, '2018-05-10 03:15:33', 0),
(5, 0, '2018-05-10 03:16:53', 0),
(6, 0, '2018-05-10 03:17:22', 0),
(7, 0, '2018-05-10 03:17:52', 0),
(8, 0, '2018-05-10 03:18:22', 0),
(9, 0, '2018-05-10 03:18:52', 0),
(10, 0, '2018-05-10 03:19:22', 0),
(11, 0, '2018-05-10 03:19:52', 0),
(12, 0, '2018-05-10 03:20:22', 0),
(13, 0, '2018-05-10 03:20:52', 0),
(14, 0, '2018-05-10 03:21:22', 0),
(15, 0, '2018-05-10 03:21:52', 0),
(16, 0, '2018-05-10 03:22:22', 0),
(17, 0, '2018-05-10 03:22:52', 0),
(18, 0, '2018-05-10 03:23:22', 0),
(19, 0, '2018-05-10 03:23:52', 0),
(20, 0, '2018-05-10 03:24:22', 0),
(21, 0, '2018-05-10 03:24:52', 0),
(22, 0, '2018-05-10 03:25:22', 0),
(23, 0, '2018-05-10 03:25:52', 0),
(24, 0, '2018-05-10 03:26:22', 0),
(25, 0, '2018-05-10 03:26:52', 0),
(26, 0, '2018-05-10 03:27:22', 0),
(27, 0, '2018-05-10 03:27:52', 0),
(28, 0, '2018-05-10 03:28:22', 0),
(29, 0, '2018-05-10 03:28:52', 0),
(30, 0, '2018-05-10 03:29:22', 0),
(31, 0, '2018-05-10 03:29:52', 0),
(32, 0, '2018-05-10 03:30:22', 0),
(33, 0, '2018-05-10 03:30:52', 0),
(34, 0, '2018-05-10 03:31:22', 0),
(35, 0, '2018-05-10 03:31:52', 0),
(36, 0, '2018-05-10 03:32:22', 0),
(37, 0, '2018-05-10 03:32:52', 0),
(38, 0, '2018-05-10 03:33:22', 0),
(39, 0, '2018-05-10 03:33:52', 0),
(40, 0, '2018-05-10 03:34:26', 0),
(41, 0, '2018-05-10 03:34:52', 0),
(42, 0, '2018-05-10 03:37:26', 0),
(43, 0, '2018-05-10 03:37:46', 0),
(44, 0, '2018-05-10 03:38:16', 0),
(45, 0, '2018-05-10 03:38:46', 0),
(46, 0, '2018-05-10 03:39:16', 0),
(47, 0, '2018-05-10 03:39:46', 0),
(48, 0, '2018-05-10 03:40:16', 0),
(49, 0, '2018-05-10 03:40:46', 0),
(50, 0, '2018-05-10 03:41:16', 0),
(51, 0, '2018-05-10 03:41:46', 0),
(52, 0, '2018-05-10 03:42:17', 0),
(53, 0, '2018-05-10 03:42:54', 0),
(54, 0, '2018-05-10 03:43:21', 0),
(55, 0, '2018-05-10 03:44:16', 0),
(56, 0, '2018-05-10 03:44:46', 0),
(57, 0, '2018-05-10 03:45:16', 0),
(58, 0, '2018-05-10 03:45:46', 0),
(59, 0, '2018-05-10 03:46:16', 0),
(60, 0, '2018-05-10 03:46:46', 0),
(61, 0, '2018-05-10 03:47:16', 0),
(62, 0, '2018-05-10 03:47:46', 0),
(63, 0, '2018-05-10 03:48:16', 0),
(64, 0, '2018-05-10 03:48:46', 0),
(65, 0, '2018-05-10 03:49:16', 0),
(66, 0, '2018-05-10 03:49:46', 0),
(67, 0, '2018-05-10 03:50:29', 0),
(68, 0, '2018-05-10 03:50:46', 0),
(69, 0, '2018-05-10 03:52:02', 0),
(70, 0, '2018-05-10 03:52:32', 0),
(71, 0, '2018-05-10 03:53:02', 0),
(72, 0, '2018-05-10 03:53:32', 0),
(73, 0, '2018-05-10 03:54:02', 0),
(74, 0, '2018-05-10 03:54:31', 0),
(75, 0, '2018-05-10 03:55:02', 0),
(76, 0, '2018-05-10 03:55:32', 0),
(77, 0, '2018-05-10 03:56:02', 0),
(78, 0, '2018-05-10 03:56:32', 0),
(79, 0, '2018-05-10 03:57:02', 0),
(80, 0, '2018-05-10 03:57:32', 0),
(81, 0, '2018-05-10 03:58:02', 0),
(82, 0, '2018-05-10 03:58:32', 0),
(83, 0, '2018-05-10 03:59:02', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `username` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(2002) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passwordhashed` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `imageurl` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `username`, `fullname`, `email`, `passwordhashed`, `created_date`, `updated_date`, `imageurl`, `address`, `gender`) VALUES
(1, 'abc', 'vi trung kiên', 'abc@gmail.com', '$2a$10$A284l/xS6yBa1eHz54z5OO/FqIqEJJVVD1p/Ngb7pKPM4yNtfQybm', '2018-04-29', '2018-06-06', '/link/1528285535-2f5c47448fdae0bd56323f206d9fc1f2_46-7735-1480135132gif.gif', 'aadasdasdasd', 'Male'),
(2, 'admin', 'admin', 'admin@gmail.com', '$2a$10$G1y1rTDKEoba0v5cit3rq.IC349Ukt1qUTBH7Gdf0QfqeYYmpUVWS', '2018-04-29', '2018-04-29', NULL, NULL, '0'),
(5, 'kiendz', 'kiendz', 'kiendz@gmail.com', '$2a$10$Sf6D9AwU2wzZFnceHJ8dQ.vYv0bWi.iBpHzEypk091LImougFRcdm', '2018-05-12', '2018-05-12', '/link/1528177697-default-user.png', NULL, '0'),
(6, 'abcd', 'abcd', 'abcd@gmail.com', '$2a$10$EcRfz/CigWE/V2gR9pKDn.ztsaHEWXxOd/y6WinKE6wItFSgcCIOu', '2018-05-25', '2018-05-25', NULL, NULL, '0'),
(11, 'Kiên Trung Vi', NULL, NULL, NULL, '2018-05-26', '2018-05-26', 'https://graph.facebook.com/v2.5/841550332695892/picture', NULL, '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_userrole`
--

CREATE TABLE `tbl_userrole` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `status` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_userrole`
--

INSERT INTO `tbl_userrole` (`id`, `user_id`, `role_id`, `status`) VALUES
(1, 1, 2, '1'),
(2, 2, 1, '1'),
(3, 5, 2, '1'),
(4, 6, 2, '1'),
(5, 7, 2, '1'),
(6, 8, 2, '1'),
(7, 9, 2, '1'),
(8, 10, 2, '1'),
(9, 11, 2, '1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`categoryid`);

--
-- Chỉ mục cho bảng `tbl_humidity`
--
ALTER TABLE `tbl_humidity`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_led`
--
ALTER TABLE `tbl_led`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_orderproduct`
--
ALTER TABLE `tbl_orderproduct`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`productid`);

--
-- Chỉ mục cho bảng `tbl_role`
--
ALTER TABLE `tbl_role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_soilmoisture`
--
ALTER TABLE `tbl_soilmoisture`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_status`
--
ALTER TABLE `tbl_status`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_temperature`
--
ALTER TABLE `tbl_temperature`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbl_userrole`
--
ALTER TABLE `tbl_userrole`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbl_category`
--
ALTER TABLE `tbl_category`
  MODIFY `categoryid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `tbl_humidity`
--
ALTER TABLE `tbl_humidity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `tbl_led`
--
ALTER TABLE `tbl_led`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `tbl_order`
--
ALTER TABLE `tbl_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tbl_orderproduct`
--
ALTER TABLE `tbl_orderproduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `tbl_product`
--
ALTER TABLE `tbl_product`
  MODIFY `productid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT cho bảng `tbl_role`
--
ALTER TABLE `tbl_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tbl_soilmoisture`
--
ALTER TABLE `tbl_soilmoisture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `tbl_status`
--
ALTER TABLE `tbl_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tbl_temperature`
--
ALTER TABLE `tbl_temperature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `tbl_userrole`
--
ALTER TABLE `tbl_userrole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
