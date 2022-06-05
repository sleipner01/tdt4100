package eksamenOving.kode.eksamen2021.task8;

import java.util.Collection;
import java.util.function.Predicate;

import eksamenOving.kode.eksamen2021.task7.Course;
 
public class UniversityHandbookUtils {
 
    /**
     * Get all courses that matches the given predicate
     *
     * @param courses The list of courses to check for
     * @param p       The predicate that should be matched on
     *
     * @return A collection of courses that satisfy the predicate.
     */
    public static Collection<Course> getCoursesWithPredicate(Collection<Course> courses, Predicate<Course> p) {
        return courses.stream().filter(p).toList();
    }
 
    /**
     * Get all courses that does not have any prerequisites
     *
     * @param courses The list of courses to check for
     * @return A collection of course without any prerequisites
     */
    public static Collection<Course> getNonPrequisiteCourses(Collection<Course> courses) {
        return courses.stream().filter(course -> course.getPrerequisites().size() == 0).toList();
    }
     
    /**
     * Returns whether the handbook contains an impossible course. A course is
     * deemed impossible if any of the prerequisite of the course has the current
     * course as a prerequisite. Only direct dependencies need to be checked. You
     * do not need to worry about transitive dependencies. That means if TDT4100 has
     * a dependency on TDT4110 and TDT4110 has a dependency on TDT4100 it is impossible.
     *
     * A transitive dependency that does not need to be checked is if TDT4100 has a
     * dependency on TDT4110, TDT4110 has dependency on TDT4200 and TDT4200 has a
     * dependency on TDT4100.
     *
     * @param courses The list of courses to check for
     * @return whether the courses contains an impossible course
     */
    public static boolean containsImpossibleCourse(Collection<Course> courses) {
        return courses.stream().anyMatch(course -> course.getPrerequisites().stream().anyMatch(prerequesite -> prerequesite.getPrerequisites().contains(course)));
    }
}