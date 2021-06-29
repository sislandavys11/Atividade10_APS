package br.ufpb.dcx.aps.atividades.decorator.form.validador;
import br.ufpb.dcx.aps.atividades.decorator.form.Resultado;

public interface ValidadorCampo {
    public Resultado validarCampo(String valor);
}
