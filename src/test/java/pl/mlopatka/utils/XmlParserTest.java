package pl.mlopatka.utils;

import org.junit.jupiter.api.Test;
import pl.mlopatka.transport.model.Address;
import pl.mlopatka.transport.model.GoodsTransport;
import pl.mlopatka.transport.model.GoodsType;
import pl.mlopatka.transport.model.Truck;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.*;

public class XmlParserTest {

    XmlParser xmlParser = new XmlParser();

    @Test
    public void shouldCreateXml() throws JAXBException {
        //given
        String goodsXml =
                "<goods_transport>" +
                "   <source_address>" +
                "       <city>Kraków</city>" +
                "       <street>Rynek</street>" +
                "   </source_address>" +
                "   <dest_address>" +
                "       <city>Kraków</city>" +
                "       <street>Wielicka</street>" +
                "   </dest_address>" +
                "   <truck>" +
                "       <id>12345678</id>" +
                "       <capacity>250</capacity>" +
                "   </truck>" +
                "   <goods_type>SMALL</goods_type>" +
                "</goods_transport>";
        Address sourceAddress = new Address("Kraków", "Rynek");
        Address destAddress = new Address("Kraków", "Wielicka");
        Truck truck = new Truck("12345678", 250);
        GoodsTransport expected = new GoodsTransport(sourceAddress, destAddress, truck, GoodsType.SMALL);

        //when
        GoodsTransport result = xmlParser.parseXml(goodsXml);

        //then
        assertEquals(expected, result);
    }

}
