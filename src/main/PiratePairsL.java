public class PiratePairsL {

    static boolean drawSuggested(Player p, Deck d){ //checking if a player should draw or not (Strategy)
            if (((p.hasCard(9) || p.hasCard(10)) && p.getPoints() > 11 && d.deckLength() < 28) || p.numCards() > 4) {
                return false;
            }
            return true;
        }

    public static void main(String[] args) {
        boolean gameOn = true;
        
    
        Deck deck = new Deck();
        Player[] p = new Player[4]; //creating players
        for (int i = 0; i < p.length; i++) {
            p[i] = new Player();
        }
    
        deck.shuffle(); //initializing the deck order to start game with

        while (gameOn) {
    
            for (int i = 0; i < p.length; i++) { //rotating through each player

                if (p[i].numCards() < 1) { //forced draw if the player has no card
                    p[i].draw(deck.getCard());
                } else {

                    if (drawSuggested(p[i], deck)) { //checking strategy
                        p[i].draw(deck.getCard()); //should draw
                    } else {
                        System.out.println("Player " + i + " is discarding..."); //should not draw: getting rid of hand, get smallest card on board, add points
                        deck.addDiscard(p[i].discard()); //adding to discard pile
                        int smallest = deck.getSmallestOnBoard(); 
                        p[i].addPoints(smallest);
                        for (int j = 0; j < p.length; j++) {
                            if (p[j].foundPlayer(smallest) && j != i) {
                                break;
                            }
                        }
                    }

                }
            


                if (!p[i].checkHand()) { // chekcing if the player has pairs in his hand
                    deck.addDiscard(p[i].discard());
                }
                System.out.print("Player " + i + " has in hand: ");
                p[i].show();
                

                System.out.println("Player " + i + " has " + p[i].getPoints() + " points.");

                if(p[i].getPoints() > 200){ //ending game if reached 21 points (ending goal is modifiable)
                    System.out.println("PLAYER " + i + " IS THE LOSER!!!");
                    return;
                }
                
            }
            System.out.println("------------------------------------------------------");
        }

    }
    
}
