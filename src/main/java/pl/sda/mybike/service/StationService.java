package pl.sda.mybike.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.mybike.dao.StationRepository;
import pl.sda.mybike.model.Station;

import java.util.List;

@Service
public class StationService {

    private Logger log = LoggerFactory.getLogger(StationService.class);

    @Autowired
    private StationRepository stationRepository;

    public List<Station> getAllStations() {
        log.debug("Getting all stations.");
        List<Station> stationList = stationRepository.findAll();
        log.debug("Found " + stationList.size() + " items.");
        return stationList;
    }

    public Station getStationById(int stationId) {
        log.debug("Searching for station id=" + stationId);
        Station station = stationRepository.findByStationId(stationId);
        log.debug("Found " + station);
        return station;
    }

}
