/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;
import entities.Class;
import entities.Course;

/**
 *
 * @author Bendico
 */
public class CourseDTO {
    
    private Integer id;
    private String courseName;
    private String description;
    private entities.Class class1;

    public CourseDTO(Course course) {
 //       this.id = course.getId();
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
 //       this.class1 = course.getClass1();
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class getClass1() {
        return class1;
    }

    public void setClass1(Class class1) {
        this.class1 = class1;
    }
    
    
    
    
    
}
