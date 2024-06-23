package com.example.demo.entity;



import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(name = "dni_empleado", columnDefinition = "CHAR(8)")
	private String dni;
	
	@Column(name = "nombre_empleado", length = 45)
	private String nombre;
	
	@Column(name = "apellido_empleado", length = 45)
	private String apellido;
	
	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechNac;
	
	@Column(name = "direccion", length = 45)
	private String direccion;
	
	@Column(name = "correo", length = 45)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntity areaEntity;
}
