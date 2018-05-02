import java.util.ArrayList;

public class BarramentoEnderecoMemoria extends Thread implements Barramento3Vias<Integer> {
    private ArrayList<Integer> filaCpuEnderecoMemoria = new ArrayList<>();
    private ArrayList<Integer> filaRamEnderecoMemoria = new ArrayList<>();

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
    public void sendCpu(Integer endereco) {
        filaCpuEnderecoMemoria.add(endereco);

    }

    @Override
    public void sendRam(Integer endereco) {
        filaRamEnderecoMemoria.add(endereco);
    }



    @Override
    public Integer receiveRam() {
        if (filaCpuEnderecoMemoria.size() > 0){
            Integer aux = filaRamEnderecoMemoria.get(0);
            filaRamEnderecoMemoria.remove(0);
            return  aux;
        }
        return null;
    }

    @Override
    public Integer receiveCpu() {
        if (filaCpuEnderecoMemoria.size() > 0){
            Integer aux = filaCpuEnderecoMemoria.get(0);
            filaCpuEnderecoMemoria.remove(0);
            return aux;
        }
        return null;
    }
}
