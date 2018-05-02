import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        //INSTANCIAS
        DAO dao = new DAO();
        Barramento barramento = new Barramento(16);
        Parser parser= new Parser(barramento.getLarguraBarramento());
        Encoder encoder = new Encoder(barramento.getLarguraBarramento());
        Cpu cpu = new Cpu(barramento);
        Ram ram = new Ram(barramento,16);
        EntradaSaida es = new EntradaSaida(barramento);
        int menu;


        int vetorCodigo[]= {1,2,1,2,3,1};

        for (int i=0 ; i < dao.pegarArrayListDAO().size(); i++) {

            menu = vetorCodigo[i];
            // --   ETAPAS --
            //passo 1 ler instrucao e checar no regex

            System.out.println(dao.pegarArrayListDAO().get(i));
            String vetor[] = parser.validando(dao.pegarArrayListDAO().get(i));
            System.out.println(Arrays.toString(vetor));
            //passo 2 encodificar(bytes) o vetor de Strings
            byte vetorBytes[] = encoder.encodificar(vetor);

            //passo 3 adiciona a fila do I/O
            es.adicionarInstrucao(vetorBytes);

            //passo 4 enfileira a instrucao do IO para o barramento // e envio para a cpu

            es.getBarramento().sendRam(es.pegarInstrucao());
            es.getBarramento().sendCpu(es.pegarInstrucao());

            //passo 5 recebe informação do barramento - payload (byte[]) escreve no vetor da RAM
            ram.write();

            //passo 6  cpu recebe instrucao do barramento que vem da Entrada e saida
            cpu.receive();

            //passo 7 envia para o barramento a informação do que quer ler da RAM
            cpu.send();

            //passo 8 verifica se possui algo na fila para ler e retornar para o barramento
            ram.read();

            //passo 9 Cpu Recebe o retorno do barramento que a Ram enviou
            cpu.receive();


            switch (menu) {
                case 1: //mov 1 e 2
                    //Passo 10 enviando para Barramento a instrução a ser movida
                    cpu.send();
                    //Passo 11 escrevendo na Ram a ultima instrução passada pela CPU
                    ram.write();

                    break;
                case 2: //mov 3
                    //Passo 10 enviando para Barramento a instrução a ser movida
                    cpu.send();
                    //passo 11 lendo da ram informação do endereço logico
                    ram.read();

                    //recebendo da ram dado e operando
                    cpu.receive();
                    break;
                case 3: //add 1 e 2 // imul 1 e 2 //inc 1 mov B, 5


                    break;

                case 4: //add 3 e 4 inc 2
                    //Passo 10 enviando para Barramento a instrução a ser movida
                    cpu.send();
                    //passo 11 lendo da ram informação do endereço logico
                    ram.read();

                    //recebendo da ram dado e operando
                    cpu.receive();

                    cpu.send();
                    ram.write();

                    break;
                case 5: //imul 3 4
                    //Passo 10 enviando para Barramento a instrução a ser movida
                    cpu.send();
                    //Passo 11 escrevendo na Ram a ultima instrução passada pela CPU
                    ram.write();
                    break;


            }

        }


    }





}