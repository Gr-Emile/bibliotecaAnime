package bibliotecaAnime;

import bibliotecaAnime.entidades.Animes;
import bibliotecaAnimeDao.DaoAnime;

public class BibliotecaAnime {
	public static void main(String[] args) {
		DaoAnime dc= new DaoAnime();
		//--- início de cadastrar anime ---
		Animes a1 = new Animes("Dota", 2 , 25 , "netflix", "PT-BR");
		if(dc.salvar(a1)) {
			System.out.println("Anime cadastrado com sucesso!");
		}
		//--- fim de cadastrar anime ---

		
		//--- início de consultar todos os animes ---
		System.out.println(dc.consultar());
 		//--- fim de consultar todos os animes ---
		
		
		//--- início de consultar um anime ---
		System.out.println(dc.consultar(2));
		//--- fim de consultar um anime ---
		
		
		//--- início do delete ---
		Animes anime = dc.consultar(2);
		System.out.println(anime);
		dc.excluir(2);
		anime = dc.consultar(2);
		System.out.println("Anime excluido com sucesso!\n");
		System.out.println(anime);
		//--- fim do delete ---
		
		
		//--- início alterar anime 
		Animes anime = dc.consultar(1);
		System.out.println(anime);
		anime.setNome("Naruto");
		anime.setNumeroTemporadas(99);
		anime.setDuracaoDoEp(20);
		anime.setStreamDisponivel("Netflix");
		anime.setLegendaDisponivel("PT-PT, PT-BR");
		if (dc.alterar(anime));
		System.out.println("Anime alterado com sucesso!\n");
		System.out.println(anime);
		//--- fim alterar anime 
		
	}
}
