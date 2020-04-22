package verival;

public class DepComb {
    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tGasolina;
    private int tAditivo;
    private int tAlcool1;
    private int tAlcool2;

    public DepComb(int tGasolina, int tAditivo, int tAlcool1, int tAlcool2) {
        this.tGasolina = tGasolina;
        this.tAditivo = tAditivo;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
    }

    public int gettGasolina() {
        return tGasolina;
    }

    public int gettAditivo() {
        return tAditivo;
    }

    public int gettAlcool1() {
        return tAlcool1;
    }

    public int gettAlcool2() {
        return tAlcool2;
    }

    public int recebeAditivo(int qtdade) {
        int aux = 0;
        if (qtdade < 0) {
            return -1;
        }
        if (tAditivo + qtdade >= 500) {
            aux = 500 - tAditivo;
            tAditivo = 500;
            return aux;
        } else {
            tAditivo += qtdade;
            return qtdade;
        }
    }

    public int recebeGasolina(int qtdade) {
        int aux = 0;
        if (qtdade < 0) {
            return -1;
        }
        if (tGasolina + qtdade >= 10000) {
            aux = 10000 - tGasolina;
            tGasolina = 10000;
            return aux;
        } else {
            tGasolina += qtdade;
            return qtdade;
        }
    }

    public int recebeAlcool(int qtdade) {
        int aux = 0;
        if (qtdade < 0) {
            return -1;
        }
        if (qtdade >= 2500) {
            aux = 2500 - (tAlcool1 + tAlcool2);
            tAlcool1 = 1250;
            tAlcool2 = 1250;
            return aux;
        } else {
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

        double aditivo = tAditivo;
        double gasolina = tGasolina;
        double alcool = tAlcool1 + tAlcool2;

        if(emerg)
        {
            aditivo  = aditivo  - (qtdade * 0.05);
            gasolina = gasolina - (qtdade * 0.7);
            alcool   = alcool   - (qtdade * 0.25);
            //System.out.println("aditivo: " + aditivo);
            //System.out.println("gasolina" + gasolina);
            //System.out.println("alcool" + alcool);
            //System.out.println("alcool dividido" + alcool/2);

            if(aditivo >=0 && gasolina >=0 && alcool >=0)
            {
                tAditivo  = (int)aditivo;
                tGasolina = (int)gasolina;
                tAlcool1  = (int)alcool/2;
                tAlcool2  = tAlcool1;

                //System.out.println("aditivo: " + tAditivo);
                //System.out.println("gasolina: " + tGasolina);
                //System.out.println("alcool 1: " + tAlcool1);
                //System.out.println("alcool 2: " + tAlcool2);
            }
            else
            {
                int encomenda[] = {0,0,0}; 

                if(aditivo < 0){
                    encomenda[0] = -1;
                }
                if(gasolina < 0){
                    encomenda[1] = -1;
                }
                if(alcool < 0){
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
            System.out.println("aditivo: " + aditivo);
            System.out.println("gasolina" + gasolina);
            System.out.println("alcool" + alcool);
            System.out.println("alcool dividido" + alcool/2);
    
            if(aditivo >=125 && gasolina >=2500 && alcool >=625){
                tAditivo  = (int)aditivo;
                tGasolina = (int)gasolina;
                tAlcool1  = (int)alcool/2;
                tAlcool2  = tAlcool1;

                System.out.println("\n\naditivo: " + tAditivo);
                System.out.println("gasolina: " + tGasolina);
                System.out.println("alcool 1: " + tAlcool1);
                System.out.println("alcool 2: " + tAlcool2);
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
    public String toString() {
        return "DepComb [tAditivo=" + tAditivo + ", tAlcool1=" + tAlcool1 + ", tAlcool2=" + tAlcool2 + ", tGasolina="
                + tGasolina + "]";
    }

    
    public static void main(String args[])
    {
    DepComb depComb = new DepComb(10000, 500, 1250, 1250);
    int actual[] = depComb.encomendaCombustivel(5000, true);
    //System.out.println("vetor: " + actual);
    //System.out.println("toString do objeto: \n\n" + depComb);
    }
}