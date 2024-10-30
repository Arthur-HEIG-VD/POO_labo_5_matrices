On estime que si l'utilisateur crée une matrice en donnant des valeurs, elles sont données dans un tableau de tableau
d'entiers dont les dimensions sont correctes (ex: toutes les lignes ont le même nombre de colonnes).

On estime que si l'utilisateur crée une matrice en donnant les valeurs et que certaines d'entre elles ne sont pas
comprises entre 0 et mod - 1, elles sont automatiquement prises modulo mod.

For the errors caused by invalid parameters, we do not throw an exception but we print an error message and exit the
program.
For the errors caused by the operation, we throw a RuntimeException with an appropriate message.

We do not provide .add, .subtract and .multiply methods because we want the program to be as flexible as possible. As
such, another programmer could add another operation by only creating a new class that extends Operation and implements
the calculate method. (though we could provide .add, .subtract and .multiply methods, and still allow access to operate,
for other cases, it would not be as clean)

We estimate that the user won't use integers that are too big for the addition or multiplication operations (that would
overflow)

![configs](./run_configs.png)