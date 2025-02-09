# Blackjack Game

This is a simple console-based Blackjack game implemented in Java. The game follows standard Blackjack rules, where the player competes against the dealer.

## Features
- Supports a player and a dealer.
- Standard Blackjack rules: hit, stand, bust, and natural Blackjack.
- Uses object-oriented principles with separate classes for `Card`, `Deck`, `Player`, and `Dealer`.
- Randomized deck shuffling for fair play.

## Installation
1. Clone this repository:
   ```sh
   git clone https://github.com/Sayangithub23/BlackJack-Game.git
   ```
2. Navigate to the project directory:
   ```sh
   cd BlackJack-Game
   ```
3. Compile and run the program:
   ```sh
   javac src/*.java
   java src.Main
   ```

## How to Play
- The player is dealt two cards.
- The dealer is also dealt two cards, one face up and one face down.
- The player can choose to `hit` (draw another card) or `stand` (keep their current hand).
- If the player's hand value exceeds 21, they bust and lose the game.
- The dealer must hit until they reach a minimum of 17.
- The player wins if they have a higher hand value than the dealer without exceeding 21.

## Future Improvements
- Implement betting system.
- Add multiplayer mode.
- Create a graphical user interface (GUI).

## Contributing
Feel free to fork the repository and submit pull requests for improvements.

## License
This project is open-source and available under the MIT License.
