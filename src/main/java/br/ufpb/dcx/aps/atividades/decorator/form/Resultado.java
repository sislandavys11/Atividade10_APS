package br.ufpb.dcx.aps.atividades.decorator.form;

import java.util.LinkedList;
import java.util.List;

public class Resultado {
    private boolean erro;
    private String msg;
    private List<String> mensagens = new LinkedList<>();

    public Resultado(){
        this.erro = false;
    }
    public Resultado(boolean erro){
        this.erro = erro;
    }
    public Resultado(boolean erro, String msg){
        this.erro = erro;
        this.msg = msg;
        this.mensagens.add(msg);
    }
    public void addMensagem(String msg){
        this.msg = msg;
        mensagens.add(msg);
    }

    public String getMsg() {

        return msg;
    }

    public List<String> getMensagens(){

        return mensagens;
    }


    public boolean isErro(){
        if (this.erro == true){
            return true;
        }
        return false;
    }

    public void setErro(boolean erro) {

        this.erro = erro;
    }
}
