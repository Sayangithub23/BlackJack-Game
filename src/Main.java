import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Game game = new Game(100);
        Scanner scanner = new Scanner(System.in);
        while (true){

            System.out.println("Do you want to play again? Y/N");
            String again = scanner.next().toLowerCase();
            if(!again.equals("y")){
                break;
            }
        }

        System.out.println("Thanks For Playing! 😊");
        scanner.close();
    }
}