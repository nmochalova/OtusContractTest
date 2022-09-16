package contractTest;

import contractTest.api.ReqresApiClient;
import contractTest.api.ReqresApiInterface;
import contractTest.dto.LoginUserSuccessRequestDto;
import contractTest.dto.LoginUserSuccessResponseDto;
import contractTest.dto.LoginUserUnsuccessRequestDto;
import contractTest.dto.LoginUserUnsuccessResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
public class LoginUserTests {

    ReqresApiInterface client = ReqresApiClient.getClient().create(ReqresApiInterface.class);

    @Test
    @DisplayName("Login user successful")
    void loginUserSuccessfulTest() throws IOException {
        String email = "eve.holt@reqres.in";
        String password = "cityslicka";

        Response<LoginUserSuccessResponseDto> response =
                client.loginUserSuccessful(new LoginUserSuccessRequestDto(email, password)).execute();

        Assertions.assertAll(() -> {
            Assertions.assertTrue(response.isSuccessful());
            Assertions.assertEquals(response.body().getToken(),"QpwL5tke4Pnpja7X4");
        });
    }

    @Test
    @DisplayName("Login user unsuccessful")
    void loginUserUnsuccessfulTest() throws IOException {
        String email = "eve.holt@reqres.in";

        Response<LoginUserUnsuccessResponseDto> response =
                client.loginUserUnsuccessful(new LoginUserUnsuccessRequestDto(email)).execute();

        Assertions.assertAll(() -> {
            Assertions.assertEquals(response.code(),400);
            Assertions.assertTrue(response.errorBody().string().contains("Missing password"));
        });
    }
}
