package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;


public class ChamadoDAO {
	public ArrayList<Chamado> listarChamados() throws IOException {
		String query = "select id_fila, id_chamado, descricao, status, dt_abertura, dt_fechamento from chamdo";
		ArrayList<Chamado> lista = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {				
				Chamado chamado = new Chamado();
				chamado.setId_fila(rs.getInt("id_fila"));
				chamado.setId_chamado(rs.getInt("id_chamado"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setDt_abertura(rs.getDate("dt_abertura"));
				chamado.setDt_fechamento(rs.getDate("dt_fechamento"));
				lista.add(chamado);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

}
