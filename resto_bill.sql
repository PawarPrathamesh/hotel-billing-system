-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2023 at 08:07 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `resto_bill`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `ID` int(11) NOT NULL,
  `Order_id` int(11) NOT NULL,
  `Date_Time` datetime NOT NULL,
  `Amount` int(10) NOT NULL,
  `Payment_type` varchar(30) NOT NULL,
  `Credit_card` varchar(15) DEFAULT NULL,
  `Expiry_date` varchar(30) DEFAULT NULL,
  `Customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `mobile` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `Name`, `mobile`) VALUES
(53, 'pp', 0),
(54, 'pp', 0),
(55, 'ws', 1212),
(56, 'ws', 1212),
(57, 'rushi', 1212111),
(58, 'rushi', 1212111),
(59, 'wqdqwd', 12221),
(60, 'wqdqwd', 12221),
(61, 'wqdqwd', 12221),
(62, 'wqdqwd', 12221),
(63, 'wqdqwd', 12221),
(64, 'wqdqwd', 12221),
(65, 'wqdqwd', 12221),
(66, 'wqdqwd', 12221),
(67, 'wqdqwd', 12221),
(68, 'wqdqwd', 12221),
(69, 'wqdqwd', 12221),
(70, 'wqdqwd', 12221),
(71, '121', 21),
(72, '121', 21);

-- --------------------------------------------------------

--
-- Table structure for table `food_catagory`
--

CREATE TABLE `food_catagory` (
  `Food_cat_No` int(200) NOT NULL,
  `Food_cat_Name` varchar(100) NOT NULL,
  `comments` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food_catagory`
--

INSERT INTO `food_catagory` (`Food_cat_No`, `Food_cat_Name`, `comments`) VALUES
(1, 'af', ''),
(2, 'Punjabi', ''),
(3, '', ''),
(4, 'ads', ''),
(5, 'Siddu moosewala', ''),
(6, 'Punjabi', ''),
(7, 'Peg', ''),
(8, 'as', ''),
(9, 'garden', ''),
(10, 'vadapav', ''),
(11, 'Pizza', ''),
(12, 'Pizza', ''),
(13, 'Indian', ''),
(14, 'Prachi spl', ''),
(15, 'korean', 'Ramen'),
(16, 'chinese', 'tasty');

-- --------------------------------------------------------

--
-- Table structure for table `food_menu`
--

CREATE TABLE `food_menu` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Price` int(11) NOT NULL,
  `Food_Cat_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Measure_ID` int(11) NOT NULL,
  `Img_Name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food_menu`
--

INSERT INTO `food_menu` (`ID`, `Name`, `Price`, `Food_Cat_ID`, `Quantity`, `Measure_ID`, `Img_Name`) VALUES
(1, 'Hakka ', 100, 2, 2, 17, NULL),
(2, 'Amul Pav bhaji', 100, 3, 1, 17, NULL),
(3, 'Pizza', 450, 6, 1, 17, NULL),
(4, 'Pav bhaji', 1520, 6, 1, 17, NULL),
(5, 'Sandwich', 150, 2, 1, 17, NULL),
(6, 'ramen', 250, 15, 2, 13, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `measurement_type`
--

CREATE TABLE `measurement_type` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `measurement_type`
--

INSERT INTO `measurement_type` (`ID`, `Name`) VALUES
(13, 'ml'),
(15, '1litre'),
(16, 'Half'),
(17, 'Full'),
(18, 'Peg'),
(19, 'Quater'),
(20, 'mlf'),
(21, 'liter'),
(23, '2'),
(24, '2');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `ID` int(20) NOT NULL,
  `Table_id` int(20) NOT NULL,
  `Waiter_id` int(20) NOT NULL,
  `Captain_id` int(20) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_food`
--

CREATE TABLE `order_food` (
  `ID` int(20) NOT NULL,
  `order_id` int(20) NOT NULL,
  `Food_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `ID` int(11) NOT NULL,
  `Role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`ID`, `Role`) VALUES
(1, 'Captain'),
(2, 'Cook'),
(3, 'Manager'),
(4, 'Cashier'),
(5, 'Waiter'),
(11, 'Head cook'),
(12, 'abcd'),
(14, 'abc'),
(15, 'sads'),
(16, 'cleaner'),
(17, 'cleaner');

-- --------------------------------------------------------

--
-- Table structure for table `table_mgmt`
--

