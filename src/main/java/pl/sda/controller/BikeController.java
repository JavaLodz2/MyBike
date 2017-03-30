package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.dao.StationRepository;
import pl.sda.dao.UserRepository;
import pl.sda.model.User;

@Controller
public class BikeController {


    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/stationList", method = RequestMethod.GET)
    public ModelAndView showStationsList() {
        ModelAndView model = new ModelAndView();
        model.addObject("stationList", stationRepository.findAll());
        model.addObject("menu", 1);
        model.setViewName("stationsList");

        return model;
    }

    @RequestMapping(value = "/bikeList", method = RequestMethod.GET)
    public ModelAndView showBikesList(@RequestParam (name = "id") Integer id) {
        ModelAndView model = new ModelAndView();
        model.addObject("bikeList", stationRepository.findAllBikesByStationId(id));
//        model.addObject("station_id", stationRepository.findByStationId(id));
        model.addObject("menu", 1);
        model.setViewName("bikesList");

        return model;
    }
}
