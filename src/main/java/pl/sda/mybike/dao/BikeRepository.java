package pl.sda.mybike.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.mybike.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {

    Bike findByBikeId(Integer bikeId);

    // todo napisać tą metodę aby pobierała obiekt z relacji. Na razie realuje to pobranie wszytkich danych i filtr.
//    @Query("SELECT t FROM public.bikes t WHERE t.station_id like ?1")
//    List<Bike> findBikeByStationStandingOn(Integer id);

}



