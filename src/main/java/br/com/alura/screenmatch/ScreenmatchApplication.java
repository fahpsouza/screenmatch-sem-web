package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi =  new ConsumoAPI();

		System.out.println("------------------------------------------------------------------");
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&y=2000&apikey=6585022c");
		System.out.println(json);

//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		System.out.println("------------------------------------------------------------------");

		ConverterDados conversor = new ConverterDados() ;
		DadosSerie dados = conversor.obterdados(json, DadosSerie.class);

		System.out.println("avaliacao: " + dados.avaliacao());
		System.out.println("titulo: "+ dados.titulo());
		System.out.println("totalTemporadas: " + dados.totalTemporadas());
	}
}
