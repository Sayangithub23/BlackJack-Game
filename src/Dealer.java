import java.util.ArrayList;
public class Dealer {
    private ArrayList<Card> hand;

    public Dealer(){
        hand = new ArrayList<>();
    }

    public void receivedCard(Card card){
        hand.add(card);
    }
    public void displayCard(){
        System.out.println(" <----- *** Dealer Cards: *** ----->");
        System.out.println();
        for (Card card:hand){
            card.display();
        }
    }

    public int calculateHandValue(){
        int totalValue = 0;
        int aces = 0;

        for (Card card:hand){
            totalValue+=card.getValue();
            if (card.getValue()>11){
                aces++;
            }
        }
        while (totalValue>21 && aces>0){
            totalValue-=10;
            aces--;
        }

        return totalValue;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void play(Deck deck){
        while (calculateHandValue()<17){
            System.out.println("Dealer Hits!");
            receivedCard(deck.cards.get(0));
            deck.cards.remove(0);
        }
    }
}
