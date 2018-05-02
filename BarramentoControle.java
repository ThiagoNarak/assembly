import util.EnumCod;

import java.util.ArrayList;

public class BarramentoControle extends Thread implements Barramento3Vias<EnumCod>{

    private ArrayList<EnumCod> filaCpuControle = new ArrayList<>();
    private ArrayList<EnumCod> filaRamControle = new ArrayList<>();

    @Override
    public void run() {

        while (true) {
            try {


                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void sendCpu(EnumCod codigo) {
        filaCpuControle.add(codigo);

    }

    @Override
    public void sendRam(EnumCod codigo) {
    filaRamControle.add(codigo);
    }

    @Override
    public EnumCod receiveRam() {
        if (filaCpuControle.size() > 0){
            EnumCod aux = filaRamControle.get(0);
            filaRamControle.remove(0);
            return  aux;
        }
        return null;
    }

    @Override
    public EnumCod receiveCpu() {
        if (filaCpuControle.size() > 0){
            EnumCod aux = filaCpuControle.get(0);
            filaCpuControle.remove(0);
            return aux;
        }
        return null;
    }


}
