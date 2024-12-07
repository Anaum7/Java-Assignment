class Student {
    private String name;
    private int id;
    private double[] grades;
    private int gradeCount;

    public Student(String name, int id, int maxGrades) {
        this.name = name;
        this.id = id;
        this.grades = new double[maxGrades];
        this.gradeCount = 0;
    }

    public void addGrade(double grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount++] = grade;
        }
    }

    public double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return gradeCount > 0 ? sum / gradeCount : 0;
    }

    public double findHighestGrade() {
        double highest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }

    public double findLowestGrade() {
        double lowest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }

    public void displayReport() {
        System.out.println("Student: " + name + " (ID: " + id + ")");
        System.out.println("Average Grade: " + calculateAverage());
        System.out.println("Highest Grade: " + findHighestGrade());
        System.out.println("Lowest Grade: " + findLowestGrade());
        System.out.println();
    }
}

public class Student {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 1, 5);
        student1.addGrade(85.5);
        student1.addGrade(90.0);
        student1.addGrade(78.5);

        Student student2 = new Student("Bob", 2, 5);
        student2.addGrade(92.0);
        student2.addGrade(88.5);
        student2.addGrade(95.0);

        student1.displayReport();
        student2.displayReport();
    }
}