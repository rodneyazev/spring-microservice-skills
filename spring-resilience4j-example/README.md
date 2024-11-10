O PaymentController expõe endpoints para processar pagamentos e simular falhas.

O ExternalPaymentService simula um serviço externo, processando pagamentos com sucesso ou gerando uma exceção para simular falhas.

O PaymentService utiliza a anotação @CircuitBreaker para envolver métodos em um circuit Breaker. O método processPayment tenta chamar o serviço externo, ativa o circuit breaker em caso de falha e chama o método de fallback. O método simulateFailure simula uma falha e invoca o método de fallback.


Teste de Chamada Bem-Sucedida (/processPayment)
Resultado Esperado:
Resposta: "Pagamento processado com sucesso"

LOG => Chamada ao serviço externo de processamento de pagamentos bem-sucedida. Resultado: Pagamento processado com sucesso



O teste invoca o método processPayment do PaymentService, a chamada ao serviço externo é bem-sucedida, e o log mostra isso.

Teste de Simulação de Falha (/simulateFailure)
Resultado Esperado:
Resposta: "Pagamento falhou. Tente novamente mais tarde."

LOG => Circuito aberto. Chamando fallbackProcessPayment devido a falha.



O teste invoca o método simulateFailure do PaymentService. A simulação de falha ativa o Circuit Breaker, e o método de fallback é chamado, conforme indicado no log.

Estratégias Adicionais de Resiliência
Este exemplo básico oferece uma base para a implementação de resiliência, mas em ambientes mais complexos, estratégias adicionais, como Retry, Fallback Hierárquico e Rate Limiting, são essenciais. Em sistemas financeiros críticos, por exemplo.