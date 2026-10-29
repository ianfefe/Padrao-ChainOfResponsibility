public class AprovadorPresidente extends Aprovador {

    public AprovadorPresidente(Aprovador superior) {
        setSuperior(superior);
    }

    @Override
    public String getCargo() {
        return "Presidente";
    }

    @Override
    public double getLimite() {
        return 100000.0;
    }
}
