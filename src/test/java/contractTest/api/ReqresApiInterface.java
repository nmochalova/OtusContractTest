package contractTest.api;

import contractTest.dto.*;
import retrofit2.Call;
import retrofit2.http.*;

//retrofit - популярный http-клиент. Здесь прописываем endpoint's (ручки)

public interface ReqresApiInterface {
    @GET("users/{userId}") //каким http-глаголом пользоваться и на какой адрес обращаться
    Call<GetUserByIdResponseDto> getSingleUserById(@Path("userId") String userId);
    //В Call передаем класс, который представляет ответ.
    //В @Path передаем path-параметры, которые мы прокидываем.

    @GET("users?")
    Call<ListUsersResponseDto> getListUsers(@Query("page") String page);

    @POST("users")
    Call<CreateUserResponseDto> createUser(@Body CreateUserRequestDto requestBody);

    @POST("login")
    Call<LoginUserSuccessResponseDto> loginUserSuccessful(@Body LoginUserSuccessRequestDto requestBody);

    @POST("login")
    Call<LoginUserUnsuccessResponseDto> loginUserUnsuccessful(@Body LoginUserUnsuccessRequestDto requestBody);
}
