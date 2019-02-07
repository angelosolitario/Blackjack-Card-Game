package com.angelosolitario;

public class Card {
    private int rank;
    private int suit;

    public String[] ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    public String[] suits = {"Spades","Diamonds","Clubs","Hearts"};

    public Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
   public String toString(){
       return ranks[rank] + " of " + suits[suit];
   }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }
}
