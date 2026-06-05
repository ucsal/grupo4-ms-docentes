package org.example.docentes.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class AcademicoClient {

    private final RestTemplate restTemplate;

    @Value("${ms.academico.url}")
    private String academicoUrl;

    public AcademicoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HorarioResponse buscarHorarioPorId(Long horarioId) {
        try {
            String url = academicoUrl + "/api/horario/find/" + horarioId;
            return restTemplate.getForObject(url, HorarioResponse.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Horário com ID " + horarioId + " não encontrado no ms-acadêmico.");
        }
    }
}
