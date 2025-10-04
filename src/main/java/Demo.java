import java.util.Random;

import lotr.CharacterFactory;
import lotr.GameManager;
import java.util.ArrayList;

public class Demo {
    public static Random random = new Random();

    public static void main(String args[]) {
        final int characterCount = 10;

        ArrayList<lotr.Character> characters = new ArrayList<lotr.Character>();
        CharacterFactory factory = new CharacterFactory();

        GameManager Game = new GameManager();

        for (int i = 0; i < characterCount; i++) {
            characters.add(factory.createCharacter());
            System.out.println(characters.get(i).getClass().getSimpleName() + " added!");
        }

        boolean allHobits = true;

        for (lotr.Character character : characters) {
            if (!character.getClass().getSimpleName().equals("Hobbit")) {
                allHobits = false;
                break;
            }
        }

        if (allHobits) {
            System.out.println("Oops! All Hobbits! The game is at an eternal stalemate.");
            return;
        }

        while (characters.size() > 1) {
            int ci1 = random.nextInt(characters.size());
            int ci2 = random.nextInt(characters.size());

            while (ci1 == ci2) {
                ci2 = random.nextInt(characters.size());
            }

            lotr.Character c1 = characters.get(ci1);
            lotr.Character c2 = characters.get(ci2);

            Game.fight(c1, c2);

            if (!c1.isAlive()) {
                characters.remove(c1);
            }

            if (!c2.isAlive()) {
                characters.remove(c2);
            }
        }

        System.out.println("The battle has ended!");
        System.out.println(characters.get(0) + " remains the only one alive and achieves victory in the battle!");
    }
}
