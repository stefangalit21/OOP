

public class Main {
    public static void main(String[] args) {

        University university = new University("Tech University");


        university.addFaculty(1, "Computer Science", Specialities.InformationalTechnology);
        university.addFaculty(2, "Data Science", Specialities.DataScience);


        Student student1 = new Student("Alice", 1001);
        Student student2 = new Student("Bob", 1002);


        university.enrollStudent("Computer Science", student1);
        university.enrollStudent("Computer Science", student2);


        university.graduateStudent("Computer Science", "1001");


        System.out.println("Graduated students from Computer Science:");
        university.displayGraduatedStudents("Computer Science");


        university.batchEnrollStudents("students_to_enroll.txt", "Data Science");


        university.batchGraduateStudents("students_to_graduate.txt", "Data Science");


        System.out.println("\nOperation Logs:");
        for (String log : Logger.getLogs()) {
            System.out.println(log);
        }
    }
}