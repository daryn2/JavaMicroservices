package dar.iitu.kz.producerservice.services;


import dar.iitu.kz.producerservice.model.CarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC = "car_request";
    @Autowired
    private KafkaTemplate<String, CarRequest> kafkaTemplate;

    public String bookRequestNotify(CarRequest carRequest) {
        System.out.println(String.format("#### -> Producing book request to notification service -> %s", carRequest));
        this.kafkaTemplate.send(TOPIC, carRequest);
        return "Successfully";
    }


}
