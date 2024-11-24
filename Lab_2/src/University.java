import jdk.jfr.Unsigned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class University {
    private final String name;
    private final List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    void addFaculty(int id, String name, Specialities speciality) {
        faculties.add(new Faculty(id, name, speciality));
        Logger.log("Faculty added: " + name + " with ID: " + id);
    }

    public Faculty searchFaculty(String name) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(name)) {
                return faculty;
            }
        }
        Logger.log("Faculty not found: " + name);
        return null;
    }

    public Boolean enrollStudent(String facultyName, Student student) {
        Faculty faculty = searchFaculty(facultyName);
        if (faculty != null) {
            faculty.addStudent(student);
            Logger.log("Student enrolled: " + student.getName() + " " + student.getId() + " in faculty " + facultyName);
            return true;
        } else {
            Logger.log("Enrollment failed: Faculty " + facultyName + " not found");
            return false;
        }
    }

    public Boolean graduateStudent(String facultyName, String studentID) {
        Faculty faculty = searchFaculty(facultyName);
        if (faculty != null) {
            boolean result = faculty.graduateStudent(studentID);
            if (result) {
                Logger.log("Student graduated: ID " + studentID + " from faculty " + facultyName);
            } else {
                Logger.log("Cannot graduate student: ID " + studentID + " not found in faculty " + facultyName);
            }
            return result;
        }
        Logger.log("Graduation failed: Faculty " + facultyName + " not found");
        return false;
    }

    public void displayGraduatedStudents(String facultyName) {
        Faculty faculty = searchFaculty(facultyName);
        if (faculty != null) {
            List<Student> students = faculty.getStudents();
            for (Student student : students) {
                if (student.isGraduated()) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("No such faculty: " + facultyName);
        }
    }

    // Metodă pentru înrolarea studenților dintr-un fișier
    public void batchEnrollStudents(String fileName, String facultyName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Presupunem că fișierul are formatul "Nume, ID"
                if (parts.length == 2) {
                    String studentName = parts[0].trim();
                    int studentId = Integer.parseInt(parts[1].trim());
                    Student student = new Student(studentName, studentId);
                    enrollStudent(facultyName, student);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Metodă pentru absolvirea studenților dintr-un fișier
    public void batchGraduateStudents(String fileName, String facultyName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String studentID = line.trim();
                graduateStudent(facultyName, studentID);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void displayFaculties() {
        for (Faculty faculty : faculties) {
            System.out.println(faculty.getName() + " - " + faculty.getField());
        }
    }
}