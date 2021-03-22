# Library_Batch


Contexte

Ce projet a été développé dans le cadre du cursus "Développeur d'application Java" d'OpenClassrooms et correspond aux Batchs du projet 7 et 10 "Développez le nouveau système d’information de la bibliothèque d’une grande ville". 

Les batchs permetent le système d'envoi d'emails récurent lorsque le délai de retour d'un emprunt est dépassé.

# Architecture

Version de java : 11 (jdk utilisé : jdk13) 
Maven 3.6 

[ API ] : API Rest https://github.com/NicoEvgl/Library_API.git 'Library_Api'

[ batch ] : Système d’envoi d’e-mails récurent https://github.com/NicoEvgl/Library_Batch.git 'Library_Batch'

[ WebClient ] : Application web https://github.com/NicoEvgl/Library_WebClient.git 'Library_WebClient'

# Frameworks

Maven

Spring boot MVC

Hibernate 5.0

Apache Log4J 2.11.0

Bootstrap 3.3.7

# Persistence

PostgreSQL 10.4

# Configuration

La configuration du serveur SMTP doit être renseignée dans les fichiers src\resources\application.properties

# Déploiement

L'API du projet ('LibraryP7_API' https://github.com/NicoEvgl/LibraryP7_API.git) doit actif.

Application standalone intégrant un conteneur web (grace à SpringBoot)

Ouvrir le terminal de commande, se placer dans le dossier du projet cloné puis taper les commandes :

mvn clean spring-boot:run

# Accès au site WEB

Le site est accessible par http://localhost:8080/

# Accès à l'API

L'API est exposée via l'URL : http://localhost:9090/ 
L'application via le JDD fourni contient un compte utilisateur démo (Pseudo : Nicoe, mot de passe : Pass123).
