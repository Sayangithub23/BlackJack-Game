public class Card {
    String suit;
    int value;

    public Card(String suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public void display(){
        System.out.println(value + " of " + suit);
    }

    public int getValue(){
        return value;
    }
}
