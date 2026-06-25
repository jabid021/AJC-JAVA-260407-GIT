-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : jeu. 25 juin 2026 à 09:09
-- Version du serveur : 8.0.44
-- Version de PHP : 8.3.30

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

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `id` int NOT NULL,
  `libelle` varchar(35) NOT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `salle` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`id`, `libelle`, `debut`, `fin`, `salle`) VALUES
(1, 'SOPRA-JAVA-260209', '2026-02-09', '2026-05-12', 1),
(2, 'SOPRA-JAVA-260407', '2026-04-07', '2026-07-15', NULL),
(4, 'test', '2026-06-19', '2026-06-28', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `id` int NOT NULL,
  `libelle` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`id`, `libelle`) VALUES
(1, 'SQL'),
(2, 'Spring Core'),
(3, 'Angularaa');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `id` int NOT NULL,
  `quest` int NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `matiere` int NOT NULL,
  `filiere` int NOT NULL,
  `formateur` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

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

CREATE TABLE `ordinateur` (
  `numero` int NOT NULL,
  `marque` varchar(10) NOT NULL,
  `ram` int NOT NULL DEFAULT '0',
  `utilisateur` int DEFAULT NULL,
  `version` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `ordinateur`
--

INSERT INTO `ordinateur` (`numero`, `marque`, `ram`, `utilisateur`, `version`) VALUES
(1, 'Apple', 16, 2, 1),
(2, 'Apple', 32, 1, 1),
(3, 'test', 8, NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int NOT NULL,
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
  `filiere` int DEFAULT NULL,
  `type_personne` enum('Stagiaire','Formateur') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `login`, `password`, `nom`, `prenom`, `civilite`, `admin`, `email`, `numero`, `voie`, `cp`, `ville`, `filiere`, `type_personne`) VALUES
(1, 'stagiaire1', 'stagiaire1', 'Doe', 'John', 'Homme', NULL, 'john@gmail.co', '6', 'rue rougemont', '75009', 'Paris', 1, 'Stagiaire'),
(2, 'stagiaire2', 'stagiaire2', 'Doe', 'Jane', 'Femme', NULL, 'jane@gmail.co', '12', 'rue de paris', '75011', 'Paris', 2, 'Stagiaire'),
(3, 'f', '$2a$10$awEh9d14IyLGLCNdaE0VhuUOOhJ5bMq.OYHHzFC1aQ7txx82se1Ui', 'Abid', 'Jordan', 'NB', 1, NULL, NULL, NULL, NULL, NULL, NULL, 'Formateur'),
(4, 'formateur2', 'formateur2', 'Perrouault', 'Jeremy', 'Homme', 0, NULL, NULL, NULL, NULL, NULL, NULL, 'Formateur');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `id` int NOT NULL,
  `nom` varchar(20) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `voie` varchar(35) NOT NULL,
  `cp` varchar(15) NOT NULL,
  `ville` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `nom`, `numero`, `voie`, `cp`, `ville`) VALUES
(1, 'Violet', '161', 'avenue de verdun', '94200', 'Ivry sur Seine');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_filiere_salle` (`salle`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_module_filiere` (`filiere`),
  ADD KEY `fk_module_matiere` (`matiere`),
  ADD KEY `fk_module_formateur` (`formateur`);

--
-- Index pour la table `ordinateur`
--
ALTER TABLE `ordinateur`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `fk_ordinateur_stagiare` (`utilisateur`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`),
  ADD KEY `fk_stagiaire_filiere` (`filiere`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `ordinateur`
--
ALTER TABLE `ordinateur`
  MODIFY `numero` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
