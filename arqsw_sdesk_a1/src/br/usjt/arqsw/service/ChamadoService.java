package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;

public class ChamadoService {
	private ChamadoDAO dao;

	public ChamadoService() {
		dao = new ChamadoDAO();
	}

	public ArrayList<Chamado> listarChamados() throws IOException {
		return dao.listarChamados();
	}

}
