# Projet mobile Android
## Les bons comptes font les bons amis


Faites une applications pour gérer les comptes partagées d'un groupe d'amis (par exemple une collocation ou bien un groupe passant les vacances ensembles). L'application doit permettre d'ajouter des dépenses réalisées en précisant qui a payé combien, et pour qui (à quelle date, pourquoi, etc…). Elle n'est pas reliée à un serveur, et ne nécessite pas d'authentification (juste des contacts).

### Fonctionnalités:
- création d'un groupe d'amis (pas besoin d'authentification), qui sont importés depuis le carnet de contacts
- création d'une liste de dépenses (à l'intérieur d'un groupe)
- ajout d'une dépense (à l'intérieur d'une liste), avec certains attributs

```sh
+ date — e.g., le 22/02/2020
+ montant — e.g., 80€
+ destinataires (pour qui la dépense a été faite ?) — e.g., Jean (20%), Martine (10%), Sylvie (30%) et Paul (40%)
+ émetteurs (qui a payé ?) — e.g., par Jean 30€ et Sylvie 50€
+ titre — e.g.,  "dernier dîner au restaurant avant le confinement"
```
- ajout remboursement: un type de dépense particulier, avec un titre préformaté, un destinataire unique et un émetteur unique
- visualisation de la balance pour voir, qui doit combien à qui, et ce au niveau d'un groupe ou d'une liste
- envoi de récapitulatif de balance par message aux amis
- export d'une liste de dépense
- import d'une liste de dépense
- fusion d'une liste de dépense, avec détection et gestion (automatique ? interactive ?) doublons
- pas de serveur
