package debtorService;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.DebtorItem;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DebtorItemRepository {
    private static final Map<String, DebtorItem> debtorItems = new HashMap<>();
    private GenerateValues gen = new GenerateValues();

    @PostConstruct
    public void initData() throws DatatypeConfigurationException {
        DebtorItem test = new DebtorItem();
        test.setCustomerVatNumber("123");
        test.setReferenceNumber(gen.generateReferenceNumber());

        Date mydate = new Date("10/28/2018");
        String FORMATER = "yyyy-MM-dd";
        DateFormat format = new SimpleDateFormat(FORMATER);
        XMLGregorianCalendar gDateFormatted = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(format.format(mydate));
        test.setDueDate(gDateFormatted);



        test.setAmount("56");


        debtorItems.put(test.getCustomerVatNumber(), test);
    }

    public DebtorItem findDebtorItem(String name) {
        Assert.notNull(name, "The DebtorItem's CustomerVatNumber must not be null");
        return debtorItems.get(name);
    }
}
