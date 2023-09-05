package ru.andreyTw.delivery;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryStepDefinitions {

    String clientType;
    Integer deliveryAmount;
    Integer cartAmount;
    Integer orderAmount = 0;

    final private RestTemplate restTemplate = new RestTemplate();

    @Дано("{string} и {int}")
    public void given(String clientType, Integer cartAmount) {
        this.clientType = clientType;
        this.cartAmount = cartAmount;
    }

    @И("Стоимость доствки {int}")
    public void and(Integer deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    @Когда("Проводим расчет")
    public void when() {
        this.orderAmount = restTemplate.getForObject("http://localhost:8080/delivery/" + clientType + "/" + cartAmount + "/", Integer.class);
    }

    @Тогда("Получаем {int}")
    public void then(Integer orderAmount) {
        assertEquals(orderAmount, this.orderAmount);
    }

}
