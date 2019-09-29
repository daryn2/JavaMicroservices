package dar.iitu.kz.car.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private String id;
    private Integer rating;
    private String review;
    private User user;
}
