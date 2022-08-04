package bibliotecaAnimeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bibliotecaAnime.entidades.Animes;
import bibliotecaAnime.interfaces.ICrud;
import bibliotecaAnime.utilidades.Conexao;

public class DaoAnime  implements ICrud<Animes>{

	@Override
	public boolean salvar(Animes obj) {
		String sql = "INSERT INTO public.animes(\r\n"
				+ "	nome, numerotemporadas, duracaodoep, streamdisponivel, legendadisponivel)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?);";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setInt(2, obj.getNumeroTemporadas());
			stm.setInt(3,  obj.getDuracaoDoEp());
			stm.setString(4, obj.getStreamDisponivel());
			stm.setString(5, obj.getLegendaDisponivel());
			stm.execute();
					
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.desconectar();
		}
		return true;
	}

	@Override
	public boolean alterar(Animes obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Animes consultar(int id) {
		Animes anime = new Animes(); 
		String sql = "select * from animes where id= " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				anime.setId(rs.getInt("id"));
				anime.setNome(rs.getString("nome"));
				anime.setNumeroTemporadas(rs.getInt("numeroTemporadas"));
				anime.setDuracaoDoEp(rs.getInt("duracaoDoEp"));
				anime.setStreamDisponivel(rs.getString("streamDisponivel"));
				anime.setLegendaDisponivel(rs.getString("legendaDisponivel"));	
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}

	@Override
	public List<Animes> consultar() {
		List<Animes> animes = new ArrayList<Animes>();
		String sql = "SELECT * FROM animes";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Animes anime = new Animes();
				anime.setId(rs.getInt("id"));
				anime.setNome(rs.getString("nome"));
				anime.setNumeroTemporadas(rs.getInt("numeroTemporadas"));
				anime.setDuracaoDoEp(rs.getInt("duracaoDoEp"));
				anime.setStreamDisponivel(rs.getString("streamDisponivel"));
				anime.setLegendaDisponivel(rs.getString("legendaDisponivel"));
				animes.add(anime);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return animes;
	}


}
