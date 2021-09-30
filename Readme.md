| | |
|-|-|
|No de Travail pratique|	Travail pratique 1|
|Étudiants|Wilfried NKOUEKAM MBOUGA,	|
|Cours|	MGL7361|
|Session|S2021|
|Enseignant|Naima Essadi|
## Justification des choix de conception
|Classe|	Responsabilités|	Dépendances|
|------|-------------------|---------------|
|Client|Identifier une personne qui désire acheter un produit||
|CarteInfidelite|Identifier une carte d'infidelité|Partenaire|
|Abonne|Identifier un client qui dispose d'une carte d'infidelite|Client,CarteInfidelite|
|Ville|Identifier une ville et les zones associés|Zone|
|Zone|Identifier une zone et les partenaires de la zone|Partenaire|
|Partenaire|Identifier un magagin ou un commerce ainsi que les produits qui y sont vendues|AProduit|
|AProduit|identifier une abstraction d'un service offert par un partenaire|Aproduit|
|Produit|identifier un service concret offert par un partenaire|Aproduit,IStrategie|
|CatalogueCadeau|Identifier un ensemble de produit |AProduit|
|Cadeau|Identifier un produit dont la méthode de calcul de prix est différente du la méthode normal|Produit|
|IStrategie|Identifier la strategie utilisée pour calcul le prix ou la reduction appliqué à un produit||
|ReductionParking|Identifier la reduction appliquée à un ticket de parking|IStrategie|
|ReductionParking|Identifier la reduction appliquée à un ticket de parking|IStrategie|
|NormalStrategie|Identifier qu'aucune reduction n'est appliquée au produit |IStrategie|

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

