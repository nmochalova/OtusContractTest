package contractTest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//Для jackson должен быть только пустой конструктор!!!
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //включить только те поля, которые не null
public class GetUserByIdResponseDto {
    @JsonProperty("data") //Это аннотация указывает, что поле data нужно искать в json
    private DataJson data;

    @JsonProperty("support")
    private Support support;
}
