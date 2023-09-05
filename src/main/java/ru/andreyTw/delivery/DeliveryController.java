package ru.andreyTw.delivery;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.andreyTw.delivery.service.CostCalculationService;
import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException;

@RestController
@AllArgsConstructor
public class DeliveryController {

    CostCalculationService costCalculationService;

    @GetMapping("/delivery/{clientType}/{cartAmount}/")
    public Integer calculate(@PathVariable("clientType") String clientType,
                             @PathVariable("cartAmount") Integer cartAmount) throws UnknownClientTypeException {

        return costCalculationService.calculate(clientType, cartAmount);
    }

}
