package lotr;

import kickstrat.KickStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Character {
    private int power;
    private int hp;
    private KickStrategy kickStrategy;

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{hp=" + getHp() + ", power=" + getPower() + "}";
    }

    public void kick(Character target) {
        kickStrategy.kick(this, target);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
