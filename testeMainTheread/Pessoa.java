package testeMainTheread;

import java.util.ArrayList;
import java.util.Arrays;

public class Pessoa  extends Thread{
    private ArrayList<String> lista = new ArrayList<>();
    int contador =0;
    boolean rodando = true;

    @Override
    public void run() {


            while (rodando) {


                try {
                    sleep(5000);
                    System.out.println(Arrays.toString(new ArrayList[]{lista}));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    public void add(String add){
    lista.add(add);
    contador++;
    }

    public void parar()
    {
        this.rodando = false;
    }
}
