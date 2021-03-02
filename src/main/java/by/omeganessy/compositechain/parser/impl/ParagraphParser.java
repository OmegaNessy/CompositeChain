package by.omeganessy.compositechain.parser.impl;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;

public class ParagraphParser implements Parser {
    final String SENTENCE_SPLITTER = "(?<=([.!?.{3}]\\s))";
    private Parser sentenceParser = new SentenceParser();

    @Override
    public Component parse(String text) throws CustomException {
        if (text == null || text.isEmpty()) {
            throw new CustomException("paragraph is null or empty");
        }
        Component component = new TextComposite(TextType.PARAGRAPH);
        String[] sentences = text.split(SENTENCE_SPLITTER);
        for (String sentence : sentences) {
            Component sentenceComponent = sentenceParser.parse(sentence);
            component.addComponent(sentenceComponent);
        }
        return component;
    }
}
