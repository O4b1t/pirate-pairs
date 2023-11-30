public class Player {

    private int[] hand = new int[55];
    private int points = 0;

    public Player(){
        
    }

    public int[] show(){
        return hand;
    }

    public int getPoint(){
        return points;
    }

    public int[] discard(){
        int[] dis = new int[55];
        dis = hand;
        for(int i = 0; i < hand.length; i++) {
            hand[i] = 0;
        }
        return dis;
    }

    public void draw(int card){
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 0){
                hand[i] = card;
                return;
            }
        }
    }

    public boolean checkHand(){
        int[]check = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int i = 0; i < hand.length; i++){
            check[hand[i]]++;
            if(check[hand[i]] > 1){
                points += hand[i];
                return false;
            }
        }
        return true;
    }
}
