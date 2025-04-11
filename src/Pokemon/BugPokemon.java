package Pokemon;
import Type.Type;

public class BugPokemon extends Pokemon{
    public BugPokemon(String name, int hp, int attack, Type typeOne, Type typeTwo){
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
        return "The Bug type unfortunately does not have any passives.";
    }
}
