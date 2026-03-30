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

        String resultado = service.registrarPedido("123", "Juan", 10, 50.0, LocalDate.now());

        assertEquals("Ingrese un código de pedido válido", resultado);
    }

    @Test
    void deberiaRetornarErrorSiNombreEsInvalido() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido("P123", "J1", 10, 50.0, LocalDate.now());

        assertEquals("El nombre del cliente debe tener al menos tres caracteres alfabéticos", resultado);
    }

    @Test
    void deberiaRetornarErrorSiMesaEsInvalida() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido("P123", "Juan", 0, 50.0, LocalDate.now());

        assertEquals("Ingrese un número de mesa válido", resultado);
    }
    @Test
    void deberiaRetornarErrorSiMontoEsInvalido() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido("P123", "Juan", 10, -5.0, LocalDate.now());

        assertEquals("El monto total debe ser mayor a cero", resultado);
    }
    @Test
    void deberiaRetornarErrorSiFechaEsInvalida() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido("P123", "Juan", 10, 50.0, LocalDate.of(2020, 1, 1));

        assertEquals("La fecha del pedido debe ser la fecha actual", resultado);
    }
    @Test
    void deberiaRegistrarPedidoCorrectamente() {
        PedidoService service = new PedidoService();

        String resultado = service.registrarPedido("P123", "Juan", 10, 50.0, LocalDate.now());

        assertEquals("El pedido ha sido registrado correctamente", resultado);
    }
}