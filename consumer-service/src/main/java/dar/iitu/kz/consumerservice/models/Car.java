package dar.iitu.kz.consumerservice.models;


import lombok.*;

@Getter
@Setter
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
