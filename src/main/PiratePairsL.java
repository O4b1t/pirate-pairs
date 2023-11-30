public class PiratePairsL {

    static int[] deck = new int[55];
    static int[] discard = new int[55];
    static int[] cardOnBoard = new int[55];

    public static void main(String[] args) {
        int start = 0;
        for(int i = 0; i < 10; i ++){ //created deck
            for(int j = 0; j <= i; j++){
                deck[start] = i+1;
                start++;
            }
        }

        boolean gameOn = true;
    
        Deck deck = new Deck();
        Player[] p = new Player[4];
        for(int i = 0; i < p.length; i++){
         p[i] = new Player();
        }
    
        deck.shuffle();

        while(gameOn){
    
            for(int i = 0; i < p.length; i++){
            
                p[i].draw(deck.getCard());
                if(!p[i].checkHand()){
                    p[i].discard();
                }

                if(p[i].getPoint() > 21){
                    gameOn = false;
                    System.out.println("Player " + i + " is the loser!");
                }
                
            }
        }

    }
    
}
