# Repository for legacy code meetup

![A-TDD](https://dzone.com/storage/temp/7012527-atdd-workflow.jpg)

[Read More](https://dzone.com/articles/acceptance-test-driven-development-closing-the-com)


## Working with legacy code

---
_**Legend**: You have legacy (without tests) service which calculates order amount. You've hired separate testing team. 
They worked hard some months and wrote acceptance tests._

---

### Go down with test
```
class DeliveryControllerShould {

    @ParameterizedTest
    @CsvSource({
            "Обычный, 999, 1249",
            "Обычный, 1000, 1000",
            "VIP, 999, 999",
            "VIP, 2499, 2499",
            "VIP, 2500, 2375"
    })
    void calculateDeliveryFee(String clientType, Integer cartAmount, Integer orderAmount) {
        assertEquals(orderAmount, new DeliveryController().calculate(clientType, cartAmount));
    }
}
```

### Refactoring
1. Add SpringTest:
```java
    @SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
    public class DeliveryServiceApprovalTest {
    
        @Autowired
        DeliveryController deliveryController;
    
        @Test
        void vipClientShouldNotPayForDelivery() {
            assertEquals(Integer.valueOf(2499), deliveryController.calculate("VIP", 2499));
        }
    }
```
1. Add TDD ```DeliveryServiceShould``` and create ```DeliverService```.
```java
    @Test
    void addDeliveryFeeToOrderAmount() {
        assertEquals(1249, deliveryService.calculate(999));
    }

    @Test
    void NotAddDeliveryFeeToOrderAmountIfItIsEqualOrMoreThen1000() {
        assertEquals(1000, deliveryService.calculate(1000));
    }
```
1. Replace call in ```DeliveryContoller```
1. Extract interface of ```DeliverService```
