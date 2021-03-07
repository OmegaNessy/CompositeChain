package by.omeganessy.compositechain.logic;

import by.omeganessy.compositechain.composite.Component;
import by.omeganessy.compositechain.exception.CustomException;
import by.omeganessy.compositechain.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextEditorTest {
    TextEditor textEditor;

    @BeforeClass
    public void setUp() {
        textEditor = new TextEditor();
    }

    @AfterClass
    public void tearDown() {
        textEditor = null;
    }

    @Test(dataProvider = "paragraphSortData")
    public void paragraphSortTest(Component textComponent, String expected) throws CustomException {
        Component actual = textEditor.paragraphSort(textComponent);
        Assert.assertEquals(actual.toString(), expected);
    }

    @DataProvider(name = "paragraphSortData")
    public Object[][] createParagraphSortData() throws CustomException {
        TextParser textParser = new TextParser();
        String text1 = "    Hello World.\n   Greate. And.\n   None Problem detected.";
        String sortedText1 = "\t\n\t Hello World.\t\n\t None Problem detected.\t\n\t Greate. And.";
        Component textComponent1 = textParser.parse(text1);
        String text2 = "    Hello World. Hello World.\n   Hello.   \nHello World. Hello World. Hello World.";
        String sortedText2 = "\t\n\t Hello.\t\n\t Hello World. Hello World.\t\n\t Hello World. Hello World. Hello World.";
        Component textComponent2 = textParser.parse(text2);
        String text3 = "    Hello World. Hello World. Hello World.";
        String sortedText3 = "\t\n\t Hello World. Hello World. Hello World.";
        Component textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

}
