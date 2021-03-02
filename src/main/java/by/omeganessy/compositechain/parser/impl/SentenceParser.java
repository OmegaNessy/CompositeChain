package by.omeganessy.compositechain.parser.impl;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;

public class SentenceParser implements Parser {
    final String LEXEME_SPLITTER = "\s";
    private Parser lexemeParser = new LexemeParser();

    @Override
    public Component parse(String text) throws CustomException {
        if (text == null || text.isEmpty()) {
            throw new CustomException("sentence is null or empty");
        }
        Component component = new TextComposite(TextType.SENTENCE);
        String[] lexemes = text.split(LEXEME_SPLITTER);
        for (String lexeme : lexemes) {
            Component lexemeComponent = lexemeParser.parse(lexeme);
            component.addComponent(lexemeComponent);
        }
        return component;
    }
}
