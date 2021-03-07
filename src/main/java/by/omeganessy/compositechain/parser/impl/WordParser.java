package by.omeganessy.compositechain.parser.impl;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.Symbol;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;

public class WordParser implements Parser {
    private static final String LETTER_REGEX = "[a-zA-Zа-яА-Я0-9]";
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    @Override
    public Component parse(String text) throws CustomException {
        if (text == null || text.isEmpty()) {
            throw new CustomException("word is null or empty");
        }
        TextType type = null;
        Component component = new TextComposite(TextType.WORD);
        String[] chars = text.split("");
        for (String symbolChar : chars) {
            if (symbolChar.matches(LETTER_REGEX)) {
                type = TextType.SYMBOL;
            } else if (symbolChar.matches(PUNCTUATION_REGEX)) {
                type = TextType.PUNCTUATION;
            }
            Symbol symbol = new Symbol(symbolChar.charAt(0),type);
            component.addComponent(symbol);
        }
        return component;
    }
}
