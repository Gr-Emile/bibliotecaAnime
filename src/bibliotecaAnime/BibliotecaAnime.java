package bibliotecaAnime;

import bibliotecaAnime.entidades.Animes;
import bibliotecaAnimeDao.DaoAnime;

public class BibliotecaAnime {
	public static void main(String[] args) {
		DaoAnime dc= new DaoAnime();
//		//--- início de cadastrar anime ---
//		Animes a1 = new Animes("Dota", 2 , 25 , "netflix", "PT-BR");
//		if(dc.salvar(a1)) {
//			System.out.println("Anime cadastrado com sucesso!");
//		}
//		//--- fim de cadastrar anime ---

//		//--- início de consultar todos os animes ---
//		System.out.println(dc.consultar());
// 		//--- fim de consultar todos os animes ---
		
		//--- início de consultar um anime ---
				System.out.println(dc.consultar(1));
		//--- fim de consultar um anime ---
		
		
		
	}
}
