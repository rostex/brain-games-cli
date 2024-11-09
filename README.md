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
### Prerequisites:
Before running the game, you need to have the following installed on your machine:
- Java 17 or later
- A terminal/command line interface (Command Prompt, PowerShell, Terminal, etc.)

### Installation Instructions:
1. Clone the repository or download the project files to your machine.

```
git clone https://github.com/your-username/brain-games.git
cd brain-games
```

2. Compile the project using javac:
If you're using a simple command-line environment:

```
javac -d bin src/**/*.java
```

3. Run the game using java:
Once the project is compiled, you can run the game with the following command:

```
java -cp bin hexlet.code.Main
This will start the main menu of the game where you can choose which game to play, adjust settings, and view statistics.
```

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
