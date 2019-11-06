package HIS_E2.app_sanidad.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import HIS_E2.app_sanidad.model.Cita;
import HIS_E2.app_sanidad.model.Medico;
import HIS_E2.app_sanidad.model.Paciente;
import HIS_E2.app_sanidad.model.PacienteMedico;
import HIS_E2.app_sanidad.model.Usuario;
import HIS_E2.app_sanidad.repositories.CitaRepository;
import HIS_E2.app_sanidad.repositories.EspecialidadRepository;
import HIS_E2.app_sanidad.repositories.MedicoRepository;
import HIS_E2.app_sanidad.repositories.PacienteMedicoRepository;
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
	@Autowired
	private PacienteMedicoRepository pacienteMedicoRepo;
	
	
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
		dniNum = Integer.parseInt(dni.substring(0, 8));
		char letra = calcularLetraDni(dniNum);
		if(Character.toUpperCase(letra) != Character.toUpperCase(dni.charAt(8))) {
			throw new Exception("El dni es incorrecto");
		}
	}
	
	private void comprobarNSS(String numSS) throws Exception{
		if(numSS.length()!=12) {
			throw new Exception("El numero de seguridad social no es correcto");
		}
		for(int i = 0; i<numSS.length(); i++) {
			if(!Character.isDigit(numSS.charAt(i))) {
				throw new Exception("El número de seguridad social no es correcto");
			}
		}
	}
	
	public Usuario register(String dni,	String nombre, String apellidos, 
			String contrs, String numSS, int idEspecialidad) throws Exception {
		if(dni == null || nombre == null || apellidos == null || contrs == null || numSS == null) {
			throw new Exception("No debe haber campos vacios");
		}
		if(dni.equals("") || nombre.equals("") || apellidos.equals("") || contrs.equals("") || numSS.equals("")) {
			throw new Exception("No debe haber campos vacios");
		}
		comprobarPassword(contrs);
		comprobarDni(dni);
		comprobarNSS(numSS);
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
	
	public Cita pedirCita(String dniPaciente, String fecha, String especialidad) throws Exception {
		PacienteMedico pacienteMed = pacienteMedicoRepo.findCustomMedico(dniPaciente, especialidad);
		String dniMedico = pacienteMed.getDniMedico();
		Date fechaCita = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		Date sysdate = new Date(System.currentTimeMillis());
		if(fechaCita.compareTo(sysdate) < 0) {
	          throw new Exception("La fecha de la cita no puede ser pasada");
		}
		Cita cita = new Cita(fechaCita, dniMedico, dniPaciente);
		cita = citaRepo.insert(cita);
		return cita;
	}
}