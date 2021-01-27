/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bendico
 */
@Entity
@Table(name = "Teacher_has_Class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherhasClass.findAll", query = "SELECT t FROM TeacherhasClass t"),
    @NamedQuery(name = "TeacherhasClass.findByTeacherid", query = "SELECT t FROM TeacherhasClass t WHERE t.teacherhasClassPK.teacherid = :teacherid"),
    @NamedQuery(name = "TeacherhasClass.findByClassid", query = "SELECT t FROM TeacherhasClass t WHERE t.teacherhasClassPK.classid = :classid")})
public class TeacherhasClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeacherhasClassPK teacherhasClassPK;
    @JoinColumns({
        @JoinColumn(name = "Class_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "Class_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Class class1;
    @JoinColumns({
        @JoinColumn(name = "Teacher_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "Teacher_id", referencedColumnName = "id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Teacher teacher;

    public TeacherhasClass() {
    }

    public TeacherhasClass(TeacherhasClassPK teacherhasClassPK) {
        this.teacherhasClassPK = teacherhasClassPK;
    }

    public TeacherhasClass(int teacherid, int classid) {
        this.teacherhasClassPK = new TeacherhasClassPK(teacherid, classid);
    }

    public TeacherhasClassPK getTeacherhasClassPK() {
        return teacherhasClassPK;
    }

    public void setTeacherhasClassPK(TeacherhasClassPK teacherhasClassPK) {
        this.teacherhasClassPK = teacherhasClassPK;
    }

    public Class getClass1() {
        return class1;
    }

    public void setClass1(Class class1) {
        this.class1 = class1;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherhasClassPK != null ? teacherhasClassPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherhasClass)) {
            return false;
        }
        TeacherhasClass other = (TeacherhasClass) object;
        if ((this.teacherhasClassPK == null && other.teacherhasClassPK != null) || (this.teacherhasClassPK != null && !this.teacherhasClassPK.equals(other.teacherhasClassPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TeacherhasClass[ teacherhasClassPK=" + teacherhasClassPK + " ]";
    }
    
}
