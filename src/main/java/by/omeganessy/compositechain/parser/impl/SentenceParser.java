package by.omeganessy.compositechain.parser.impl;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;

public class SentenceParser implements Parser {
    final String WORD_SPLITTER = "\s";
    private Parser wordParser = new WordParser();

    @Override
    public Component parse(String text) throws CustomException {
        if (text == null || text.isEmpty()) {
            throw new CustomException("sentence is null or empty");
        }
        Component component = new TextComposite(TextType.SENTENCE);
        String[] words = text.split(WORD_SPLITTER);
        for (String word : words) {
            Component wordComponent = wordParser.parse(word);
            component.addComponent(wordComponent);
        }
        return component;
    }
}
