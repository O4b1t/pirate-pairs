public class Player {

    private int[] hand = new int[55];

    public Player(){
        
    }

    public Player(int i) {
    }

    public int[] get(){
        return hand;
    }

    public int[] discard(){
        //int[] dis = new int[55];
        //dis = hand;
        for(int i = 0; i < hand.length; i++) {
            hand[i] = 0;
        }
        return hand;
        //drawSmallest
    }
}
