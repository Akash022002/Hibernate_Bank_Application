package Main.Demo;
import ServiceImpl.HDFCBank;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Configure.HibernateUtil;

public class BankMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int choice;
        HDFCBank f1 = new HDFCBank();

        do {
            System.out.println("Menu:");
            System.out.println("1 Create Account");
            System.out.println("2. View Details ");
            System.out.println("3. Deposite Money");
            System.out.println("4. WithDraw Money");
            System.out.println("5. Update_AccountDetails");
            System.out.println("6. Delete_Account");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	f1.Create_account();
                    break;
                case 2:
                    f1.view_details();
                    break;
                case 3:
                    f1.Deposite_Money();
                    break;
                case 4:
                    f1.Withdraw_Money();
                    break;
                case 5:
                    f1.Update_AccountDetails();;
                    break;
                case 6:
                    f1.Delete_Account();;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 4);

	}

}
