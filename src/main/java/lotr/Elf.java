package lotr;

import kickstrat.ElfStrategy;

final public class Elf extends lotr.Character {
    public Elf() {
        super(10, 10, new ElfStrategy());
    }
}
