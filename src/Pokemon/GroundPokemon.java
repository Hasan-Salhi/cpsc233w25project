package Pokemon;
import Type.Type;

public class GroundPokemon extends Pokemon{
    public GroundPokemon(String name, int hp, int attack, Type typeOne, Type typeTwo){
        super(name, hp, attack, typeOne, typeTwo);
    }

    @Override
    public void useMove() {
        System.out.println(name + " ");
    }

    @Override
    public String getSTAB(){
        return (name + " gets a 1.5x BP buff to moves of " + typeOne + " and " + typeTwo + " typing.");
    }

    @Override
    public String getTypeWeakness() {
        return "";
    }

    @Override
    public String typePassive() {
        return "As a Ground type Pokemon this Pokemon is immune to sandstorm damage.";
    }
}
