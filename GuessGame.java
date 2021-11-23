import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int trycounter = 1;
        int secretnr = random.nextInt(10);
        int tries = 3;

        while (trycounter <= tries) {
            System.out.println("Enter a number: ");
            int guessednr = input.nextInt();

            if (guessednr < secretnr && guessednr != secretnr) {
                System.out.println("\nGo higher\n");
            } else if (guessednr > secretnr && guessednr != secretnr) {
                System.out.println("\nGo lower\n");
            } else if (guessednr == secretnr) {
                System.out.println("\nCongrats you found the secret number " + trycounter + " tries!\n");
                break;
            }

            trycounter++;

        }
        if (trycounter == 4) {
            System.out.println(
                    "\nGAME OVER!!!\n" + "The secret number was " + secretnr + "\nYou tried " + tries + " times");
        }
    }
}
