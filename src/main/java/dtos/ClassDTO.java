/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;
import entities.Class;

/**
 *
 * @author Bendico
 */
public class ClassDTO {
    
    
    private String semester;
    private Integer numberOfStudents;

    public ClassDTO(Class c) {
        this.semester = c.getSemester();
        this.numberOfStudents = c.getNumberOfStudents();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    
    
    
}
