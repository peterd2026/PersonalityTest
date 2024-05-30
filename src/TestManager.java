import java.util.Scanner;

/**
 * Manage different tests
 */
public class TestManager {
    Personality p = new Personality();
    Scanner input = new Scanner(System.in);

    public void text() {
        boolean isR = true;
        while (isR) {
            System.out.println("Which test would you like to take?: ");
            System.out.println("1) Personality Test\t\t2) Anxiety/Stress level test");
            int res = input.nextInt();
            if (res == 1) {
                System.out.println("Welcome to personality test\n");
                System.out.println("This test will consist of a total of 60 questions\n");
                System.out.println("***************************************\n");
                p.showQuestion("PT Questions");
                isR = false;
            } else if (res == 2) {
                System.out.println("This area has not been activated yet");
                isR = true;
            } else {
                System.out.println("Please enter a valid answer");
                isR = true;
            }
        }
    }
}
