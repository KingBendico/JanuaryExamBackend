package dtos;
import entities.Teacher;

/**
 *
 * @author Bendico
 */

public class TeacherDTO {
    
   
    private Integer id;
    private String name;
    private String email;

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.email = teacher.getEmail();
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    
}
