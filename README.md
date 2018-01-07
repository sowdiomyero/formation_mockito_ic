#### Tests Unitaires avec JUnit

- Step 01 : Les dependances
- Step 02 : Creer un premier test JUnit ListTest.java
- Step 03 : Mocker la taille d'une liste avec un retour when().thenReturn()
- Step 04 : Mocker la taille d'une liste avec deux retours successifs when().thenReturn().thenReturn()
- Step 05 : Mocker Un retour : get pat exemple sur une liste
- Step 06 : Les Matchers anyInt() dans une mockList.get()
- Step 07 : Faire l'exercice avec Lampes

# Exercices à faire

## Gestion des lampes avec Mockito

  Dans une classe sn.sonatel.formation.junit.service.LampeService.java :
  
  Ecrire deux fonctions :

	* AllumerToutesLesLampes
	* eteindreToutesLesLampes
	
  Disons que LampeService repose sur LampeReporitory pour ajouter, modifier, supprimer, lister les lampes

  Vous ne devez tester que les methodes de la classe d'implementation de LampeService.
  
  - Testez les méthodes de l'implementation de LampeService en suivant les spécifications suivantes :
  
  	* Une lampe possède les proprietés suivantes : 
  		- String: id : autorgenerated (UUID.randomUUID().toString())
  		- String:emplacement
  		- enum:etat {ON,OFF}
  	* Si Une lampe dejà eteinte ne peut être eteinte, jeter une exception LampeDejaEteinteException
  	* Si Une lampe dejà allumée ne peut être allumée, jeter une exception LampeDejaAlluméeException
  	
# Introduire le projet dans git et ajouter à la chaine IC

   - Ajouter le fichier Jenkinsfile à la racine de votre projet
   - Ajouter votre projet sur github
   - Creez un pipeline directement sur le serveur http://jenkins.tools.orange-sonatel.com
   - Lancer les builds depuis la chaine d'intégration Continue
   - Visualiser le pipeline et commentez
    
    