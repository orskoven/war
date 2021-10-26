//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Random;

public class CardStack implements ArrayWarStack {
    private static ArrayList<Hearts> heartsObjects = new ArrayList(13);
    private static ArrayList<Clubs> clubsObjects = new ArrayList(13);
    private static ArrayList<Diamonds> diamondsObjects = new ArrayList(13);
    private static ArrayList<Spades> spadesObjects = new ArrayList(13);
    private static ArrayList<Card> cardObjects = new ArrayList(52);
    private Card firstCard;

    public CardStack() {
    }

    public ArrayList<Card> createStack() {
        for (int j = 1; j < 16; j++) {
            switch (j) {
                case 1:
                    for (CardNames name: CardNames.values()) {
                    cardObjects.add(new Hearts(name,j));
                        j++;
                    } j = 1;
                case 16:

                    for (CardNames name: CardNames.values()) {
                        cardObjects.add(new Clubs(name,j));
                        j++;
                    }j = 1;
                case 29:

                    for (CardNames name: CardNames.values()) {
                        cardObjects.add(new Diamonds(name,j));
                        j++;
                    }j = 1;
                case 35:
                    for (CardNames name: CardNames.values()) {
                        cardObjects.add(new Spades(name,j));
                        j++;
                    }
            }

        }return cardObjects;
    }

    public void push(Card c) {
        cardObjects.add(c);
    }



    public Card pop() {
        return (Card)cardObjects.remove(cardObjects.size() - 1);
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public boolean isEmpty() {
        return cardObjects.isEmpty();
    }

    public Card top() {
        return (Card)cardObjects.get(0);
    }

    public int size() {
        return cardObjects.size();
    }

    public void display() {
        System.out.println(cardObjects.toString());
    }

    public String toString() {
        return "Stack{}";
    }
    public ArrayList<Card> shuflle(){
        Random random = new Random();
        for (int i = 1; i < cardObjects.size() ; i++) {
            int randomNumbers = random.nextInt(60);
            cardObjects.set(randomNumbers,cardObjects.get(i));
        } return cardObjects;
    }
}
