package dar.iitu.kz.producerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    private String id;
    private String brand;
    private String colour;
    private String number;
    private String url;

}