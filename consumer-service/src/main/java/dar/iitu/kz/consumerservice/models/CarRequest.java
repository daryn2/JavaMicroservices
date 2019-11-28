package dar.iitu.kz.consumerservice.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarRequest {
    private String userId;
    private Car car;

    public CarRequest() {

    }
    public CarRequest(String userId, Car car) {
        this.userId = userId;
        this.car = car;
    }



}
