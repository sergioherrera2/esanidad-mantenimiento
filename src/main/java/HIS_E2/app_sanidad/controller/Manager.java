package HIS_E2.app_sanidad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;

import HIS_E2.app_sanidad.model.Cifrador;
import HIS_E2.app_sanidad.model.Cita;
import HIS_E2.app_sanidad.model.Medico;
import HIS_E2.app_sanidad.model.Paciente;
import HIS_E2.app_sanidad.model.Usuario;
import HIS_E2.app_sanidad.repositories.CitaRepository;
import HIS_E2.app_sanidad.repositories.EspecialidadRepository;
import HIS_E2.app_sanidad.repositories.MedicoRepository;
import HIS_E2.app_sanidad.repositories.PacienteRepository;
import HIS_E2.app_sanidad.repositories.UserRepository;

@Service
public class Manager {
	
	//Aqui se declaran los repository con @Autowire
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PacienteRepository pacienteRepo;
	@Autowired
	private MedicoRepository medicoRepo;
	@Autowired
	private CitaRepository citaRepo;
	@Autowired
	private EspecialidadRepository especialidadRepo;
	
	private Manager() {
		
	}

	private static class ManagerHolder {
		static Manager singleton=new Manager();
	}
	
	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	public Usuario register(String dni,	String nombre, String apellidos, String contrs, int numSS, int idEspecialidad) throws Exception {
		Usuario usuario = new Usuario(dni, nombre, apellidos, contrs);
		userRepo.insert(usuario);
		
		if(idEspecialidad < 0) {
			Paciente paciente = new Paciente(dni, nombre, apellidos, contrs, numSS);
			pacienteRepo.insert(paciente);
		} else if(numSS < 0) {
			Medico medico = new Medico(dni, nombre, apellidos, contrs, idEspecialidad);
			medicoRepo.insert(medico);
		} 
		
		return usuario;
	}

	public List<Cita> getCitas(String dni, String pass) throws Exception {
		Medico med = medicoRepo.findByDni(dni);
		
		if(med.getContrs().equals(pass)) {
			List<Cita> lista = citaRepo.findByDniMedico(dni);
			return lista;
		} else {
			return null;
		}
		
	}

	public List<Cita> getCitasPaciente(String dni) {
		List<Cita> lista = citaRepo.findByDniPaciente(dni);
		return lista;
	}

	public boolean autenticar(String dni, String pass) throws Exception {
		String dniABuscar= Cifrador.cifrar(dni);
		String passABuscar=Cifrador.cifrarHash(pass);

		Usuario user = userRepo.findByDni(dniABuscar);
		if(user.getContrs().equals(passABuscar)) {
			return true;
		} else {
			return false;
		}
	}
}