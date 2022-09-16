# Contract Testing Spring
Контрактные тесты – является разновидностью между интеграционными и unit-тестами.

**Цель:**
Написать автотесты с использованием:
- Retrofit (http-клиент) 
- Spring (java фраемворк для разработки web-приложений)
- Spring Cloud Contract (библиотека из модуля Spring для описания endpoint's, так называемых "ручек" или API-методов)
- Jackson (модуль который преобразование JSON в Java и наоборот)

Автотест при помощи Retrofit отправляет http-запрос на некий endpoint, полученный ответ при помощи Jackson 
преобразуется из JSON в java-объекты (dto). Далее при помощи Assertions проводятся проверки ответа.

Презентация и конспект лекции в папке [doc](https://github.com/nmochalova/OtusContractTest/tree/main/doc)

Тестируемые методы расположены по адресу: https://reqres.in/

*Дополнительные материалы:*
- [Генерация Spring проекта](https://start.spring.io/)

