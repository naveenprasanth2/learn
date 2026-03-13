import com.telusko.learn.health.Student;

void main() {
    Student student = new Student("naveen", 22);

    switch (student) {
        case Student(String name, int _) -> System.out.println(name);
        case null -> System.out.println("Its null");
        case Student s when s.name().equals("summa") -> System.out.println("The name is summa");
        default -> System.out.println("not a student");
    }
}