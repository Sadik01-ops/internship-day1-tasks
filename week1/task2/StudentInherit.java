package week1.task2;

public class StudentInherit extends Person {

    private String course;

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void showDetails() {
        System.out.println(getPname());
        System.out.println(getAge());
        System.out.println(course);
    }

    // ✅ ADD THIS METHOD (this fixes the error)
    public void study() {
        System.out.println("Student is studying");
    }
}
