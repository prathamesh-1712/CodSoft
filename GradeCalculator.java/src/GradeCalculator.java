import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter no. of Subjects:-");
        int numSubjects= scanner.nextInt();
        int totalMarks=0;
        for (int i=1;i<=numSubjects;i++){
            System.out.println("Enetr marks Obtained in Each Subject"+i+":-");
            int marks= scanner.nextInt();
            if (marks<0 ||marks>100){
                System.out.println("Invalid Marks!,Enter marks between 0 to 100.Exiting");
                System.exit(0);
            }
            totalMarks += marks;
        }
        double avgPercentage=(double) totalMarks/numSubjects;
        char grade;
        if (avgPercentage>=90){
            grade='A';
        } else if (avgPercentage>=80) {
            grade='B';
        } else if (avgPercentage>=70) {
            grade='C';
        } else if (avgPercentage>=60) {
            grade='D';
        }else {
            grade='F';
        }
        System.out.println("\nResults=");
        System.out.println("Total Marks="+totalMarks);
        System.out.println("AvgPercentage="+avgPercentage);
        System.out.println("Grade="+grade);
    }
}