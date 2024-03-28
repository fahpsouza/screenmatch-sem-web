package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverterDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private ConsumoAPI consumo =  new ConsumoAPI();
    private ConverterDados conversor = new ConverterDados();
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";



    public void exibeMenu() {
        System.out.println("Digite o nome da serie para busca:");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = conversor.obterdados(json, DadosSerie.class);
        System.out.println(dados);
        System.out.println("\n");

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterdados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }

        System.out.println("\n");

//        temporadas.forEach(System.out::println);

        List<DadosEpisodio> episodiosTemporada = null;
//        for (int i = 0; i < dados.totalTemporadas(); i++) {
//            episodiosTemporada = temporadas.get(i).episodios();
//
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }
       // temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println("Episodio: '" + e.titulo().trim() + "' - " + e.dataLancamento())));

        List<DadosEpisodio> dadosEpisodio = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());
                //.toList(); // nao pode alterar a lista

//        System.out.println("\n Top 5 episodios");
//        dadosEpisodio.stream()
//                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//                .limit(5)
//                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                    .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);
    }

}
