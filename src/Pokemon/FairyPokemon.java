package Pokemon;
import Type.Type;

public class FairyPokemon extends Pokemon{
    public FairyPokemon(String name, int hp, int attack, Type typeOne, Type typeTwo){
        super(name, hp, attack, typeOne, typeTwo);
    }

    @Override
    public void useMove() {
        System.out.println(name + " ");
    }

    @Override
    public int getSTAB(){

        return 0;
    }

    @Override
    public String getTypeWeakness() {
        return "";
    }
}
