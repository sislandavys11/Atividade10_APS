package br.ufpb.dcx.aps.atividades.decorator.sorvete;

public class Calda extends ElementoSorveteDecorator{

    private String sabor;

    public Calda(String sabor, ElementoSorvete decorator) {
        super(decorator);
        this.sabor = sabor;
    }

    @Override
    public double getPreco() {
        return 0.1 + super.getPreco();
    }

    @Override
    public String getSabor() {
        return "calda(" + sabor + "), " + super.getSabor();
    }
}
