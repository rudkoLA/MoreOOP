package kickstrat;

import lotr.Character;

public class HobbitStrategy implements KickStrategy {
    public void kick(Character c, Character target) {
        toCry();
    }

    public void toCry() {
        System.out.println("The hobbit cries out \"WAAAAA!\" for it cannot kick.");
    }
}
