package pl.mlopatka.transport.model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum(String.class)
public enum GoodsType {
    REGULAR, BIG, SMALL
}
