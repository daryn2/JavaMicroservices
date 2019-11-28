package dar.iitu.kz.producerservice.controllers;


import dar.iitu.kz.producerservice.model.CarRequest;
import dar.iitu.kz.producerservice.services.CarInformationService;
import dar.iitu.kz.producerservice.services.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/car/request")
public class CarRequestController {


    private final Producer producer;
    private CarInformationService carInformationService;

    @Autowired
    public CarRequestController(Producer producer, CarInformationService carInformationService) {
        this.producer = producer;
        this.carInformationService = carInformationService;
    }

    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") String userId,
                                           @RequestParam("bookId") String bookId) {

        CarRequest bookRequest = new CarRequest(userId, carInformationService.getCarById(bookId));
        this.producer.bookRequestNotify(bookRequest);
        return "Your request sent successful!";
    }

}
