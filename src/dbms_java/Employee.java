/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_java;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "employee", catalog = "postgres", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEid", query = "SELECT e FROM Employee e WHERE e.eid = :eid"),
    @NamedQuery(name = "Employee.findByEname", query = "SELECT e FROM Employee e WHERE e.ename = :ename"),
    @NamedQuery(name = "Employee.findByEmphono", query = "SELECT e FROM Employee e WHERE e.emphono = :emphono"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByEsal", query = "SELECT e FROM Employee e WHERE e.esal = :esal"),
    @NamedQuery(name = "Employee.findByEaddr", query = "SELECT e FROM Employee e WHERE e.eaddr = :eaddr")})
public class Employee implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "eid")
    private Integer eid;
    @Column(name = "ename")
    private String ename;
    @Column(name = "emphono")
    private String emphono;
    @Column(name = "email")
    private String email;
    @Column(name = "esal")
    private Integer esal;
    @Column(name = "eaddr")
    private String eaddr;

    public Employee() {
    }

    public Employee(Integer eid) {
        this.eid = eid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        Integer oldEid = this.eid;
        this.eid = eid;
        changeSupport.firePropertyChange("eid", oldEid, eid);
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        String oldEname = this.ename;
        this.ename = ename;
        changeSupport.firePropertyChange("ename", oldEname, ename);
    }

    public String getEmphono() {
        return emphono;
    }

    public void setEmphono(String emphono) {
        String oldEmphono = this.emphono;
        this.emphono = emphono;
        changeSupport.firePropertyChange("emphono", oldEmphono, emphono);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Integer getEsal() {
        return esal;
    }

    public void setEsal(Integer esal) {
        Integer oldEsal = this.esal;
        this.esal = esal;
        changeSupport.firePropertyChange("esal", oldEsal, esal);
    }

    public String getEaddr() {
        return eaddr;
    }

    public void setEaddr(String eaddr) {
        String oldEaddr = this.eaddr;
        this.eaddr = eaddr;
        changeSupport.firePropertyChange("eaddr", oldEaddr, eaddr);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbms_java.Employee[ eid=" + eid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
