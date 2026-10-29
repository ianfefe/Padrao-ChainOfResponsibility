public class AprovadorGerente extends Aprovador {

    public AprovadorGerente(Aprovador superior) {
        setSuperior(superior);
    }

    @Override
    public String getCargo() {
        return "Gerente";
    }

    @Override
    public double getLimite() {
        return 5000.0;
    }
}
