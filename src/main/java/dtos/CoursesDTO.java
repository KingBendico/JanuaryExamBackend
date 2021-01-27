package dtos;

import entities.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bendico
 */
public class CoursesDTO {
    
        List<CourseDTO> all = new ArrayList();

    public CoursesDTO(List<Course> courseEntities) {
       courseEntities.forEach((co) -> {
            all.add(new CourseDTO(co));
        });
    }
    
    
}
