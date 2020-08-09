package pl.mlopatka.utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import pl.mlopatka.transport.model.Address;
import pl.mlopatka.transport.model.GoodsTransport;
import pl.mlopatka.transport.model.GoodsType;
import pl.mlopatka.transport.model.Truck;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class XmlReaderTest {
    XmlReader xmlReader = new XmlReader();

    @Test
    public void shouldParseXml() throws IOException, JAXBException, SAXException {
        //given
        String xmlPath = "/pl/mlopatka/utils/Goods01.xml";
        Address sourceAddress = new Address("Kraków", "Rynek");
        Address destAddress = new Address("Kraków", "Wielicka");
        Truck truck = new Truck("12345678", 250);
        GoodsTransport expected = new GoodsTransport(sourceAddress, destAddress, truck, GoodsType.SMALL);

        //when
        GoodsTransport result = xmlReader.parseXml(xmlPath);

        //then
        assertEquals(expected, result);
    }

    @Test
    @Disabled
    public void shouldParseTransitGoods() throws IOException, JAXBException, SAXException {
        //given
        String xmlPath = "/pl/mlopatka/utils/GoodsTransit.xml";
        Address sourceAddress = new Address("Berlin", "Ottt-Weidt-Platz 1 & 2");
        Address destAddress = new Address("Kraków", "Wielicka");
        Truck truck = new Truck("Abc<DEfg", 300);
        GoodsTransport expected = new GoodsTransport(sourceAddress, destAddress, truck, GoodsType.BIG);

        //when
        GoodsTransport result = xmlReader.parseXml(xmlPath);

        //then
        assertEquals(expected, result);
    }

    @Test
    @Disabled
    public void shouldParseGoodsFromSameCountry() throws IOException, JAXBException, SAXException {
        //given
        String xmlPath = "/pl/mlopatka/utils/GoodsSameCountry.xml";
        Address sourceAddress = new Address("Szczecin", "Górna");
        Address destAddress = new Address("Zakopane", "Krakowska");
        Truck truck = new Truck("'Adamed'-Truck >0< 1>", 50);
        GoodsTransport expected = new GoodsTransport(sourceAddress, destAddress, truck, GoodsType.SMALL);

        //when
        GoodsTransport result = xmlReader.parseXml(xmlPath);

        //then
        assertEquals(expected, result);
    }
}
