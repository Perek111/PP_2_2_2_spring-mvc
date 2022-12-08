package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

    private static final List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car(0, "Lada", "Kalina"));
        cars.add(new Car(1, "Lada", "10"));
        cars.add(new Car(2, "Tesla", "Y"));
        cars.add(new Car(3, "Alfa Rameo", "123"));
        cars.add(new Car(4, "Nissan", "x trail"));
    }

    @Override
    public List<Car> getListCars(int count) {
        if (count <= 0 || count >= 5) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
