package pl.sda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

    Station findByStationId(Integer stationId);
    Station findByStreet(String street);
    List<Bike> findAllBikesByStation(Station station);
    
}
