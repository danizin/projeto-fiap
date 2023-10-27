package br.com.projetofiap.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidateError extends StandardError{

    private List<ValidateMessage> mensagens = new ArrayList<>();

    public void addMessage(String campo, String mensagem){
        mensagens.add(new ValidateMessage(campo, mensagem));

    }
}
