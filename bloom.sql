-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Oct 29, 2024 at 05:24 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bloom`
--

-- --------------------------------------------------------

--
-- Table structure for table `plant`
--

CREATE TABLE `plant` (
  `id` bigint(20) NOT NULL,
  `care` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `in_stock` bit(1) DEFAULT NULL,
  `include` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `plant`
--

INSERT INTO `plant` (`id`, `care`, `description`, `in_stock`, `include`, `name`, `price`) VALUES
(1, 'Does not ship to\r\nCA\r\n\r\nSize\r\nXL—36\"-39\" tall (including recycled plastic Ecopot) Size Guide\r\n\r\nDifficulty\r\nNo-fuss—Easy Care\r\n\r\nLight\r\nPartial/Bright Indirect\r\n\r\nPet Friendly\r\nYes—Non-toxic and pet-friendly\r\n\r\nAir Cleaner\r\nYes—Releases oxygen and absorbs', 'The Cat Palm is sure to become a favorite thanks to its lush tropical appearance and dense green foliage. The Cat Palm’s fluffy leaves and short trunk give the feeling of a jungle oasis in your very own home. As one of our fullest plants, this palm is rea', b'1', '1. Healthy plant pre-potted with premium soil\r\n2. Plant size: 36″-39″ tall (including pot)\r\n3. Large Ecopots pot and saucer\r\n4. Pot size: 11.8″ in diameter, 10.25″ tall\r\n5. Saucer size: 10.5″ in diameter\r\n6. All the tips and tricks for expert-level care', 'Cat Palm', 169.00),
(2, 'This Cacti Fertilizer (2-7-7) is specifically formulated to provide vigor to cacti, jade, aloe, and other succulents. Feeding your plants with this concentrate encourages them to grow strong and healthy. It can also encourage flowering plants to produce b', 'This Cacti Fertilizer (2-7-7) is specifically formulated to provide vigor to cacti, jade, aloe, and other succulents. Feeding your plants with this concentrate encourages them to grow strong and healthy. It can also encourage flowering plants to produce b', b'1', '1. Healthy plant pre-potted with premium soil\r\n2. Plant size: 36″-39″ tall (including pot)\r\n3. Large Ecopots pot and saucer\r\n4. Pot size: 11.8″ in diameter, 10.25″ tall\r\n5. Saucer size: 10.5″ in diameter\r\n6. All the tips and tricks for expert-level care', 'Cactus', 70.00),
(3, 'This Cacti Fertilizer (2-7-7) is specifically formulated to provide vigor to cacti, jade, aloe, and other succulents. Feeding your plants with this concentrate encourages them to grow strong and healthy. It can also encourage flowering plants to produce b', 'This Cacti Fertilizer (2-7-7) is specifically formulated to provide vigor to cacti, jade, aloe, and other succulents. Feeding your plants with this concentrate encourages them to grow strong and healthy. It can also encourage flowering plants to produce b', b'1', '1. Healthy plant pre-potted with premium soil\r\n2. Plant size: 36″-39″ tall (including pot)\r\n3. Large Ecopots pot and saucer\r\n4. Pot size: 11.8″ in diameter, 10.25″ tall\r\n5. Saucer size: 10.5″ in diameter\r\n6. All the tips and tricks for expert-level care', 'Kimberley Queen Fern', 200.00),
(4, 'The Eureka Lemon Tree (Citrus limon ‘Eureka’) is here to add a little bit of sunshine to your home decor year-round. This dwarf tree thrives in sun-drenched locations and will be happiest near south-facing windows or gracing your summer patios.', 'The Eureka Lemon Tree (Citrus limon ‘Eureka’) is here to add a little bit of sunshine to your home decor year-round. This dwarf tree thrives in sun-drenched locations and will be happiest near south-facing windows or gracing your summer patios.', b'1', '1. Healthy plant pre-potted with premium soil\r\n2. Plant size: 36″-39″ tall (including pot)\r\n3. Large Ecopots pot and saucer\r\n4. Pot size: 11.8″ in diameter, 10.25″ tall\r\n5. Saucer size: 10.5″ in diameter\r\n6. All the tips and tricks for expert-level care', 'Eureka Lemon Tree', 80.00);

-- --------------------------------------------------------

--
-- Table structure for table `plant_image_urls`
--

CREATE TABLE `plant_image_urls` (
  `plant_id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `plant_image_urls`
--

INSERT INTO `plant_image_urls` (`plant_id`, `url`) VALUES
(1, '\\images\\plant-1.jpeg'),
(1, '\\images\\plant-1-1.jpeg'),
(1, '\\images\\plant-1-2.jpeg'),
(2, '\\images\\plant-2.jpeg'),
(2, '\\images\\plant-2-1.jpeg'),
(2, '\\images\\plant-2-2.jpeg'),
(3, '\\images\\plant-3.jpeg'),
(3, '\\images\\plant-3-1.jpeg'),
(3, '\\images\\plant-3-2.jpeg'),
(3, '\\images\\plant-3-3.jpeg'),
(4, '\\images\\plant-4.jpeg'),
(4, '\\images\\plant-4-1.jpeg'),
(4, '\\images\\plant-4-2.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `delivery_address`, `email`, `first_name`, `last_name`, `password`, `username`) VALUES
(1, NULL, 'k@gmail.com', 'Kamila', 'Ulevič', 'Kamila!007', 'ulevick');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `plant`
--
ALTER TABLE `plant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `plant_image_urls`
--
ALTER TABLE `plant_image_urls`
  ADD KEY `FK2pru6ghrmrx6t30bxogapsjru` (`plant_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `plant`
--
ALTER TABLE `plant`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `plant_image_urls`
--
ALTER TABLE `plant_image_urls`
  ADD CONSTRAINT `FK2pru6ghrmrx6t30bxogapsjru` FOREIGN KEY (`plant_id`) REFERENCES `plant` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
