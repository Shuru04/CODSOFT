import java.util.*;

public class NumberGuessTask {
    private static final int max_chances = 5;
    private static final int max_range = 1;
    private static final int min_range = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int tscore = 0;
        char choice;
        do {
           // while (playAgain) {
                int genNumber = random.nextInt(100) + 1;
                int chances = 0;
                boolean correctGuess = false;
                System.out.println("A number between 1 to 100 is generated .Try to guess it !!! ");
                System.out.println("You have 5 chances .");

                while (chances < max_chances && !correctGuess) {
                    System.out.println("Guess a number  : ");
                    int guessNum = sc.nextInt();
                    chances++;
                    if (guessNum == genNumber) {
                        System.out.println("Excellent  !!! Your guess is on Spot .");
                        correctGuess = true;
                        tscore = tscore + (max_chances - chances + 1);
                    } else if (guessNum > genNumber) {
                        System.out.println("Too High !! Get it in another Shot.");
                    } else {
                        System.out.println("Too Low  !! You're almost there. ");
                    }

                }

                if (!correctGuess) {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("OOPS!! You have exhausted your chances .");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("The right guess is : " + genNumber);
                }
                    System.out.println("---------------------------------------------------------");
                System.out.println("Score status : " + tscore);


            System.out.println(" Wanna play again ?(yes/no) : ");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y') ;

        sc.close();
        System.out.println("Thanks for playing !!");
    }

}