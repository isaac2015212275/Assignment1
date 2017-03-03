package ss.labs.pokemon;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //TODO declare and initiate a Scanner
        Scanner scanner = new Scanner(System.in);

        //TODO declare and initiate pokedex as an ArrayList to store pokemon data
        ArrayList<PokemonData> pokeDex = new ArrayList();

        //TODO declare and initiate typeCountMap as a HashMap to count the number of each types of pokemon
        HashMap<String,Integer> typeCountMap = new HashMap();


        System.out.println("Enter the Number of pokemon in the pokedex:");
        //TODO 0: scan the number of the testData from user input
        int n;
        n = scanner.nextInt();

        //TODO use a loop to read several input data
        for(int i=0;i<n;i++)
        {
            String name,type,move;
            System.out.println("Enter pokemon name:");
            //TODO 1-1:scan pokemon name and save to a variable from user input
            name = scanner.next();

            System.out.println("Enter pokemon type:");
            //TODO 1-2:scan pokemon type and save to a variable
            type = scanner.next();

            System.out.println("Enter pokemon's move name:");
            //TODO 1-3:scan pokemon move's name
            move = scanner.next();

            //TODO 2-1:create a new pokemon data from the above variables
            PokemonData pokeDataTem = new PokemonData(name,type,move);

            //TODO 2-2:add the pokemon data into pokedex
            pokeDex.add(pokeDataTem);

            //TODO 4: Tricky part!! get the value from the type counting map , add 1 and put it back (multiple line
            boolean checkExist = typeCountMap.containsKey(type);
            if(checkExist)
            {
                typeCountMap.put(type,typeCountMap.get(type)+1);
            }
            else
            {
                typeCountMap.put(type,1);
            }
        }

        //TODO 5 print out the created pokemon information (multiple lines
        for(int i=0;i<n;i++)
        {
            PokemonData pokeDataTem = pokeDex.get(i);
            System.out.println("name: "+pokeDataTem.name+",type: "+pokeDataTem.type+",move's name: "+pokeDataTem.move);
        }
        //TODO 6 print out how many type of pokemons in the pokedex
        System.out.println("number of types of pokemons: "+typeCountMap.size());
    }
}
