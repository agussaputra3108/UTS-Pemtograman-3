-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 09, 2012 at 12:28 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpus`
--
CREATE DATABASE `perpus` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `perpus`;

-- --------------------------------------------------------

--
-- Table structure for table `databuku`
--

CREATE TABLE IF NOT EXISTS `databuku` (
  `kode` varchar(4) NOT NULL,
  `judul` varchar(40) NOT NULL,
  `pengarang` varchar(40) NOT NULL,
  `penerbit` varchar(40) NOT NULL,
  `tempat` varchar(40) NOT NULL,
  `tahun` varchar(10) NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `databuku`
--

INSERT INTO `databuku` (`kode`, `judul`, `pengarang`, `penerbit`, `tempat`, `tahun`) VALUES
('001', 'pemograman java', 'hero wintolo', 'YUDISTIRA', 'RK 1 -Teknik Infromatika', '2012'),
('002', 'pemograman c', 'hero wintolo', 'ERLANGGA', 'RK 1 -Teknik Infromatika', '2012'),
('003', 'Animasi 2D', 'Hendro Wibowo', 'ANDI', 'RK 1 -Teknik Infromatika', '2012'),
('004', 'belajar mysql', 'hero wintolo', 'ERLANGGA', 'RK 1 -Teknik Infromatika', '2009'),
('005', 'belajar animasi', 'Dwi Nugraheny', 'YUDISTIRA', 'RK 1 -Teknik Infromatika', '2009'),
('010', 'Interaksi Manusia dan komputer', 'Dwi Nurgaheny', 'YUDISTIRA', 'RK 2 -Teknik Infromatika', '2012'),
('101', 'Basic Pesawat terbang', 'Ibnu Jamil', 'YUDISTIRA', 'RK 1 -Teknik Penerbangan', '2009'),
('102', 'Fisika 1', 'Bill Gates', 'ERLANGGA', 'RK 2-Teknik Penerbangan', '2010'),
('103', 'kalkulus', 'Stave Jobs', 'ANDI', 'RK 1 -Teknik Penerbangan', '2012');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `nim` varchar(8) NOT NULL,
  `kode` varchar(4) NOT NULL,
  `tanggalpinjam` date NOT NULL,
  `tanggalkembali` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`nim`, `kode`, `tanggalpinjam`, `tanggalkembali`) VALUES
('10030035', '004', '2012-01-13', '2012-01-08'),
('10030039', '101', '2012-01-13', '2012-01-08');
