package br.ufpb.dcx.aps.atividades.decorator.sorvete;

public class Copinho implements ElementoSorvete{
    @Override
    public double getPreco() {
        return 0.5;
    }

    @Override
    public String getSabor() {

        return "";
    }
}
