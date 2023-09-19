package ch.zhaw.ads;

import ch.zhaw.ads.solutions.WellformedXmlServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ADS1_4_test {
    WellformedXmlServer xml;

    @BeforeEach
    public void setUp() {
        xml = new WellformedXmlServer();
    }

    private void test(String content, boolean expected) {
        assertEquals(expected, xml.checkWellformed(content), content);
    }

    @Test
    public void testXmlAttributes() {
        test("<a href=\"sugus\"></a>", true);
    }

    @Test
    public void testXml() {
        test("<a></a>", true);
        test("<a>", false);
        test("</a>", false);
        test("<a/>", true);
        test("<a><b></b></a>", true);
        test("<a><b></a></b>", false);
    }
}