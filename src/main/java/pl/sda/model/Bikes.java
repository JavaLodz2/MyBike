package pl.sda.model;

import javax.persistence.*;

@Entity
@Table(name = "bikes")
public class Bikes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bike_id")
    private Integer bikeId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users userBorrowed;

    public Bikes() {
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Users getUserBorrowed() {
        return userBorrowed;
    }

    public void setUserBorrowed(Users userBorrowed) {
        this.userBorrowed = userBorrowed;
    }

    @Override
    public String toString() {
        return "Bikes{" +
                "bikeId=" + bikeId +
                '}';
    }
}
