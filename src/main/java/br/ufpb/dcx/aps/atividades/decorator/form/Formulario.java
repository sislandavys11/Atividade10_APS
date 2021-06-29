package br.ufpb.dcx.aps.atividades.decorator.form;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Formulario {
    private String titulo;
    private Map<String, ItemFormulario> itensForm = new LinkedHashMap<>();


    public Formulario(String titulo){

        this.titulo = titulo;
    }

    public void addItemFormulario(ItemFormulario item) {
        if (itensForm.containsKey(item.getId())){
            throw new RuntimeException("'" + item.getId() + "' já existe");
        }
        itensForm.put(item.getId(),item);
    }


}
