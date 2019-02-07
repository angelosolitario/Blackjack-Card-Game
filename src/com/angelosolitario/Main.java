package com.angelosolitario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double money = 100.00;
        double playerBet;
        boolean gameOver;

        Scanner scanner = new Scanner(System.in);

        Deck playingDeck = new Deck();
        playingDeck.createDeck();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        System.out.println("Welcome to BlackJack");
        while (money > 0) {
            playingDeck.shuffle();
            gameOver = false;
            System.out.println("\nYou have $" + money);
            System.out.println("How much do you want to bet?(or to quit, enter 0)");

            playerBet = scanner.nextDouble();

            if (playerBet == 0) {
                break;
            }

            while (playerBet > money) {
                System.out.println("You cannot bet more than you have!");
                System.out.println("Please make a change with your bet.");
                playerBet = scanner.nextDouble();
            }

            //player draws
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            //dealer draws - maybe to make it more realistic make them alternate
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);


            //game loop
            while (!gameOver) {
                System.out.print("Your hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Value: " + playerDeck.cardValue());

                int playerChoice;
                boolean flag = true;

                while (flag) {
                    System.out.println("\n1-Hit, 2-Stand");
                    playerChoice = scanner.nextInt();
                    switch (playerChoice) {
                        case 1:
                            playerDeck.draw(playingDeck);
                            System.out.print("Your hand now: \n");
                            System.out.println(playerDeck.toString());
                            System.out.println("Value: " + playerDeck.cardValue());
                            break;
                        case 2:
                            flag = false;
                            break;
                    }

                    if (playerDeck.cardValue() > 21) {
                        flag = false;
                    }
                }


                while(dealerDeck.cardValue()<=16) {
                    dealerDeck.draw(playingDeck);
                    System.out.println("\nDealer draws.");
                    if (dealerDeck.cardValue() > 17) {
                        break;
                    }
                }

                if (playerDeck.cardValue() > 21) {
                    System.out.println("\nBust");
                    System.out.println("You lose the round\n");
                    money -= playerBet;
                    gameOver = true;
                } else if(dealerDeck.cardValue()>21){
                    System.out.println("\nDealer bust!");
                    System.out.print("Dealer's hand: ");
                    System.out.println(dealerDeck.toString());
                    System.out.println("Value: " + dealerDeck.cardValue());
                    gameOver = true;
                } else if (playerDeck.cardValue() > dealerDeck.cardValue()) {
                    System.out.println("\nYou win against the dealer.");
                    System.out.println("Dealer's hand: " + dealerDeck.cardValue());
                    money += playerBet;
                    gameOver = true;
                } else if (dealerDeck.cardValue() > playerDeck.cardValue()) {
                    System.out.println("\nYou lose against the dealer");
                    System.out.print("Dealer's hand: ");
                    System.out.println(dealerDeck.toString());
                    System.out.println("Value: " + dealerDeck.cardValue());
                    money -= playerBet;
                    gameOver = true;
                } else {
                    System.out.println("\nDraw!");
                    gameOver = true;
                }

                playerDeck.moveTo(playingDeck);
                dealerDeck.moveTo(playingDeck);
            }

        }

        if (money == 0) {
            System.out.println("\nYou ran out of money!\nYou lose!");
        }

        System.out.println("Total mullah: $" + money);
    }
}
