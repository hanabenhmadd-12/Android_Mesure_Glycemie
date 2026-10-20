# Android_Mesure_Glycemie
<h1 align="center">🩸 Mesure de Glycémie</h1>

<p align="center">
  Application Android qui interprète un niveau de glycémie selon l'âge, le jeûne et l'unité de mesure.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Langage-Java-orange?logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Plateforme-Android-3DDC84?logo=android&logoColor=white" alt="Android">
  <img src="https://img.shields.io/badge/UI-Material%20Design%203-1565C0?logo=materialdesign&logoColor=white" alt="Material Design 3">
  <img src="https://img.shields.io/badge/Projet-Acad%C3%A9mique-blueviolet" alt="Projet académique">
</p>

---

## 📌 À propos

Projet réalisé dans le cadre du module **Développement mobile (LSI3)**, TP1.
L'utilisateur saisit son âge, indique s'il est à jeun, choisit l'unité (g/L ou mg/dL) puis entre sa valeur de glycémie. L'application vérifie la saisie et affiche un résultat clair, en couleur.

## ✨ Fonctionnalités

- 👤 Saisie de l'**âge** avec validation (1 à 120 ans)
- 🍽️ Choix de l'état de **jeûne** (Oui / Non)
- 🔁 Choix de l'**unité** : **g/L** ou **mg/dL** (conversion automatique, 100 mg/dL = 1 g/L)
- ⚠️ Messages d'erreur sur les champs vides ou invalides
- 🎨 Résultat **coloré** : 🟢 normal, 🟠 un peu élevé, 🔴 hypoglycémie ou élevé
- 🧹 Bouton **EFFACER** pour réinitialiser le formulaire

## 📊 Seuils utilisés

Valeurs en g/L, à titre indicatif.

| Situation | Valeur | Résultat |
|---|---|---|
| Toutes situations | < 0,70 | 🔴 Hypoglycémie |
| À jeun (18 ans et plus) | 0,70 à 1,10 | 🟢 Normale |
| À jeun (moins de 18 ans) | 0,70 à 1,00 | 🟢 Normale |
| À jeun | jusqu'à 1,26 | 🟠 Un peu élevée |
| À jeun | 1,26 et plus | 🔴 Élevée |
| Non à jeun | 0,70 à 1,40 | 🟢 Normale |
| Non à jeun | 1,40 à 2,00 | 🟠 Un peu élevée |
| Non à jeun | 2,00 et plus | 🔴 Élevée |

## 🛠️ Technologies

| | |
|---|---|
| **Langage** | Java |
| **Interface** | XML, Material Design 3 (`MaterialCardView`, `TextInputLayout`, `MaterialButton`) |
| **Outils** | Android Studio, Gradle (Kotlin DSL) |
| **Versionnement** | Git / GitHub |
| **Tests** | Émulateur Medium Phone API 37.0 (SDK minimum : API 24) |

## 📁 Structure du projet

```text
app/src/main/
├── java/com/example/benhmadhana_tp1/
│   └── MainActivity.java        # validation, conversion, interprétation
└── res/
    ├── layout/activity_main.xml # interface
    ├── values/strings.xml       # textes
    ├── values/themes.xml        # thème Material 3
    └── drawable/fond_medical.jpg
```

## 🚀 Installation

1. Cloner le dépôt :
```bash
   git clone https://github.com/hanabenhmadd-12/Android_Mesure_Glycemie.git
```
2. Ouvrir le dossier avec **Android Studio**.
3. Attendre la synchronisation Gradle (**Sync Now** si proposé).
4. Choisir un émulateur ou un téléphone, puis cliquer sur **Run ▶️**.

## 🧪 Exemples de tests

| Saisie | Résultat attendu |
|---|---|
| 25 ans, à jeun, 0.95 g/L | 🟢 Glycémie normale |
| 25 ans, à jeun, 115 mg/dL | 🟠 Un peu élevée |
| 25 ans, non à jeun, 210 mg/dL | 🔴 Élevée |
| Champs vides | ⚠️ Messages d'erreur |

## ⚕️ Avertissement

> Cette application est un exercice pédagogique. Les résultats sont **indicatifs** et ne remplacent en aucun cas l'avis d'un médecin ou d'un professionnel de santé.

## 👩‍💻 Auteur

**Hana Benhmad**, Licence LSI3, Développement mobile.
