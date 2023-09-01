package ru.agilix.workshop.legacy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.agilix.workshop.legacy.service.CostCalculationService;
import ru.agilix.workshop.legacy.service.UnknownClientTypeException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = {DeliveryController.class})
class DeliveryControllerShould {

    @MockBean
    private CostCalculationService costCalculationServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateCalculatePriceForVipAndAmountOf100() throws Exception, UnknownClientTypeException {

        String clientType = ClientType.VIP.getTitle();
        Integer cartAmount = 100;
        final ResultActions result = mockMvc.perform(get("/delivery/" + clientType + "/" + cartAmount + "/"));

        result.andExpect(status().isOk());
        verify(costCalculationServiceMock).calculate(eq(clientType), eq(cartAmount));
    }
}