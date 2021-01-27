/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bendico
 */
@Entity
@Table(name = "Class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c"),
    @NamedQuery(name = "Class.findById", query = "SELECT c FROM Class c WHERE c.id = :id"),
    @NamedQuery(name = "Class.findBySemester", query = "SELECT c FROM Class c WHERE c.semester = :semester"),
    @NamedQuery(name = "Class.findByNumberOfStudents", query = "SELECT c FROM Class c WHERE c.numberOfStudents = :numberOfStudents")})
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "semester")
    private String semester;
    @Column(name = "numberOfStudents")
    private Integer numberOfStudents;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "class1")
    private TeacherhasClass teacherhasClass;
    @JoinColumns({
        @JoinColumn(name = "Course_id", referencedColumnName = "id"),
        @JoinColumn(name = "Course_id", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private Course course;

    public Class() {
    }

    public Class(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public TeacherhasClass getTeacherhasClass() {
        return teacherhasClass;
    }

    public void setTeacherhasClass(TeacherhasClass teacherhasClass) {
        this.teacherhasClass = teacherhasClass;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Class[ id=" + id + " ]";
    }
    
}
