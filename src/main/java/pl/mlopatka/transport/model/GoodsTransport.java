package pl.mlopatka.transport.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "goods_transport")
public class GoodsTransport {

    @XmlElement(name = "source_address")
    private Address sourceAddress;
    @XmlElement(name = "dest_address")
    private Address destAddress;
    @XmlElement(name = "truck")
    private Truck truck;
    @XmlElement(name = "goods_type")
    private GoodsType goodsType;

    public GoodsTransport() {
    }

    public GoodsTransport(final Address sourceAddress, final Address destAddress, final Truck truck, final GoodsType goodsType) {
        this.sourceAddress = sourceAddress;
        this.destAddress = destAddress;
        this.truck = truck;
        this.goodsType = goodsType;
    }

    public Address getSourceAddress() {
        return sourceAddress;
    }

    public Address getDestAddress() {
        return destAddress;
    }

    public Truck getTruck() {
        return truck;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsTransport that = (GoodsTransport) o;
        return Objects.equals(sourceAddress, that.sourceAddress) &&
                Objects.equals(destAddress, that.destAddress) &&
                Objects.equals(truck, that.truck) &&
                goodsType == that.goodsType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAddress, destAddress, truck, goodsType);
    }

    @Override
    public String toString() {
        return "GoodsTransport{" +
                "sourceAddress=" + sourceAddress +
                ", destAddress=" + destAddress +
                ", truck=" + truck +
                ", goodsType=" + goodsType +
                '}';
    }
}
