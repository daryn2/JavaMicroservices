package dar.iitu.kz.consumerservice.services;


import dar.iitu.kz.consumerservice.models.CarRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "car_request", groupId = "group_id")
    public void consume(CarRequest bookRequest) throws IOException {
        System.out.println(String.format("#### -> Notify user by email: -> %s",
                "User " + bookRequest.getUserId() + " purchased book "
                        + bookRequest.getCar().toString()));
    }
}