CREATE TABLE `table_mgmt` (
  `ID` int(20) NOT NULL,
  `Table_type` varchar(50) NOT NULL,
  `Table_no` varchar(20) NOT NULL,
  `seats` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `table_mgmt`
--

INSERT INTO `table_mgmt` (`ID`, `Table_type`, `Table_no`, `seats`) VALUES
(2, 'family', '45', '4'),
(3, 'Freinds', '1', '10'),
(4, 'rooftop', '5', '8'),
(5, 'rooftop', '5', '8');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `ID` int(10) NOT NULL,
  `Name` varchar(10) DEFAULT NULL,
  `Last_name` varchar(10) NOT NULL,
  `Phone_no` int(10) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Role_id` int(10) NOT NULL,
  `User_login_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`ID`, `Name`, `Last_name`, `Phone_no`, `Address`, `Gender`, `Role_id`, `User_login_Id`) VALUES
(4, 'GHAJEWDFV', 'jhg', 0, 'df', 'FEMALE', 2, 2),
(6, 'Prachi', 'Sapkal', 0, 'hatti chowk', 'FEMALE', 2, 4),
(7, 'Nakul', 'Bhandari', 0, 'abc', 'MALE', 5, 5),
(8, 'Vedant', 'Yadav', 0, 'abcd', 'MALE', 1, 6),
(10, 'wfqdd', 'qwdwq', 984543, 'rt4rw4', 'Other', 3, 7),
(11, 'pranav', 'chutiya', 121, 'nahre', 'Other', 17, 11);

-- --------------------------------------------------------

--
-- Table structure for table `user_login`
--

CREATE TABLE `user_login` (
  `User_id` int(20) NOT NULL,
  `User_Name` varchar(20) NOT NULL,
  `User_Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_login`
--

INSERT INTO `user_login` (`User_id`, `User_Name`, `User_Password`) VALUES
(1, 'DAWWADAWDDES', 'GAERGER'),
(2, 'GHAJEWDFV', 'hjfgv'),
(4, 'Prachi', 'virat'),
(5, 'Nakul', '789'),
(6, 'Vedant', '7898'),
(7, 'qwdwqd', '1234'),
(11, 'awidbawudjaw', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `or` (`Order_id`),
  ADD KEY `cus_bill` (`Customer_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `food_catagory`
--
ALTER TABLE `food_catagory`
  ADD PRIMARY KEY (`Food_cat_No`);

--
-- Indexes for table `food_menu`
--
ALTER TABLE `food_menu`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `food_menu&Catagory` (`Food_Cat_ID`),
  ADD KEY `food_menu&Measure_ID` (`Measure_ID`);

--
-- Indexes for table `measurement_type`
--
ALTER TABLE `measurement_type`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Table_id` (`Table_id`),
  ADD KEY `Captain_id` (`Captain_id`),
  ADD KEY `Waiter_id` (`Waiter_id`);

--
-- Indexes for table `order_food`
--
ALTER TABLE `order_food`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `Food_id` (`Food_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `table_mgmt`
--
ALTER TABLE `table_mgmt`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `user_info` (`Role_id`),
  ADD KEY `User_login_Id` (`User_login_Id`);

--
-- Indexes for table `user_login`
--
ALTER TABLE `user_login`
  ADD PRIMARY KEY (`User_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT for table `food_catagory`
--
ALTER TABLE `food_catagory`
  MODIFY `Food_cat_No` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `food_menu`
--
ALTER TABLE `food_menu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `measurement_type`
--
ALTER TABLE `measurement_type`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_food`
--
ALTER TABLE `order_food`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `table_mgmt`
--
ALTER TABLE `table_mgmt`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user_login`
--
ALTER TABLE `user_login`
  MODIFY `User_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `cus_bill` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `or` FOREIGN KEY (`Order_id`) REFERENCES `orders` (`ID`);

--
-- Constraints for table `food_menu`
--
ALTER TABLE `food_menu`
  ADD CONSTRAINT `food_menu&Catagory` FOREIGN KEY (`Food_Cat_ID`) REFERENCES `food_catagory` (`Food_cat_No`),
  ADD CONSTRAINT `food_menu&Measure_ID` FOREIGN KEY (`Measure_ID`) REFERENCES `measurement_type` (`ID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Table_id`) REFERENCES `table_mgmt` (`ID`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`Captain_id`) REFERENCES `role` (`ID`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`Waiter_id`) REFERENCES `role` (`ID`);

--
-- Constraints for table `order_food`
--
ALTER TABLE `order_food`
  ADD CONSTRAINT `order_food_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`ID`),
  ADD CONSTRAINT `order_food_ibfk_2` FOREIGN KEY (`Food_id`) REFERENCES `food_menu` (`ID`);

--
-- Constraints for table `user_info`
--
ALTER TABLE `user_info`
  ADD CONSTRAINT `user_info` FOREIGN KEY (`Role_id`) REFERENCES `role` (`ID`),
  ADD CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`User_login_Id`) REFERENCES `user_login` (`User_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
