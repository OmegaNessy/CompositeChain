package by.omeganessy.compositechain.main;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;
import by.omeganessy.compositechain.parser.impl.TextParser;
import by.omeganessy.compositechain.util.FileReaderUtil;

public class Main {
    public static void main(String[] args) throws CustomException {
        FileReaderUtil reader = new FileReaderUtil();
        String text = reader.read("resources/data/data.txt");

        Parser parser = new TextParser();
        Component textComponent = parser.parse(text);
        System.out.println(textComponent);
    }
}
