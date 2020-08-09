package pl.mlopatka.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.apache.commons.io.FileUtils.toFile;

public class FileReader {

    private static final String ISO_8859_2 = "ISO_8859-2";

    public String readFile(String filePath) throws IOException {
        File file = loadFile(filePath);
        return readFileToString(file, Charset.forName(ISO_8859_2)).trim();
    }

    public File loadFile(String filePath) {
        return toFile(getClass().getResource(filePath));
    }
}
