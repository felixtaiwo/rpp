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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author felix
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Student.findByOthername", query = "SELECT s FROM Student s WHERE s.othername = :othername"),
    @NamedQuery(name = "Student.findByMatricNumber", query = "SELECT s FROM Student s WHERE s.matricNumber = :matricNumber"),
    @NamedQuery(name = "Student.findByEmailAddress", query = "SELECT s FROM Student s WHERE s.emailAddress = :emailAddress"),
    @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password"),
    @NamedQuery(name = "Student.findByTnu", query = "SELECT s FROM Student s WHERE s.tnu = :tnu"),
    @NamedQuery(name = "Student.findByTgp", query = "SELECT s FROM Student s WHERE s.tgp = :tgp"),
    @NamedQuery(name = "Student.findByCgpa", query = "SELECT s FROM Student s WHERE s.cgpa = :cgpa"),
    @NamedQuery(name = "Student.findByDateCreated", query = "SELECT s FROM Student s WHERE s.dateCreated = :dateCreated"),
    @NamedQuery(name = "Student.findByLastModified", query = "SELECT s FROM Student s WHERE s.lastModified = :lastModified")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 45)
    @Column(name = "othername")
    private String othername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "matric_number")
    private String matricNumber;
    @Size(max = 45)
    @Column(name = "email_address")
    private String emailAddress;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "tnu")
    private Integer tnu;
    @Column(name = "tgp")
    private Integer tgp;
    @Column(name = "cgpa")
    private Integer cgpa;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @JoinTable(name = "student_course", joinColumns = {
        @JoinColumn(name = "student", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "course", referencedColumnName = "id")})
    @ManyToMany
    private List<Course> courseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Result> resultList;
    @JoinColumn(name = "year_of_entry", referencedColumnName = "id")
    @ManyToOne
    private EntryYear yearOfEntry;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(Integer id, String matricNumber) {
        this.id = id;
        this.matricNumber = matricNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTnu() {
        return tnu;
    }

    public void setTnu(Integer tnu) {
        this.tnu = tnu;
    }

    public Integer getTgp() {
        return tgp;
    }

    public void setTgp(Integer tgp) {
        this.tgp = tgp;
    }

    public Integer getCgpa() {
        return cgpa;
    }

    public void setCgpa(Integer cgpa) {
        this.cgpa = cgpa;
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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public EntryYear getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(EntryYear yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbest.rpp.entity.Student[ id=" + id + " ]";
    }
    
}
