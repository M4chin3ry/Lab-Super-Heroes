import java.util.Arrays;
import java.util.Comparator;

public class SuperheroRoster {
    public static void main(String[] args) {
        String[] heroNames = {"Spider-Man", "Iron Man", "Black Widow"};
        String[] abilities = {"Web-slinging", "Flying and high-tech armor", "Stealth and combat"};
        int[] powerLevels = {85, 90, 80};
        System.out.println("All Superheroes:");
        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Name: " + heroNames[i]);
            System.out.println("Ability: " + abilities[i]);
            System.out.println("Power Level: " + powerLevels[i]);
            System.out.println("-------------------------");
        }
        String targetHero = "Iron Man";
        System.out.println("Searching for: " + targetHero);
        searchHero(heroNames, abilities, powerLevels, targetHero);
        double average = calculateAveragePower(powerLevels);
        System.out.println("\nAverage Power Level: " + average);

        Superhero[] heroes = new Superhero[heroNames.length];
        for (int i = 0; i < heroNames.length; i++) {
            heroes[i] = new Superhero(heroNames[i], abilities[i], powerLevels[i]);
        }
        System.out.println("\nUsing Superhero objects:");
        for (Superhero hero : heroes) {
            hero.displayHero();
        }
        sortHeroesByPower(heroes);
    }
    public static void searchHero(String[] names, String[] abilities, int[] powerLevels, String target) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("Hero found:");
                System.out.println("Name: " + names[i]);
                System.out.println("Ability: " + abilities[i]);
                System.out.println("Power Level: " + powerLevels[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Hero not found: " + target);
        }
    }
    public static double calculateAveragePower(int[] powerLevels) {
        int sum = 0;
        for (int power : powerLevels) {
            sum += power;
        }
        return (double) sum / powerLevels.length;
    }
    public static void sortHeroesByPower(Superhero[] heroes) {
        Arrays.sort(heroes, new Comparator<Superhero>() {
            public int compare(Superhero h1, Superhero h2) {
                return Integer.compare(h2.getPowerLevel(), h1.getPowerLevel()); // Descending
            }
        });
        System.out.println("\nHeroes sorted by power level (descending):");
        for (Superhero hero : heroes) {
            hero.displayHero();
        }
    }
}
