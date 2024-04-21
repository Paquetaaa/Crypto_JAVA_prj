
Projet de Crypto
=====

Utilisation du code 
-------

Pour utiliser le code il faut créer le projet Java, on peut le faire soit par le script Shell soit en utilisant l'option de Eclipse : clic droit > Export > Jar > donner le nom au fichier .jar > sélectionner la classe Main > Finish.

Ensuite on l'éxecute comme demandé dans le sujet avec :

*java -jar exec.jar + arguments voulus* 

Donc par exemple pour chiffrer la phrase "ceci est un test" avec RO13 cela ressemble à :

*java -jar exec.jar -e rot13 "ceci est un test"*

Du point de vue code, on utilise une classe interface *Crypto* qui contient 2 méthodes *cipher* et *uncipher*, prenant toutes les deux en paramètres un String et retournant un String.
Chaque algorithme de chiffrement (dans notre cas : rot13, cesar, sub, Vernam), implémente ensuite cette classe en y ajoutant ses propres paramètres (un entier pour césar, une clé pour otp...), en utilisant l'override.

On a incorporé de la gestion d'erreur pour que si les paramètres ne sont pas dans le bon ordre, le bon format ou manquant, l'erreur adéquate soit générée à l'utilisateur. 


