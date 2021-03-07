package by.omeganessy.compositechain.parser;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.composite.Symbol;
import by.omeganessy.compositechain.composite.TextComposite;
import by.omeganessy.compositechain.composite.TextType;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentenceParserTest {
    private TextParser textParser;

    @BeforeClass
    public void setUp() {
        textParser = new TextParser();
    }

    @AfterClass
    public void tearDown() {
        textParser = null;
    }

    @Test(dataProvider = "textParserData")
    public void textParserTest(Component expected, String text) throws CustomException {
        Component actual = textParser.parse(text);
        Assert.assertEquals(actual.toString(),expected.toString());
    }

    @DataProvider(name = "textParserData")
    public Object[][] createTextParserData(){
        Symbol symbolLeaf1 = new Symbol('H',TextType.SYMBOL);
        Symbol symbolLeaf2 = new Symbol('e',TextType.SYMBOL);
        Symbol symbolLeaf3 = new Symbol('l',TextType.SYMBOL);
        Symbol symbolLeaf4 = new Symbol('l',TextType.SYMBOL);
        Symbol symbolLeaf5 = new Symbol('o',TextType.SYMBOL);
        Component word1 = new TextComposite(TextType.WORD);
        word1.addComponent(symbolLeaf1);
        word1.addComponent(symbolLeaf2);
        word1.addComponent(symbolLeaf3);
        word1.addComponent(symbolLeaf4);
        word1.addComponent(symbolLeaf5);
        Symbol symbolLeaf6 = new Symbol('w',TextType.SYMBOL);
        Symbol symbolLeaf7 = new Symbol('o',TextType.SYMBOL);
        Symbol symbolLeaf8 = new Symbol('r',TextType.SYMBOL);
        Symbol symbolLeaf9 = new Symbol('l',TextType.SYMBOL);
        Symbol symbolLeaf10 = new Symbol('d',TextType.SYMBOL);
        Symbol symbolLeaf11 = new Symbol('!',TextType.PUNCTUATION);
        Component word2 = new TextComposite(TextType.WORD);
        word2.addComponent(symbolLeaf6);
        word2.addComponent(symbolLeaf7);
        word2.addComponent(symbolLeaf8);
        word2.addComponent(symbolLeaf9);
        word2.addComponent(symbolLeaf10);
        word2.addComponent(symbolLeaf11);
        Component sentence1 = new TextComposite(TextType.SENTENCE);
        sentence1.addComponent(word1);
        sentence1.addComponent(word2);
        Symbol symbolLeaf12 = new Symbol('J',TextType.SYMBOL);
        Symbol symbolLeaf13 = new Symbol('A',TextType.SYMBOL);
        Symbol symbolLeaf14 = new Symbol('V',TextType.SYMBOL);
        Symbol symbolLeaf15 = new Symbol('A',TextType.SYMBOL);
        Symbol symbolLeaf16 = new Symbol('.',TextType.PUNCTUATION);
        Component word3 = new TextComposite(TextType.WORD);
        word3.addComponent(symbolLeaf12);
        word3.addComponent(symbolLeaf13);
        word3.addComponent(symbolLeaf14);
        word3.addComponent(symbolLeaf15);
        word3.addComponent(symbolLeaf16);
        Component sentence2 = new TextComposite(TextType.SENTENCE);
        sentence2.addComponent(word3);
        Component paragraph1 = new TextComposite(TextType.PARAGRAPH);
        paragraph1.addComponent(sentence1);
        paragraph1.addComponent(sentence2);
        Symbol symbolLeaf17 = new Symbol('L',TextType.SYMBOL);
        Symbol symbolLeaf18 = new Symbol('a',TextType.SYMBOL);
        Symbol symbolLeaf19 = new Symbol('n',TextType.SYMBOL);
        Symbol symbolLeaf20 = new Symbol('g',TextType.SYMBOL);
        Symbol symbolLeaf21 = new Symbol('u',TextType.SYMBOL);
        Symbol symbolLeaf22 = new Symbol('a',TextType.SYMBOL);
        Symbol symbolLeaf23 = new Symbol('g',TextType.SYMBOL);
        Symbol symbolLeaf24 = new Symbol('e',TextType.SYMBOL);
        Symbol symbolLeaf25 = new Symbol('.',TextType.PUNCTUATION);
        Component word4 = new TextComposite(TextType.WORD);
        word4.addComponent(symbolLeaf17);
        word4.addComponent(symbolLeaf18);
        word4.addComponent(symbolLeaf19);
        word4.addComponent(symbolLeaf20);
        word4.addComponent(symbolLeaf21);
        word4.addComponent(symbolLeaf22);
        word4.addComponent(symbolLeaf23);
        word4.addComponent(symbolLeaf24);
        word4.addComponent(symbolLeaf25);
        Component sentence3 = new TextComposite(TextType.SENTENCE);
        sentence3.addComponent(word4);
        Component paragraph2 = new TextComposite(TextType.PARAGRAPH);
        paragraph2.addComponent(sentence3);
        Component textComponent = new TextComposite(TextType.TEXT);
        textComponent.addComponent(paragraph1);
        textComponent.addComponent(paragraph2);
        String text1 = "Hello world! JAVA.\nLanguage\n";
        return new Object[][]{
                {textComponent,text1}
        };
    }
}
