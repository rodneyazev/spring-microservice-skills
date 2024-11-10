package com.main.app.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalPaymentService {

	public String processPayment() {
        return "Pagamento processado com sucesso";
    }

    public String simulateFailure() {
        throw new RuntimeException("Erro ao processar pagamento no serviço externo");
    }
	
}
