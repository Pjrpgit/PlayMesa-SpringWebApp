package com.example.modelo;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;

/**
 *
 * @author soad_
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Habilidad.findAll", query = "SELECT h FROM Habilidad h"),
    @NamedQuery(name = "Habilidad.findByHabilidadId", query = "SELECT h FROM Habilidad h WHERE h.habilidadId = :habilidadId"),
    @NamedQuery(name = "Habilidad.findByNombre", query = "SELECT h FROM Habilidad h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Habilidad.findByDescripcion", query = "SELECT h FROM Habilidad h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "Habilidad.findByImagen", query = "SELECT h FROM Habilidad h WHERE h.imagen = :imagen")})
public class Habilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "habilidad_id")
    private Integer habilidadId;
    @Basic(optional = false)
    @NotEmpty
    private String nombre;
    private String descripcion;
    @URL
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habilidadId")
    private List<JuegoHabilidad> juegoHabilidadList;

    public Habilidad() {
    }

    public Habilidad(Integer habilidadId) {
        this.habilidadId = habilidadId;
    }

    public Habilidad(Integer habilidadId, String nombre) {
        this.habilidadId = habilidadId;
        this.nombre = nombre;
    }

    public Integer getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(Integer habilidadId) {
        this.habilidadId = habilidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<JuegoHabilidad> getJuegoHabilidadList() {
        return juegoHabilidadList;
    }

    public void setJuegoHabilidadList(List<JuegoHabilidad> juegoHabilidadList) {
        this.juegoHabilidadList = juegoHabilidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habilidadId != null ? habilidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habilidad)) {
            return false;
        }
        Habilidad other = (Habilidad) object;
        if ((this.habilidadId == null && other.habilidadId != null) || (this.habilidadId != null && !this.habilidadId.equals(other.habilidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Habilidad[ habilidadId=" + habilidadId + " ]";
    }
    
}
