package br.com.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Cliente;
import br.com.cursomc.repositories.ClienteRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id: " + id + " Tipo: " + Cliente.class.getName()));
		return obj.orElse(null);
	}

}
