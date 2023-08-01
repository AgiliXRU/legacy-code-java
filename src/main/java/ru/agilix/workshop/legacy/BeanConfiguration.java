package ru.agilix.workshop.legacy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.agilix.workshop.legacy.service.*;

import java.util.HashMap;

@Configuration
public class BeanConfiguration {

    @Bean
    public DeliveryCostCalculationService getDeliveryCostCalculationService() {
        final var handlers = new HashMap<ClientType, ClientTypeHandler>();
        handlers.put(ClientType.COMMON, new CommonClientTypeHandler());
        handlers.put(ClientType.VIP, new VipClientTypeHandler());
        handlers.put(ClientType.FnF, new FnFClientTypeHandler());
        return new DeliveryCostCalculationService(handlers);
    }

}
