import java.util.Scanner;
import java.util.Random;

public class gambling_game {

    public static void main(String[] args) {
        char[] machine = {'O', 'X', '#'};
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        System.out.println("SLOT MACHINE PROGRAM    ");
        System.out.println("2XMONEY EVERY TIME YOU WIN");
        System.out.println("___________________________________________");
        System.out.println("play game?");
        System.out.print("yes or no: ");
        String S = scan.nextLine();
        System.out.print("please enter some money into machine: ");
        int balance = scan.nextInt();
        String choice;
        if (S.equals("yes")) {

            do {
                System.out.print("enter the amount of money you want to bet: ");
                int bet = scan.nextInt();
                if (bet > balance) {
                    System.out.println("insufficient funds, please add more money to the machine");
                    break;
                }
                balance -= bet;
                System.out.println("machine is running...");
                char [] result = new char[3];
                for(int i = 0; i<=2;i++){
                    char res = machine[random.nextInt(3)];
                    result[i] = res;
                    System.out.print(res+ " | ");
                }
                System.out.println();
                if(result[0] == result[1] && result[0] == result[2]){
                    System.out.println("YOU WIN");
                    System.out.println("The money has been added to your balance");
                    int k = bet*2;
                    balance += k;
                    System.out.println("your current balance is: " + balance);
                    System.out.println("you have won "+ bet + "amount of money");
                    System.out.println("-_-_-_-_--_-_-_-_--_-_-_-_--_-_-_-_--_-_-_-_-");
                }else{
                    System.out.println("you lost :(");
                    System.out.println("better luck next time");
                    System.out.println("your current balance is: " + balance);
                    System.out.println("you have lost "+ bet + "from your main balance");
                    System.out.println("-_-_-_-_--_-_-_-_--_-_-_-_--_-_-_-_--_-_-_-_-");
                }
                System.out.print("play again? (yes or no): ");
                scan.nextLine(); // Add this to consume the leftover newline from scan.nextInt()
                choice = scan.nextLine();
                choice = choice.toLowerCase();

            }while(!choice.equals("no"));
        }

    }
}
