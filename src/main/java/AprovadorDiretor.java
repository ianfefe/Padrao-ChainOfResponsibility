public class AprovadorDiretor extends Aprovador {

    public AprovadorDiretor(Aprovador superior) {
        setSuperior(superior);
    }

    @Override
    public String getCargo() {
        return "Diretor";
    }

    @Override
    public double getLimite() {
        return 20000.0;
    }
}
