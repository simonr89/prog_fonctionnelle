# Pour démarrer

Pour démarrer ces exercices, l'utilisation de l'IDE IntelliJ est
recommandée, avec le plugin `Scala`.

Pour installer ce plugin dans IntelliJ:
```
File > Settings > Plugins
```
puis utilisez la barre de recherche pour trouver et installer le
plugin.

Ensuite, après avoir cloné ce dépôt Git, ouvrez un projet dans l'IDE
```
File > Open
```
et sélectionnez le fichier `tp/build.sbt`, puis confirmez `Open as
project` et attendez que l'IDE configure automatiquement le projet.
Exécutez `TestInit.scala` dans le dossier `src/test/scala` afin de
vérifier que le projet est correctement configuré.

# Contenu

Le dossier `src/main/scala` contient un fichier `TPX.scala` pour
chaque TP. Vous devrez éditez ce fichier en remplacant les `???` par
le code approprié.

Le dossier `src/test/scala` contient un fichier `TestsTPX.scala` pour
chaque TP qui contient les tests unitaires du TP. Vous ne devez *pas
modifier* ce fichier. Exécutez cette classe dans l'IDE pour lancer les
tests. Si votre solution est correcte, tous les tests doivent être
validés.
