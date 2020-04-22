package verival;

public class DepComb
{
    public static final int MAX_ADITIVO  = 500;
    public static final int MAX_ALCOOL   = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tGasolina;
    private int tAditivo;
    private int tAlcool1;
    private int tAlcool2;

    public DepComb(int tGasolina, int tAditivo, int tAlcool1, int tAlcool2)
    {
        this.tGasolina = tGasolina;
        this.tAditivo = tAditivo;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
    }

    public int gettGasolina()
    {
        return tGasolina;
    }

    public int gettAditivo()
    {
        return tAditivo;
    }

    public int gettAlcool1()
    {
        return tAlcool1;
    }

    public int gettAlcool2()
    {
        return tAlcool2;
    }

    public int recebeAditivo(int qtdade)
    {
        int aux = 0;
        if(qtdade < 0)
        {
            return -1;
        }

        if(tAditivo + qtdade > MAX_ADITIVO)
        {
            aux = MAX_ADITIVO - tAditivo;
            tAditivo = MAX_ADITIVO;
            return aux;
        }
        else
        {
            tAditivo += qtdade;
            return qtdade;
        }
    }

    public int recebeGasolina(int qtdade)
    {
        int aux = 0;
        if(qtdade < 0)
        {
            return -1;
        }

        if(tGasolina + qtdade >= MAX_GASOLINA)
        {
            aux = MAX_GASOLINA - tGasolina;
            tGasolina = MAX_GASOLINA;
            return aux;
        }
        else
        {
            tGasolina += qtdade;
            return qtdade;
        }
    }

    public int recebeAlcool(int qtdade)
    {
        int aux = 0;
        if(qtdade < 0)
        {
            return -1;
        }

        if(qtdade >= MAX_ALCOOL)
        {
            aux = MAX_ALCOOL - (tAlcool1 + tAlcool2);
            tAlcool1 = MAX_ALCOOL/2;
            tAlcool2 = tAlcool1;
            return aux;
        } 
        else 
        {
            tAlcool1 += qtdade / 2;
            tAlcool2 += qtdade / 2;
            return qtdade;
        }
    }

    public int[] encomendaCombustivel(int qtdade, boolean emerg)
    {
        if(qtdade < 0)
        {
           int encomenda[] = new int[1];
           encomenda[0] = -2;
           return encomenda;
        }

        double aditivo  = tAditivo;
        double gasolina = tGasolina;
        double alcool   = tAlcool1 + tAlcool2;

        if(emerg)
        {
            aditivo  = aditivo  - (qtdade * 0.05);
            gasolina = gasolina - (qtdade * 0.7);
            alcool   = alcool   - (qtdade * 0.25);

            if(aditivo >=0 && gasolina >=0 && alcool >=0)
            {
                tAditivo  = (int)aditivo;
                tGasolina = (int)gasolina;
                tAlcool1  = (int)alcool/2;
                tAlcool2  = tAlcool1;
            }
            else
            {
                int encomenda[] = {0,0,0}; 

                if(aditivo < 0)
                {
                    encomenda[0] = -1;
                }
                if(gasolina < 0)
                {
                    encomenda[1] = -1;
                }
                if(alcool < 0)
                {
                    encomenda[2] = -1;
                }

                return encomenda;
            } 
        }
        else
        {
            aditivo  = aditivo  - (qtdade * 0.05);
            gasolina = gasolina - (qtdade * 0.7);
            alcool   = alcool   - (qtdade * 0.25);
    
            if(aditivo >=125 && gasolina >=2500 && alcool >=625)
            {
                tAditivo  = (int)aditivo;
                tGasolina = (int)gasolina;
                tAlcool1  = (int)alcool/2;
                tAlcool2  = tAlcool1;
            }
            else
            {
                int encomenda[] = {0,0,0};

                if(aditivo < 125)
                {
                    encomenda[0] = -1;
                }
                if(gasolina < 2500)
                {
                    encomenda[1] = -1;
                }
                if(alcool < 625)
                {
                    encomenda[2] = -1;
                }

                return encomenda;
            }
        }

        int[] encomenda = new int[4];

        encomenda[0] = tAditivo;
        encomenda[1] = tGasolina;
        encomenda[2] = tAlcool1;
        encomenda[3] = tAlcool2;

        return encomenda;
    }

    @Override
    public String toString()
    {
        return "DepComb [tAditivo=" + tAditivo + ", tAlcool1=" + tAlcool1 + ", tAlcool2=" + tAlcool2 + ", tGasolina="
                + tGasolina + "]";
    }
}