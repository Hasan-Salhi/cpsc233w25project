package Type;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
/**
 * CPSC 233 W25 Project Type.Type Enumeration
 * An enumeration of Pokemon.Pokemon types.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.0 - March 18, 2025
 */
public enum Type {
    NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON, GROUND,
    FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY, NONE;

    // lists of all the weaknesses for each unique type
    private List<Type> weaknesses;

    //ditto but for resistances
    private List<Type> resistances;

    public List<Type> getWeaknesses(){
        return weaknesses;
    }
    // resistances are needed for accurate weakness determination
    public List<Type> getResistances(){
        return resistances;
    }

    // block of code that runs on class startup
    static {
        FIRE.weaknesses = List.of(WATER, GROUND, ROCK, FIGHTING);
        WATER.weaknesses = List.of(ELECTRIC, GRASS);
        GRASS.weaknesses = List.of(FIRE, ICE, FLYING, BUG, POISON);
        FIGHTING.weaknesses = List.of(FLYING, PSYCHIC, FAIRY);
        GROUND.weaknesses = List.of(WATER, GRASS, ICE);
        ROCK.weaknesses = List.of(WATER, GRASS, FIGHTING);
        ELECTRIC.weaknesses = List.of(GROUND);
        NONE.weaknesses = Collections.emptyList(); // no weaknesses
    }

    //also required for resistances
    static{
        NORMAL.resistances = List.of(GHOST);
    }
}