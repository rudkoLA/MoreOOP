package kickstrat;

import lotr.Character;
import java.util.Random;

public class NobleStrategy implements KickStrategy {
    public static Random random = new Random();

    @Override
    public void kick(Character c, Character target) {
        int damage = random.nextInt(c.getPower()) + 1;
        target.setHp(target.getHp() - damage);
    }
}
