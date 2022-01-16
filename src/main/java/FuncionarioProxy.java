import java.util.List;
public class FuncionarioProxy implements IFuncionario{
    private Funcionario funcionario;
    private String matricula;

    public FuncionarioProxy(String matricula){
        this.matricula = matricula;
    }


    @Override
    public List<String> obterDadosPessoais() {
        if(this.funcionario == null){
            this.funcionario = new Funcionario(this.matricula);
        }
        return this.funcionario.obterDadosPessoais();
    }

    @Override
    public List<Float> obterSalario(Dono dono) {
        if(!dono.isAdministrador()){
            throw new IllegalArgumentException("Socio nao autorizado");
        }
        if(this.funcionario == null){
            this.funcionario = new Funcionario(this.matricula);
        }

        return this.funcionario.obterSalario(dono);
    }
}
