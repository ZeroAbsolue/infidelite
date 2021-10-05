| | |
|-|-|
|No de Travail pratique|	Travail pratique 1|
|Étudiants|Wilfried NKOUEKAM MBOUGA, Nadine Manuela GOKAR (GOKN29569802),	|
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
|Classe|Produit|identifier un service concret offert par un partenaire|Aproduit,IStrategyCout|Avoir les mêmes caractéristique et méthodes que l'on retrouve dans AProduit, identifier la méthode utilisée pour calculer le prix ||
|Classe|CatalogueCadeau|Identifier un ensemble de produit |AProduit|Un Catalogue de cadeau est composé de Produit abstrait et est aussi un produit abstrait ||
|Classe|Cadeau|Identifier un produit dont la méthode de calcul de prix est différente du la méthode normal|Produit|Un cadeau est un produit dont la stratégie de calcul de prix est différente de celle normale||
|Interface|IStrategyCout|Identifier la strategie utilisée pour calcul le prix ou la reduction appliqué à un produit|||Encapsuler à haut niveaux les variations possible qui pourrait avoir lieu lors du calcul de prix|
|Classe|ReductionParking|Identifier la reduction appliquée à un ticket de parking|IStrategyCout| correspond à une variante de calcul de prix d'un produit de type ticket de parking ||
|Classe|TransportCommun|Identifier la reduction appliquée à un transport en commun|IStrategyCout|correspond à une variante de calcul de prix d'un produit de type transport en commun ||
|Classe|NormalStrategie|Identifier qu'aucune reduction n'est appliquée au produit |IStrategyCout|variante par défaut pour le calcul du prix d'un produit||
|Interface|IStrategyPoint|Identifier la strategie utilisée pour calcul le nombre de point appliqué à un produit|||Encapsuler à haut niveaux les variations possible qui pourrait avoir lieu lors du calcul du nombre de points associe a un produit|
|Classe|DixPourCentCout|Identifier que dix pour cent du cout du produit est considere comme nombre de point |IStrategyPoint|variante permettant de definir que dix pour cent du cout du produit est considere comme nombre de point ||
## Diagramme de classe
![](out/DiagrammeDeChoixDeConception2/Diagramme%20de%20classe.png)


## Justification de l'implementation
# Patron composite

|Nom dans le <br>modèle de conception | Nom actuel |
|-|-|
|Primitive| AProduct |
|Composite| CatalogueCadeau  |
|Leaf| Produit |
|method()| getCost |

Nous nous sommes rendus compte qu'un catalogue cadeau ou catalogue de produit en réalité correspond à une collection de plusieurs produits sous un seul élement (Catalogue). Nous désirions facilement accéder à la description du catologue de produit ou cadeau de la même manière que nous le faisions avec la description du produit. Sachant qu'à travers des itérations ou une boucle for nous pouvons parcourir le catalogue produit, nous avons choisis d'implémenté le catalogue et les produits sous forme de design pattern composite

# Patron Strategie
|Nom dans le <br>modèle de conception | Nom actuel |
|-|-|
|Strategy| IStrategyCout |
|ConcreteStrategy| reductionParking,<br>transportCommun,<br>NormalStrategie |
|doWork()| getCost():Double |

Ici nous désirions protéger l'action de calculer les couts d'un produit des différentes variantes d'algorithme qui pourraient exister pour effectuer cette action. Nous avons choisi donc d'utiliser le design pattern Strategy 
