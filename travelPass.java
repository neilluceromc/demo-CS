package Ange;

import java.lang.Runtime.Version;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.text.DecimalFormat;

public class travelPass {

    public static String[] finalLoc = { "Tarlac", "Pampanga", "Bulacan" };
    public static List finalLoclist = Arrays.asList(finalLoc);

    public static void main(String[] args) {

        System.out.println("This is A.N.G.E Travel Pass System, Kindly please state your information below: ");
        firstProcess();

    }

    // Method Here

    public static void firstProcess() {

        Scanner sc = new Scanner(System.in);

        String fName;
        String mInitial;
        String lName;
        String contactNo;
        String initialLoc;
        String verification;

        System.out.print("First Name: ");
        fName = sc.nextLine();
        System.out.print("Middle Initial: ");
        mInitial = sc.nextLine();
        System.out.print("Last Name: ");
        lName = sc.nextLine();
        System.out.print("Contact Number: ");
        contactNo = sc.nextLine();
        System.out.print("Initial Location: ");
        initialLoc = sc.nextLine();
        System.out.println("\n");

        System.out.println("Is the information below is correct? Type 'YES' if yes and type 'NO' if its incorrect: ");
        System.out.println("Name: " + fName + " " + mInitial + " " + lName);
        System.out.println("Contact Number: " + contactNo);
        System.out.println("Initial Location: " + initialLoc);
        System.out.println("\n");
        verification = sc.nextLine();

        if (verification.equals("YES")) {
            System.out.println();
            secondProcess(fName, mInitial, lName, contactNo, initialLoc);
        }

        if (verification.equals("NO")) {
            System.out.println();
            firstProcess();
        }

    }

    // Method 2 Here
    public static void secondProcess(String firstName, String midInitial, String lastName, String contactNum,
            String initialLocation) {

        Scanner sc = new Scanner(System.in);

        String fn = firstName;
        String mi = midInitial;
        String ln = lastName;
        String finalLocation;
        String cn = contactNum;
        String il = initialLocation;

        System.out.println("\n");
        System.out.println("Hello " + fn + " " + mi + " " + ln);
        System.out.println("Please choose your desired location below. Type the Corresponding Number: ");

        for (int i = 0; i < finalLoc.length; i++) {
            System.out.println(i + 1 + " - " + finalLoc[i]);
        }

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You have selected to travel to: Tarlac");
                System.out.println();
                finalLocation = "TARLAC";
                thirdProcess(fn, mi, ln, finalLocation, cn, il);
                System.out.println();
                break;

            case 2:
                System.out.println("You have selected to travel to: Pampanga");
                System.out.println();
                finalLocation = "PAMPANGA";
                thirdProcess(fn, mi, ln, finalLocation, cn, il);
                System.out.println();
                break;

            case 3:
                System.out.println("You have selected to travel to: Bulacan");
                System.out.println();
                finalLocation = "BULACAN";
                thirdProcess(fn, mi, ln, finalLocation, cn, il);
                System.out.println();
                break;
        }

        /*
         * if (choice == 1) // TARLAC
         * System.out.println("You have selected to travel to: Tarlac");
         * System.out.println();
         * finalLocation = "TARLAC";
         * thirdProcess(fn, mi, ln, finalLocation, cn, il);
         * System.out.println();
         * 
         * if (choice == 2) // PAMPANGA
         * System.out.println("You have selected to travel to: Pampanga");
         * System.out.println();
         * finalLocation = "PAMPANGA";
         * thirdProcess(fn, mi, ln, finalLocation, cn, il);
         * System.out.println();
         * 
         * if (choice == 3) // BULACAN
         * System.out.println("You have selected to travel to: Bulacan");
         * System.out.println();
         * finalLocation = "BULACAN";
         * thirdProcess(fn, mi, ln, finalLocation, cn, il);
         * System.out.println();
         */

        // 1 - TARLAC
        // 2 - PAMPANGA
        // 3 - BULACAN

    }

    // Method 3
    public static void thirdProcess(String tFname, String tMinitial, String tLname, String finalL, String tCn,
            String tInitialLoc) {

        int min_val = 1000000;
        int max_val = 2000000;
        double rand = Math.random() * (max_val - min_val);

        String thirdFname = tFname;
        String thirdMinitial = tMinitial;
        String thirdLastName = tLname;
        String thirdFinalLocation = finalL;
        String thirdContact = tCn;
        String thirdInitialLocation = tInitialLoc;
        DecimalFormat DF = new DecimalFormat("0");

        System.out.println("Travel Pass successfully generated! ");
        // NAME
        System.out.println("NAME: " + thirdFname + " " + thirdMinitial + " " + thirdLastName);
        // CONTACT NUMBER
        System.out.println("CONTACT NUMBER: " + thirdContact);
        // INITIAL LOCATION
        System.out.println("INITIAL LOCATION: " + thirdInitialLocation);
        // FINAL LOCATION
        System.out.println("DESTINATION: " + thirdFinalLocation);
        // ID NUMBER
        System.out.println("ID NUMBER: " + DF.format(rand));

        System.out.println("\n" + "Congratulation, have a safe trip!.");

    }

}