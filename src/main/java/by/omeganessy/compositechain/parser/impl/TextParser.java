package by.omeganessy.compositechain.parser.impl;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;

public class TextParser implements Parser {
    final String PARAGRAPH_SPLITTER = "\\s{4}";
    private Parser paragraphParser = new ParagraphParser();

    @Override
    public Component parse(String text) throws CustomException {
        if (text == null || text.isEmpty()) {
            throw new CustomException("text is null or empty");
        }
        Component component = new TextComposite(TextType.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_SPLITTER);
        for (String paragraph : paragraphs) {
            if (!paragraph.isEmpty()) {
                Component paragraphComponent = paragraphParser.parse(paragraph);
                component.addComponent(paragraphComponent);
            }
        }
        return component;
    }
}
