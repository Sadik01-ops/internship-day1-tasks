package week1.task1;

public class Student {

    // 1️⃣ Private attributes (Encapsulation)
    private int id;
    private String name;
    private int age;
    private String course;

    // 2️⃣ Constructor
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // 3️⃣ Methods
    public void study() {
        System.out.println(name + " is studying");
    }

    public void attendClass() {
        System.out.println(name + " is attending class");
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }

    // 4️⃣ Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 5️⃣ toString()
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name +
                ", age=" + age + ", course=" + course + "]";
    }
}
