package pl.sda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.Bike;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {

    Bike findByBikeId(Integer bikeId);

    // todo napisać tą metodę aby pobierała obiekt z relacji. Na razie realuje to pobranie wszytkich danych i filtr.
//    @Query("SELECT t FROM public.bikes t WHERE t.station_id like ?1")
//    List<Bike> findBikeByStationStandingOn(Integer id);

}



