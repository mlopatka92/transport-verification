package pl.mlopatka.utils;

import pl.mlopatka.transport.model.GoodsTransport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlParser {

    public GoodsTransport parseXml(String xmlString) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(GoodsTransport.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (GoodsTransport) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
    }

}
