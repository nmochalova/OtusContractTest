package contractTest;

import contractTest.api.ReqresApiClient;
import contractTest.api.ReqresApiInterface;
import contractTest.dto.CreateUserRequestDto;
import contractTest.dto.CreateUserResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@SpringBootTest
class CreateUserTests {

	//Получить клиента
	ReqresApiInterface client = ReqresApiClient.getClient().create(ReqresApiInterface.class);

	@Test
	@DisplayName("Create user")
	void createUserTest() throws IOException {
		Instant now = Instant.now();
		String name = "Alex";
		String job = "Engineer";

		Response<CreateUserResponseDto> response =
				client.createUser(new CreateUserRequestDto(name, job))
						.execute();

		Assertions.assertAll(() -> {
			Assertions.assertTrue(response.isSuccessful());
			Assertions.assertEquals(response.body().getName(),name);
			Assertions.assertEquals(response.body().getJob(),job);
			Assertions.assertTrue(response.body().getCreatedAt().isAfter(now)); //время между сейчас и сейчас плюс 1 минута
			Assertions.assertTrue(response.body().getCreatedAt().isBefore(now.plus(1, ChronoUnit.MINUTES)));
		});
	}
}
