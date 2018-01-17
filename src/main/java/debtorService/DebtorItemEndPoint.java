package debtorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetDebtorItemRequest;
import io.spring.guides.gs_producing_web_service.GetDebtorItemResponse;

@Endpoint
public class DebtorItemEndPoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private DebtorItemRepository debtorItemRepository;

    @Autowired
    public DebtorItemEndPoint(DebtorItemRepository debtorItemRepository) {
        this.debtorItemRepository = debtorItemRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDebtorItemRequest")
    @ResponsePayload
    public GetDebtorItemResponse getDebtorItem(@RequestPayload GetDebtorItemRequest request) {
        GetDebtorItemResponse response = new GetDebtorItemResponse();
        response.setDebtorItem(debtorItemRepository.findDebtorItem(request.getCustomerVatNumber()));

        return response;
    }
}
