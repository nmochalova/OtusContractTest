package contractTest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserResponseDto {
    @JsonProperty("job")
    private String job;

    @JsonProperty("name")
    private  String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("createdAt")
    private Instant createdAt;
}

