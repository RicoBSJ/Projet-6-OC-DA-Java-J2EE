# Réalisation de l'application web "LES AMIS DE L'ESCALADE", Projet 6, dans le cadre de la formation DA JAVA JEE OPENCLASSROOMS

	Création d'un site communautaire autour de l'escalade pour l'association "Les amis de l'escalade".

# Contexte :

	Avec l’objectif de fédérer les licenciés, l’association “Les amis de l’escalade” souhaite développer
	sa présence en ligne. À ce titre, plusieurs axes d’amélioration ont été identifiés dont la création 
	d’un site communautaire.
	Ce site aura pour but la mise en relation et le partage d’informations. Il permettra de donner 
	de la visibilité l’association afin d’encourager des grimpeurs indépendants à y adhérer.


## Les fonctionnalités :

	- F1 : Un utilisateur doit pouvoir consulter les informations des sites	d’escalades
	(secteurs, voies, longueurs, etc.).

	- F2 : Un utilisateur doit pouvoir faire une recherche à l’aide de plusieurs critères 
	pour trouver un site de grimpe et consulter le résultat de cette recherche. 
	Les critères peuvent être le lieu, la cotation, le nombre de secteurs, etc.

	- F3 : Un utilisateur doit pouvoir s’inscrire gratuitement sur le site.

	- F4 : Un utilisateur connecté doit pouvoir partager des informations sur un site d’escalade
	(secteurs, voies, longueurs, etc.).

	- F5 : Un utilisateur connecté doit pouvoir laisser des commentaires sur les pages des sites d’escalade.

	- F6 : Un membre de l'association doit pouvoir taguer un site d’escalade enregistré 
	sur la plateforme comme « Officiel Les amis de l’escalade ».

	- F7 : Un membre de l'association doit pouvoir modifier et supprimer un commentaire.

	- F8 : Un utilisateur connecté doit pouvoir enregistrer dans son espace	personnel 
	les topos qu’ils possèdent et préciser si ces derniers sont disponibles pour être prêtés ou non.
	Un topo est défini par un nom, une description, un lieu et une date de parution.

	- F9 : Un utilisateur connecté doit pouvoir consulter la liste des topos disponibles par d’autres 
	utilisateurs et faire une demande de réservation. La réservation n’inclut pas les notions de date 
	de début et date de fin.

	- F10 : Un utilisateur connecté doit pouvoir accepter une demande de réservation.
	Si une réservation est acceptée, automatiquement le topo devient indisponible. 
	L’utilisateur connecté pourra ensuite de nouveau changer le statut du topo en « disponible ».
	La plateforme se contente de mettre en contact les deux parties pour le	prêt d’un topo 
	(par échange de coordonnées).

	
## Les contraintes fonctionnelles

	- Le vocabulaire de l’escalade doit être utilisé : site, spot, voie, longueur, grimpeur, point ou spit, cotation, topo.
	- Le site doit être ​responsive : mon site est responsive grace à Bootstrap
	- Le site doit être sécurisé : les mots de passe enregistrés dans la base de données sont cryptés
	
## Spécificités
	
	## Les outils utilisés pour le développement

	Cette application a été développé avec :
	
	- Eclipse IDE for Enterprise Java Developers (version: 2020-03 (4.15.0))
	- Apache Maven 3.6.3
	- Java 8 (version 1.8 Update 251)
	- Tomcat 9.0.30
	- PostgreSql 12 (version 10.12 - 10.14)
	- Hibernate ORM (version hibernate-release-5.4.10.Final)
	
	## Les étapes de déploiement de l'application
	
	1/Vous devez au-préalable télécharger et installer :
	
	- Java sur https://www.java.com/fr/download/
	- Le JDK sur https://www.oracle.com/fr/java/technologies/javase/javase-jdk8-downloads.html
	- Apache Maven sur https://maven.apache.org/download.cgi (n'oubliez pas d'ajouter la variable d'environnement d'Apache au "Path")
	- Apache Tomcat sur https://tomcat.apache.org/download-90.cgi
	- PostgreSQL sur https://www.postgresql.org/download/
	- Hibernate sur https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.4.10.Final/hibernate-release-5.4.10.Final.zip/download
	- Dézippez le package "PEscalade_AUBRUN_Eric"
	
	2/Ceci fait, vous devez lancer pgAdmin4 :
	
	- Voici le chemin : /Library/PostgreSQL/12/
	- Dans la base de données, créez un utilisateur "postgres", attribuez lui le mot de passe "postgres"
	- A partir de la base de données, ouvrez l'éditeur de script et exécutez le fichier "PEscalade_03_Script_SQL_Creation_Base_De_Donnees.sql" que vous trouverez dans le package
	- Pour alimenter la base de données, vous devez exécuter à partir de l'emplacement "Tables" le fichier "PEscalade_04_Script_SQL_Jeu_De_Donnees.sql"
	
	3/A partir du terminal
	
	- Ouvrez votre terminal de commande, tapez cd et copiez le chemin d'accès à l'application : ............Faites "ENTRER"
	- Une fois placé dans le chemin de l'application, tapez "mvn package"
	- Rendez-vous dans le chemin suivant : escalade-webapp\target
	- Copiez le fichier "escalade-webapp.war" généré par l'étape précédente
	- Rendez-vous dans le dossier apache-tomcat-9.0.30\webapps\ et collez "escalade-webapp.war"
	
	4/Démarrage de Tomcat
	
	Sur Mac, la démarche est la suivante :
	- Ouvrez le terminal
	- Tapez : "sudo su", ce qui a pour effet de vous donner tous les droits en lecture et écriture
	- Rendez-vous dans le dossier de Tomcat "apache-tomcat-9.0.30\" et tapez : "ls -l"
	- Tapez "sudo chmod -R 755 apache-tomcat-9.0.30\", rendez-vous dans "\bin" et tapez "./startup.sh"
	- Si Tomcat démarre, vous devez obtenir à l'affichage quelque chose de semblable à ceci :
	- Using CATALINA_BASE:   /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_HOME:   /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_TMPDIR: /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30/temp
	- Using JRE_HOME:        /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home
	- Using CLASSPATH:       /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30/bin/bootstrap.jar:/Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30/bin/tomcat-juli.jar
	- Tomcat started.

    ## Le lancement de l'application
    
    - Ouvrez votre navigateur Internet et tapez "http://localhost:8080/escalade-webapp/accueil" pour lancer l'application
    
    ## Pour arrêter Tomcat
    
    	- Pour arrêter Tomcat, tapez "./shutdown.sh", votre affichage devrait ressembler à ceci :
	- Using CATALINA_BASE:   /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_HOME:   /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30
	- Using CATALINA_TMPDIR: /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30/temp
	- Using JRE_HOME:        /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home
	- Using CLASSPATH:       /Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30/bin/bootstrap.jar:/Users/ricobsj/eclipse-workspace/Servers/apache-tomcat-9.0.30/bin/tomcat-juli.jar

## Auteur

Rico BSJ
