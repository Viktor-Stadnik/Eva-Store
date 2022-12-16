package stadnik.evastore.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
}
