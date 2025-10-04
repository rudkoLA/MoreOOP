package lotr;

import kickstrat.HobbitStrategy;

final public class Hobbit extends Character {
    public Hobbit() {
        super(0, 3, new HobbitStrategy());
    }
}
