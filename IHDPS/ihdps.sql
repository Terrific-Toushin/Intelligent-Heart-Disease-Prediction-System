-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2018 at 07:04 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ihdps`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `ID` int(100) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `username`, `password`) VALUES
(1, 'Admin', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `tbtrainingdataset`
--

CREATE TABLE IF NOT EXISTS `tbtrainingdataset` (
  `patientId` int(255) NOT NULL,
  `patientName` varchar(30) NOT NULL,
  `Age` varchar(15) NOT NULL,
  `Gender` varchar(15) NOT NULL,
  `ChestPainType` varchar(30) NOT NULL,
  `FastingBloodsugger` varchar(30) NOT NULL,
  `RestECG` varchar(30) NOT NULL,
  `Exang` varchar(30) NOT NULL,
  `Slop` varchar(30) NOT NULL,
  `Thal` varchar(40) NOT NULL,
  `TrestBloodPressure` varchar(30) NOT NULL,
  `SerumCholesterol` varchar(30) NOT NULL,
  `Thalach` varchar(30) NOT NULL,
  `Oldpeak` varchar(30) NOT NULL,
  `Smoking` varchar(30) NOT NULL,
  `Obesity` varchar(30) NOT NULL,
  `Disease` varchar(30) DEFAULT NULL,
  `Probabilty` varchar(30) NOT NULL,
  `BestClassName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbtrainingdataset`
--

INSERT INTO `tbtrainingdataset` (`patientId`, `patientName`, `Age`, `Gender`, `ChestPainType`, `FastingBloodsugger`, `RestECG`, `Exang`, `Slop`, `Thal`, `TrestBloodPressure`, `SerumCholesterol`, `Thalach`, `Oldpeak`, `Smoking`, `Obesity`, `Disease`, `Probabilty`, `BestClassName`) VALUES
(1701001, 'Md Shahid', 'Mid', 'Male', 'Asymptomatic', 'No', 'Normal', 'Yes', 'Unsloping', 'Normal', 'Medium', 'Low', 'Low', 'Low', 'Past', 'Yes', 'Positive', '89.06%', 'Chest Pain Type'),
(1701002, 'Md Aman', 'Mid', 'Male', 'Atypical Angina', 'No', 'Normal', 'Yes', 'Unsloping', 'Normal', 'Low', 'Medium', 'High', 'Risk', 'Past', 'No', 'Negative', '0.0%', 'N/A'),
(1701003, 'Pritom Barua', 'Mid', 'Male', 'Non-angina pain', 'Yes', 'Normal', 'No', 'Downsloping', 'Reversible Defect', 'High', 'Low', 'High', 'Terrible', 'Current', 'No', 'Negative', '0.0%', 'N/A'),
(1701004, 'Aklima Khanam', 'Mid', 'Female', 'Non-angina pain', 'No', 'Normal', 'No', 'Flat', 'Reversible Defect', 'High', 'High', 'Medium', 'Risk', 'Never', 'No', 'Negative', '0.0%', 'N/A'),
(1701005, 'Kamal Uddin', 'Old', 'Male', 'Asymptomatic', 'No', 'Normal', 'No', 'Downsloping', 'Normal', 'Medium', 'Low', 'Medium', 'Risk', 'Never', 'Yes', 'Negative', '0.0%', 'N/A'),
(1701006, 'Arjun', 'Old', 'Male', 'Asymptomatic', 'No', 'Normal', 'No', 'Unsloping', 'Normal', 'Medium', 'High', 'Medium', 'Terrible', 'Past', 'Yes', 'Negative', '0.0%', 'N/A'),
(1701007, 'Naima', 'Very Old', 'Female', 'Asymptomatic', 'Yes', 'Hypertrophy', 'Yes', 'Unsloping', 'Normal', 'Medium', 'Very High', 'Low', 'Terrible', 'Past', 'No', 'Positive', '86.12%', 'Chest Pain Type'),
(1701008, 'Reshmi Akter', 'Old', 'Female', 'Asymptomatic', 'No', 'Normal', 'Yes', 'Unsloping', 'Fixed Defect', 'Very High', 'Very High', 'High', 'Low', 'Current', 'Yes', 'Positive', '86.23%', 'Chest Pain Type'),
(1701009, '', 'Very Old', 'Male', 'Asymptomatic', 'No', 'Normal', 'No', 'Flat', 'Normal', 'Low', 'Low', 'Low', 'Risk', 'Current', 'No', 'Positive', '', ''),
(1701010, '', 'Very Old', 'Female', 'Asymptomatic', 'No', 'ST_T abnormal', 'Yes', 'Flat', 'Normal', 'Very High', 'Medium', 'Low', 'Low', 'Past', 'Yes', 'Positive', '', ''),
(1701011, '', 'Old', 'Female', 'Non-angina pain', 'No', 'ST_T abnormal', 'No', 'Downsloping', 'Reversible Defect', 'Medium', 'High', 'High', 'Low', 'Never', 'Yes', 'Negative', '', ''),
(1701012, '', 'Very Old', 'Female', 'Asymptomatic', 'No', 'Normal', 'No', 'Flat', 'Fixed Defect', 'Low', 'High', 'Low', 'Risk', 'Never', 'Yes', 'Positive', '', ''),
(1701013, '', 'Old', '', 'Atypical Angina', 'Yes', 'Normal', 'Yes', 'Flat', 'Fixed Defect', 'High', 'Low', 'Medium', 'Risk', 'Past', 'No', 'Positive', '', ''),
(1701014, '', 'Very Old', 'Male', 'Atypical Angina', 'Yes', 'Normal', 'No', 'Downsloping', 'Normal', 'Medium', 'Low', 'Medium', 'Terrible', 'Never', 'Yes', 'Negative', '', ''),
(1701015, '', 'Mid', 'Female', 'Asymptomatic', 'No', 'Normal', 'No', 'Downsloping', 'Normal', 'Low', 'Medium', 'High', 'Terrible', 'Current', 'No', 'Positive', '', ''),
(1701016, '', 'Very Old', 'Male', 'Non-angina pain', 'No', 'Hypertrophy', 'No', 'Flat', 'Reversible Defect', 'Low', 'Medium', 'Medium', 'Low', 'Current', 'No', 'Negative', '', ''),
(1701017, '', 'Old', 'Male', 'Atypical Angina', 'No', 'Normal', 'No', 'Flat', 'Reversible Defect', 'Medium', 'Low', 'High', 'Low', 'Past', 'No', 'Negative', '', ''),
(1701018, '', 'Old', 'Female', 'Asymptomatic', 'No', 'ST_T abnormal', 'Yes', 'Unsloping', 'Normal', 'Medium', 'Very High', 'Medium', 'Risk', 'Never', 'Yes', 'Positive', '', ''),
(1701019, '', 'Mid', 'Male', 'Asymptomatic', 'Yes', 'Normal', 'No', 'Flat', 'Normal', 'Low', 'High', 'Low', 'Terrible', 'Past', 'No', 'Positive', '', ''),
(1701020, '', 'Very Old', 'Female', 'Atypical Angina', 'No', 'Normal', 'No', 'Flat', 'Normal', 'Very High', 'Medium', 'Low', 'Risk', 'Current', 'Yes', 'Negative', '', ''),
(1701021, 'Asif Imtiaj', 'Mid', 'Male', 'Asymptomatic', 'Yes', 'ST_T abnormal', 'Yes', 'Downsloping', 'Fixed Defect', 'High', 'High', 'Medium', 'Risk', 'Current', 'Yes', 'Positive', '4.06%', 'Chest Pain Type');

-- --------------------------------------------------------

--
-- Table structure for table `trdata`
--

CREATE TABLE IF NOT EXISTS `trdata` (
  `ID` int(255) NOT NULL,
  `Age` varchar(15) NOT NULL,
  `Gender` varchar(15) NOT NULL,
  `ChestPainType` varchar(30) NOT NULL,
  `FastingBloodSugar` varchar(30) NOT NULL,
  `RestECG` varchar(30) NOT NULL,
  `Exang` varchar(30) NOT NULL,
  `Slop` varchar(30) NOT NULL,
  `Thal` varchar(40) NOT NULL,
  `TrestBloodPresure` varchar(30) NOT NULL,
  `SerumCholesterol` varchar(30) NOT NULL,
  `Thalach` varchar(30) NOT NULL,
  `Oldpeak` varchar(30) NOT NULL,
  `Smoking` varchar(30) NOT NULL,
  `Obesity` varchar(30) NOT NULL,
  `Disease` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1701021 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trdata`
