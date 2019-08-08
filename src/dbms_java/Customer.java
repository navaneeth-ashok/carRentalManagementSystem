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
@Table(name = "customer", catalog = "postgres", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCId", query = "SELECT c FROM Customer c WHERE c.cId = :cId"),
    @NamedQuery(name = "Customer.findByCName", query = "SELECT c FROM Customer c WHERE c.cName = :cName"),
    @NamedQuery(name = "Customer.findByCPhno", query = "SELECT c FROM Customer c WHERE c.cPhno = :cPhno"),
    @NamedQuery(name = "Customer.findByNoOfCars", query = "SELECT c FROM Customer c WHERE c.noOfCars = :noOfCars"),
    @NamedQuery(name = "Customer.findByCAddr", query = "SELECT c FROM Customer c WHERE c.cAddr = :cAddr")})
public class Customer implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_id")
    private Integer cId;
    @Column(name = "c_name")
    private String cName;
    @Column(name = "c_phno")
    private String cPhno;
    @Column(name = "no_of_cars")
    private Integer noOfCars;
    @Column(name = "c_addr")
    private String cAddr;

    public Customer() {
    }

    public Customer(Integer cId) {
        this.cId = cId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        Integer oldCId = this.cId;
        this.cId = cId;
        changeSupport.firePropertyChange("CId", oldCId, cId);
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        String oldCName = this.cName;
        this.cName = cName;
        changeSupport.firePropertyChange("CName", oldCName, cName);
    }

    public String getCPhno() {
        return cPhno;
    }

    public void setCPhno(String cPhno) {
        String oldCPhno = this.cPhno;
        this.cPhno = cPhno;
        changeSupport.firePropertyChange("CPhno", oldCPhno, cPhno);
    }

    public Integer getNoOfCars() {
        return noOfCars;
    }

    public void setNoOfCars(Integer noOfCars) {
        Integer oldNoOfCars = this.noOfCars;
        this.noOfCars = noOfCars;
        changeSupport.firePropertyChange("noOfCars", oldNoOfCars, noOfCars);
    }

    public String getCAddr() {
        return cAddr;
    }

    public void setCAddr(String cAddr) {
        String oldCAddr = this.cAddr;
        this.cAddr = cAddr;
        changeSupport.firePropertyChange("CAddr", oldCAddr, cAddr);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbms_java.Customer[ cId=" + cId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
