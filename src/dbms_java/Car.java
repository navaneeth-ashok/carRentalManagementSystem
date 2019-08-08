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
@Table(name = "car", catalog = "postgres", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByCarId", query = "SELECT c FROM Car c WHERE c.carId = :carId"),
    @NamedQuery(name = "Car.findByCarModel", query = "SELECT c FROM Car c WHERE c.carModel = :carModel"),
    @NamedQuery(name = "Car.findByManufactur", query = "SELECT c FROM Car c WHERE c.manufactur = :manufactur"),
    @NamedQuery(name = "Car.findByRating", query = "SELECT c FROM Car c WHERE c.rating = :rating"),
    @NamedQuery(name = "Car.findByCapacity", query = "SELECT c FROM Car c WHERE c.capacity = :capacity"),
    @NamedQuery(name = "Car.findByRate", query = "SELECT c FROM Car c WHERE c.rate = :rate")})
public class Car implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "car_id")
    private Integer carId;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "manufactur")
    private String manufactur;
    @Column(name = "rating")
    private String rating;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "rate")
    private String rate;

    public Car() {
    }

    public Car(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        Integer oldCarId = this.carId;
        this.carId = carId;
        changeSupport.firePropertyChange("carId", oldCarId, carId);
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        String oldCarModel = this.carModel;
        this.carModel = carModel;
        changeSupport.firePropertyChange("carModel", oldCarModel, carModel);
    }

    public String getManufactur() {
        return manufactur;
    }

    public void setManufactur(String manufactur) {
        String oldManufactur = this.manufactur;
        this.manufactur = manufactur;
        changeSupport.firePropertyChange("manufactur", oldManufactur, manufactur);
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        String oldRating = this.rating;
        this.rating = rating;
        changeSupport.firePropertyChange("rating", oldRating, rating);
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        String oldCapacity = this.capacity;
        this.capacity = capacity;
        changeSupport.firePropertyChange("capacity", oldCapacity, capacity);
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        String oldRate = this.rate;
        this.rate = rate;
        changeSupport.firePropertyChange("rate", oldRate, rate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbms_java.Car[ carId=" + carId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
