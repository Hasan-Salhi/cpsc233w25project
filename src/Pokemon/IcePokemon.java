package Pokemon;
import Type.Type;

public class IcePokemon extends Pokemon{
    public IcePokemon(String name, int hp, int attack, Type typeOne, Type typeTwo){
        super(name, hp, attack, typeOne, typeTwo);
    }

    @Override
    public void useMove() {

    }

    @Override
    public int getSTAB() {
        return 0;
    }

    @Override
    public String getTypeWeakness() {
        return "";
    }
}
