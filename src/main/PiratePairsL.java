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
    Player player1 = new Player();

    }
    
}
