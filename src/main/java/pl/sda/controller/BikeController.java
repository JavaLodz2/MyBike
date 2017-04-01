package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Bike;
import pl.sda.model.Station;
import pl.sda.model.User;
import pl.sda.service.BikeService;
import pl.sda.service.StationService;
import pl.sda.service.UserService;
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
        model.addObject("stationList", stationService.getAllStations());
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
        return model;
    }

    @RequestMapping(value = "/return/{userId}", method = RequestMethod.GET)
    public ModelAndView confirmReturnBike(@PathVariable("userId") Integer userId) {
        ModelAndView model = new ModelAndView();
        List<Bike> bikeList = bikeService.getAllBikesFromUser(userId);
        User user = userService.getUser(userId);
        List<Station> stations = stationService.getAllStations();
        model.addObject("bikeList", bikeList);
        model.addObject("user", user);
        model.addObject("stations", stations);
        model.addObject("menu", 3);
        model.setViewName("userBikes");
        return model;
    }




}
