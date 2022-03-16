import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class waterBill {

    // ARRAYS AND LIST
    public static String[] eWallets = { "Paymaya", "GCash", "PayPal" };
    public static List eWalletLib = Arrays.asList(eWallets);

    public static void main(String[] args) {

        // 3 METHODS

        // VIA E-WALLET
        // NAME - ACCOUNT NO. - AMOUNT DUE
        // PAYMENT METHOD GCASH/PAYMAYA

        String fName;
        String lName;
        String accountNo;

        // Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Renz Kiosk Machine.");
        System.out.println(
                "You can pay your water bill using this machine, Please type your Full Name and Account No.: ");

        System.out.print("Type your First Name: ");
        fName = sc.nextLine();

        System.out.print("Type your Last Name: ");
        lName = sc.nextLine();

        System.out.print("Type your Account Number: ");
        accountNo = sc.nextLine();

        verification(fName, lName, accountNo);

    }

    // Method 1

    public static void verification(String firstName, String lastName, String accNo) {

        Scanner sc = new Scanner(System.in);

        String vFirstname = firstName;
        String vLastname = lastName;
        String vAccno = accNo;

        System.out.println("Is the information below are correct?");
        System.out.println("\n");
        System.out.println("Name: " + vFirstname + " " + vLastname);
        System.out.println("Account Number: " + vAccno);
        System.out.println("TYPE 1 if Correct, otherwise type 2.");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                choosePayment(accNo);
                System.out.println();
                break;

            case 2:
                System.out.println("Restarting System");
                System.out.println();
                main(null);
                break;
        }

    }

    // Method 2

    public static void choosePayment(String accNum) {

        String accNom = accNum;
        int userChoice;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Choose your E-WALLET");
        for (int i = 0; i < eWalletLib.size(); i++) {
            System.out.println((i + 1) + " - " + eWallets[i]);
        }

        System.out.print("E-WALLET: ");
        userChoice = sc.nextInt();
        String eWalletChoice = "0";

        if (userChoice == 1) {

            eWalletChoice = "Paymaya";

        }

        if (userChoice == 2) {

            eWalletChoice = "GCash";

        }

        if (userChoice == 3) {

            eWalletChoice = "PayPal";

        }

        System.out.println("\n");
        System.out.println("User chose: " + eWalletChoice);

        payment(eWalletChoice, accNom);

    }

    // Method 3

    public static void payment(String eWalletUser, String accpNuM) {
        String mop = eWalletUser;
        String accountNumberPayment = accpNuM;

        String contactNo;
        int amountDue;
        int userChoicePayment;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please type your Account No. in " + mop + " :");
        contactNo = sc.nextLine();

        System.out.println("\n");
        System.out.print("Please type the amount due: ");
        amountDue = sc.nextInt();

        System.out.println("Your paying for the account number: " + accountNumberPayment);
        System.out.println("For the amount of: " + amountDue);
        System.out.println(" ");
        System.out.println("Is this correct? Type 1 for Yes, otherwise 2");
        userChoicePayment = sc.nextInt();

        if (userChoicePayment == 1) {

            System.out.println("Payment Received");
            System.out.println("Thank you for using Renz Kiosk");

        }

        if (userChoicePayment == 2) {

            System.out.println("Restarting");
            payment(eWalletUser, accpNuM);

        }

    }

}
