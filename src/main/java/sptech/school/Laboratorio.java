package sptech.school;

import sptech.school.exception.ArgumentoInvalidoException;
import sptech.school.exception.VacinaInvalidaException;
import sptech.school.exception.VacinaNaoEncontradaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String nome;
    private List<Vacina> vacinas;

    public Laboratorio(String nome) {
        this.nome = nome;
        this.vacinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void adicionarVacina(Vacina vacina){
            if(vacina == null && vacina.getNome() == null && vacina.getTipo() == null && vacina.getPreco() == null && vacina.getPreco() < 0.0 && vacina.getEficacia() <0 && vacina.getEficacia() > 5 && vacina.getDataLancamento() == null && vacina.getDataLancamento().isBefore(LocalDate.now())){
                throw new VacinaInvalidaException();
            }else{
                vacinas.add(vacina);
                System.out.println("Vacina adicionada com sucesso!!!!");
            }
    }

    public Vacina buscarVacinaPorCodigo(String codigo){
            if(codigo == null && codigo == ""){
                throw new VacinaNaoEncontradaException();
            }else{
                for(Vacina vacina: vacinas){
                    if(codigo.equalsIgnoreCase(vacina.getCodigo())){
                        System.out.println("Vacina encontrada:");
                        System.out.println(vacina.toString());
                        return vacina;
                        }
            }
        }
        return null;
    }

    public void removerVacinaPorCodigo(String codigo){
            if(codigo == null && codigo == ""){
                throw new VacinaNaoEncontradaException();
            }else{
                for(Vacina vac : vacinas){
                    if(codigo.equalsIgnoreCase(vac.getCodigo())){
                        vacinas.remove(vac);
                        System.out.println(vac.toString());
                        System.out.println("Vacina removida com sucesso!!!!");
                    }
                }
            }
    }

    public Vacina buscarVacinaComMelhorEficacia(){
            if(vacinas == null){
                throw new VacinaNaoEncontradaException();
            }else{
                Vacina maiorEficacia = new Vacina();
                maiorEficacia.setEficacia(0.0);
                for(Vacina vacina : vacinas){
                    if(maiorEficacia.getEficacia() < vacina.getEficacia()){
                        maiorEficacia = vacina;
                    } else if (maiorEficacia.getEficacia().equals(vacina.getEficacia())){
                        if(maiorEficacia.getDataLancamento().isAfter(vacina.getDataLancamento())){

                        }else{
                            maiorEficacia = vacina;
                        }
                    }
                }
                System.out.println("Vacina com maior eficacia:");
                System.out.println(maiorEficacia.toString());
                return maiorEficacia;
            }
    }

    public List<Vacina> buscarVacinaPorPeriodo(LocalDate dataInicio, LocalDate dataFim){
        List<Vacina> vacinaPeriodo = new ArrayList<>();
           if(dataInicio != null && dataFim != null && dataInicio.isBefore(dataFim)){
               for(Vacina vacina : vacinas){
                   if(vacina.getDataLancamento().isAfter(dataInicio) && vacina.getDataLancamento().isBefore(dataFim)){
                       vacinaPeriodo.add(vacina);
                   }
               }
               System.out.println("Vacinas encontradas dentro do periodo:");
               for(Vacina vacina : vacinaPeriodo){
                   System.out.println(vacina.toString());
               }
               return vacinaPeriodo;
           }else{
               throw new ArgumentoInvalidoException();
           }
    }
}
