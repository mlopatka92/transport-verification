package pl.mlopatka.transport.service;

import pl.mlopatka.transport.model.GoodsTransport;
import pl.mlopatka.transport.model.TransportResponse;

public interface TransportVerificationService {

    TransportResponse verifyTransport(GoodsTransport goodsTransport);
}
