package pregunta1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class PedidoServiceTest {

    @Test
    void deberiaRetornarErrorSiHayCamposVacios() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido(null, "", null, null, null);

        assertEquals("Debe ingresar todos los datos requeridos", resultado);
    }

    @Test
    void deberiaRetornarErrorSiNombreEsInvalido() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido("P123", "J1", 10, 50.0, LocalDate.now());

        assertEquals("El nombre del cliente debe tener al menos tres caracteres alfabéticos", resultado);
    }

}