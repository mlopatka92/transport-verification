This project is for training purpose only. It works on java 11 version.

The project simulates verification of transport requests.

There are 3 tasks to do:

-Add rule in class SimpleTransportVerifier that reject transports of 
BIG goods when truck capacity is lower than 200 (use isTruckSizeEnough method).
When this is done, remove @Disabled annotation from test shouldRejectInvalidCapacityTransport
to check if your code is working.

-In directory /src/test/resources/pl/mlopatka/utils there are two files: GoodsSameCountry.xml 
and GoodsTransit.xml. They are used in the following tests: shouldParseGoodsFromSameCountry, 
shouldParseTransitGoods. Fill those files based on "expected" objects from those tests and
remove @Disable annotations from them.

-In GoodsTransport.xsd file there is truck_type missing. Define this type and then uncomment
line: first line from method XmlReader#parseXml

-Answer questions from Questions.txt

