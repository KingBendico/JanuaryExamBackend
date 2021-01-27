/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bendico
 */
@Embeddable
public class TeacherhasClassPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Teacher_id")
    private int teacherid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Class_id")
    private int classid;

    public TeacherhasClassPK() {
    }

    public TeacherhasClassPK(int teacherid, int classid) {
        this.teacherid = teacherid;
        this.classid = classid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) teacherid;
        hash += (int) classid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherhasClassPK)) {
            return false;
        }
        TeacherhasClassPK other = (TeacherhasClassPK) object;
        if (this.teacherid != other.teacherid) {
            return false;
        }
        if (this.classid != other.classid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TeacherhasClassPK[ teacherid=" + teacherid + ", classid=" + classid + " ]";
    }
    
}
