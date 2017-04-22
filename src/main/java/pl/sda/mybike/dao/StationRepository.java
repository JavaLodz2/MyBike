package pl.sda.mybike.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.mybike.model.Station;

import java.util.List;


@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

    List<Station> findAll();

    Station findByStationId(Integer stationId);

    Station findByStreet(String street);

}
