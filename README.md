# Medieval Upper Silesia - simple strategic game
Simple build and upgrade game, which action took place in medieval Upper Silesia. The player starts the game with 2000 units as a budget and can build new buildings which generate income depends on type of building. Budget increases every second by the amount of income.

## Table of contents
* [Technologies](#technologies)
* [Features](#features)
* [Run application](#how-to-run)
* [Design patterns](#used-design-patterns)
* [UML Diagram](#uml-diagram)

## Technologies
Java 15

## How to run
```
$ javac Main.java
$ java Main
```

## Features
Player can build new units if all the requirements(visible at the bottom of the screen) are fulfilled. If it is impossible name of the building has red font color. User can undo the bulding/s by press CTRL+Z or redo it by press CTRL+Y.

## Game

## Used design patterns:
- **Template Method** : Used to create scoreboard and requirements description panel
- **Memento** : Allow user to undo building (CTRL + Z) by remove it decrease income and undo budget to state before purchase. Second use of this design pattern is to restoration of the undo action (CTRL + Y) 
