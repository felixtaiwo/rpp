/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "entry_year")
@NamedQueries({
    @NamedQuery(name = "EntryYear.findAll", query = "SELECT e FROM EntryYear e"),
    @NamedQuery(name = "EntryYear.findById", query = "SELECT e FROM EntryYear e WHERE e.id = :id"),
    @NamedQuery(name = "EntryYear.findByYear", query = "SELECT e FROM EntryYear e WHERE e.year = :year"),
    @NamedQuery(name = "EntryYear.findByDateCreated", query = "SELECT e FROM EntryYear e WHERE e.dateCreated = :dateCreated"),
    @NamedQuery(name = "EntryYear.findByLastModified", query = "SELECT e FROM EntryYear e WHERE e.lastModified = :lastModified")})
public class EntryYear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @OneToMany(mappedBy = "yearOfEntry")
    private List<Student> studentList;
    @JoinColumn(name = "session", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AcademicSession session;
    @JoinColumn(name = "grade_scale", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GradeScale gradeScale;

    public EntryYear() {
    }

    public EntryYear(Integer id) {
        this.id = id;
    }

    public EntryYear(Integer id, Date year, Date dateCreated) {
        this.id = id;
        this.year = year;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public AcademicSession getSession() {
        return session;
    }

    public void setSession(AcademicSession session) {
        this.session = session;
    }

    public GradeScale getGradeScale() {
        return gradeScale;
    }

    public void setGradeScale(GradeScale gradeScale) {
        this.gradeScale = gradeScale;
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
        if (!(object instanceof EntryYear)) {
            return false;
        }
        EntryYear other = (EntryYear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbest.rpp.entity.EntryYear[ id=" + id + " ]";
    }
    
}
