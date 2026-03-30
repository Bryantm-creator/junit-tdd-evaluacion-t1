package pregunta1;

import java.time.LocalDate;

public class PedidoService {

    public String registrarPedido(String codigo, String nombre, Integer mesa, Double monto, LocalDate fecha) {

        // 1.Campos vacios
        if (codigo == null || nombre == null || nombre.isEmpty() || mesa == null || monto == null || fecha == null) {
            return "Debe ingresar todos los datos requeridos";
        }

        // 2.Codigo
        if (!codigo.matches("P\\d{3}")) {
            return "Ingrese un código de pedido válido";
        }

        // 3.Nombre
        if (!nombre.matches("[a-zA-Z]{3,}")) {
            return "El nombre del cliente debe tener al menos tres caracteres alfabéticos";
        }

        // 4.Numero de mesa
        if (mesa < 1 || mesa > 50) {
            return "Ingrese un número de mesa válido";
        }
        // 5.Monto
        if (monto <= 0) {
            return "El monto total debe ser mayor a cero";
        }
        // 6.Fecha
        if (!fecha.equals(LocalDate.now())) {
            return "La fecha del pedido debe ser la fecha actual";
        }
        return "El pedido ha sido registrado correctamente";
    }
}