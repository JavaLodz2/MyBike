package pl.sda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.BikeRepository;
import pl.sda.dao.StationRepository;
import pl.sda.model.Bike;
import pl.sda.model.Station;

import java.util.List;

@Service("stationService")
public class StationService {


    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private BikeRepository bikeRepository;

    List<Station> getAllStations() {

        return stationRepository.findAll();
    }

    Station getStationById(int id) {
        return stationRepository.findByStationId(id);
    }

    List<Bike> getStationBikesById(int id) {

        return stationRepository.findAllBikesByStation(id);

    }
}
