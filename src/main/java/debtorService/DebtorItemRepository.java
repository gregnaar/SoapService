package debtorService;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import io.spring.guides.gs_producing_web_service.DebtorItem;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DebtorItemRepository {
    private static final Map<String, DebtorItem> debtorItems = new HashMap<>();
    private GenerateValues gen = new GenerateValues();

    @PostConstruct
    public void generateData() throws DatatypeConfigurationException {
        DebtorItem test1 = new DebtorItem();
        test1.setCustomerVatNumber("123");
        test1.setReferenceNumber(gen.generateRandomNumber(8));
        test1.setDueDate(gen.generateDueDate());
        test1.setAmount(gen.generateRandomNumber(ThreadLocalRandom.current().nextInt(1, 9)));
        debtorItems.put(test1.getCustomerVatNumber(), test1);

        DebtorItem test2 = new DebtorItem();
        test2.setCustomerVatNumber("1824325");
        test2.setReferenceNumber(gen.generateRandomNumber(8));
        test2.setDueDate(gen.generateDueDate());
        test2.setAmount(gen.generateRandomNumber(ThreadLocalRandom.current().nextInt(1, 9)));
        debtorItems.put(test2.getCustomerVatNumber(), test2);

        DebtorItem test3 = new DebtorItem();
        test3.setCustomerVatNumber("3246234234563");
        test3.setReferenceNumber(gen.generateRandomNumber(8));
        test3.setDueDate(gen.generateDueDate());
        test3.setAmount(gen.generateRandomNumber(ThreadLocalRandom.current().nextInt(1, 9)));
        debtorItems.put(test3.getCustomerVatNumber(), test3);

        DebtorItem test4 = new DebtorItem();
        test4.setCustomerVatNumber("666");
        test4.setReferenceNumber(gen.generateRandomNumber(8));
        test4.setDueDate(gen.generateDueDate());
        test4.setAmount(gen.generateRandomNumber(ThreadLocalRandom.current().nextInt(1, 9)));
        debtorItems.put(test4.getCustomerVatNumber(), test4);
    }

    public DebtorItem findDebtorItem(String customerVatNumber) {
        Assert.notNull(customerVatNumber, "The DebtorItem's CustomerVatNumber must not be null");
        return debtorItems.get(customerVatNumber);
    }
}
