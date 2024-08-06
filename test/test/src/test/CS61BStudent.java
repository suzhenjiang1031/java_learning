package test;

public class CS61BStudent { // Class Declaration
    public int idNumber; // Instance Variables
    public int grade;
    public static String instructor = "Hug"; // Class (Static) Variables
    public CS61BStudent(int id) { // Constructor
        this.idNumber = id;
        this.grade = 100;
    }

    public boolean watchLecture() { // Instance Method
// Returns whether the student actually watched the lecture
        return true;
    }
    public static String getInstructor() { // Static Method
        return instructor;
    }

    public static void main(String[] args) {
        CS61BStudent student = new CS61BStudent(12345);
        System.out.println("Student ID: " + student.idNumber);
        System.out.println("Student Grade: " + student.grade);
        System.out.println("Watched Lecture: " + student.watchLecture());
        System.out.println("Instructor: " + CS61BStudent.getInstructor());
    }
}
