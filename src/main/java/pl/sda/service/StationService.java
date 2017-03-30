package pl.sda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.StationRepository;
import pl.sda.model.Bike;
import pl.sda.model.Station;

import java.util.List;

@Service("stationService")
public class StationService {


    @Autowired
    private StationRepository stationRepository;

    List<Station> getAllStations() {

        return stationRepository.findAll();
    }

    Station getStationById(int stationId) {
        return stationRepository.findByStationId(stationId);
    }

    List<Bike> getStationBikesById(int stationId) {

        return stationRepository.findAllBikesByStation(stationId);

    }
}
