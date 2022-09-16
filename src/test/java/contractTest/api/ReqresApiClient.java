package contractTest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ReqresApiClient {

    private static final String BASE_URL = "https://reqres.in/api/";

    //Настраиваем свой ObjectMapper, в котором настраиваем модуль jackson.datatype.jsr310.JavaTimeModule нужный для работы со временем
    public static ObjectMapper getObjectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        return new ObjectMapper()
                .registerModule(module);
    }

    //Метод, который возвращает клиента
    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(getObjectMapper())) //преобразование JSON в Java и наоборот
                .build();
    }
}
