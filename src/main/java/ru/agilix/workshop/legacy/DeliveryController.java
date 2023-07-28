package ru.agilix.workshop.legacy;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.agilix.workshop.legacy.service.DeliveryService;

@RestController
@AllArgsConstructor
public class DeliveryController {

    DeliveryService deliveryService;

    @GetMapping("/delivery/{clientType}/{cartAmount}/")
    public Integer calculate(@PathVariable("clientType") String clientType,
                             @PathVariable("cartAmount") Integer cartAmount) throws Exception {

        return deliveryService.calculate(clientType, cartAmount);
    }

}
