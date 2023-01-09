package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private ArrayList<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1, "model1", 1));
        cars.add(new Car(2, "model2", 2));
        cars.add(new Car(3, "model3", 3));
        cars.add(new Car(4, "model4", 4));
        cars.add(new Car(5, "model5", 5));
    }


    @Override
    public ArrayList<Car> getCars(long count) {

        if (count >= 5 || count < 0) {
            return cars;
        } else {
            return (ArrayList<Car>) cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
