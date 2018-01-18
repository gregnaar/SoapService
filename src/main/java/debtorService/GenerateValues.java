package debtorService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class GenerateValues {

    String candidateChars = "1234567890";


    public int generateRandomNumber(int referenceNumberLength) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < referenceNumberLength; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return Integer.parseInt(sb.toString());
    }

    private String generateDateString() {
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(2018, 2020);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return(gc.get(gc.YEAR) + "/" + (gc.get(gc.MONTH) + 1) + "/" + gc.get(gc.DAY_OF_MONTH));

    }

    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }


    public XMLGregorianCalendar generateDueDate() throws DatatypeConfigurationException {
        Date mydate = new Date(generateDateString());
        String FORMATER = "yyyy-MM-dd";
        DateFormat format = new SimpleDateFormat(FORMATER);
        XMLGregorianCalendar gDateFormatted = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(format.format(mydate));
        return gDateFormatted;
    }
}
