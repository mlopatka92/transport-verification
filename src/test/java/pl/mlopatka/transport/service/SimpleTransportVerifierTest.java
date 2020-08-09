package pl.mlopatka.transport.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.mlopatka.transport.TransportConsts;
import pl.mlopatka.transport.model.*;
import pl.mlopatka.utils.XmlReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTransportVerifierTest {

    TransportVerificationService transportVerificationService = new SimpleTransportVerifier();
    XmlReader xmlReader = new XmlReader();

    @Test
    public void shouldAcceptValidTransport() {
        //given
        Address sourceAddress = new Address("Kraków", "Rynek");
        Address destAddress = new Address("Kraków", "Wielicka");
        Truck truck = new Truck("123456", 250);
        GoodsTransport goodsTransport = new GoodsTransport(sourceAddress, destAddress, truck, GoodsType.REGULAR);

        //when
        TransportResponse result = transportVerificationService.verifyTransport(goodsTransport);

        //then
        assertEquals(TransportStatus.ACCEPTED, result.getTransportStatus());
    }

    @Test
    public void shouldRejectInvalidAddressesTransport() {
        //given
        Address sourceAddress = new Address("Kraków", "Rynek");
        Address destAddress = new Address("Kraków", "Rynek");
        Truck truck = new Truck("123456", 250);
        GoodsTransport goodsTransport = new GoodsTransport(sourceAddress, destAddress, truck, GoodsType.REGULAR);

        //when
        TransportResponse result = transportVerificationService.verifyTransport(goodsTransport);

        //then
        assertEquals(TransportStatus.REJECTED, result.getTransportStatus());
        assertEquals(TransportConsts.INVALID_ADDRESSES_MSG, result.getNote());
    }

    @Test
    @Disabled
    public void shouldRejectInvalidCapacityTransport() {
        //given
        Address sourceAddress = new Address("Kraków", "Rynek");
        Address destAddress = new Address("Kraków", "Wielicka");
        Truck truck = new Truck("123456", 120);
        GoodsTransport goodsTransport = new GoodsTransport(sourceAddress, destAddress, truck, GoodsType.BIG);

        //when
        TransportResponse result = transportVerificationService.verifyTransport(goodsTransport);

        //then
        assertEquals(TransportStatus.REJECTED, result.getTransportStatus());
        assertEquals("Truck is to small for BIG goods types", result.getNote());
    }
}
