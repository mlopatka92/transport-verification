package pl.mlopatka.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    private FileReader fileReader = new FileReader();

    @Test
    public void shouldReadFile() throws IOException {
        //given
        String filePath = "/pl/mlopatka/utils/Test.txt";
        //when
        String result = fileReader.readFile(filePath);
        //then
        assertEquals("Test text..", result);
    }
}


