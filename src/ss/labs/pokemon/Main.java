package ss.labs.pokemon;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Iterator;

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

            //lower type
            String typeTmp = type.toLowerCase();
            type = typeTmp;

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

        //initial Random
        Random random = new Random();

        //接下來幾行單純是要嗆輸錯指令的玩家
        ArrayList<String> dirtyWords = new ArrayList();
        Random randomDirtywords = new Random();
        dirtyWords.add("Are you retard?");
        dirtyWords.add("Are you idiot?");
        dirtyWords.add("Are you db2?");
        dirtyWords.add("Why type wrong words?");

        //start the game GUI
        System.out.println("==============================");
        System.out.println("=                            =");
        System.out.println("=         Game Start!        =");
        System.out.println("=                            =");
        System.out.println("==============================");

        String command; //command
        int choseMonster; //random number to chose pokemon
        int score=0; //score
        HashMap<String,Integer> catchedHash = new HashMap(); //hash for catched pokemon

        do
        {
            choseMonster = random.nextInt(n); //pick a random number
            PokemonData pokeDataTem = pokeDex.get(choseMonster); //pick pokemon

            //顯示出現的怪 in fake GUI
            System.out.println("==============================");
            System.out.println("=   遇到了野生的"+pokeDataTem.name+"  =");
            System.out.println("=     Type: "+pokeDataTem.type+"            =");
            System.out.println("=     Move: "+pokeDataTem.move+"        =");
            System.out.println("==============================");

            //顯示可行的行動 in fake GUI
            System.out.println("==============================");
            System.out.println("=     catch         run      =");
            System.out.println("=                            =");
            System.out.println("=     quit                   =");
            System.out.println("==============================");
            System.out.println("enter your reaction: ");
            command = scanner.next();
            if(command.equals("catch"))
            {
                //fake GUI
                System.out.println("==============================");
                System.out.println("=   You  catch               =");
                System.out.println("=              "+pokeDataTem.name+"!     =");
                System.out.println("==============================");
                //score system
                if(pokeDataTem.type.equals("grass"))
                    score++;
                else
                    score--;
                //hash system
                if(catchedHash.containsKey(pokeDataTem.type))
                    catchedHash.put(pokeDataTem.type,catchedHash.get(pokeDataTem.type)+1);
                else
                    catchedHash.put(pokeDataTem.type,1);
            }
            else if(command.equals("run"))
            {
                //fake GUI
                System.out.println("==============================");
                System.out.println("=   You                      =");
                System.out.println("=              run away!     =");
                System.out.println("==============================");
                //score system
                if(pokeDataTem.type.equals("grass"))
                    score--;
                else
                    score++;
            }
            else if(command.equals("quit"));
            else
            {
                //fake GUI
                System.out.println("==============================");
                System.out.println("=       "+dirtyWords.get(randomDirtywords.nextInt(4))+"       =");
                System.out.println("=     "+pokeDataTem.name+"   run Away!   =");
                System.out.println("==============================");
            }
        }while(!command.equals("quit"));

        //quit game
        System.out.println("==============================");
        System.out.println("=     You quit the game!     =");
        System.out.println("=     Score: "+score+"              =");

        //use iterator to go through every kind you catch
        Iterator it = catchedHash.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey(); //get the type
            Object val = entry.getValue(); //get the numer
            System.out.println("=    "+key+": "+val+"         =");
        }
        System.out.println("==============================");
    }
}
