package contractTest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //включить только те поля, которые не null
public class CreateUserRequestDto {
    @JsonProperty("job")
    private String job;

    @JsonProperty("name")
    private  String name;

    //Это request поэтому тут два конструктора: пустой и для всех параметров.
    public CreateUserRequestDto() {
    }

    public CreateUserRequestDto(String name, String job) {
        this.job = job;
        this.name = name;
    }
}
