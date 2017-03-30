package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.dao.StationRepository;

@Controller
public class BikeController {


    @Autowired
    private StationRepository stationRepository;


    @RequestMapping(value = "/stationList", method = RequestMethod.GET)
    public ModelAndView showStudentsList() {
        ModelAndView model = new ModelAndView();
        model.addObject("stationList", stationRepository.findAll());
        model.addObject("menu", 1);
        model.setViewName("stationsList");

        return model;
    }
}
