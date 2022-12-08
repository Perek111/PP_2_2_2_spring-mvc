package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
public class CarController {
    private final CarService carService;

    public CarController (CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam("count") Optional<Integer> count, Model model) {
        model.addAttribute("cars", carService.getListCars(count.orElse(5)));
        return "cars";
    }
}
