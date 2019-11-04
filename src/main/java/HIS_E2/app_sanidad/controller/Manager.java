package HIS_E2.app_sanidad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
		private static Manager singleton=new Manager();
	}
	
	@Bean
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	private void comprobarPassword(String contrs) throws Exception {
		int contadorMayus = 0;
		int contadorMinus = 0;
		int contadorNum = 0;
		for(int i = 0; i<contrs.length(); i++) {
			if(Character.isUpperCase(contrs.charAt(i))) {
				contadorMayus++;
			}
			if(Character.isLowerCase(contrs.charAt(i))) {
				contadorMinus++;
			}
			if(Character.isDigit(contrs.charAt(i))) {
				contadorNum++;
			}
		}
		if(contadorMayus == 0 || contadorMinus == 0 || contadorNum == 0) {
			throw new Exception("La contraseña debe contener Mayúscula, Minúscula y Número");
		}
	}
	
	public char calcularLetraDni(int dniNum) {
	    String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
	    int modulo= dniNum % 23;
	    char letra = juegoCaracteres.charAt(modulo);
	    return letra;
	}
	
	public void comprobarDni(String dni) throws Exception{
		int dniNum;
		if(dni.length() > 9) {
			throw new Exception("El dni es incorrecto");
		}
		for(int i = 0; i<dni.length(); i++) {
			if(i < 8 && !Character.isDigit(dni.charAt(i))) {
				throw new Exception("El dni es incorrecto");
			}
			if( i == 8 && !Character.isLetter(dni.charAt(i))) {
				throw new Exception("El dni es incorrecto");
			}
		}
		dniNum = Integer.parseInt(dni.substring(0, 7));
		char letra = calcularLetraDni(dniNum);
		if(Character.toUpperCase(letra) != Character.toUpperCase(dni.charAt(8))) {
			throw new Exception("El dni es incorrecto");
		}
	}
	
	public Usuario register(String dni,	String nombre, String apellidos, 
			String contrs, int numSS, int idEspecialidad) throws Exception {
		if(dni == null || nombre == null || apellidos == null || contrs == null || numSS < 0) {
			throw new Exception("No debe haber campos vacios");
		}
		comprobarPassword(contrs);
		comprobarDni(dni);
		Usuario usuario = new Usuario(dni, nombre, apellidos, contrs);
		userRepo.insert(usuario);
		Paciente paciente = new Paciente(dni, nombre, apellidos, contrs, numSS);
		pacienteRepo.insert(paciente);
		return usuario;
	}

	public List<Cita> getCitas(String dni, String pass) {
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

	public boolean autenticar(String dni, String pass) {
		Usuario user = userRepo.findByDni(dni);
		if(user.getContrs().equals(pass)) {
			return true;
		} else {
			return false;
		}
	}
}