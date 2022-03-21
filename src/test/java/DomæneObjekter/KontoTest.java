package DomæneObjekter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {

    Konto konto;

    @BeforeEach
    void setUp() {
      konto = new Konto("Nik", "123",100);
    }

    @Test
    void indsæt() {
        assertEquals(200,konto.indsæt(100));
    }

    @Test
    void indsætNegativ() {
        assertEquals(100,konto.indsætNegativ(-100));
    }

    @Test
    void hæv() {
        assertEquals(0, konto.hæv(100));
    }

    @Test
    void bevilgetOvertræk() {
        assertEquals(-100,konto.bevilgetOvertræk(-200));
    }
}