package dtos;

import entities.Class;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bendico
 */
public class ClassesDTO {
    
    
        List<ClassDTO> all = new ArrayList();

    public ClassesDTO(List<Class> classEntities) {
        classEntities.forEach((cl) -> {
            all.add(new ClassDTO(cl));
        });
    }
    
    
}
