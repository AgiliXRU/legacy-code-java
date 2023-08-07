package ru.agilix.workshop.legacy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.agilix.workshop.legacy.service.*;

import java.util.HashMap;

@Configuration
public class BeanConfiguration {

    @Bean
    public CommonClientTypeHandler getCommonClientTypeHandler() {
        return new CommonClientTypeHandler();
    }

    @Bean
    public VipClientTypeHandler getVipClientTypeHandler() {
        return new VipClientTypeHandler();
    }

    @Bean
    public FnFClientTypeHandler getFnFClientTypeHandler() {
        return new FnFClientTypeHandler();
    }

    @Bean
    public DeliveryCostCalculationService getDeliveryCostCalculationService() {
        final var handlers = new HashMap<ClientType, ClientTypeHandler>();
        handlers.put(ClientType.COMMON, getCommonClientTypeHandler());
        handlers.put(ClientType.VIP, getVipClientTypeHandler());
        handlers.put(ClientType.FnF, getFnFClientTypeHandler());
        return new DeliveryCostCalculationService(handlers);
    }

}
