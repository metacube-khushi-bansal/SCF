import java.util.ArrayList;
import java.util.Scanner;

public class Marksheet {
    private ArrayList<Student> students;

    public Marksheet(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * Calculates the Average grade of all students
     * 
     * @return float- returns the average grade of all students present in the class
     * @throws ArithmeticException - throws an arithmetic exception if no. of
     *                             students present is zero
     */
    public float calcAvgOfGrades() {
        if (students.size() == 0)
            throw new ArithmeticException("Cannot calculate Average: No. of Students is zero");
        int sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        float average = (float) sum / students.size();
        return average;
    }

    /**
     * To calculate the maximum grade from the grades of all students
     * 
     * @return int- returns the maximum grade from a number of students
     * @throws ArithmeticException - throws an arithmetic exception if no. of
     *                             students present is zero
     */

    public int maximumOfAllGrades() {
        if (students.size() == 0)
            throw new ArithmeticException("Cannot calculate MAximum grade: No. of Students is zero");
        int maximumGrade = students.get(0).getGrade(); // initialise with 0th student
        for (Student student : students) {
            maximumGrade = Math.max(maximumGrade, student.getGrade());
        }
        return maximumGrade;
    }

    /**
     * To calculate the minimum grade from the grades of all students
     * 
     * @return int - returns the minimum grade from a number of students
     * @throws ArithmeticException - throws an arithmetic exception if no. of
     *                             students present is zero
     */
    public int minimumOfAllGrades() {
        if (students.size() == 0)
            throw new ArithmeticException("Cannot calculate Minumum grade: No. of Students is zero");
        int minimumGrade = students.get(0).getGrade(); // initialise with 0th student
        for (Student student : students) {
            minimumGrade = Math.min(minimumGrade, student.getGrade());
        }
        return minimumGrade;
    }

    /**
     * To calculate the Percentage of students passed when minuimum grade to pass is
     * 40
     * 
     * @return float - returns the percentage of students passed
     * @throws ArithmeticException - throws an arithmetic exception if no. of
     *                             students present is zero
     */
    public float calcPercentageOfStudentsPassed() {
        if (students.size() == 0)
            throw new ArithmeticException("Cannot calculate Percentage of Students passed: No. of Students is zero");
        int minimumGradeToPass = 40;
        int noOfStudentsPassed = 0;
        for (Student student : students) {
            if (student.getGrade() >= minimumGradeToPass)
                noOfStudentsPassed++;
        }

        float PercentageOfStudentsPassed = (float) noOfStudentsPassed / students.size() * 100;
        return PercentageOfStudentsPassed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        System.out.println("Enter the number of students: ");
        int noOfStudents = scanner.nextInt();

        for (int i = 0; i < noOfStudents; i++) {
            System.out.println("Enter the grades for " + (i + 1) + " student: ");
            int grade = scanner.nextInt();
            students.add(new Student(grade));
        }
        scanner.close();
        Marksheet marksheet = new Marksheet(students);
        try{
            System.out.printf("Average of grades of all students is: %.2f\n", marksheet.calcAvgOfGrades());
            System.out.println("Maximum of grades of all students is: " + marksheet.maximumOfAllGrades());
            System.out.println("Minimum of grades of all students is: " + marksheet.minimumOfAllGrades());
            System.out.printf("Pecentage of passed students is: %.2f\n", marksheet.calcPercentageOfStudentsPassed());
        }
       catch(ArithmeticException e ){
        System.out.println(e.getMessage());
       }
    }
}
