# Pour démarrer

Pour démarrer ces exercices, l'utilisation de l'IDE IntelliJ est
recommandée, avec les plugins `Scala` et `SBT Executor`.

Pour installer ces deux plugins dans IntelliJ:
```
File > Settings > Plugins
```
puis utiliser la barre de recherche pour trouver et installer les
plugins.

Ensuite, ouvrir un projet
```
File > Open
```
et sélectionner le dossier `tp`. Une fois le dossier ouvert, SBT le
configure automatiquement. Exécutez `TestInit.scala` dans le dossier
`src/test/scala` afin de vérifier que le projet est correctement
configuré.

# Contenu

Le dossier `src/main/scala` contient un fichier `TPX.scala` pour
chaque TP. Vous devrez éditez ce fichier en remplacant les `???` par
le code approprié.

Le dossier `src/test/scala` contient un fichier `TestsTPX.scala` pour
chaque TP qui contient les tests unitaires du TP. Vous ne devez *pas
modifier* ce fichier. Exécutez cette classe dans l'IDE pour lancer les
tests. Si votre solution est correcte, tous les tests doivent être
validés.