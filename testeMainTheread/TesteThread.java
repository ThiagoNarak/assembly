package testeMainTheread;

import java.util.Scanner;

public class TesteThread {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        pessoa.start();




        while (true){
            System.out.println("digite o nome");
            String nome = scanner.next();
            pessoa.add(nome);
        }



    }
}
