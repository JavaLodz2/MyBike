package pl.sda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {

    Bike findByBikeId(Integer bikeId);
    Bike findByUserBorrowed(User userBorrowed);

}


