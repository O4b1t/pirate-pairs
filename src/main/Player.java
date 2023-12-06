import java.util.Arrays;

public class Player {

    private int[] hand = new int[0];
    private int points = 0;

    public Player(){
        
    }

    public void show(){
        System.out.println(Arrays.toString(hand)); 
    }

    public int getPoints(){
        return points;
    }


    public int numCards(){
        return hand.length;
    }

    public int[] discard(){ //clearing a players hand
        int[] dis;
        dis = hand;
        int[] temp = new int[0];
        hand = temp;
        return dis;
    }

    public void draw(int card){
        int[] temp = new int[hand.length+1];
        if (hand.length > 0) {
            for (int i = 0; i < hand.length; i++) {
                temp[i] = hand[i];
            }
        }
        temp[hand.length] = card;
        hand = temp;

    }


    public void addPoints(int card){
        points += card;
    }

    public boolean hasCard(int num){
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean foundPlayer(int card){ // checking if a players has a certain card
        int[] temp = hand;
        if (hand.length > 0) {
            Arrays.sort(temp); //used in grabing the smallest card, so sorting to help reduce calculation
            if (temp[0] == card) {
                int[] temp2 = new int[temp.length - 1];
                
                for (int i = 0; i < temp2.length; i++) {
                    temp2[i] = temp[i+1];
                }
                
                hand = temp2;
                return true;
            }
        }
        return false;
    }

    public boolean checkHand(){
        int[]check = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //checking pairs, this way is easier and clearer
        for (int i = 0; i < hand.length; i++) {
            check[hand[i]]++;
            if (check[hand[i]] > 1) {
                points += hand[i];
                return false;
            }
        }
        return true;
    }
}
