package pl.sda.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stations")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "street")
    @NotBlank(message = "Station street name cannot be empty.")
    private String street;

    @OneToMany(mappedBy = "stationStandingOn", cascade = CascadeType.PERSIST)
    private List<Bike> bikeList;

    public Station() {
    }

    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", street='" + street + '\'' +
                ", bikes count='" + bikeList.size() + '\'' +
                '}';
    }
}
