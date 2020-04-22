package verival;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DepCombTest
{
    private DepComb depComb;

    // ------------ Método para encomendar combustível ------------

    @Test
    public void vendeNaEmergencia() {
        depComb = new DepComb(10000, 500, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(5000, true);
        int expected[] = {250, 6500, 625, 625};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void naoVendeNaEmergencia() {
        depComb = new DepComb(10000, 500, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(15000, true);
        int expected[] = {-1, -1, -1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void vendeSemEmergencia() {
        depComb = new DepComb(10000, 500, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(1500, false);
        int expected[] = {425, 8950, 1063, 1063};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void naoVendeSemEmergencia() {
        depComb = new DepComb(10000, 500, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(8250, false);
        int expected[] = {-1, 0, -1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void quantidadeInvalida() {
        depComb = new DepComb(10000, 500, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(-1, false);
        int expected[] = {-2};
        Assertions.assertArrayEquals(expected, actual);
    }

    // ------------------ Métodos de encher tanques ------------------

    @Test
    public void recebeAditivo() {
        depComb = new DepComb(10000, 200, 1250, 1250);
        int actual = depComb.recebeAditivo(500);
        int expected = 300;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void recebeAditivoInvalido() {
        depComb = new DepComb(10000, 200, 1250, 1250);
        int actual = depComb.recebeAditivo(-1);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void recebeGasolina() {
        depComb = new DepComb(7000, 500, 1250, 1250);
        int actual = depComb.recebeGasolina(10000);
        int expected = 3000;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void recebeGasolinaInvalido() {
        depComb = new DepComb(7000, 500, 1250, 1250);
        int actual = depComb.recebeGasolina(-10);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void recebeAlcool() {
        depComb = new DepComb(10000, 500, 50, 50);
        int actual = depComb.recebeAlcool(2500);
        int expected = 2400;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void recebeAlcoolInvalido() {
        depComb = new DepComb(10000, 500, 50, 50);
        int actual = depComb.recebeAlcool(-100);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }
}