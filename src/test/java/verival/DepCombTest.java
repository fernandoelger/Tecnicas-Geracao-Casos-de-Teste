package verival;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DepCombTest
{
    private DepComb depComb;

    //------------- TECNICA BASEADA NA ESPECIFICACAO -------------
    //------------ Método para encomendar combustível ------------

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
        int expected[] = {425, 8950, 1062, 1062};
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

    //------------------ Métodos de encher tanques ------------------

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

    //------------------ TECNICA DO VALOR LIMITE -----------------
    //------------ Método para encomendar combustível ------------

    @Test
    public void onPointAditivoComEmergencia() {
        depComb = new DepComb(10000, 250, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(5000, true);
        int expected[] = {0, 6500, 625, 625};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void offPointAditivoComEmergencia() {
        depComb = new DepComb(10000, 250, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(5001, true);
        int expected[] = {-1, 0, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void onPointGasolinaComEmergencia() {
        depComb = new DepComb(5000, 500, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(7142, true);
        int expected[] = {142, 0, 357, 357};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void offPointGasolinaComEmergencia() {
        depComb = new DepComb(5000, 500, 1250, 1250);
        int actual[] = depComb.encomendaCombustivel(7143, true);
        int expected[] = {0, -1, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void onPointAlcoolComEmergencia() {
        depComb = new DepComb(10000, 500, 625, 625);
        int actual[] = depComb.encomendaCombustivel(5000, true);
        int expected[] = {250, 6500, 0, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void offPointAlcoolComEmergencia() {
        depComb = new DepComb(10000, 500, 625, 625);
        int actual[] = depComb.encomendaCombustivel(5001, true);
        int expected[] = {0, 0, -1};
        Assertions.assertArrayEquals(expected, actual);
    }

    //-----------------------------------------------------------------

    @Test
    public void onPointAditivoSemEmergencia() {
        depComb = new DepComb(9000, 250, 1125, 1125);
        int actual[] = depComb.encomendaCombustivel(2500, false);
        int expected[] = {125, 7250, 812, 812};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void offPointAditivoSemEmergencia() {
        depComb = new DepComb(9000, 250, 1125, 1125);
        int actual[] = depComb.encomendaCombustivel(2501, false);
        int expected[] = {-1, 0, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void onPointGasolinaSemEmergencia() {
        depComb = new DepComb(5000, 450, 1125, 1125);
        int actual[] = depComb.encomendaCombustivel(3571, false);
        int expected[] = {271, 2500, 678, 678};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void offPointGasolinaSemEmergencia() {
        depComb = new DepComb(5000, 450, 1125, 1125);
        int actual[] = depComb.encomendaCombustivel(3572, false);
        int expected[] = {0, -1, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void onPointAlcoolSemEmergencia() {
        depComb = new DepComb(9000, 450, 625, 625);
        int actual[] = depComb.encomendaCombustivel(2500, false);
        int expected[] = {325, 7250, 312, 312};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void offPointAlcoolSemEmergencia() {
        depComb = new DepComb(9000, 450, 625, 625);
        int actual[] = depComb.encomendaCombustivel(2501, false);
        int expected[] = {0, 0, -1};
        Assertions.assertArrayEquals(expected, actual);
    }
}