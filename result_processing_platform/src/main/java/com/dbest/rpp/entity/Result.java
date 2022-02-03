/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "result")
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findById", query = "SELECT r FROM Result r WHERE r.id = :id"),
    @NamedQuery(name = "Result.findByCa", query = "SELECT r FROM Result r WHERE r.ca = :ca"),
    @NamedQuery(name = "Result.findByExam", query = "SELECT r FROM Result r WHERE r.exam = :exam"),
    @NamedQuery(name = "Result.findByTotal", query = "SELECT r FROM Result r WHERE r.total = :total"),
    @NamedQuery(name = "Result.findByDateCreated", query = "SELECT r FROM Result r WHERE r.dateCreated = :dateCreated"),
    @NamedQuery(name = "Result.findByLastModified", query = "SELECT r FROM Result r WHERE r.lastModified = :lastModified")})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ca")
    private double ca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exam")
    private double exam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @JoinColumn(name = "course", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "semester", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Semester semester;
    @JoinColumn(name = "session", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CurrentSession session;

    public Result() {
    }

    public Result(Integer id) {
        this.id = id;
    }

    public Result(Integer id, double ca, double exam, double total, Date dateCreated) {
        this.id = id;
        this.ca = ca;
        this.exam = exam;
        this.total = total;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCa() {
        return ca;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public CurrentSession getSession() {
        return session;
    }

    public void setSession(CurrentSession session) {
        this.session = session;
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
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbest.rpp.entity.Result[ id=" + id + " ]";
    }
    
}
