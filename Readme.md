| | |
|-|-|
|No de Travail pratique|	Travail pratique 1|
|Étudiants|Wilfried NKOUEKAM MBOUGA,	|
|Cours|	MGL7361|
|Session|S2021|
|Enseignant|Naima Essadi|
## Justification des choix de conception
|Type|Nom de l'objet|	Responsabilités|	Dépendances|Raison de dependance|Raison choix Interface ou abstraction|
|----|--------------|------------------|---------------|--------------------|--------------------|
|Classe|Client|Identifier une personne qui désire acheter un produit||||
|Classe|CarteInfidelite|Identifier une carte d'infidelité|Partenaire|Identifier le nombre de partenaires ou la carte a été utilisé le mois précedent||
|Classe|Abonne|Identifier un client qui dispose d'une carte d'infidelite|Client,CarteInfidelite|Identifier les informations clients ainsi que les informations de la carte d'infidelite détenues||
|Classe|Ville|Identifier une ville et les zones associés|Zone|Identifier les zones de la ville||
|Classe|Zone|Identifier une zone et les partenaires de la zone|Partenaire|Identifier les partenaires de la zone||
|Classe|Partenaire|Identifier un magagin ou un commerce ainsi que les produits qui y sont vendues|AProduit|Identifie les produits et cadeaux vendues ou offerte par le partenaire||
|Abstract class|AProduit|identifier une abstraction d'un service offert par un partenaire|||Accéder facilement et de la même manière aux informations(descriptions,prix) d'un produit, d'un cadeau ou d'un catalogue cadeau |
|Classe|Produit|identifier un service concret offert par un partenaire|Aproduit,IStrategie|Avoir les mêmes caractéristique et méthodes que l'on retrouve dans AProduit, identifier la méthode utilisée pour calculer le prix ||
|Classe|CatalogueCadeau|Identifier un ensemble de produit |AProduit|Un Catalogue de cadeau est composé de Produit abstrait et est aussi un produit abstrait ||
|Classe|Cadeau|Identifier un produit dont la méthode de calcul de prix est différente du la méthode normal|Produit|Un cadeau est un produit dont la stratégie de calcul de prix est différente de celle normale||
|Interface|IStrategie|Identifier la strategie utilisée pour calcul le prix ou la reduction appliqué à un produit|||Encapsuler à haut niveaux les variations possible qui pourrait avoir lieu lors du calcul de prix|
|Classe|ReductionParking|Identifier la reduction appliquée à un ticket de parking|IStrategie| correspond à une variante de calcul de prix d'un produit de type ticket de parking ||
|Classe|TransportCommun|Identifier la reduction appliquée à un transport en commun|IStrategie|correspond à une variante de calcul de prix d'un produit de type transport en commun ||
|Classe|NormalStrategie|Identifier qu'aucune reduction n'est appliquée au produit |IStrategie|variante par défaut pour le calcul du prix d'un produit||

## Diagramme de classe
![](out/DiagrammeDeChoixDeConception2/Diagramme%20de%20classe.png)


# Table de correspondance

|Nom dans le <br>modèle de conception | Nom actuel |
|-|-|
|Primitive| AProduct |
|Composite| CatalogueCadeau  |
|Leaf| Produit |
|method()| getCost |


|Nom dans le <br>modèle de conception | Nom actuel |
|-|-|
|Strategy| IStrategie |
|ConcreteStrategy| reductionParking,<br>transportCommun,<br>NormalStrategie |
|doWork()| getCost():Double |

