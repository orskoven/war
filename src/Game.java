import com.logicbig.example.ConsoleHelper1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        ConsoleHelper1.main();
        System.out.println("TYPE PLAYER ONE NAME:");
        String inputNamePlayerOne = scanner.next();
        System.out.println("TYPE PLAYER TWO NAME:");
        String inputNamePlayerTwo = scanner.next();
        CardStackPlayerOne stackPlayerOne = new CardStackPlayerOne(inputNamePlayerOne);
        CardStackPlayerTwo stackPlayerTwo = new CardStackPlayerTwo(inputNamePlayerTwo);
        Collections.shuffle(stackPlayerOne.createStack());
        Collections.shuffle(stackPlayerTwo.createStack());
        char surrenderInput;
        int roundCounter = 1;
        do {
            System.out.println("PRESS 'X' TO SURRENDER!\n"
            + "OR ANY OTHER KEY TO CONTINUE!");
            surrenderInput = scanner.next().charAt(0);
            Card playerOneTopCard = stackPlayerOne.top();
            Card playerTwoTopCard = stackPlayerTwo.top();
            int cardCompare = playerOneTopCard.compareTo(playerTwoTopCard);
            System.out.println("_________________________________________________\n");
            System.out.println("\n" + inputNamePlayerOne + "'s top card is " + playerOneTopCard + "\n");
            System.out.println("_________________________________________________\n");
            System.out.println(inputNamePlayerTwo + "'s top card is " + playerTwoTopCard + "\n");

            if (cardCompare == 0) {
                ArrayList<Card> warCardsPlayerOne = new ArrayList<Card>();
                ArrayList<Card> warCardsPlayerTwo = new ArrayList<Card>();
                System.out.println("it's WAR!\n");
                System.out.println(inputNamePlayerOne + " PLEASE TYPE A NUMBER 1-3");
                int inputChoicePlayerOne = scanner.nextInt();
                for (int i = 0; i < 3; i++) {
                  warCardsPlayerOne.add(stackPlayerOne.pop());
                }
                playerOneTopCard = warCardsPlayerOne.get(randomizer(inputChoicePlayerOne));
                System.out.println(inputNamePlayerTwo + " PLEASE TYPE A NUMBER 1-3");
                int inputChoicePlayerTwo = scanner.nextInt();
                for (int i = 0; i < 3; i++) {
                    warCardsPlayerTwo.add(stackPlayerTwo.pop());
                }
                playerTwoTopCard = warCardsPlayerTwo.get(randomizer(inputChoicePlayerTwo));
                cardCompare = playerOneTopCard.compareTo(playerTwoTopCard);
            }
            if (cardCompare > 0) {
                System.out.println("_________________________________________________\n");
                System.out.println("\n" + inputNamePlayerTwo + " wins round nr. " + roundCounter);
                System.out.println("_________________________________________________\n");
                stackPlayerOne.pop();
                stackPlayerTwo.enqueue(playerOneTopCard);
            }
            if (cardCompare < 0) {
                System.out.println("_________________________________________________\n");
                System.out.println("\n" + inputNamePlayerOne + " wins round nr. " + roundCounter);
                System.out.println("_________________________________________________\n");
                stackPlayerTwo.pop();
                stackPlayerOne.enqueue(playerTwoTopCard);
            }
            System.out.println(inputNamePlayerOne + "'s card stack is " + stackPlayerOne.size());
            System.out.println(inputNamePlayerTwo + "'s card stack is " + stackPlayerTwo.size());
            roundCounter++;
        } while (!stackPlayerOne.isEmpty() && !stackPlayerTwo.isEmpty() && surrenderInput != 'X');
        if (stackPlayerOne.size() > stackPlayerTwo.size()){
            System.out.println(inputNamePlayerOne + " WINS THE GAME!");
        }  if (stackPlayerTwo.size() > stackPlayerOne.size()) {
            System.out.println(inputNamePlayerTwo + " WINS THE GAME!");
        }
    }
    static int randomizer(int bound){
        return random.nextInt(bound);
    }


}

