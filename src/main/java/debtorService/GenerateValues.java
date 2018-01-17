package debtorService;

import java.util.Random;

public class GenerateValues {

    String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    int referenceNumberLength = 10;


    public String generateReferenceNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < referenceNumberLength; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }
}
