import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final int id;
    private final String name;
    private final Specialities speciality;
    private final List<Student> students;

    public Faculty(int id, String name, Specialities speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Specialities getField() {
        return speciality;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean graduateStudent(String studentID) {
        for (Student student : students) {
            if (student.getId().toString().equals(studentID)) {
                student.graduate();
                return true;
            }
        }
        return false;
    }

    public List<Student> getCurrentStudents() {
        List<Student> enrolledStudents = new ArrayList<>();
        for (Student student : students) {
            if (!student.isGraduated()) {
                enrolledStudents.add(student);
            }
        }
        return enrolledStudents;
    }

    public List<Student> getGraduatedStudents() {
        List<Student> graduates = new ArrayList<>();
        for (Student student : students) {
            if (student.isGraduated()) {
                graduates.add(student);
            }
        }
        return graduates;
    }
}