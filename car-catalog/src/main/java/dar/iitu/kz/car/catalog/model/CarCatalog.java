package dar.iitu.kz.car.catalog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarCatalog {
    private String id;
    private String brand;
    private String colour;
    private String number;
    private String url;
    private List<Integer> rating;
    private List<String> reviews;

}
