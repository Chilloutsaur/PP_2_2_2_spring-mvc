package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ServletConfigPropertySource;
import web.DAO.CarDAOImpl;
import web.config.WebConfig;
import web.service.CarServiceImp;


@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceImp carServiceImp;
    @Autowired
    public CarsController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping()
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null) {
            model.addAttribute("allCars", carServiceImp.carList(5));
            return "car";
        }
        else if (count <= 0) {
            return "car";
        } else {
            model.addAttribute("count", carServiceImp.carList(count));
            return "car";
        }
    }
}
