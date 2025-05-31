import static org.junit.jupiter.api.Assertions.*;

import org.example.ExcepcionEdad;
import org.example.Usuario;
import org.junit.jupiter.api.*;

public class UsuarioTest {
    private static Usuario usuario;
    @BeforeAll
    public static void iniciar(){
        System.out.println("INICIANDO PRUEBA");
    }
    @AfterAll
    public static void terminar(){
        System.out.println("TERMINANDO PRUEBA");
    }
    @BeforeEach
    public  void iniciarusuario(){
        usuario=new Usuario("Juan",25);
    }
    @AfterEach
    public  void cerrarproceso(){
        System.out.println("Prueba finalizada");
    }
    @Test
    @DisplayName("Prueba de asignacion y obtencion del nombre")
    public  void testnombre(){
        String nombreesperado="Juan";
        String nombrereal=usuario.getNombre();
        assertEquals(nombreesperado,nombrereal);
    }
    @Test
    @DisplayName("Prueba de asignacion y obtencion de la edad")
    public void testedad(){
        try{
            usuario.setEdad(25);
        } catch (ExcepcionEdad e) {
            fail("Error en la edad" +e.getMessage());
        }
        int edadesperada=25;
        assertEquals(edadesperada,usuario.getEdad());
    }
    @Test
    @DisplayName("Prueba de edad negativa")
    public void testedadnegativa(){
        try{
            usuario.setEdad(-2);
            fail("Excepcion no lanzada");
        } catch (ExcepcionEdad e) {
            assertEquals("La edad no puede ser negativa",e.getMessage());
        }

    }

}

