package pregunta2;

public class TransferenciaService {

    private CuentaRepository cuentaRepository;
    private FraudeService fraudeService;
    private OtpService otpService;
    private TransaccionRepository transaccionRepository;

    public TransferenciaService(CuentaRepository cuentaRepository,
                                FraudeService fraudeService,
                                OtpService otpService,
                                TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.fraudeService = fraudeService;
        this.otpService = otpService;
        this.transaccionRepository = transaccionRepository;
    }

    public boolean transferir(String origen, String destino, double monto) {

        if (!cuentaRepository.existeCuenta(destino)) {
            throw new RuntimeException("Cuenta destino no existe");
        }

        if (!cuentaRepository.tieneSaldo(origen, monto)) {
            throw new RuntimeException("Saldo insuficiente");
        }

        if (monto > 1000) {
            if (!otpService.validarOtp()) {
                throw new RuntimeException("OTP inválido");
            }
        }

        if (fraudeService.esSospechoso(origen, monto)) {
            throw new RuntimeException("Actividad sospechosa");
        }

        transaccionRepository.registrar(origen, destino, monto);

        return true;
    }
}