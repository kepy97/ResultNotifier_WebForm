/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sonav
 */
@Entity
@Table(name = "studentdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentdetails.findAll", query = "SELECT s FROM Studentdetails s"),
    @NamedQuery(name = "Studentdetails.findById", query = "SELECT s FROM Studentdetails s WHERE s.id = :id"),
    @NamedQuery(name = "Studentdetails.findByFirstName", query = "SELECT s FROM Studentdetails s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Studentdetails.findByLastName", query = "SELECT s FROM Studentdetails s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Studentdetails.findByMobile", query = "SELECT s FROM Studentdetails s WHERE s.mobile = :mobile"),
    @NamedQuery(name = "Studentdetails.findByEmailID", query = "SELECT s FROM Studentdetails s WHERE s.emailID = :emailID"),
    @NamedQuery(name = "Studentdetails.findBySemester", query = "SELECT s FROM Studentdetails s WHERE s.semester = :semester"),
    @NamedQuery(name = "Studentdetails.findByCollege", query = "SELECT s FROM Studentdetails s WHERE s.college = :college"),
    @NamedQuery(name = "Studentdetails.findByResult", query = "SELECT s FROM Studentdetails s WHERE s.result = :result")})
public class Studentdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Mobile")
    private String mobile;
    @Basic(optional = false)
    @Column(name = "EmailID")
    private String emailID;
    @Basic(optional = false)
    @Column(name = "Semester")
    private String semester;
    @Column(name = "College")
    private String college;
    @Basic(optional = false)
    @Column(name = "Result")
    private String result;

    public Studentdetails() {
    }

    public Studentdetails(Integer id) {
        this.id = id;
    }

    public Studentdetails(Integer id, String firstName, String mobile, String emailID, String semester, String result) {
        this.id = id;
        this.firstName = firstName;
        this.mobile = mobile;
        this.emailID = emailID;
        this.semester = semester;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        if (!(object instanceof Studentdetails)) {
            return false;
        }
        Studentdetails other = (Studentdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modal.Studentdetails[ id=" + id + " ]";
    }
    
}
