import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card>cards;

    public Deck(){
        cards = new ArrayList<Card>();

        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        int[] values = {2,3,4,5,6,7,8,9,10,10,10,10};

        for (String suit:suits){
            for (int value:values){
                cards.add(new Card(suit,value));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void displayCards(){
        for (Card card:cards){
            card.display();
        }
    }

}
