package pl.sda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.BikeRepository;
import pl.sda.dao.StationRepository;
import pl.sda.model.Bike;
import pl.sda.model.Station;

import java.util.List;

@Service("bikeService")
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private StationRepository stationRepository;

    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    public Bike getBike(int bikeId) {
        return bikeRepository.findByBikeId(bikeId);
    }

    public void returnBike(int bikeId, int stationId) {
        Bike bike = bikeRepository.findByBikeId(bikeId);
        Station station = stationRepository.findByStationId(stationId);

        bike.setUserBorrowed(null);
        bike.setStationStandingOn(station);
    }
}
