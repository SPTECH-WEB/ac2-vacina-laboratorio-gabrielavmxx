package sptech.school;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Você pode usar essa classe para testar o seu código se precisar.");

        Vacina vacina1 = new Vacina("ABC","Febre Amarela", "A", 29.99, 2.0, LocalDate.of(2025,10,2));
        Vacina vacina2 = new Vacina("DFG","Gripe", "B", 15.99, 4.9, LocalDate.of(2025,9,1));
        Vacina vacina3 = new Vacina("HIJ","Hapatite", "C", 12.99, 4.3, LocalDate.of(2025,10,6));
        Vacina vacina4 = new Vacina("KLM","Tetano", "D", 33.99, 2.9, LocalDate.of(2025,8,2));

        Laboratorio laboratorio = new Laboratorio("Laboratório triste");

        System.out.println("\n\nADICIONAR VACINAS");
        laboratorio.adicionarVacina(vacina1);
        laboratorio.adicionarVacina(vacina2);
        laboratorio.adicionarVacina(vacina3);
        laboratorio.adicionarVacina(vacina4);

        System.out.println("\n\nBUSCAR POR CODIGO");
        laboratorio.buscarVacinaPorCodigo("DFG");

        System.out.println("\n\nVACINA COM MELHOR EFICACIA");
        laboratorio.buscarVacinaComMelhorEficacia();

        System.out.println("\n\nVACINA POR PERIODO");
        laboratorio.buscarVacinaPorPeriodo(LocalDate.of(2025,10,1), LocalDate.of(2025,10,22));

        System.out.println("\n\nREMOVER VACINA POR CODIGO");
        laboratorio.removerVacinaPorCodigo("KLM");
    }
}