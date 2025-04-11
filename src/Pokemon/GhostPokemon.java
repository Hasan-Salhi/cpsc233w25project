package Pokemon;
import Type.Type;

public class GhostPokemon extends Pokemon{
    public GhostPokemon(String name, int hp, int attack, Type typeOne, Type typeTwo){
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
        return "As a Ghost type Pokemon this Pokemon cannot be prevented from switching out.";
    }
}
