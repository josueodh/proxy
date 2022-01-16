import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Funcionario implements IFuncionario {
    private String matricula;
    private String nome;
    private Float salario;

    public Funcionario(String matricula){
        this.matricula = matricula;
        Funcionario objeto = BD.getFuncionario(matricula);
        this.nome = objeto.nome;
        this.salario = objeto.salario;
    }

    public Funcionario(String matricula, String nome, Float salario){
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
    }

    public String getMatricula(){
        return this.matricula;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome);
    }

    @Override
    public List<Float> obterSalario(Dono dono) {
        return Arrays.asList(this.salario);
    }
}
