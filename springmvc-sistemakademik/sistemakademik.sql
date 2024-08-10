-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for sistemakademik
CREATE DATABASE IF NOT EXISTS `sistemakademik` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistemakademik`;

-- Dumping structure for table sistemakademik.dosen
CREATE TABLE IF NOT EXISTS `dosen` (
  `rec_no` int NOT NULL AUTO_INCREMENT,
  `no_dos` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  PRIMARY KEY (`rec_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sistemakademik.dosen: ~4 rows (approximately)
INSERT INTO `dosen` (`rec_no`, `no_dos`, `nama`) VALUES
	(2, '15002', 'Dewi Rosmala'),
	(3, '15003', 'Diash Firdaush'),
	(4, '15003', 'Irma Amelia'),
	(5, '150012', 'Katon Rinantomo'),
	(8, '15004', 'Uung Ungkawa');

-- Dumping structure for table sistemakademik.mahasiswa
CREATE TABLE IF NOT EXISTS `mahasiswa` (
  `rec_no` int NOT NULL AUTO_INCREMENT,
  `nrp` varchar(255) DEFAULT NULL,
  `nama` varchar(255) NOT NULL,
  `status` enum('aktif','cuti') NOT NULL DEFAULT 'aktif',
  PRIMARY KEY (`rec_no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sistemakademik.mahasiswa: ~2 rows (approximately)
INSERT INTO `mahasiswa` (`rec_no`, `nrp`, `nama`, `status`) VALUES
	(6, '152022001', 'M. Ikhsan', 'aktif'),
	(8, '152022009', 'Jeffry Sukmawidjaya', 'aktif');

-- Dumping structure for table sistemakademik.mk
CREATE TABLE IF NOT EXISTS `mk` (
  `rec_no` int NOT NULL AUTO_INCREMENT,
  `id_mk` varchar(255) NOT NULL,
  `mk` varchar(255) NOT NULL,
  PRIMARY KEY (`rec_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sistemakademik.mk: ~0 rows (approximately)
INSERT INTO `mk` (`rec_no`, `id_mk`, `mk`) VALUES
	(2, 'IFB-213', 'Rekayasa Perangkat Lunak'),
	(3, 'IFB-209', 'Sistem Operasi'),
	(4, 'IFB-201', 'Grafika Komputer Terapan'),
	(5, 'IFB-206', 'komputasi_pararel'),
	(6, 'ELB-107', 'pemograman_komputer'),
	(8, 'IFB-202', 'Pemrograman Berorientasi Objek');

-- Dumping structure for table sistemakademik.nilai
CREATE TABLE IF NOT EXISTS `nilai` (
  `rec_no` int NOT NULL AUTO_INCREMENT,
  `rec_mhs` int NOT NULL DEFAULT '0',
  `rec_dos` int NOT NULL DEFAULT '0',
  `rec_mk` int NOT NULL DEFAULT '0',
  `sc1` int DEFAULT NULL,
  `sc2` int DEFAULT NULL,
  `sc3` int DEFAULT NULL,
  PRIMARY KEY (`rec_no`),
  KEY `FK__mahasiswa` (`rec_mhs`),
  KEY `FK__mk` (`rec_mk`),
  KEY `FK_nilai_dosen` (`rec_dos`),
  CONSTRAINT `FK__mahasiswa` FOREIGN KEY (`rec_mhs`) REFERENCES `mahasiswa` (`rec_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__mk` FOREIGN KEY (`rec_mk`) REFERENCES `mk` (`rec_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_nilai_dosen` FOREIGN KEY (`rec_dos`) REFERENCES `dosen` (`rec_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sistemakademik.nilai: ~0 rows (approximately)
INSERT INTO `nilai` (`rec_no`, `rec_mhs`, `rec_dos`, `rec_mk`, `sc1`, `sc2`, `sc3`) VALUES
	(7, 8, 2, 2, 100, 90, 95),
	(8, 6, 8, 8, 80, 90, 100);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
