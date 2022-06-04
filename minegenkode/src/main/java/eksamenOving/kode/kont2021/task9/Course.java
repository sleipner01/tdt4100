package eksamenOving.kode.kont2021.task9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
public class Course {
    private String courseName;
    private List<Course> prerequisites = new ArrayList<>();
    private double averageGrade;
 
    public Course(String courseName, double averageGrade) {
        this(courseName);
        this.averageGrade = averageGrade;
    }
 
    public Course(String courseName) {
        this.courseName = courseName;
    }
     
    public String getCourseName() {
        return courseName;
    }
 
    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
     
    public double getAverageGrade() {
        return averageGrade;
    }
 
    public void addPrequisite(Course course) {
        this.prerequisites.add(course);
    }
     
    public Collection<Course> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }
     
    public String toString() {
        return this.courseName;
    }
 
}
