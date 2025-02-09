import java.util.Scanner;

public class Game {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private int playerBalance;
    private int betAmount;

    public Game(int startingBalance) {
        player = new Player();
        dealer = new Dealer();
        deck = new Deck();
        deck.shuffle();
        playerBalance = startingBalance;
    }

    public void startGame() {
        // Set bet
        Scanner scanner = new Scanner(System.in);
        System.out.println("<----- *** NEW ROUND *** ----->");
        System.out.println("Player Balance: " + playerBalance);
        System.out.print("Put your bet: ");
        betAmount = scanner.nextInt();

        if (betAmount > playerBalance) {
            System.out.println("Sorry! You don't have enough money!");
            return;
        }

        // Reset player and dealer hands
        player = new Player();
        dealer = new Dealer();

        // Check if deck is low, then reshuffle
        if (deck.cards.size() < 10) {
            deck = new Deck();
            deck.shuffle();
        }

        // Deal Cards
        player.receivedCard(deck.cards.get(0));
        deck.cards.remove(0);
        dealer.receivedCard(deck.cards.get(0));
        deck.cards.remove(0);
        player.receivedCard(deck.cards.get(0));
        deck.cards.remove(0);
        Card hiddenCard = deck.cards.get(0);
        dealer.receivedCard(hiddenCard);
        deck.cards.remove(0);

        // Show Cards
        player.displayCard();
        System.out.println("\nDealer's First Card:");
        dealer.getHand().get(0).display();
        System.out.println("[Hidden]");

        // Check for BlackJack
        if (player.calculateHandValue() == 21 && dealer.calculateHandValue() != 21) {
            System.out.println("\nBlackJack! You get 1.5x your bet!");
            playerBalance += (int) (betAmount * 1.5);
            return;
        } else if (dealer.calculateHandValue() == 21) {
            System.out.println("Dealer has BlackJack! You lose.");
            playerBalance -= betAmount;
            return;
        }

        // Player Turn
        while (true) {
            System.out.println("\nYour total Value: " + player.calculateHandValue());
            System.out.println("Do you want to (H)it, (S)tand, or (D)ouble Down?");
            String choice = scanner.next().toLowerCase();

            if (choice.equals("h")) {
                player.receivedCard(deck.cards.get(0));
                deck.cards.remove(0);
                System.out.println("\nYou drew a Card!");
                player.displayCard();

                if (player.calculateHandValue() > 21) {
                    System.out.println("\nYou Busted! Dealer wins!");
                    playerBalance -= betAmount;
                    return;
                }
            } else if (choice.equals("s")) {
                break;
            } else if (choice.equals("d") && betAmount * 2 <= playerBalance) {
                betAmount *= 2;
                System.out.println("\nYou doubled down and received one card!");
                player.receivedCard(deck.cards.get(0));
                deck.cards.remove(0);
                player.displayCard();

                if (player.calculateHandValue() > 21) {
                    System.out.println("\nYou Busted! Dealer wins!");
                    playerBalance -= betAmount;
                    return;
                }
                break; // Player cannot hit again after doubling down
            } else {
                System.out.println("Invalid Choice! Please enter 'H', 'S', or 'D'.");
            }
        }

        // Reveal dealer's hidden card
        System.out.println("\nDealer reveals their hidden card:");
        dealer.displayCard();

        // Dealer's Turn
        System.out.println("\nDealer's Turn...");
        dealer.play(deck);
        System.out.println("\nDealer's total value: " + dealer.calculateHandValue());

        // Determine winner
        int playerScore = player.calculateHandValue();
        int dealerScore = dealer.calculateHandValue();

        if (playerScore > dealerScore || dealerScore > 21) {
            System.out.println("\nYou won!");
            playerBalance += betAmount;
        } else if (playerScore == dealerScore) {
            System.out.println("\nIt's a Tie! Your bet is returned.");
        } else {
            System.out.println("\nDealer wins!");
            playerBalance -= betAmount;
        }

        System.out.println("Your Balance: $ " + playerBalance);
    }
}
