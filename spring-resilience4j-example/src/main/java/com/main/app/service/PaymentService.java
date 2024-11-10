package com.main.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {

	@Autowired
    private ExternalPaymentService externalPaymentService;

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackProcessPayment")
    public String processPayment() {
        try {
            String result = externalPaymentService.processPayment();
            log.info("Chamada ao serviço externo de processamento de pagamentos bem-sucedida. Resultado: {}", result);
            return result;
        } catch (RuntimeException e) {
            log.error("Erro durante a chamada ao serviço externo de processamento de pagamentos", e);
            throw e;
        }
    }

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackProcessPayment")
    public String simulateFailure() {
        try {
            return externalPaymentService.simulateFailure();
        } catch (RuntimeException e) {
            return fallbackProcessPayment(e);
        }
    }

    public String fallbackProcessPayment(Throwable t) {
        log.warn("Circuito aberto. Chamando fallbackProcessPayment devido a falha.", t);
        return "Pagamento falhou. Tente novamente mais tarde.";
    }
	
}
