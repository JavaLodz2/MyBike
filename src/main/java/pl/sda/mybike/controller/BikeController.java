package pl.sda.mybike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.mybike.dto.ReturnBikeDTO;
import pl.sda.mybike.model.Bike;
import pl.sda.mybike.model.Station;
import pl.sda.mybike.model.User;
import pl.sda.mybike.service.BikeService;
import pl.sda.mybike.service.StationService;
import pl.sda.mybike.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BikeController {

    @Autowired
    private StationService stationService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/stationsList", method = RequestMethod.GET)
    public ModelAndView showStations() {
        ModelAndView model = new ModelAndView();
        Integer userId = 1;
        List<Bike> bikeList = new ArrayList<>();
        bikeList = bikeService.getAllBikesFromUser(userId);
        model.addObject("bikeList", bikeList);
        User user = userService.getUser(userId);
        model.addObject("user", user);
        model.addObject("stationList", stationService.getAllStations());

//        Bike bike = bikeService.getBike(id);
//        model.addObject("bike", bike);
//        model.addObject("station", bike.getStationStandingOn());

        model.addObject("menu", 1);
        model.setViewName("stationsList");
        return model;
    }

    @RequestMapping(value = "/station/{id}", method = RequestMethod.GET)
    public ModelAndView showBikesOnStation(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.addObject("bikeList", bikeService.getAllBikesOnStation(id));
        model.addObject("station", stationService.getStationById(id));
        model.addObject("menu", 1);
        model.setViewName("bikeList");
        return model;
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
    public ModelAndView confirmRentingBike(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView();
        Bike bike = bikeService.getBike(id);
        model.addObject("bike", bike);
        model.addObject("station", bike.getStationStandingOn());
        model.addObject("menu", 1);
        model.setViewName("confirmRent");
        return model;
    }


    @RequestMapping(value = "/rent/ok", method = RequestMethod.POST)
    public ModelAndView rentBitke(@ModelAttribute Bike bike) {
        ModelAndView model = new ModelAndView();

        model.addObject("stationList", stationService.getAllStations());
        model.addObject("menu", 1);
        model.setViewName("stationsList");

        userService.rentBike(bike.getBikeId(), 1);
        return new ModelAndView("redirect:/stationsList");
    }

    @RequestMapping(value = "/return", method = RequestMethod.GET)
    public ModelAndView returnBike() {

        // Todo poprawić ten kontroler - nie działa
        Integer userId = 1;
        ModelAndView model = new ModelAndView();
        List<Bike> bikeList = new ArrayList<Bike>();
        User user = userService.getUser(userId);
        List<Station> stations = stationService.getAllStations();

        Bike userBike = bikeService.getAllBikesFromUser(userId).get(0);
        model.addObject("userBike", userBike);

        model.addObject("user", user);
        model.addObject("stations", stations);
        ReturnBikeDTO dto = new ReturnBikeDTO();
        dto.setBikeId(userBike.getBikeId());
        model.addObject("returnBikeDTO", dto);
        model.addObject("menu", 3);
        model.setViewName("userBikes");
        return model;
    }

    @RequestMapping(value = "/returnBike", method = RequestMethod.POST)
    public ModelAndView returnBike(@ModelAttribute ReturnBikeDTO returnBikeDTO) {
        // TODO poprawić kontroler ponieważ nie działa, formularz nie zwraca DTO poprawnie
        ModelAndView model = new ModelAndView();
        Integer bikeId = returnBikeDTO.getBikeId();
        Integer stationId = returnBikeDTO.getStationId();

        System.out.println(bikeId + " " + stationId);

        bikeService.returnBike(bikeId, stationId);
        model.addObject("stationList", stationService.getAllStations());
        model.addObject("menu", 1);
        model.setViewName("stationsList");

        return model;
    }


}
