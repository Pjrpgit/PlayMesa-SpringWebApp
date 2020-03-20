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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.URL;

/**
 *
 * @author soad_
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j"),
    @NamedQuery(name = "Juego.findByJuegoId", query = "SELECT j FROM Juego j WHERE j.juegoId = :juegoId"),
    @NamedQuery(name = "Juego.findByNombre", query = "SELECT j FROM Juego j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Juego.findByAutor", query = "SELECT j FROM Juego j WHERE j.autor = :autor"),
    @NamedQuery(name = "Juego.findByNumeroJugadores", query = "SELECT j FROM Juego j WHERE j.numeroJugadores = :numeroJugadores"),
    @NamedQuery(name = "Juego.findByComplejidad", query = "SELECT j FROM Juego j WHERE j.complejidad = :complejidad"),
    @NamedQuery(name = "Juego.findByDuracion", query = "SELECT j FROM Juego j WHERE j.duracion = :duracion"),
    @NamedQuery(name = "Juego.findByTematica", query = "SELECT j FROM Juego j WHERE j.tematica = :tematica"),
    @NamedQuery(name = "Juego.findByCooperativo", query = "SELECT j FROM Juego j WHERE j.cooperativo = :cooperativo"),
    @NamedQuery(name = "Juego.findByEdadRecomendada", query = "SELECT j FROM Juego j WHERE j.edadRecomendada = :edadRecomendada"),
    @NamedQuery(name = "Juego.findByTieneCartas", query = "SELECT j FROM Juego j WHERE j.tieneCartas = :tieneCartas"),
    @NamedQuery(name = "Juego.findByTieneTablero", query = "SELECT j FROM Juego j WHERE j.tieneTablero = :tieneTablero"),
    @NamedQuery(name = "Juego.findByTieneMiniaturas", query = "SELECT j FROM Juego j WHERE j.tieneMiniaturas = :tieneMiniaturas"),
    @NamedQuery(name = "Juego.findByTieneDados", query = "SELECT j FROM Juego j WHERE j.tieneDados = :tieneDados"),
    @NamedQuery(name = "Juego.findByPortada", query = "SELECT j FROM Juego j WHERE j.portada = :portada"),
    @NamedQuery(name = "Juego.findByTamTablero", query = "SELECT j FROM Juego j WHERE j.tamTablero = :tamTablero"),
    @NamedQuery(name = "Juego.findByViaje", query = "SELECT j FROM Juego j WHERE j.viaje = :viaje")})
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "juego_id")
    private Integer juegoId;
    private String nombre;
    private String autor;
    @Column(name = "numero_jugadores")
    @Min(1)
    @Max(99)
    private Integer numeroJugadores;
    private String complejidad;
    @Min(0)
    @Max(999)
    private Integer duracion;
    private String tematica;
    private Short cooperativo;
    @Column(name = "edad_recomendada")
    @Min(0)
    @Max(99)
    private Integer edadRecomendada;
    @Column(name = "tiene_cartas")
    private Short tieneCartas;
    @Column(name = "tiene_tablero")
    private Short tieneTablero;
    @Column(name = "tiene_miniaturas")
    private Short tieneMiniaturas;
    @Column(name = "tiene_dados")
    private Short tieneDados;
    @URL
    private String portada;
    @Column(name = "tam_tablero")
    private String tamTablero;
    private Short viaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juegoId")
    private List<JuegoHabilidad> juegoHabilidadList;
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    @ManyToOne
    private Categoria categoria;
    @JoinColumn(name = "editorial_id", referencedColumnName = "editorial_id")
    @ManyToOne
    private Editorial editorialId;

    public Juego() {
    }

    public Juego(Integer juegoId) {
        this.juegoId = juegoId;
    }

    public Integer getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(Integer juegoId) {
        this.juegoId = juegoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(Integer numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public String getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(String complejidad) {
        this.complejidad = complejidad;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Short getCooperativo() {
        return cooperativo;
    }

    public void setCooperativo(Short cooperativo) {
        this.cooperativo = cooperativo;
    }

    public Integer getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(Integer edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public Short getTieneCartas() {
        return tieneCartas;
    }

    public void setTieneCartas(Short tieneCartas) {
        this.tieneCartas = tieneCartas;
    }

    public Short getTieneTablero() {
        return tieneTablero;
    }

    public void setTieneTablero(Short tieneTablero) {
        this.tieneTablero = tieneTablero;
    }

    public Short getTieneMiniaturas() {
        return tieneMiniaturas;
    }

    public void setTieneMiniaturas(Short tieneMiniaturas) {
        this.tieneMiniaturas = tieneMiniaturas;
    }

    public Short getTieneDados() {
        return tieneDados;
    }

    public void setTieneDados(Short tieneDados) {
        this.tieneDados = tieneDados;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getTamTablero() {
        return tamTablero;
    }

    public void setTamTablero(String tamTablero) {
        this.tamTablero = tamTablero;
    }

    public Short getViaje() {
        return viaje;
    }

    public void setViaje(Short viaje) {
        this.viaje = viaje;
    }

    public List<JuegoHabilidad> getJuegoHabilidadList() {
        return juegoHabilidadList;
    }

    public void setJuegoHabilidadList(List<JuegoHabilidad> juegoHabilidadList) {
        this.juegoHabilidadList = juegoHabilidadList;
    }

    public Categoria getCategoriaId() {
        return categoria;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoria = categoriaId;
    }

    public Editorial getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Editorial editorialId) {
        this.editorialId = editorialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (juegoId != null ? juegoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.juegoId == null && other.juegoId != null) || (this.juegoId != null && !this.juegoId.equals(other.juegoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Juego[ juegoId=" + juegoId + " ]";
    }
    
}
