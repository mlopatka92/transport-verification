package pl.mlopatka.transport.service;

import pl.mlopatka.transport.model.*;

import static pl.mlopatka.transport.TransportConsts.INVALID_ADDRESSES_MSG;

public class SimpleTransportVerifier implements TransportVerificationService {

    @Override
    public TransportResponse verifyTransport(GoodsTransport goodsTransport) {
        if(areAddressesValid(goodsTransport.getSourceAddress(), goodsTransport.getDestAddress())) {
            return TransportResponse.rejectedResponse(INVALID_ADDRESSES_MSG);
        }

        return TransportResponse.acceptedResponse();
    }

    private boolean areAddressesValid(Address sourceAddress, Address destAddress) {
        return sourceAddress == null || destAddress == null ||
                (sourceAddress.getCity().equals(destAddress.getCity())
                && sourceAddress.getStreet().equals(destAddress.getStreet()));
    }

    private boolean isTruckSizeEnough(GoodsType goodsType, Truck truck) {
        //put your code here
        return false;
    }
}
