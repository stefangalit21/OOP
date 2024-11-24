public class Student {
    private String name;
    private Integer id;
    private boolean isGraduated;

    public Student(String name, Integer studentID) {
        this.name = name;
        this.id = studentID;
        this.isGraduated = false;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    public void graduate() {
        this.isGraduated = true;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + " Name: " + name + " Graduated: " + isGraduated;
    }
}