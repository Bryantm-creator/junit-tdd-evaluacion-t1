package pregunta1;

import java.time.LocalDate;

public class PedidoService {

    public String registrarPedido(String codigo, String nombre, Integer mesa, Double monto, LocalDate fecha) {

        // 1. VALIDAR VACÍOS PRIMERO
        if (codigo == null || nombre == null || nombre.isEmpty() || mesa == null || monto == null || fecha == null) {
            return "Debe ingresar todos los datos requeridos";
        }

        // 2. VALIDAR CÓDIGO
        if (!codigo.matches("P\\d{3}")) {
            return "Ingrese un código de pedido válido";
        }

        return "";
    }
}