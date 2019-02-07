package com.angelosolitario;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck {
    ArrayList<Card> deck;
    Random random = new Random();

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public Deck(ArrayList<Card> deck) {
        this.deck = deck;
        for (int a = 1; a <= 4; a++) {
            for (int b = 1; b <= 13; b++) {
                this.deck.add(new Card(a, b));
            }
        }
    }

    public ArrayList<Card> createDeck() {
        for (int a = 0; a <= 3; a++) {
            for (int b = 0; b <= 12; b++) {
                this.deck.add(new Card(a, b));
            }
        }
        return this.deck;
    }

    @Override
    public String toString() {
        String cardListOutput = "";
        for (Card card : this.deck) {
            cardListOutput += "\n" + card.toString();
        }
        return cardListOutput;
    }

    public void moveTo(Deck startingDeck){
        int deckSize = this.deck.size();

        for(int i=0; i<deckSize; i++){
            startingDeck.addCard(this.getCard(i));
        }

        for(int i=0; i<deckSize; i++){
            this.removeCard(0);
        }
    }

    //shuffle
    public void shuffle() {
        if (this.deck.isEmpty()) {
            System.out.println("Deck is empty");
        } else {
            int index1;
            int index2;
            Card card;
            for (int i = 0; i < 100; i++) {
                index1 = random.nextInt(this.deck.size());
                index2 = random.nextInt(this.deck.size());

                card = this.deck.get(index2);

                this.deck.set(index2, deck.get(index1));
                this.deck.set(index1, card);
            }
        }
    }

    public int cardValue() {
        int totalValue = 0;
        int aces = 0;

        for (Card cards : this.deck) {
            switch (cards.getRank()) {
                case 0:
                    totalValue += 2;
                    break;
                case 1:
                    totalValue += 3;
                    break;
                case 2:
                    totalValue += 4;
                    break;
                case 3:
                    totalValue += 5;
                    break;
                case 4:
                    totalValue += 6;
                    break;
                case 5:
                    totalValue += 7;
                    break;
                case 6:
                    totalValue += 8;
                    break;
                case 7:
                    totalValue += 9;
                    break;
                case 8:
                    totalValue += 10;
                    break;
                case 9:
                    totalValue += 10;
                    break;
                case 10:
                    totalValue += 10;
                    break;
                case 11:
                    totalValue += 10;
                    break;
                case 12:
                    aces += 1;
                    break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (totalValue > 10) {
                totalValue+=1;
            } else{
                totalValue +=11;
            }
        }
        return totalValue;
    }


    public void draw(Deck drawDeck) {
        this.deck.add(drawDeck.getCard(0));
        drawDeck.removeCard(0);
    }

    public Card draw() {
        return this.deck.remove(0);
    }

    public void removeCard(int index) {
        this.deck.remove(index);
    }


    public Card getCard(int index) {
        return this.deck.get(index);
    }

    public void addCard(Card addCard) {
        this.deck.add(addCard);
    }
}
