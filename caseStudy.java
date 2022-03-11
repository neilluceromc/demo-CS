import java.util.Scanner;
import java.text.DecimalFormat;

public class caseStudy {

    public static void main (String[] args) {

        //Scanner
        Scanner sc = new Scanner (System.in);

        //Variables
        int input;
        float classnum; 

        //User Input 1 
        System.out.print("Enter Number of Class: ");
        classnum = sc.nextInt();

        //User Input 2
        System.out.print("Enter Number of Samples: ");
        input = sc.nextInt();

        firstProcess(input, classnum);
        sc.close();
    }

    public static void firstProcess(int iNum, float cNum) {

        // For getting how many numbers in the table
        int classNum = (int)cNum;
        int inputNum = iNum;
        int []numbers = new int[iNum];
        int LowLimit[] = new int[classNum];
        int UpLimit[] = new int[classNum];
        
        double highestNum, lowestNum, width;
        
        // Scanner
        Scanner sc = new Scanner (System.in);

        //Enter User Data Input
        for (int i = 0; i < iNum; i++) {
            System.out.print("Enter Data Number: " + (i+1) + ": ");
            numbers[i] = sc.nextInt();
        }

        //Getting Highest and Lowest Data

        highestNum = numbers[0]; //Going to used in getting Midpoint
        lowestNum = numbers[0]; // 

        for (int i = 0; i < numbers.length; i++) {
           if (lowestNum > numbers[i])
           lowestNum = numbers[i];

           if (highestNum < numbers[i])
           highestNum = numbers[i];
        }

        //Getting Width
        width = Math.ceil(((highestNum-lowestNum)/classNum));
        int valWidth = (int)width;

        //Getting Range (Unused)
        double range;
        range = (double)highestNum - (double)lowestNum;

        System.out.println("Maximum Value is " + highestNum + " and the Minimum Value is " + lowestNum);
        System.out.println("Width is " + valWidth);

        //Getting Upper Limit and Lower Limit 2.0
        //Variables
        int valminval = (int)lowestNum;
        int mincounter = valminval;
        int maxcounter = valminval + (valWidth - 1);

        //Getting the Values of Upper Limit and Lower Limit
        for (int x = 0; x < classNum; x++) {

            if (x == 0) {
                LowLimit[x] = valminval;
                UpLimit[x] = valminval + (valWidth - 1);
            }

            else {
                LowLimit[x] = mincounter;
                UpLimit[x] = maxcounter;
            }

            mincounter += valWidth;
            maxcounter += (valWidth);
        }

        //Frequency

        int[] freq = new int [classNum];
        int counterfreq = 0;

        for (int i = 0; i < classNum; i++){
            
            for (int j = 0; j < numbers.length; j++) {
                
                if (numbers[j] >= LowLimit[i] && numbers[j] <= UpLimit[i]) {
                    counterfreq += 1;
                }
            }

            freq[i] = counterfreq;
            counterfreq = 0;
        }

        //Midpoint
        double[] midpoint = new double[classNum];

        for (int i = 0; i < classNum; i++) {
            midpoint[i] = (((double)LowLimit[i] + UpLimit[i])/2);
        }

        //Cummulalative Frequency
        int[] CF = new int[classNum];
        
        for (int i = 0; i < classNum; i++) {
            if (CF[i] == CF[0]){
                CF[i] = freq [i];
            }

            else {
                CF[i] = CF[i-1] + freq[i];
            }
        }

        //Relative Frequency
        double [] RF = new double[classNum];

        for (int i = 0; i < classNum; i++) {
            RF[i] = (double)freq[i]/inputNum;
        }

        //Class Boundaries for adding and subtracting values to Upperlimit and Lower Limit
        double constantB = 0.5;

        //Round Off Decimals for Relative Frequency
        DecimalFormat DF = new DecimalFormat("0.00");

        //Printing
        System.out.println("LOWER LIMIT" + "\t" + "UPPER LIMIT" + "\t" + "F" + "\t" + "MIDPOINT" + "\t" + "RELATIVE FREQUENCY"
        + "\t" + "CUMULATIVE FREQUENCY" + "\t\t" + "CLASS BOUNDARIES");

            for (int i = 0; i < classNum; i++) {
                System.out.println(LowLimit[i] + "\t\t" + UpLimit[i] + "\t\t" + freq[i] + "\t" + midpoint[i] + "\t\t\t" + 
                DF.format(RF[i]) + "\t\t\t" + CF[i] + "\t\t\t" + (LowLimit[i] - constantB) + "   -   " + (UpLimit[i] + constantB));
    
            }

            sc.close();
    }
}