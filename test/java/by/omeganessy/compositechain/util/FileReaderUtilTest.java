package by.omeganessy.compositechain.util;

import by.omeganessy.compositechain.exception.CustomException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileReaderUtilTest {
    FileReaderUtil fIleReader;

    @BeforeClass
    public void setUp() {
        fIleReader = new FileReaderUtil();
    }

    @AfterClass
    public void tearDown() {
        fIleReader = null;
    }

    @Test(dataProvider = "textData")
    public void readTextTest(String fileName, String expected) throws CustomException {
        String actual = fIleReader.read(fileName);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "textData")
    public Object[][] createReadTextData() {
        String text = "    It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!" +
                "    It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?" +
                "    It is a established fact that a reader will be of a page when looking at its layout..." +
                "    Bye бандерлоги.";
        String text2 = "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                "    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English." +
                "    It is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout." +
                "    Bye.";
        return new Object[][]{
                {"resources/data/data.txt", text},
                {"resources/data/dataForTesting.txt", text2}
        };
    }
}
