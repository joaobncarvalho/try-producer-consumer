package org.acme.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestDto {
    public String idMensagemExterna;
    public String idMensagemInterna;
    public String descricao;
    public boolean isError;

    public String getIdMensagemExterna() {
        return idMensagemExterna;
    }

    public void setIdMensagemExterna(String idMensagemExterna) {
        this.idMensagemExterna = idMensagemExterna;
    }

    public String getIdMensagemInterna() {
        return idMensagemInterna;
    }

    public void setIdMensagemInterna(String idMensagemInterna) {
        this.idMensagemInterna = idMensagemInterna;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}
