package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarDAOImpl implements CarDAO {
    private final List<Car> carList = new ArrayList<>();

    public List<Car> fullCarList() {
        for (int i = 1; i <= 5; i++) {
            carList.add(new Car("model" + i, "Color" + i, i));
        }
        return carList;
    }

    @Override
    public List<Car> carlist(int count) {
        return fullCarList().stream().limit(count).toList();
    }
}
