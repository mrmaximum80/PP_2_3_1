package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/car")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") long count, ModelMap model) {

        carService.getCars(count);
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello! People!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}
