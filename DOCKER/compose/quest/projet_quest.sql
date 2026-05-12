-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 20 avr. 2026 à 15:24
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_quest`
--
CREATE DATABASE IF NOT EXISTS `projet_quest` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `projet_quest`;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
CREATE TABLE IF NOT EXISTS `filiere` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(35) NOT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `salle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_filiere_salle` (`salle`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`id`, `libelle`, `debut`, `fin`, `salle`) VALUES
(1, 'SOPRA-JAVA-260209', '2026-02-09', '2026-05-12', 1),
(2, 'SOPRA-JAVA-260407', '2026-04-07', '2026-07-15', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`id`, `libelle`) VALUES
(1, 'SQL'),
(2, 'Spring Core'),
(3, 'Angular');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quest` int(11) NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `matiere` int(11) NOT NULL,
  `filiere` int(11) NOT NULL,
  `formateur` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_module_filiere` (`filiere`),
  KEY `fk_module_matiere` (`matiere`),
  KEY `fk_module_formateur` (`formateur`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`id`, `quest`, `debut`, `fin`, `matiere`, `filiere`, `formateur`) VALUES
(1, 4659, '2026-02-09', '2026-02-12', 1, 1, 3),
(2, 9367, '2026-03-23', '2026-03-25', 2, 1, 3),
(3, 3422, '2026-04-20', '2026-04-24', 3, 1, 4),
(4, 6618, '2026-04-16', '2026-04-20', 1, 2, 3),
(5, 6511, '2026-06-04', '2026-06-08', 2, 2, 3),
(6, 2377, '2026-06-26', '2026-07-02', 3, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `ordinateur`
--

DROP TABLE IF EXISTS `ordinateur`;
CREATE TABLE IF NOT EXISTS `ordinateur` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `marque` varchar(10) NOT NULL,
  `ram` int(11) NOT NULL DEFAULT '0',
  `utilisateur` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `fk_ordinateur_stagiare` (`utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ordinateur`
--

INSERT INTO `ordinateur` (`numero`, `marque`, `ram`, `utilisateur`) VALUES
(1, 'Asus', 8, 1),
(2, 'Apple', 16, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(70) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `civilite` enum('Homme','Femme','NB') NOT NULL,
  `admin` tinyint(1) DEFAULT '0',
  `email` varchar(30) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `voie` varchar(35) DEFAULT NULL,
  `cp` varchar(15) DEFAULT NULL,
  `ville` varchar(35) DEFAULT NULL,
  `filiere` int(11) DEFAULT NULL,
  `type_personne` enum('Stagiaire','Formateur') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  KEY `fk_stagiaire_filiere` (`filiere`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `login`, `password`, `nom`, `prenom`, `civilite`, `admin`, `email`, `numero`, `voie`, `cp`, `ville`, `filiere`, `type_personne`) VALUES
(1, 'stagiaire1', 'stagiaire1', 'Doe', 'John', 'Homme', NULL, 'john@gmail.co', '6', 'rue rougemont', '75009', 'Paris', 1, 'Stagiaire'),
(2, 'stagiaire2', 'stagiaire2', 'Doe', 'Jane', 'Femme', NULL, 'jane@gmail.co', '12', 'rue de paris', '75011', 'Paris', 2, 'Stagiaire'),
(3, 'formateur1', 'formateur1', 'Abid', 'Jordan', 'NB', 1, NULL, NULL, NULL, NULL, NULL, NULL, 'Formateur'),
(4, 'formateur2', 'formateur2', 'Perrouault', 'Jeremy', 'Homme', 0, NULL, NULL, NULL, NULL, NULL, NULL, 'Formateur');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `voie` varchar(35) NOT NULL,
  `cp` varchar(15) NOT NULL,
  `ville` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `nom`, `numero`, `voie`, `cp`, `ville`) VALUES
(1, 'Violet', '161', 'avenue de verdun', '94200', 'Ivry sur Seine');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD CONSTRAINT `fk_filiere_salle` FOREIGN KEY (`salle`) REFERENCES `salle` (`id`);

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `fk_module_filiere` FOREIGN KEY (`filiere`) REFERENCES `filiere` (`id`),
  ADD CONSTRAINT `fk_module_formateur` FOREIGN KEY (`formateur`) REFERENCES `personne` (`id`),
  ADD CONSTRAINT `fk_module_matiere` FOREIGN KEY (`matiere`) REFERENCES `matiere` (`id`);

--
-- Contraintes pour la table `ordinateur`
--
ALTER TABLE `ordinateur`
  ADD CONSTRAINT `fk_ordinateur_stagiare` FOREIGN KEY (`utilisateur`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `fk_stagiaire_filiere` FOREIGN KEY (`filiere`) REFERENCES `filiere` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
