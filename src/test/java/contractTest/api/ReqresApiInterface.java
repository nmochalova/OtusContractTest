package contractTest.api;

import contractTest.dto.CreateUserRequestDto;
import contractTest.dto.CreateUserResponseDto;
import contractTest.dto.GetUserByIdResponseDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//retrofit - популярный http-клиент. Здесь прописываем endpoint's (ручки)

public interface ReqresApiInterface {
    @GET("users/{userId}") //каким http-глаголом пользоваться и на какой адрес обращаться
    Call<GetUserByIdResponseDto> getSingleUserById(@Path("userId") String userId);
    //В Call передаем класс, который представляет ответ.
    //В @Path передаем path-параметры, которые мы прокидываем.

    @POST("users")
    Call<CreateUserResponseDto> createUser(@Body CreateUserRequestDto requestBody);
}
