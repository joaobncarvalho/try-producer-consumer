package org.acme.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.RequestDto;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/producer")
@ApplicationScoped
public class ProducerResource {

    @Inject
    @Channel("words-out")
    Emitter<String> emitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void produce(RequestDto request) {
        // Log para verificar a entrada
        System.out.println("Recebendo mensagem: " + request);

        // Construir JSON
        String message = String.format(
                "{\"idMensagemExterna\":\"%s\",\"idMensagemInterna\":\"%s\",\"descricao\":\"%s\",\"isError\":%s}",
                request.getIdMensagemExterna(),
                request.getIdMensagemInterna(),
                request.getDescricao(),
                request.isError()
        );

        // Enviar para Kafka
        emitter.send(message);
        System.out.println("Mensagem enviada para o Kafka: " + message);
    }
}
