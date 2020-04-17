package verival;

public class DepComb 
{
    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tGasolina;
    private int tAditivo;
    private int tAlcool1;
    private int tAlcool2;

    public DepComb(int tGasolina,int tAditivo,int tAlcool1,int tAlcool2)
    {
        this.tGasolina = tGasolina;
        this.tAditivo = tAditivo;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
    }

    public int gettGasolina(){ return tGasolina; }
    public int gettAditivo(){ return tAditivo; }
    public int gettAlcool1(){ return tAlcool1; }
    public int gettAlcool2(){ return tAlcool2; }

    public int recebeAditivo(int qtdade)
    {
        return 0;
    }

    public int recebeGasolina(int qtdade)
    {
        return 0;
    }

    public int recebeAlcool(int qtdade)
    {
        return 0;
    }

    public int[] encomendaCombustivel(int qtdade,boolean emerg)
    {
        return  null;
    }
    
    @Override
    public String toString()
    {
        return "DepComb [tAditivo=" + tAditivo +
               ", tAlcool1=" + tAlcool1 +
               ", tAlcool2=" + tAlcool2 + 
               ", tGasolina="+ tGasolina + "]";
    }
}