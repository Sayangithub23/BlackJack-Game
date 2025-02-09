import java.util.ArrayList;
public class Player {
    private ArrayList<Card> hand;

    public Player(){
        hand = new ArrayList<>();
    }

    public void receivedCard(Card card){
        hand.add(card);
    }
    public void displayCard(){
        System.out.println(" <----- *** Player Cards: *** ----->");
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
}
