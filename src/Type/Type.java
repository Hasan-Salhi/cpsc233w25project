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
        NORMAL.weaknesses = List.of(FIGHTING);
        FIRE.weaknesses = List.of(WATER, GROUND, ROCK, FIGHTING);
        WATER.weaknesses = List.of(ELECTRIC, GRASS);
        ELECTRIC.weaknesses = List.of(GROUND);
        GRASS.weaknesses = List.of(FIRE, ICE, FLYING, BUG, POISON);
        ICE.weaknesses = List.of(FIRE,FIGHTING,STEEL,ROCK);
        FIGHTING.weaknesses = List.of(FLYING, PSYCHIC, FAIRY);
        POISON.weaknesses = List.of(GROUND,PSYCHIC);
        GROUND.weaknesses = List.of(WATER, GRASS, ICE);
        FLYING.weaknesses = List.of(ICE,ROCK,ELECTRIC);
        PSYCHIC.weaknesses = List.of(BUG,DARK,GHOST);
        BUG.weaknesses = List.of(FIRE,FLYING,ROCK);
        ROCK.weaknesses = List.of(WATER, GRASS, FIGHTING);
        GHOST.weaknesses = List.of(DARK,GHOST);
        DRAGON.weaknesses = List.of(FAIRY,ICE,DRAGON);
        DARK.weaknesses = List.of(FIGHTING,BUG,FAIRY);
        STEEL.weaknesses = List.of(FIGHTING,FIRE,GROUND);
        FAIRY.weaknesses = List.of(POISON,STEEL);
        NONE.weaknesses = Collections.emptyList(); // no weaknesses
    }

    //also required for resistances
    static{
        NORMAL.resistances = List.of(GHOST);
        FIRE.resistances = List.of(BUG,FAIRY,FIRE,GRASS,ICE,STEEL);
        WATER.resistances = List.of(FIRE,ICE,STEEL,WATER);
        ELECTRIC.resistances = List.of(ELECTRIC,FLYING,STEEL);
        GRASS.resistances = List.of(ELECTRIC,GRASS,GROUND,WATER);
        ICE.resistances = List.of(ICE);
        FIGHTING.resistances = List.of(BUG,DARK,ROCK);
        POISON.resistances = List.of(BUG,FAIRY,FIGHTING,GRASS,POISON);
        GROUND.resistances = List.of(POISON,ROCK,ELECTRIC);
        FLYING.resistances = List.of(BUG,FIGHTING,GRASS,GROUND);
        PSYCHIC.resistances = List.of(FIGHTING,PSYCHIC);
        BUG.resistances = List.of(FIGHTING,GRASS,GROUND);
        ROCK.resistances = List.of(FLYING,FIRE,NORMAL,POISON);
        GHOST.resistances = List.of(BUG,POISON);
        DRAGON.resistances = List.of(ELECTRIC,FIRE,GRASS,WATER);
        DARK.resistances = List.of(DARK,GHOST,PSYCHIC);
        STEEL.resistances = List.of(BUG,DRAGON,FAIRY,FLYING,GRASS,ICE,NORMAL,PSYCHIC,ROCK,STEEL);
        FAIRY.resistances = List.of(BUG,DARK,FIGHTING);
        NONE.resistances = Collections.emptyList(); // no resistances either
    }
}