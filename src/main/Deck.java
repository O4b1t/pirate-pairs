public class Deck {
    int[] deck = new int[55];

    public Deck(){
        int start = 0;
        for(int i = 1; i <= 10; i++){
            for(int j = 0; j < i; j++){
                deck[start] = i;
                start++;
            }
        }
    }

    public void shuffle(){
        for(int i = deck.length - 1; i >= 0; i-- ){
            int ran = (int)(Math.random() * i);
            int temp = deck[i];
            deck[i] = deck[ran];
            deck[ran] = temp;
        }
    }

    public int[] show(){
        return deck;
    }

    public int getCard() {
        for(int i = 0; i < deck.length; i++) {
            if(deck[i] != 0){
                int temp = deck[i];
                deck[i] = 0;
                return temp;
            }
        }
        return 0; // will have to add reshuffling of the discard pile
    }

    public void reshuffle(){

    }
    
}
