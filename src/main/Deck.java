public class Deck {
    int[] deck = new int[55];
    int[] discard = new int[0];
    int[] cardOnBoard = new int[55];

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

    public void show(){
        System.out.println(deck);
    }

    public int getCard() {
        int numCard = 0;
        for(int i = 0; i < deck.length; i++) {
            if(deck[i] != 0){
                int temp = deck[i];
                deck[i] = 0;
                for(int j = 0; j < cardOnBoard.length; j++){
                    if(cardOnBoard[j]== 0){
                        cardOnBoard[j] = temp;
                        break;
                    }
                }
                numCard = 54 - i; //redesign this because the last card might not be at the last position
                if(numCard == 0){
                    reshuffle();
                }
                return temp;
            }
        }
        return 0; // will have to add reshuffling of the discard pile
    }

    public void addDiscard(int[] dis) {
        int[] temp = new int[dis.length + discard.length];
        int start = 0;
        for(int i = 0; i < discard.length; i++){
            temp[i] = discard[i];
            start = i;
        }
        for(int i = 0; i < dis.length; i++){
            temp[start + 1 + i] = dis[i];
        }

    }

    public void reshuffle(){
        for(int i = 0; i < discard.length; i++){
            deck[i] = discard[i];
        }
        shuffle();//redesign needed
    
    }
    
}
