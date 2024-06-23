package com.example.demo.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tb_empleado")
public class EmpleadoEntity {
	
	@Id
	@Column(name = "dni_empleado")
	private String dni;
	
	@Column(name = "nombre_empleado")
	private String nombre;
	
	@Column(name = "apellido_empleado")
	private String apellido;
	
	@Column(name = "fecha_nacimiento")
	private Date fechNac;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "correo")
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntity areaEntity;
}
