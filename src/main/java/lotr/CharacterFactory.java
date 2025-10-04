package lotr;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.reflections.Reflections;

public class CharacterFactory {
    public static final Random random = new Random();

    public Character createCharacter() {
        Reflections reflections = new Reflections("lotr");
        List<Class<? extends Character>> charClasses = new ArrayList<>(reflections.getSubTypesOf(Character.class));
        charClasses.removeIf(c -> !Modifier.isFinal(c.getModifiers()));
        int idx = random.nextInt(charClasses.size());
        try {
            Constructor<? extends Character> constructor = charClasses.get(idx).getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
