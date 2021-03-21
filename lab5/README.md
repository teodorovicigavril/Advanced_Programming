Compulsory part:
  - created classes Image and Song that inherits class Item
  - this Items have a name, an id, a path, and other particular fields
  - created class Catalog with following commands:
    - add wich will add an item to the catalog
    - list which will print the content of the catalog
    - play method that will play an item from the catalog
    - save method that will save the content of the catalog in a file(in the path catalog)
    - load will load the content from a given path into the current catalog
  - class to treat invalid data and exceptions.

Optional part:
  - created a shell in which we can run commands like the above ones
  - method for exiting the shell
  - the commands from shell will be objects of classes for every single existent command, ex: AddCommand class, LoadCommand, etc..
  - created custom exception for commands that are not possible in the created shell
  - created the executable jar archive and lunched it from the console

Bonus part:
-----------
