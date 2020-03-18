package com.example.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author soad_
 */
@Entity
@Table(name = "juego_habilidad")
@NamedQueries({
    @NamedQuery(name = "JuegoHabilidad.findAll", query = "SELECT j FROM JuegoHabilidad j"),
    @NamedQuery(name = "JuegoHabilidad.findByDescripcion", query = "SELECT j FROM JuegoHabilidad j WHERE j.descripcion = :descripcion"),
    @NamedQuery(name = "JuegoHabilidad.findByRelacionId", query = "SELECT j FROM JuegoHabilidad j WHERE j.relacionId = :relacionId")})
public class JuegoHabilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    private String descripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relacion_id")
    private Integer relacionId;
    @JoinColumn(name = "habilidad_id", referencedColumnName = "habilidad_id")
    @ManyToOne(optional = false)
    private Habilidad habilidadId;
    @JoinColumn(name = "juego_id", referencedColumnName = "juego_id")
    @ManyToOne(optional = false)
    private Juego juegoId;

    public JuegoHabilidad() {
    }

    public JuegoHabilidad(Integer relacionId) {
        this.relacionId = relacionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRelacionId() {
        return relacionId;
    }

    public void setRelacionId(Integer relacionId) {
        this.relacionId = relacionId;
    }

    public Habilidad getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(Habilidad habilidadId) {
        this.habilidadId = habilidadId;
    }

    public Juego getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(Juego juegoId) {
        this.juegoId = juegoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relacionId != null ? relacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuegoHabilidad)) {
            return false;
        }
        JuegoHabilidad other = (JuegoHabilidad) object;
        if ((this.relacionId == null && other.relacionId != null) || (this.relacionId != null && !this.relacionId.equals(other.relacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.JuegoHabilidad[ relacionId=" + relacionId + " ]";
    }
    
}
