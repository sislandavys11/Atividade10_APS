package br.ufpb.dcx.aps.atividades.decorator.sorvete;

public class Banana extends ElementoSorveteDecorator{



    public Banana( ElementoSorvete decorator) {
        super(decorator);
    }

    @Override
    public double getPreco() {

        return 0.3 + super.getPreco();
    }

    @Override
    public String getSabor() {

        return "banana, " + super.getSabor();
    }
}
