import entity.Ladder;
import entity.Player;
import entity.Snake;
import manager.GameManager;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        try {
            GameManager gm = new GameManager(100);
            Snake s1 = new Snake(5, 1);
            Snake s2 = new Snake(25, 10);
            Snake s3 = new Snake(51, 29);
            Snake s4 = new Snake(35, 12);
            Snake s5 = new Snake(68, 15);
            Snake s6 = new Snake(85, 56);
            Snake s7 = new Snake(99, 50);

            Ladder l1 = new Ladder(13, 29);
            Ladder l2 = new Ladder(22, 59);
            Ladder l3 = new Ladder(32, 89);
            Ladder l4 = new Ladder(72, 86);
            Ladder l5 = new Ladder(3, 9);
            Ladder l6 = new Ladder(31, 84);
            Ladder l7 = new Ladder(28, 38);

            Player p1 = new Player("Alice");
            Player p2 = new Player("Bob");
            Player p3 = new Player("Chris");
            Player p4 = new Player("Don");

            gm.setSnakes(Arrays.asList(s1,s2,s3,s4,s5,s6,s7));
            gm.setLadder(Arrays.asList(l1,l2,l3,l4,l5,l6,l7));
            gm.setPlayers(Arrays.asList(p1,p2,p3,p4));

            gm.startGame();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
