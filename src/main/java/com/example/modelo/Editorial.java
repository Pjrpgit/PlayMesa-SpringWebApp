package com.example.modelo;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e"),
    @NamedQuery(name = "Editorial.findByEditorialId", query = "SELECT e FROM Editorial e WHERE e.editorialId = :editorialId"),
    @NamedQuery(name = "Editorial.findByNombre", query = "SELECT e FROM Editorial e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Editorial.findByDescripcion", query = "SELECT e FROM Editorial e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Editorial.findByUrl", query = "SELECT e FROM Editorial e WHERE e.url = :url"),
    @NamedQuery(name = "Editorial.findByImagen", query = "SELECT e FROM Editorial e WHERE e.imagen = :imagen")})
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "editorial_id")
    private Integer editorialId;
    @Basic(optional = false)
    @NotEmpty
    private String nombre;
    private String descripcion;
    private String url;
    @URL
    private String imagen;
    @OneToMany(mappedBy = "editorialId")
    private List<Juego> juegoList;

    public Editorial() {
    }

    public Editorial(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public Editorial(Integer editorialId, String nombre) {
        this.editorialId = editorialId;
        this.nombre = nombre;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Juego> getJuegoList() {
        return juegoList;
    }

    public void setJuegoList(List<Juego> juegoList) {
        this.juegoList = juegoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (editorialId != null ? editorialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.editorialId == null && other.editorialId != null) || (this.editorialId != null && !this.editorialId.equals(other.editorialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Editorial[ editorialId=" + editorialId + " ]";
    }
    
}
