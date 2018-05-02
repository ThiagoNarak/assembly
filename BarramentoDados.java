import java.util.ArrayList;

public class BarramentoDados  extends Thread implements Barramento3Vias<Instrucao>{
    private ArrayList<Instrucao> filaCpuDados = new ArrayList<>();
    private ArrayList<Instrucao> filaRamDados = new ArrayList<>();

    @Override
    public void run() {
        while (true){
            try {

                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendCpu(Instrucao payload) {
        filaCpuDados.add(payload);

    }

    @Override
    public void sendRam(Instrucao payload) {
        filaRamDados.add(payload);
    }

    @Override

    public Instrucao receiveRam() {
        if (filaCpuDados.size() > 0){
            Instrucao aux = filaRamDados.get(0);
            filaRamDados.remove(0);
            return  aux;
        }
        return null;
    }

    @Override
    public Instrucao receiveCpu() {
        if (filaCpuDados.size() > 0){
            Instrucao aux = filaCpuDados.get(0);
            filaCpuDados.remove(0);
            return aux;
        }
        return null;
    }

}
