import java.util.concurrent.ThreadLocalRandom;

public class Teste {
	enum Animal {
	    ELEPHANT, LION, TIGER, WASP, SNAKE, MONKEY, EMU
	}

    // It's not clear from the question if you're provided with this or if you have to write it
    private static class RandomTools {
        public static int randomValue(int start, int end) {
            return ThreadLocalRandom.current().nextInt(start, end);
        }
    }

    public static void main(String[] args) {
		
    	 Animal[] zoo = generateRandomZoo(100);
         // Printing to STDOUT to check results
         for (int i = 0; i < zoo.length; i++) {
             System.out.println(zoo[i]);
         }
	}
       
    

    private static Animal[] generateRandomZoo(int numberOfAnimals) {
        Animal[] animals = new Animal[numberOfAnimals];
        Animal[] values = Animal.values();
        for (int i = 0; i < animals.length; i++) {
            int random = RandomTools.randomValue(0, values.length);
            animals[i] = values[random];
        }
        return animals;
    }
}