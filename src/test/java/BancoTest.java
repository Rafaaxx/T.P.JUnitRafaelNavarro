import org.example.Banco;
import org.example.Cuenta;
import org.example.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BancoTest {
    private Banco banco;
 @BeforeEach
    public void crearbanco(){
     banco=new Banco();
 }
   @Test
   @DisplayName("Prueba de adicion de cuentas")
    public void agregarclienteyconsultasaldo(){
       Cuenta cuenta=new Cuenta("123",500.0);
       banco.agregarcuenta(cuenta);
       double numero=banco.consultarsaldo("123");
       assertEquals(cuenta.getSaldo(), numero);
   }
   @Test
    @DisplayName("Prueba de consulta de saldo")
    public void consultadesaldoexcepcion(){
     try{
         banco.consultarsaldo("123");
         fail("No se lanzó la excepción");
     }catch (RuntimeException e){
         assertEquals("No existe la cuenta",e.getMessage());
     }
   }
   @Test
    @DisplayName("Prueba de depósitos")
    public void pruebadeposito(){
       Cuenta cuenta=new Cuenta("123",500);
       banco.agregarcuenta(cuenta);
       banco.depositar("123",300);
       assertEquals(800.0,cuenta.getSaldo());
   }
   @Test
    @DisplayName("Prueba excepcion cuenta inexistente")
   public void pruebadepositoexcepcion1(){
     try{
     banco.depositar("12344",200);
     fail("No se lanzó la excepcion");
   } catch (RuntimeException e) {
         assertEquals("No existe la cuenta",e.getMessage());
     }
 }
    @Test
    @DisplayName("Prueba excepcion monto negativo")
    public void pruebadepositoexcepcion2(){
     Cuenta cuenta=new Cuenta("123",400.0);
     banco.agregarcuenta(cuenta);
     try {
         banco.depositar("123", -300);
         fail("Excepcion no lanzada");
     } catch (IllegalArgumentException e) {
         assertEquals("El monto es negativo.",e.getMessage());
     }
    }
    @Test
    @DisplayName("Prueba de retiros")
    public void pruebaretiros(){
     Cuenta cuenta=new Cuenta("123",500);
     banco.agregarcuenta(cuenta);
     banco.retirar("123",100);
     assertEquals(400,cuenta.getSaldo());
    }
    @Test
    @DisplayName("Prueba excepcion cuenta inexistente")
    public void pruebaexcepcionretiro1(){
     try {
         banco.retirar("123", 400);
         fail("Excepcion no lanzada");

     }catch (RuntimeException e){
         assertEquals("No existe la cuenta",e.getMessage());
     }
    }
    @Test
    @DisplayName("Prueba excepcion monto negativo")
    public void pruebaexcepcionretiro2(){
     Cuenta cuenta=new Cuenta("123",500);
     banco.agregarcuenta(cuenta);
     try{
         banco.retirar("123",-21);
         fail("Excepcion no lanzada");
     }catch (IllegalArgumentException e){
         assertEquals("El monto es negativo.",e.getMessage());
        }

    }
    @Test
    @DisplayName("Prueba excepcion saldo insuficiente")
    public void pruebaexcepcionretiro3(){
        Cuenta cuenta=new Cuenta("123",500);
        banco.agregarcuenta(cuenta);
        try{
            banco.retirar("123",1234);
            fail("Excepcion no lanzada");
        }catch (SaldoInsuficienteException e){
            assertEquals("El monto a retirar es mayor que el saldo",e.getMessage());
        }
    }
}
