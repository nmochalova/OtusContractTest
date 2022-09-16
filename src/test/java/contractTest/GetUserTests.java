package contractTest;

import contractTest.api.ReqresApiClient;
import contractTest.api.ReqresApiInterface;
import contractTest.dto.GetUserByIdResponseDto;
import contractTest.dto.ListUsersResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import java.io.IOException;

@SpringBootTest
public class GetUserTests {
    ReqresApiInterface client = ReqresApiClient.getClient().create(ReqresApiInterface.class);

    @Test
    @DisplayName("Get user by id if id == 2")
    void getSingleUserTest() throws IOException {
        Response<GetUserByIdResponseDto> response =
                client.getSingleUserById("2").execute();

        Assertions.assertAll(() -> {
            Assertions.assertTrue(response.isSuccessful());  //проверка, что код ответа 200
            Assertions.assertEquals(response.body().getData().getId(),2);   //проверяем что в ответе id=2
            Assertions.assertEquals(response.body().getData().getFirstName(),"Janet"); //проверяем что в ответе first_name=Janet
        });
    }

    @Test
    @DisplayName("Get user by id if id == 2")
    void getListUsersTest() throws IOException {
        Response<ListUsersResponseDto> response =
                client.getListUsers("2").execute();

        Assertions.assertAll(() -> {
            Assertions.assertTrue(response.isSuccessful());
            Assertions.assertEquals(response.body().getDataJsonList().size(),6); //проверяем, что в списке 6 юзеров
        });
    }
}
