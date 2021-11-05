import org.junit.jupiter.api.Test;
import rentcompany.car.Avante;
import rentcompany.car.K5;
import rentcompany.RentCompany;
import rentcompany.car.Sonata;

import static org.junit.jupiter.api.Assertions.*;

class RentCompanyTest {

    @Test
    public void report() throws Exception {
        final String NEWLINE = System.getProperty("line.separator");
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();

        assertEquals(report,
                "Sonata : 15리터" + NEWLINE +
                        "K5 : 20리터" + NEWLINE +
                        "Sonata : 12리터" + NEWLINE +
                        "Avante : 20리터" + NEWLINE +
                        "K5 : 30리터" + NEWLINE
        );
    }

}