# Android_Mesure_Glycemie

Application Android qui permet de saisir un niveau de glycémie et d'obtenir une interprétation indicative, selon l'âge, l'état de jeûne et l'unité de mesure.

Projet académique réalisé dans le cadre du module Développement mobile (LSI3) : TP1.

Fonctionnalités
Saisie de l'âge (validation entre 1 et 120 ans).
Choix de l'état de jeûne (Oui / Non).
Choix de l'unité de mesure : g/L ou mg/dL (conversion automatique : 100 mg/dL = 1 g/L).
Saisie de la valeur de glycémie avec contrôle des champs et messages d'erreur.
Résultat coloré : vert (normal), orange (un peu élevé), rouge (hypoglycémie ou valeur élevée).
Bouton EFFACER pour remettre le formulaire à zéro.
Avertissement rappelant que le résultat est indicatif.
Seuils utilisés (en g/L, indicatifs)
Situation	Valeur	Résultat
Toutes situations	< 0,70	Hypoglycémie (rouge)
À jeun (18 ans et plus)	0,70 à 1,10	Normale (vert)
À jeun (moins de 18 ans)	0,70 à 1,00	Normale (vert)
À jeun	jusqu'à 1,26	Un peu élevée (orange)
À jeun	1,26 et plus	Élevée (rouge)
Non à jeun	0,70 à 1,40	Normale (vert)
Non à jeun	1,40 à 2,00	Un peu élevée (orange)
Non à jeun	2,00 et plus	Élevée (rouge)
Technologies
Langage : Java
Interface : XML, Material Design 3 (MaterialCardView, TextInputLayout, MaterialButton)
Outil : Android Studio, Gradle (Kotlin DSL)
Versionnement : Git / GitHub
Test : émulateur Medium Phone API 37.0 (SDK minimum : API 24)
Structure du projet
app/src/main/
├── java/com/example/benhmadhana_tp1/MainActivity.java   # logique : validation, conversion, interprétation
├── res/layout/activity_main.xml                         # interface
├── res/values/strings.xml                               # textes de l'application
├── res/values/themes.xml                                # thème Material 3
└── res/drawable/fond_medical.jpg                        # image de fond
Installation et lancement
Cloner le dépôt :
bash
   git clone https://github.com/hanabenhmadd-12/Android_Mesure_Glycemie.git
Ouvrir le dossier avec Android Studio.
Attendre la synchronisation Gradle (Sync Now si proposé).
Choisir un émulateur ou un téléphone, puis cliquer sur Run.
Exemples de tests
Saisie	Résultat attendu
Âge 25, à jeun, 0.95 g/L	Glycémie normale (vert)
Âge 25, à jeun, 115 mg/dL	Un peu élevée (orange)
Âge 25, non à jeun, 210 mg/dL	Élevée (rouge)
Champs vides	Messages d'erreur
<!-- ## Captures d'écran Ajoutez vos captures dans un dossier "captures" puis retirez les balises de commentaire : ![Accueil](captures/accueil.png) ![Résultat normal](captures/resultat_vert.png) -->
Avertissement

Cette application est un exercice pédagogique. Les résultats sont indicatifs et ne remplacent en aucun cas l'avis d'un médecin ou d'un professionnel de santé.

Auteur

Hana Benhmad, Licence LSI3, module Développement mobile.
