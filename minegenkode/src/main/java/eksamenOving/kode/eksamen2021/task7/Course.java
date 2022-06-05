package eksamenOving.kode.eksamen2021.task7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
public class Course {
    // The name of the course
    private String courseName;
    // A list of course prerequisites for this course. This means that all the courses in this list should be taken before this one.
    private List<Course> prerequisites = new ArrayList<>();
    // The average grade of the course
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
     
    /**
     * Adds a new prerequisite to this course
     * @param course The course to add
     */
    public void addPrequisite(Course course) {
        this.prerequisites.add(course);
    }
     
    /**
     *
     * @return A copy of the list of prerequisites
     */
    public Collection<Course> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }
     
    public String toString() {
        return this.courseName;
    }
 
}