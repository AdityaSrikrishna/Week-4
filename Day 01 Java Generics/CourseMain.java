import java.util.ArrayList;
import java.util.List;
abstract class CourseType{
    private String name;
    private int id;
    public CourseType(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract void evaluate();
}
class ExamCourse extends CourseType{
    public ExamCourse(String name, int id){
        super(name, id);
    }
    @Override
    public void evaluate(){
        System.out.println("Evaluation: Final Exam.");
    }
}
class AssignmentCourse extends CourseType{
    public AssignmentCourse(String name, int id){
        super(name, id);
    }
    public void evaluate(){
        System.out.println("Evaluation: Multiple Asssignments.");
    }
}
class ResearchCourse extends CourseType{
    public ResearchCourse(String name, int id){
        super(name, id);
    }
    public void evaluate(){
        System.out.println("Evaluation: Research Paper Submission.");
    }
}
class Course<T extends CourseType>{
    private List<T> courses = new ArrayList<>();
    public void addCourse(T course){
        courses.add(course);
    }
    public void removeCourse(T course){
        courses.remove(course);
    }
    public List<T> getCourses(){
        return courses;
    }
    public static void displayCourses(List<? extends CourseType> courses){
        for(CourseType course : courses){
            System.out.println("Course Name: " + course.getName());
            System.out.println("Course ID: " + course.getId());
            course.evaluate();
            System.out.println("---------------");
        }
    }
}
public class CourseMain{
    public static void main(String[] args) {
        Course<ExamCourse> exam = new Course<>();
        exam.addCourse(new ExamCourse("Mathematics", 1211));
        exam.addCourse(new ExamCourse("Physics" , 1212));
        Course<AssignmentCourse> assignment = new Course<>();
        assignment.addCourse(new AssignmentCourse("English Literature", 1213));
        assignment.addCourse(new AssignmentCourse("History", 1214));

        // Create Research based courses
        Course<ResearchCourse> research = new Course<>();
        research.addCourse(new ResearchCourse("Artificial Intelligence", 1215));
        research.addCourse(new ResearchCourse("Quantum Computing", 1216));

        // Display all courses
        System.out.println("=== Exam Based Courses ===");
        Course.displayCourses(exam.getCourses());

        System.out.println("=== Assignment Based Courses ===");
        Course.displayCourses(assignment.getCourses());

        System.out.println("=== Research Based Courses ===");
        Course.displayCourses(research.getCourses());
    }
}