package pl.wipek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Created by Krzysztof Adamczyk on 02.06.2017.
 */
@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Override
    public void run(String... strings) throws Exception {

        // ***********************************************
        String URI = "http://localhost:8080/";
        Webservicerequest webservicerequest = new Webservicerequest();
        webservicerequest.item_id = "2";
        webservicerequest.item_desc = "desc";
        webservicerequest.item_name = "name";

        // ***********************************************

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);

        for(int x=1; x<10;x++) {
            Webservicereresponse webservicereresponse = (Webservicereresponse) webServiceTemplate.marshalSendAndReceive(URI, webservicerequest);

            System.out.println("Response token: " + webservicereresponse.token);
        }

    }
}