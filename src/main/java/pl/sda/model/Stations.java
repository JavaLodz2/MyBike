package pl.sda.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "stations")
public class Stations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "street")
    @NotBlank(message = "Nazwa ulicy statcji nie może być pusta.")
    private String street;

    public Stations() {
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
        return "Stations{" +
                "stationId=" + stationId +
                ", street='" + street + '\'' +
                '}';
    }
}
