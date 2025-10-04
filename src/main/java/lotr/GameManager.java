package lotr;

import java.util.Random;

public class GameManager {
    public static Random random = new Random();

    public void fight(Character c1, Character c2) {
        System.out.println("A fight begins between " + c1 + " and " + c2 + "!");
    

        if (c1.getClass().getSimpleName().equals("Hobbit") && c2.getClass().getSimpleName().equals("Hobbit")) {
            System.out.println("However, hobbits are weak and can't do anything to each other, it's a draw!");
            return;
        }

        while (c1.isAlive() && c2.isAlive()) {
            if (random.nextInt(2) == 0) {
                System.out.println(c1 + " kicks " + c2 + "!");
                c1.kick(c2);
            } else {
                System.out.println(c2 + " kicks " + c1 + "!");
                c2.kick(c1);
            }
        }

        if (!c1.isAlive()) {
            System.out.println(c1 + " has died! The battle is over and " + c2 + " has won!");
            return;
        }

        if (!c2.isAlive()) {
            System.out.println(c2 + " has died! The battle is over and " + c1 + " has won!");
            return;
        }
    }
}
