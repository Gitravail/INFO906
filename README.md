# Chronopost - INFO906

Raphaël TOURNAFOND - Ambroise DECOUTTERE


Chronopost - INFO906 est un TP réalisé en cours de 'Déploiement applications, logiciels d'infrastructure'.

## Lancement

Il faut d'abord initialiser un serveur GlassFish ou un serveur JEE.
Il ne reste ensuite qu'à lancer le projet.

> Le projet a été réalisé sous Intellij et nécessiste peut être quelques adaptation pour Eclipse

## Utilisation
### Navigation
Au sommet de la page se trouve la barre de navigation qui comprend les 3 boutons suivant : Add / Progress / Monitor.

### Add
Sur la page 'Add', l'utilisateur à la possibilité de créer un nouveau colis.

### Progress
Sur la page 'Progress', l'utilisateur peut suivre les étapes d'avancement de son colis en sélectionnant dans la liste déroulante l'identifiant du colis en question.

### Monitor
Sur la page 'Monitor', l'utilisateur doit d'abord sélectionner l'identifiant du colis qu'il souhaite gérer.
Une fois l'identifiant sélectionné, l'utilisateur va avoir la possibilité d'ajouter une étapes d'avancement à la livraison du colis ou de modifier une des étapes déjà existante.

> Le format DMS n'est pas supporté pour les coordonnées (latitude et longitude)

## Architecture

Voici l'architecture global de l'application:

![Diagramme de classe]("./images/class_diagram.png")

