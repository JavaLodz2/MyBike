package pl.sda.model;

import javax.persistence.*;

@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bike_id")
    private Integer bikeId;

    @OneToOne(mappedBy = "userId")
    private User userBorrowed;

    @ManyToOne
    private Station stationStandingOn;

    public Bike() {
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public User getUserBorrowed() {
        return userBorrowed;
    }

    public void setUserBorrowed(User userBorrowed) {
        this.userBorrowed = userBorrowed;
    }

    public Station getStationStandingOn() {
        return stationStandingOn;
    }

    public void setStationStandingOn(Station stationStandingOn) {
        this.stationStandingOn = stationStandingOn;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeId=" + bikeId +
                ", userBorrowed=" + userBorrowed +
                ", stationStandingOn=" + stationStandingOn +
                '}';
    }
}