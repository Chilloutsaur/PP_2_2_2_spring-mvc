package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DAO.CarDAOImpl;
import web.model.Car;


import java.util.List;
@Service
public class CarServiceImp implements CarService {
    private final CarDAOImpl carDAO;
    @Autowired
    public CarServiceImp(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> carList(int count) {
        return carDAO.carlist(count);
    }
}
