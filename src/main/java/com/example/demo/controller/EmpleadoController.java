package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {

	@Autowired
	private AreaRepository repositoryArea;
	
	@Autowired
	private EmpleadoRepository repositoryEmpleado;
	
	@GetMapping("/")
	public String Listar(Model model) {
		List<EmpleadoEntity> listaEmpleado = repositoryEmpleado.findAll();
		model.addAttribute("listaEmpleado",listaEmpleado);
		
		return "EmpleadoLista";
	}
	
	@GetMapping("/registrar_empleado")
	public String mostrarRegistrarEmpleado(Model model) {
		model.addAttribute("empleado",new EmpleadoEntity());
		
		List<AreaEntity> listaAreas = repositoryArea.findAll();
		
		model.addAttribute("listaAreas",listaAreas);
		
		return "registro_empleado";
	}
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute EmpleadoEntity empleado, Model model) {
		
		if(repositoryEmpleado.findByCorreo(empleado.getCorreo())!=null) {
			model.addAttribute("errorMessage","El correo ya esta en uso");
			model.addAttribute("empleado",new EmpleadoEntity());
			return "registro_empleado";
		}
		repositoryEmpleado.save(empleado);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/detalle_empleado/{dni}")
	public String verEmpleado(Model model, @PathVariable("dni") String dni) {
		EmpleadoEntity empleadoActualizar = repositoryEmpleado.findById(dni).get();
		model.addAttribute("empleado",empleadoActualizar);
		
		return "detalle_empleado";
	}
	
	
	@GetMapping("/actualizar_empleado/{dni}")
	public String mostrarActualizarEmpleado(Model model, @PathVariable("dni") String dni) {
		EmpleadoEntity empleadoActualizar = repositoryEmpleado.findById(dni).get();
		List<AreaEntity> listaAreas = repositoryArea.findAll();
		
		model.addAttribute("empleado",empleadoActualizar);

		model.addAttribute("listaAreas",listaAreas);
		
		return "actualizar_empleado";
	}
	
	
	@PostMapping("/actualizar_empleado")
	public String actualizarFuncion(@ModelAttribute EmpleadoEntity empleado, Model model) {
		repositoryEmpleado.save(empleado);
	    return "redirect:/";
	}
	
	
	
	@GetMapping("/delete/{dni}")
	public String eliminarFuncion(@PathVariable("dni")String dni) {
		repositoryEmpleado.deleteById(dni);
		return "redirect:/";
	}
	
}
