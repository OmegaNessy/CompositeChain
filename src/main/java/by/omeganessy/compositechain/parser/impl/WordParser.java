package by.omeganessy.compositechain.parser.impl;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.Symbol;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;

public class WordParser implements Parser {
    @Override
    public Component parse(String text) throws CustomException {
        if (text == null || text.isEmpty()) {
            throw new CustomException("word is null or empty");
        }
        Component component = new TextComposite(TextType.SYMBOL);
        char[] symbols = text.toCharArray();
        for (char symbolChar : symbols) {
            Symbol symbol = new Symbol(symbolChar);
            component.addComponent(symbol);
        }
        return component;
    }
}
