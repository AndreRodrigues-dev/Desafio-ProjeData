package desafioprojedata;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    
    BigDecimal salario;
    String funcao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String padrao = "#,###.00";
    DecimalFormat df = new DecimalFormat(padrao);

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    public void aumentoSalario(BigDecimal salario) {
        this.salario = salario.multiply(new BigDecimal("1.1"));
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome + ", Data de Nascimento: " + dataNascimento.format(formatter) + ", Salário: " + df.format(salario) + ", Função: " + funcao + "\n";
    } 
}
