# Brain Games
This project is a set of five console games:

- **Even game** – Definition of an even number  
- **Calc game** – Arithmetic expressions  
- **GCD game** – Finding the Greatest Common Divisor  
- **Progression game** – Search for missing number in a sequence of numbers  
- **Prime game** – Definition of a prime number  
  
## Game Features:
- **Levels of Difficulty** – Choose from three difficulty levels: Easy (default), Medium, and Hard. The difficulty affects the complexity of the questions.
- **Scoring System** – Earn points for correct answers. If you provide an incorrect answer, points will be subtracted. After blocks of answers, the game is considered completed.
- **Statistics** – View the statistics of the top players (best local total score).
- **Settings** – You can change the player’s name and select the difficulty level through the Settings menu. The default difficulty is Easy.

Each game asks a series of questions that need to be answered correctly. After three correct answers, the game is considered completed. Wrong answers will end the game and reduce the total score.


### Links to Other Sections:

- [How to Run the Game](#how-to-run-the-game)
- [Saving Player Data](#saving-player-data)
- [How to Change Settings](#how-to-change-settings)
- [File Locations](#file-locations)
- [Game demonstration](#game-demonstration)


## How to Run the Game
### To play Brain Games, follow these steps:

1. **Download the JAR File**
   
   First, you need to download the compiled .jar file. You can find it in the [Releases](https://github.com/rostex/brain-games-cli/releases) section of the GitHub repository or in the provided download link.

3. **Install Java**

   Ensure that you have **Java 18** or later installed on your system. You can check if Java is installed by running the following command in your terminal or command prompt:

```bash
java -version
```
If Java is not installed, download and install the latest version from the [official Java website](https://www.oracle.com/java/technologies/javase-downloads.html).

3. **Run the JAR File**

   Once you have the `.jar` file and Java installed, navigate to the directory where the `.jar` file is located. Open your terminal or command prompt and run the following command:

```bash
java -jar BrainGames.jar
```
This will start the game and you can follow the instructions on the screen to play the games.

4. **Enjoy the Game!**

   Follow the on-screen prompts to choose a game, set your difficulty level, and start playing!

## Saving Player Data
### Where the Data is Stored
The game saves player statistics (score data) in a file located in the following directories depending on the operating system:

- **Windows:**
  - The data is saved in the APPDATA directory, under Brain Games CLI.
  - Typical path: `C:\Users\<YourUsername>\AppData\Roaming\Brain Games CLI\PlayersStat.yml`

- **macOS:**
  -  The data is saved in the user's Library/Application Support directory.
  - Typical path: `/Users/<YourUsername>/Library/Application Support/Brain Games CLI/PlayersStat.yml`

- **Linux:**
  - The data is saved in the home directory.
  - Typical path: `/home/<YourUsername>/.Brain Games CLI/PlayersStat.yml`
    
If the directory doesn't exist, the game will create it automatically when saving the player’s statistics.

### What Data is Stored
The statistics include the player’s name and their total score from completed games. The game stores the top players' scores, and these can be viewed in the Statistics menu.

## How to Change Settings
You can change the following settings during the game:

- Player Name – Change your name in the settings menu.
- Difficulty Level – Choose from the following difficulty levels:
  -Easy (default)
  - Medium
  - Hard
These settings will affect the complexity of the questions you will encounter during the games.

### File Locations
- Game Files (YAML data) are stored in the following default locations:
  - Windows: `C:\Users\<YourUsername>\AppData\Roaming\Brain Games CLI\PlayersStat.yml`
  - macOS: `/Users/<YourUsername>/Library/Application Support/Brain Games CLI/PlayersStat.yml`
  - Linux: `/home/<YourUsername>/.Brain Games CLI/PlayersStat.yml`


### Code status:
<!-- Due to the development of additional features, the check from Hexlet is not working anymore.
[![Actions Status](https://github.com/rostex/java-project-61/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/rostex/java-project-61/actions)
-->
[![Maintainability](https://api.codeclimate.com/v1/badges/7facfe9189a9d5598939/maintainability)](https://codeclimate.com/github/rostex/java-project-61/maintainability)

## Game demonstration

[![asciicast](https://asciinema.org/a/KEyKhPgEbZdx5aLj05GJAuamy.svg)](https://asciinema.org/a/KEyKhPgEbZdx5aLj05GJAuamy)
<!--
#### Even game demo:
[![asciicast](https://asciinema.org/a/yRzHJFVLpt6FWe3Wg8S8AbucC.svg)](https://asciinema.org/a/yRzHJFVLpt6FWe3Wg8S8AbucC)

#### Calc game demo:
[![asciicast](https://asciinema.org/a/BCOh9iwIdYuzDZjRWfHINLYar.svg)](https://asciinema.org/a/BCOh9iwIdYuzDZjRWfHINLYar)

#### GCD game demo:
[![asciicast](https://asciinema.org/a/IvJmqkkDOw0NRt9fwdh1Cce9i.svg)](https://asciinema.org/a/IvJmqkkDOw0NRt9fwdh1Cce9i)

#### Progression game demo:
[![asciicast](https://asciinema.org/a/1Li09kQbEQMD9Zj5YCF59WHqu.svg)](https://asciinema.org/a/1Li09kQbEQMD9Zj5YCF59WHqu)

#### Prime game demo:
[![asciicast](https://asciinema.org/a/cgNbPjbWeb2TycOnWRnuIHFnk.svg)](https://asciinema.org/a/cgNbPjbWeb2TycOnWRnuIHFnk)
-->