--

INSERT INTO `trdata` (`ID`, `Age`, `Gender`, `ChestPainType`, `FastingBloodSugar`, `RestECG`, `Exang`, `Slop`, `Thal`, `TrestBloodPresure`, `SerumCholesterol`, `Thalach`, `Oldpeak`, `Smoking`, `Obesity`, `Disease`) VALUES
(1701001, 'Mid', 'Male', 'Asymptomatic', 'No', 'Normal', 'Yes', 'Unsloping', 'Normal', 'Medium', 'Low', 'Low', 'Low', 'Past', 'Yes', 'Positive'),
(1701002, 'Mid', 'Male', 'Atypical Angina', 'No', 'Normal', 'Yes', 'Unsloping', 'Normal', 'Low', 'Medium', 'High', 'Risk', 'Past', 'No', 'Negative'),
(1701003, 'Mid', 'Male', 'Non-angina pain', 'Yes', 'Normal', 'No', 'Downsloping', 'Reversible Defect', 'High', 'Low', 'High', 'Terrible', 'Current', 'No', 'Negative'),
(1701004, 'Mid', 'Female', 'Non-angina pain', 'No', 'Normal', 'No', 'Flat', 'Reversible Defect', 'High', 'High', 'Medium', 'Risk', 'Never', 'No', 'Negative'),
(1701005, 'Old', 'Male', 'Asymptomatic', 'No', 'Normal', 'No', 'Downsloping', 'Normal', 'Medium', 'Low', 'Medium', 'Risk', 'Never', 'Yes', 'Negative'),
(1701006, 'Old', 'Male', 'Asymptomatic', 'No', 'Normal', 'No', 'Unsloping', 'Normal', 'Medium', 'High', 'Medium', 'Terrible', 'Past', 'Yes', 'Negative'),
(1701007, 'Very Old', 'Female', 'Asymptomatic', 'Yes', 'Hypertrophy', 'Yes', 'Unsloping', 'Normal', 'Medium', 'Very High', 'Low', 'Terrible', 'Past', 'No', 'Positive'),
(1701008, 'Old', 'Female', 'Asymptomatic', 'No', 'Normal', 'Yes', 'Unsloping', 'Fixed Defect', 'Very High', 'Very High', 'High', 'Low', 'Current', 'Yes', 'Positive'),
(1701009, 'Very Old', 'Male', 'Asymptomatic', 'No', 'Normal', 'No', 'Flat', 'Normal', 'Low', 'Low', 'Low', 'Risk', 'Current', 'No', 'Positive'),
(1701010, 'Very Old', 'Female', 'Asymptomatic', 'No', 'ST_T abnormal', 'Yes', 'Flat', 'Normal', 'Very High', 'Medium', 'Low', 'Low', 'Past', 'Yes', 'Positive'),
(1701011, 'Old', 'Female', 'Non-angina pain', 'No', 'ST_T abnormal', 'No', 'Downsloping', 'Reversible Defect', 'Medium', 'High', 'High', 'Low', 'Never', 'Yes', 'Negative'),
(1701012, 'Very Old', 'Female', 'Asymptomatic', 'No', 'Normal', 'No', 'Flat', 'Fixed Defect', 'Low', 'High', 'Low', 'Risk', 'Never', 'Yes', 'Positive'),
(1701013, 'Old', 'Male', 'Atypical Angina', 'Yes', 'Normal', 'Yes', 'Flat', 'Fixed Defect', 'High', 'Low', 'Medium', 'Risk', 'Past', 'No', 'Positive'),
(1701014, 'Very Old', 'Male', 'Atypical Angina', 'Yes', 'Normal', 'No', 'Downsloping', 'Normal', 'Medium', 'Low', 'Medium', 'Terrible', 'Never', 'Yes', 'Negative'),
(1701015, 'Mid', 'Female', 'Asymptomatic', 'No', 'Normal', 'No', 'Downsloping', 'Normal', 'Low', 'Medium', 'High', 'Terrible', 'Current', 'No', 'Positive'),
(1701016, 'Very Old', 'Male', 'Non-angina pain', 'No', 'Hypertrophy', 'No', 'Flat', 'Reversible Defect', 'Low', 'Medium', 'Medium', 'Low', 'Current', 'No', 'Negative'),
(1701017, 'Old', 'Male', 'Atypical Angina', 'No', 'Normal', 'No', 'Flat', 'Reversible Defect', 'Medium', 'Low', 'High', 'Low', 'Past', 'No', 'Negative'),
(1701018, 'Old', 'Female', 'Asymptomatic', 'No', 'ST_T abnormal', 'Yes', 'Unsloping', 'Normal', 'Medium', 'Very High', 'Medium', 'Risk', 'Never', 'Yes', 'Positive'),
(1701019, 'Mid', 'Male', 'Asymptomatic', 'Yes', 'Normal', 'No', 'Flat', 'Normal', 'Low', 'High', 'Low', 'Terrible', 'Past', 'No', 'Positive'),
(1701020, 'Very Old', 'Female', 'Atypical Angina', 'No', 'Normal', 'No', 'Flat', 'Normal', 'Very High', 'Medium', 'Low', 'Risk', 'Current', 'Yes', 'Negative');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `tbtrainingdataset`
--
ALTER TABLE `tbtrainingdataset`
  ADD PRIMARY KEY (`patientId`);

--
-- Indexes for table `trdata`
--
ALTER TABLE `trdata`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `trdata`
--
ALTER TABLE `trdata`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1701021;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
