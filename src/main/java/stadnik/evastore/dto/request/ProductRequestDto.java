package stadnik.evastore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProductRequestDto {
    @NotBlank
    @Size(max = 100, message =
            "Description should be max 100 symbols")
    private String name;
    @NotBlank
    @Size(max = 1000, message =
            "Description should be max 1000 symbols")
    private String description;
}
