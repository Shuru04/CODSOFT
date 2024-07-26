import java.util.Scanner;

public class StudentGetData {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        char choice;
        do{
        System.out.println("Enter the number of Subjects : ");
        int sub=sc.nextInt();
        double[] marks=new double[sub];
        double sum=0;
       // double totalmarks=sub*100;
        for(int i=0;i<sub;i++){
            System.out.println("Enter marks got in Subject "+(i+1)+" out of 100 : ");
            marks[i]= sc.nextDouble();
            sum=sum+marks[i];
        }
        System.out.println("--------------------------------------------------------------------------");
      System.out.println("Total Marks obtained of "+sub*100+" are : "+sum);
       double avgPercent= calculateAvgPercentage(sum,sub);
       System.out.println("Average Percentage is : "+avgPercent);
       String str=gradeCalcultion(avgPercent);
       System.out.println("Grade Obtained : "+str);
        System.out.println("--------------------------------------------------------------------------");
            System.out.println("Do you want to enter data for another student? (Y/N): ");
            choice = sc.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');

        sc.close();
    }
    public static double calculateAvgPercentage(double sum,double sub){
        double avgpercent=(sum/sub);
        //System.out.println("Average percentage Obtained out of 100 is : "+avgpercent);
        return avgpercent;
    }
    public static String gradeCalcultion(double avgPercent){
        if (avgPercent >= 90) {
            return "A+";
        } else if (avgPercent>= 80) {
            return "A";
        } else if (avgPercent >= 70) {
            return "B+";
        } else if (avgPercent >= 60) {
            return "B";
        } else if (avgPercent >= 50) {
            return "C";
        } else if (avgPercent >= 40) {
            return "D";
        } else {
            return "Fail";
        }

    }

}
