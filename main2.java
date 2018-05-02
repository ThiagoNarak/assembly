import com.sun.prism.paint.Color;

import java.util.List;


public class main2 {
    public static void main(String[] args) {
        Emulator emulator = new Emulator(16,1024);

        emulator.run();
        asd();
    }
    static public void asd(){
        DAO dao = new DAO();
        List users = dao.pegarArrayListDAO();
        for (int i = 0; i < users.size(); i++) {

            System.out.println(users.get(i));

        }


    }
}
