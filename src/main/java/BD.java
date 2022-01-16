import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<String, Funcionario> funcionarios = new HashMap<>();

    public static Funcionario getFuncionario(String matricula){
        return funcionarios.get(matricula);
    }

    public static void addFuncionario(Funcionario funcionario){
        funcionarios.put(funcionario.getMatricula(), funcionario);
    }



}
