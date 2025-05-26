package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PresupuestoCompraDetalleId implements Serializable {
	
	@Column(name = "id_presupuesto_compra")
    private Integer idPresupuestoCompra;

    @Column(name = "id_mercaderia")
    private Integer idMercaderia;

    // Getters y Setters
    public Integer getIdPresupuestoCompra() {
        return idPresupuestoCompra;
    }

    public void setIdPresupuestoCompra(Integer idPresupuestoCompra) {
        this.idPresupuestoCompra = idPresupuestoCompra;
    }

    public Integer getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(Integer idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PresupuestoCompraDetalleId)) return false;
        PresupuestoCompraDetalleId that = (PresupuestoCompraDetalleId) o;
        return Objects.equals(idPresupuestoCompra, that.idPresupuestoCompra) &&
               Objects.equals(idMercaderia, that.idMercaderia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPresupuestoCompra, idMercaderia);
    }

}
