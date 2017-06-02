package pl.wipek;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Krzysztof Adamczyk on 02.06.2017.
 */
@XmlRootElement
public class Webservicereresponse {
    public String token;
    public String item_id;
    public String item_name;
    public String item_desc;
}
