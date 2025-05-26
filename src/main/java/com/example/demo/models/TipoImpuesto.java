package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_impuesto")
@Getter
@Setter
public class TipoImpuesto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_impuesto")
    private Integer id_tipo_impuesto;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    // Getters y Setters
    public Integer getId_tipo_impuesto() {
        return id_tipo_impuesto;
    }

    public void setId_tipo_impuesto(Integer id_tipo_impuesto) {
        this.id_tipo_impuesto = id_tipo_impuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
