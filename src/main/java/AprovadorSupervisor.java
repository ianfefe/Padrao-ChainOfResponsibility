public class AprovadorSupervisor extends Aprovador {

    public AprovadorSupervisor(Aprovador superior) {
        setSuperior(superior);
    }

    @Override
    public String getCargo() {
        return "Supervisor";
    }

    @Override
    public double getLimite() {
        return 1000.0;
    }
}
