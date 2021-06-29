package br.ufpb.dcx.aps.atividades.decorator.sorvete;

public class ElementoSorveteDecorator implements ElementoSorvete{

    protected ElementoSorvete decorator;


    public ElementoSorveteDecorator(ElementoSorvete decorator) {

       this.decorator = decorator;
    }


    @Override
    public double getPreco() {
       if (decorator == null){
           return 0;
       }

       return decorator.getPreco();
    }

    @Override
    public String getSabor() {
       if (decorator == null){
           return "";
       }

       return decorator.getSabor();
    }
}
