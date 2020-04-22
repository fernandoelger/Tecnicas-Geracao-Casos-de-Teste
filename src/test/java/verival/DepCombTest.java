package verival;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DepCombTest
{
    private DepComb depComb;

    @BeforeEach
    public void setup(){
        depComb = new DepComb(10000, 500, 1250, 1250);
    }
    @Test
    public void somenteBarrasDe5() {
        int actual[] = depComb.encomendaCombustivel(5000, true);
        int expected[] = {250, 6500, 625, 625};
        assertArrayEquals(expected, actual);
    }

}