package pl.sda.service;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StationService {


    @Autowired
    private StationRepository stationRepository;

    List<Station> getAllStations() {

        return stationRepository.findAll();
    }

    Station getStationById(int stationId) {
        return stationRepository.findByStationId(int id);
    }

    List<Bike> getStationBikesById(int stationId) {

        return stationRepository.findBikesByStationId(int id);

    }
}
