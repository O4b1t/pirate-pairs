import java.util.Arrays;

public class Deck {
    private int[] deck = new int[55];
    private int[] discard = new int[0];
    private int[] cardOnBoard = new int[0];


    public Deck(){
        int start = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < i; j++) {
                deck[start] = i;
                start++;
            }
        }
    }

    public void shuffle(){
        for (int i = deck.length - 1; i >= 0; i-- ) {
            int ran = (int)(Math.random() * i);
            int temp = deck[i];
            deck[i] = deck[ran];
            deck[ran] = temp;
        }
    }

    public void show(){
        System.out.println(deck);
    }

    public int deckLength(){
        return deck.length;
    }


    public int getCard() {
        int temp = 0; //taking out top card each time
        int deckLength = deck.length;
        temp = deck[0];
        int[] tempDeck = new int[deck.length - 1];
        if(tempDeck.length > 0){
            for(int i = 0; i < tempDeck.length; i++){
                tempDeck[i] = deck[i+ 1];
            }
        }
        deck = tempDeck;
        if (deckLength <= 1) { //making sure there is always card in deck
            reshuffle();
        }
        int[] tempOnBoard = new int[cardOnBoard.length + 1]; // adding card to card On Board
        if (cardOnBoard.length > 0) {
            for (int i = 0; i < cardOnBoard.length; i++) {
                tempOnBoard[i] = cardOnBoard[i];
            }
        }
        tempOnBoard[cardOnBoard.length] = temp;
        cardOnBoard = tempOnBoard;
        
        return temp; //returning the top card to player
    }

    public void addDiscard(int[] dis) { //adding all discarded cards to the existing discard pile
        int[] temp = new int[dis.length + discard.length];
        int start = 0;
        for (int i = 0; i < discard.length; i++) {
            temp[i] = discard[i];
            start = i + 1;
        }
        for (int i = 0; i < dis.length; i++) {
            temp[start + i] = dis[i];
        }
        discard = temp;

    }

    public int getSmallestOnBoard() {
        int[] temp = cardOnBoard;
        Arrays.sort(temp);
        int smallest = temp[0];
        int[] temp2 = new int[temp.length-1];
        for (int i = 0; i < temp2.length; i++) {
            temp2[i] = temp[i+1];
        }
        cardOnBoard = temp2;
        return smallest;

    }

    public void reshuffle(){
        int[] temp = new int[0];
        deck = discard;
        discard = temp;
        shuffle();
    
    }
    
}
