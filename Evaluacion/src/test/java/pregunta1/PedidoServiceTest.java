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
    void deberiaRetornarErrorSiCodigoEsInvalido() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido("A123", "Juan", 10, 50.0, LocalDate.now());

        assertEquals("Ingrese un código de pedido válido", resultado);
    }

}