DROP SCHEMA IF EXISTS `BDD_BANQUE`;
CREATE SCHEMA `BDD_BANQUE` ;

DROP TABLE IF EXISTS `BDD_BANQUE`.`TypePersonne` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`Personne` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`Entreprise` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`Offre` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`OffreHistorique` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`Demande` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`DemandeHistorique` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`Information` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`Titre` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`LierOffreTitre` ;
DROP TABLE IF EXISTS `BDD_BANQUE`.`LierOffreTitreHistorique` ;


CREATE TABLE `BDD_BANQUE`.`TypePersonne` (
  `idTypePersonne` INT AUTO_INCREMENT NOT NULL,
  `typePersonne` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTypePersonne`));
  
  CREATE TABLE `BDD_BANQUE`.`Entreprise` (
`idEntreprise` int AUTO_INCREMENT NOT NULL,
`nomEntreprise` VARCHAR(45) NOT NULL,
`secteurEntreprise` VARCHAR(45) NOT NULL,
`nombreTitreTotal` INT(45) NOT NULL,
PRIMARY KEY (`idEntreprise`)
 );

  
  
CREATE TABLE `BDD_BANQUE`.`Personne` (
  `idPersonne` INT AUTO_INCREMENT NOT NULL,
  `idTypePersonne` INT NOT NULL,
  `nomPersonne` VARCHAR(45) NOT NULL,
  `prenomPersonne` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `motDePasse` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `valide` INT DEFAULT 0,
  `idEntreprise` INT,
  PRIMARY KEY (`idPersonne`),
   constraint `fk_Personne` FOREIGN KEY (`idTypePersonne`) references `BDD_BANQUE`.`TypePersonne`(`idTypePersonne`),
   constraint `fk_Personne2` FOREIGN KEY (`idEntreprise`) references `BDD_BANQUE`.`Entreprise`(`idEntreprise`)
  );
	
 
 CREATE TABLE `BDD_BANQUE`.`Offre` (
 `idOffre` int AUTO_INCREMENT NOT NULL,
 `typeOffre` VARCHAR(45) NOT NULL,
 `quantiteOffre` INT(11) NOT NULL,
 `prixOffre` DOUBLE NOT NULL,
 `statut` VARCHAR(45) NOT NULL,
 `dateOffre` DATETIME NOT NULL,
 `idEntreprise` INT NOT NULL,
 `idPersonneEmetteur` INT NOT NULL,
 `idPersonneReceveur` INT ,
 PRIMARY KEY (`idOffre`),
 constraint `fk_Offre` FOREIGN KEY (`idEntreprise`) references `BDD_BANQUE`.`Entreprise`(`idEntreprise`),
 constraint `fk_Offre2` FOREIGN KEY (`idPersonneEmetteur`) references `BDD_BANQUE`.`Personne`(`idPersonne`),
  constraint `fk_Offre3` FOREIGN KEY (`idPersonneReceveur`) references `BDD_BANQUE`.`Personne`(`idPersonne`)
 );
 
  CREATE TABLE `BDD_BANQUE`.`OffreHistorique` (
 `idOffreHistorique` int AUTO_INCREMENT NOT NULL,
 `typeOffreHistorique` VARCHAR(45) NOT NULL,
 `quantiteOffreHistorique` INT NOT NULL,
 `prixOffreHistorique` DOUBLE NOT NULL,
 `statut` VARCHAR(45) NOT NULL,
 `dateOffreHistorique` DATETIME NOT NULL,
 `idEntreprise` INT NOT NULL,
 `idPersonneEmetteur` INT NOT NULL,
 `idPersonneReceveur` INT,
 PRIMARY KEY (`idOffreHistorique`),
 constraint `fk_OffreHistorique` FOREIGN KEY (`idEntreprise`) references `BDD_BANQUE`.`Entreprise`(`idEntreprise`),
 constraint `fk_OffreHistorique2` FOREIGN KEY (`idPersonneEmetteur`) references `BDD_BANQUE`.`Personne`(`idPersonne`),
 constraint `fk_OffreHistorique3` FOREIGN KEY (`idPersonneReceveur`) references `BDD_BANQUE`.`Personne`(`idPersonne`)
 );
 
 

 CREATE TABLE `BDD_BANQUE`.`Demande` (
 `idDemande` int AUTO_INCREMENT NOT NULL,
 `descriptifDemande` VARCHAR(300) DEFAULT NULL,
 `statutDemande` VARCHAR(45) DEFAULT 'A traiter',
 `dateDemande` DATETIME NOT NULL,
 `idPersonne` INT NOT NULL,
 PRIMARY KEY (`idDemande`), 
 constraint `fk_Demande` FOREIGN KEY (`idPersonne`) references `BDD_BANQUE`.`Personne`(`idPersonne`)
 );
 
  CREATE TABLE `BDD_BANQUE`.`DemandeHistorique` (
 `idDemandeHistorique` int AUTO_INCREMENT NOT NULL,
 `descriptifDemandeHistorique` VARCHAR(300) DEFAULT NULL,
 `statutDemandeHistorique` VARCHAR(45),
 `dateDemandeHistorique` DATETIME NOT NULL,
 `idPersonne` INT NOT NULL,
 PRIMARY KEY (`idDemandeHistorique`), 
 constraint `fk_DemandeHistorique` FOREIGN KEY (`idPersonne`) references `BDD_BANQUE`.`Personne`(`idPersonne`)
 );

 
  
  CREATE TABLE `BDD_BANQUE`.`Information` (
  `idInformation` INT AUTO_INCREMENT NOT NULL,
  `typeInformation` VARCHAR(45),
  `texteInformation` VARCHAR(300) DEFAULT NULL,
  `dateInformation` DATETIME NOT NULL,
  `idEntreprise` INT NOT NULL,
  PRIMARY KEY (`idInformation`),
 constraint `fk_Information` FOREIGN KEY (`idEntreprise`) references `BDD_BANQUE`.`Entreprise`(`idEntreprise`) 
  );
  

  CREATE TABLE `BDD_BANQUE`.`Titre` (
  `idTitre` int AUTO_INCREMENT NOT NULL,
  `nomTitre` VARCHAR(45),
  `typeTitre` VARCHAR(45) NOT NULL,
  `etatTitre` INT NOT NULL DEFAULT 0,
  `idEntreprise` INT ,
  `idPersonne` INT,
  PRIMARY KEY (`idTitre`),
   constraint `fk_Titre` FOREIGN KEY (`idEntreprise`) references `BDD_BANQUE`.`Entreprise`(`idEntreprise`),
   constraint `fk_Titre2` FOREIGN KEY (`idPersonne`) references `BDD_BANQUE`.`Personne`(`idPersonne`)   
  );
   
  
  CREATE TABLE `BDD_BANQUE`.`LierOffreTitreHistorique` (
   `idOffreHistorique` int NOT NULL,
   `idTitre` INT NOT NULL,
   PRIMARY KEY (`idOffreHistorique`,`idTitre`), 
   constraint `fk_LierOffreTitreHistorique` FOREIGN KEY (`idOffreHistorique`) references `BDD_BANQUE`.`OffreHistorique`(`idOffreHistorique`) ,
   constraint `fk_LierOffreTitreHistorique2` FOREIGN KEY (`idTitre`) references `BDD_BANQUE`.`Titre`(`idTitre`) 
   );
   
   CREATE TABLE `BDD_BANQUE`.`LierOffreTitre` (
   `idOffre` int NOT NULL,
   `idTitre` INT NOT NULL,
   PRIMARY KEY (`idOffre`,`idTitre`), 
   constraint `fk_LierOffreTitre` FOREIGN KEY (`idOffre`) references `BDD_BANQUE`.`Offre`(`idOffre`) ,
   constraint `fk_LierOffreTitre2` FOREIGN KEY (`idTitre`) references `BDD_BANQUE`.`Titre`(`idTitre`) 
   );
   
   

INSERT INTO `BDD_BANQUE`.`TypePersonne` (`idTypePersonne`, `typePersonne`) VALUES ('1', 'Investisseur');
INSERT INTO `BDD_BANQUE`.`TypePersonne` (`idTypePersonne`, `typePersonne`) VALUES ('2', 'Membre Société');
INSERT INTO `BDD_BANQUE`.`TypePersonne` (`idTypePersonne`, `typePersonne`) VALUES ('3', 'Administrateur');

INSERT INTO `BDD_BANQUE`.`Entreprise` (`idEntreprise`, `nomEntreprise`, `secteurEntreprise`, `nombreTitreTotal`) VALUES ('1', 'Dauphine', 'Etude', '150');

INSERT INTO `BDD_BANQUE`.`Personne` (`idPersonne`, `idTypePersonne`, `nomPersonne`, `prenomPersonne`, `login`, `motDePasse`, `email`, `valide`) VALUES ('1', '2', 'bassem', 'bassem', 'bassem', 'bassem', 'bassem', '0');
INSERT INTO `BDD_BANQUE`.`Personne` (`idPersonne`, `idTypePersonne`, `nomPersonne`, `prenomPersonne`, `login`, `motDePasse`, `email`, `valide`) VALUES ('2', '1', 'alexis', 'alexis', 'alexis', 'alexis', 'alexis', '0');
INSERT INTO `BDD_BANQUE`.`Personne` (`idPersonne`, `idTypePersonne`, `nomPersonne`, `prenomPersonne`, `login`, `motDePasse`, `email`, `valide`) VALUES ('3', '3', 'admin', 'admin', 'admin', 'admin', 'admin', '1');


INSERT INTO `BDD_BANQUE`.`Titre` (`idTitre`, `nomTitre`, `typeTitre`, `etatTitre`, `idEntreprise`) VALUES ('1', 'Dauphine', '0', '2', '1');

INSERT INTO `BDD_BANQUE`.`Offre` (`idOffre`, `typeOffre`, `quantiteOffre`, `prixOffre`,`statut`, `dateOffre`, `idEntreprise`, `idPersonneEmetteur`,`idPersonneReceveur`) VALUES ('1', 'Achat', '15', '1500','En attente','2015-07-07 12:15:37', '1', '2','3');
INSERT INTO `BDD_BANQUE`.`Offre` (`idOffre`,`typeOffre`, `quantiteOffre`, `prixOffre`,`statut`, `dateOffre`, `idEntreprise`, `idPersonneEmetteur`,`idPersonneReceveur`) VALUES ('2','vente', '15', '1500','En attente','2015-07-07 12:15:37', '1', '3','2');

INSERT INTO `BDD_BANQUE`.`LierOffreTitre` (`idOffre`, `idTitre`) VALUES ('1', '1');

INSERT INTO `BDD_BANQUE`.`Demande` (`idDemande`, `descriptifDemande`, `statutDemande`,`dateDemande`,`idPersonne`) VALUES ('1', 'Demande  inscription', 'A traiter','2015-07-07 12:15:37', '3');

