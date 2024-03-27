package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverterDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumo =  new ConsumoAPI();
    private ConverterDados conversor = new ConverterDados();
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";



    public void exibeMenu(){
//        System.out.println("Digite o nome da serie para busca:");
//        var nomeSerie = leitura.nextLine();
//        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//
//        DadosSerie dados = conversor.obterdados(json, DadosSerie.class);
//        System.out.println(dados);
//
//
//        List<DadosTemporada> temporadas = new ArrayList<>();
//		for (int i = 1; i <= dados.totalTemporadas(); i++) {
//            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
//			DadosTemporada dadosTemporada = conversor.obterdados(json, DadosTemporada.class);
//			temporadas.add(dadosTemporada);
//
//		}
//		 temporadas.forEach(System.out::println);

//        for (int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }
//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println("Episodio: '" + e.titulo().trim() + "' - " + e.dataLancamento())));

        List<String> nomes = Arrays.asList("Nico", "Nico", "Jacque", "Yasmin", "Paulo", "Rodrigo", "Nico", "Nico", "Nico" );

        nomes.stream() // operacao intermediaria
                .sorted() // ordenar
                .distinct()
                .limit(3)
                .forEach(System.out::println); // iterar // operacao finais
    };
}
