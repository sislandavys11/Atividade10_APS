package br.ufpb.dcx.aps.atividades.decorator.sorvete;

public class BolaSorvete extends ElementoSorveteDecorator{

    public String sabor;

    public BolaSorvete(String sabor, ElementoSorvete decorator) {
        super(decorator);
        this.sabor = sabor;
    }

    @Override
    public double getPreco() {
        return 0.5 + super.getPreco();
    }

    @Override
    public String getSabor() {
        return sabor + ", " + super.getSabor();
    }
}
