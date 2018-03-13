package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

public class ChamadoDAO {
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		String query = "select * from chamado where id_fila = ?";
		ArrayList<Chamado> lista = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setInt(1, fila.getId());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Chamado chamado = new Chamado();
					chamado.setId_fila(fila);
					chamado.setId_chamado(rs.getInt("id_chamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setDt_abertura(rs.getDate("dt_abertura"));
					chamado.setDt_fechamento(rs.getDate("dt_fechamento"));
					chamado.setStatus(rs.getString("status"));
					lista.add(chamado);
				}
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

}
