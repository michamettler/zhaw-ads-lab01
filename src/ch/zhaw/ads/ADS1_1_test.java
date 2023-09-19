package ch.zhaw.ads;

import ch.zhaw.ads.solutions.KgvServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ADS1_1_test {
    KgvServer server;

    @BeforeEach
    public void setUp() {
        server = new KgvServer();
    }

    @Test
    public void testKgv() {
        assertEquals(12, server.kgv(3, 4), "kgv von 3 4");
        assertEquals(4, server.kgv(2, 4), "kgv von 2 4");
        assertEquals(35, server.kgv(5, 7), "kgv von 5 7");
        assertEquals(12, server.kgv(4, 6), "kgv von 4 6");
    }
}
