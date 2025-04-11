package Pokemon;
import Type.Type;

import java.util.ArrayList;
import java.util.List;

public class PoisonPokemon extends Pokemon{
    public PoisonPokemon(String name, int hp, int attack, Type typeOne, Type typeTwo){
        super(name, hp, attack, typeOne, typeTwo);
    }

    @Override
    public String useMove() {
        return("Poison type Pokemon can use Toxic as a default move.");
    }

    @Override
    public String getSTAB() {
        return (name + " gets a 1.5x BP buff to moves of " + typeOne + " and " + typeTwo + " typing.");
    }

    @Override
    public String getTypeWeakness() {
        StringBuilder toReturn = new StringBuilder();
        List<Type> weaknesses = typeTwo.getWeaknesses(); //grabbing weaknesses and resistances of secondary type
        List<Type> resistances = typeTwo.getResistances();

        List<Type> commonWeaknesses = new ArrayList<>(weaknesses);
        commonWeaknesses.retainAll(Type.POISON.getWeaknesses()); // checks for common weaknesses between type two and type one
        // it will get rid of all non-shared weaknesses

        List<Type> conflictingWeaknesses = new ArrayList<>(weaknesses);
        conflictingWeaknesses.retainAll(Type.POISON.getResistances()); // if type one is resistant to a weakness of the secondary type it cancels out

        List<Type> secondaryConflictingWeaknesses = new ArrayList<>(Type.POISON.getWeaknesses());
        secondaryConflictingWeaknesses.retainAll(resistances); // we need to do the same for the secondary type conflicting weaknesses

        ArrayList<String> doubleWeaknesses = new ArrayList<>(); // string arraylist of all the weaknesses to keep

        for(Type type : Type.POISON.getWeaknesses()){
            if(!conflictingWeaknesses.contains(type) && !commonWeaknesses.contains(type) && !secondaryConflictingWeaknesses.contains(type)){
                doubleWeaknesses.add(String.valueOf(type)); // basically if the type is NOT in either list of common or conflicting weaknesses it gets added
            }
        }
        for(Type type : weaknesses){ // same but for secondary type
            if(!conflictingWeaknesses.contains(type) && !commonWeaknesses.contains(type) && !secondaryConflictingWeaknesses.contains(type)){
                doubleWeaknesses.add(String.valueOf(type)); // basically if the type is NOT in either list of common or conflicting weaknesses it gets added
            }
        }

        if(typeTwo != Type.NONE){ //make sure there is a secondary type in the first place
            if(!doubleWeaknesses.isEmpty()) { //some pokemon do not have any double weaknesses so account for that
                toReturn.append("2x Weaknesses: ").append(doubleWeaknesses.getFirst()).append("\n");
                for (int i = 1; i < doubleWeaknesses.size(); i++) { // making overall weakness list
                    toReturn.append(doubleWeaknesses.get(i)).append("\n");
                }
            }

            //if and only if 4x weakness list exist do we append it
            if(!commonWeaknesses.isEmpty()){
                toReturn.append("4x Weaknesses: ").append(commonWeaknesses.getFirst()).append("\n");
                for(int i = 1; i < commonWeaknesses.size(); i++){
                    toReturn.append(commonWeaknesses.get(i)).append("\n");
                }
            }

        }else{ //otherwise just return the weaknesses of the class typing
            toReturn.append("2x Weaknesses: GROUND,PSYCHIC");
        }

        return toReturn.toString();
    }

    @Override
    public String typePassive() {
        return "As a Poison type Pokemon, this Pokemon is immune to Poison and the move 'Toxic' will always land on opposing Pokemon.";
    }
}
