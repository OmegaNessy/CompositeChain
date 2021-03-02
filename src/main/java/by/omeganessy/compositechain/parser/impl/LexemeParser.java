package by.omeganessy.compositechain.parser.impl;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.Symbol;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.Parser;

public class LexemeParser implements Parser {
    final String PUNCTUATION_SYMBOL = "\\W+";
    final String PUNCTUATION_END_SYMBOL = "/\\W+$/";
    final String ESCAPED_WORD = "/^\\W/+/\\W$/";

    private Parser wordParser = new WordParser();

    @Override
    public Component parse(String text) throws CustomException {
        if (text == null || text.isEmpty()) {
            throw new CustomException("lexeme is null or empty");
        }
        Component component = new TextComposite(TextType.LEXEME);
        String word;
        Symbol symbol;
        if(text.matches(PUNCTUATION_SYMBOL)){
            symbol = new Symbol(text.charAt(0));
            component.addComponent(symbol);
        }
        else if (text.matches(ESCAPED_WORD)){

        }
        else{
            Component wordComponent = wordParser.parse(text);
            wordComponent.addComponent(wordComponent);
        }
        return null;
    }
}
