package pl.mlopatka.utils;

import org.xml.sax.SAXException;
import pl.mlopatka.transport.TransportConsts;
import pl.mlopatka.transport.model.GoodsTransport;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

public class XmlReader {

    private final FileReader fileReader = new FileReader();
    private final XmlParser xmlParser = new XmlParser();
    private final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    public GoodsTransport parseXml(String filePath) throws IOException, JAXBException, SAXException {
//        validateXmlSchema(TransportConsts.GOODS_TRANSPORT_SCHEMA, filePath);
        String xml = fileReader.readFile(filePath);
        return xmlParser.parseXml(xml);
    }

    public void validateXmlSchema(String xsdPath, String xmlPath) throws IOException, SAXException {
        Schema schema = factory.newSchema(fileReader.loadFile(xsdPath));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(fileReader.loadFile(xmlPath)));
    }
}
