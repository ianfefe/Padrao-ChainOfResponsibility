public abstract class Aprovador {

    private Aprovador superior;

    public Aprovador getSuperior() {
        return superior;
    }

    public void setSuperior(Aprovador superior) {
        this.superior = superior;
    }

    public abstract String getCargo();

    public abstract double getLimite();

    public String aprovar(Solicitacao solicitacao) {
        if (solicitacao.getValor() <= getLimite()) {
            return "Solicitação aprovada pelo " + getCargo();
        }
        if (superior != null) {
            return superior.aprovar(solicitacao);
        }
        return "Solicitação negada";
    }
}
