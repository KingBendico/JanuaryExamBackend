package dtos;

import entities.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bendico
 */
public class TeachersDTO {
    
    
        List<TeacherDTO> all = new ArrayList();

    public TeachersDTO(List<Teacher> teacherEntities) {
        teacherEntities.forEach((t) -> {
            all.add(new TeacherDTO(t));
        });
    }
    
}
