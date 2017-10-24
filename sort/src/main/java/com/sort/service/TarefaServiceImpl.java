package com.sort.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sort.controller.SortAbstractController;
import com.sort.form.TarefaCadastroForm;
import com.sort.model.Tarefa;
import com.sort.model.Usuario;
import com.sort.repository.FluxoRepository;
import com.sort.repository.ModuloRepository;
import com.sort.repository.StatusRepository;
import com.sort.repository.TarefaRepository;
import com.sort.repository.TarefaTipoRepository;
import com.sort.repository.UsuarioRepository;

@Service("tarefaService")
public class TarefaServiceImpl extends SortAbstractController implements TarefaService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private ModuloRepository moduloRepository;

	@Autowired
	private FluxoRepository fluxoRepository;

	@Autowired
	private TarefaTipoRepository tarefaTipoRepository;

	@Override
	public void saveTarefa(TarefaCadastroForm tarefaCadastroForm) {
		Tarefa tarefa = new Tarefa();
		Usuario user = getUsuarioLogado();
		Calendar calFim = Calendar.getInstance();
		try {
			tarefa.setUsuario(usuarioRepository.findOne(user.getId()));

			tarefa.setInicioTeste(toDate(tarefaCadastroForm.getInicioTeste()));
			tarefa.setFimTeste(calFim.getTime());
			tarefa.setNumeroTarefa(Long.parseLong(tarefaCadastroForm.getNumeroTarefa()));
			tarefa.setErroCaminhoFeliz(tarefaCadastroForm.isErroCaminhoFeliz());

			tarefa.setSeveridade1(tarefaCadastroForm.getSeveridade1());
			tarefa.setSeveridade2(tarefaCadastroForm.getSeveridade2());
			tarefa.setSeveridade3(tarefaCadastroForm.getSeveridade3());
			tarefa.setSeveridade4(tarefaCadastroForm.getSeveridade4());
			tarefa.setNome(tarefaCadastroForm.getNome());
			tarefa.setStatus(statusRepository.findByNome(tarefaCadastroForm.getStatus()));
			tarefa.setFluxo(fluxoRepository.findByNome(tarefaCadastroForm.getFluxo()));
			tarefa.setModulo(moduloRepository.findByNome(tarefaCadastroForm.getModulo()));
			tarefa.setTipo(tarefaTipoRepository.findByNome(tarefaCadastroForm.getTipo()));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		tarefaRepository.saveAndFlush(tarefa);

	}

	public Date toDate(String dateConvert) throws ParseException {
		Locale.setDefault(new Locale("pt", "BR"));
		Date data = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").parse(dateConvert);
		return data;
	}

	@Override
	public List<Tarefa> findAllTarefa() {
		return tarefaRepository.findAll();
	}

}
