package desafioprojedata;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DesafioProjedata {
    
    public static void main(String[] args) {
        String padrao = "#,###.00";
        DecimalFormat df = new DecimalFormat(padrao);
        
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador");
        Funcionario joao = new Funcionario("João", LocalDate.of(1990,05,12), new BigDecimal("2284.38"), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961,05,02), new BigDecimal("9836.14"), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995,01,05), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993,03,31), new BigDecimal("4071.84"), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994,07,8), new BigDecimal("3017.45"), "Gerente");
        Funcionario heloisa = new Funcionario("Heloisa", LocalDate.of(2003,05,24), new BigDecimal("1606.85"), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996,9,02), new BigDecimal("2799.93"), "Gerente"); 
       
        //3.1 
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios.add(maria);
        listaFuncionarios.add(joao);
        listaFuncionarios.add(caio);
        listaFuncionarios.add(miguel);
        listaFuncionarios.add(alice);
        listaFuncionarios.add(heitor);
        listaFuncionarios.add(arthur);
        listaFuncionarios.add(laura);
        listaFuncionarios.add(heloisa);
        listaFuncionarios.add(helena); 
        
        //3.2
        listaFuncionarios.remove(joao);
        
        //3.3
        System.out.println(listaFuncionarios);
        
        //3.4
        Iterator<Funcionario> iterator = listaFuncionarios.iterator();
         while(iterator.hasNext()) {
            Funcionario next = iterator.next();
            next.aumentoSalario(next.getSalario());
        }
        
        //3.5
        Map<String, List<Funcionario>> mapFuncionarios = new HashMap();
        List<Funcionario> operadores = new ArrayList<>(); 
        List<Funcionario> coordenadores = new ArrayList<>();
        List<Funcionario> diretores = new ArrayList<>();
        List<Funcionario> recepcionistas = new ArrayList<>();
        List<Funcionario> contadores = new ArrayList<>();
        List<Funcionario> gerentes = new ArrayList<>();
        List<Funcionario> eletricistas = new ArrayList<>();
        
        mapFuncionarios.put("Operadores", operadores);
        mapFuncionarios.put("Coordenador", coordenadores);
        mapFuncionarios.put("Diretores", diretores);
        mapFuncionarios.put("Recepcionistas", recepcionistas);
        mapFuncionarios.put("Contadores", contadores);
        mapFuncionarios.put("Gerentes", gerentes);
        mapFuncionarios.put("Eletricistas", eletricistas);
        
        for(Funcionario funcionario : listaFuncionarios){
            if (funcionario.getFuncao() == "Operador") operadores.add(funcionario);
                else if (funcionario.getFuncao() == "Coordenador") coordenadores.add(funcionario);
                    else if (funcionario.getFuncao() == "Diretor") diretores.add(funcionario);
                        else if (funcionario.getFuncao() == "Recepcionista") recepcionistas.add(funcionario);
                            else if (funcionario.getFuncao() == "Contador") contadores.add(funcionario);
                                else if (funcionario.getFuncao() == "Gerente") gerentes.add(funcionario);
                                    else if (funcionario.getFuncao() == "Eletricista") eletricistas.add(funcionario);
        }
        
        //3.6
        System.out.println(mapFuncionarios);
        
        //3.8
        for(Funcionario funcionario: listaFuncionarios){
            LocalDate dataNasc = funcionario.dataNascimento;
            int mes = dataNasc.getMonthValue();
            if(mes == 10 || mes == 12){
                System.out.println(funcionario.getNome());
            }
        }
        
        //3.9
        int maisVelho = 0;
        String[] nome = new String[listaFuncionarios.size()];
        int[] ano = new int[listaFuncionarios.size()];
        String nomePessoaMaisVelha = "";
        for (Funcionario funcionario : listaFuncionarios){
            int i= 0;
            final LocalDate dataAtual = LocalDate.now();
            final Period idade = Period.between(funcionario.dataNascimento, dataAtual);
            ano[i] = idade.getYears();
            nome[i] = funcionario.getNome();
            if (ano[i] > maisVelho) {
                maisVelho = ano[i];
                nomePessoaMaisVelha = nome[i];
            }
        
                
                }
                System.out.println("Funcionario: " + nomePessoaMaisVelha + " Idade: " + maisVelho);
         
                //3.10
                Collections.sort(listaFuncionarios);
                System.out.println(listaFuncionarios);
                
                //3.11
                Iterator<Funcionario> iterator2 = listaFuncionarios.iterator();
                BigDecimal soma = new BigDecimal("0");
                while(iterator2.hasNext()){
                    Funcionario next = iterator2.next();
                    soma = next.getSalario().add(soma);
                }
                System.out.println("Total de salários: " + df.format(soma));
                
                //3.12
                for(Funcionario funcionario : listaFuncionarios){
                    BigDecimal salarioMinimo = funcionario.getSalario().divideToIntegralValue(new BigDecimal("1212"));
                    System.out.println("Funcionário: " + funcionario.getNome() + " - " + salarioMinimo + " salários mínimos");
                }   }  
}
