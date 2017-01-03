/**
 * Created by PeakeAndSons on 2016-12-30.
 */
public class Student extends Person {
    private int[] testScores;
    //so you dont get an error and have to change the other class...
    Student(String firstName, String lastName, int identification) {
        super(firstName, lastName, identification);
    }
    //used constructor
    Student(String firstName, String lastName, int identification,int[] testScores)
    {
        this(firstName, lastName, identification);
        this.testScores = testScores;
    }

    public String calculate()
    {
        String grade = null;
        int subjectCount = testScores.length;

        double total = 0;
        for (int i = 0; i < testScores.length; i++)
        {
            total = total + testScores[i];

        }

        double average = total / subjectCount;

        if (average >= 90 && average <= 100)
            grade = "O";
        else if (average >= 80 && average < 90)
            grade = "E";
        else if (average >= 70 && average < 80)
            grade = "A";
        else if (average >= 55 && average < 70)
            grade = "P";
        else if (average >= 40 && average < 55)
            grade = "D";
        else if (average < 40)
            grade = "T";

        return grade;
    }
}
