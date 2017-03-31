package pl.sda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Bike;
import pl.sda.model.Station;

import java.util.List;


@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

    List<Station> findAll();

    Station findByStationId(Integer stationId);

    Station findByStreet(String street);

}
