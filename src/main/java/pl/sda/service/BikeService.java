package pl.sda.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.BikeRepository;
import pl.sda.dao.StationRepository;
import pl.sda.model.Bike;
import pl.sda.model.Station;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BikeService {

    private Logger log = LoggerFactory.getLogger(BikeService.class);

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private StationRepository stationRepository;

    public List<Bike> getAllBikes() {
        log.debug("Gettings all bikes.");
        List<Bike> bikeList = bikeRepository.findAll();
        log.debug("Found " + bikeList.size() + " items.");
        return bikeList;
    }

    public Bike getBike(Integer bikeId) {
        log.debug("Searching for bike id=" + bikeId);
        Bike bike = bikeRepository.findByBikeId(bikeId);
        log.debug("Found " + bike);
        return bike;
    }

    public void returnBike(Integer bikeId, Integer stationId) {
        Bike bike = bikeRepository.findByBikeId(bikeId);
        Station station = stationRepository.findByStationId(stationId);

        bike.setUserBorrowed(null);
        bike.setStationStandingOn(station);
    }

    public List<Bike> getAllBikesOnStation(Integer stationId) {
        log.debug("Searching for bikes on station id=" + stationId);
        List<Bike> bikeList = bikeRepository.findAll().stream()
                .filter(s -> Objects.equals(s.getStationStandingOn().getStationId(), stationId))
                .collect(Collectors.toList());
        log.debug("Found " + bikeList.size() + " items.");
        //todo - napisać query która pobierze mapowane w encji dane. Na razie realizuję to filtrem.
        return bikeList;
    }
}
