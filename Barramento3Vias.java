public interface  Barramento3Vias <T>{



      void sendCpu(T endereco);

      void sendRam(T endereco);


      T receiveRam() ;

      T receiveCpu();

}
