public class PiratePairsL {

    public static void main(String[] args) {
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
