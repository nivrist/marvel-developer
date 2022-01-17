/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marvel.developer.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author irvin_monterroza
 */
@Entity
@Table(name = "mv_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MvUsuarios.findAll", query = "SELECT m FROM MvUsuarios m")
    , @NamedQuery(name = "MvUsuarios.findById", query = "SELECT m FROM MvUsuarios m WHERE m.id = :id")
    , @NamedQuery(name = "MvUsuarios.findByNombre", query = "SELECT m FROM MvUsuarios m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MvUsuarios.findByUsr", query = "SELECT m FROM MvUsuarios m WHERE m.usr = :usr")
    , @NamedQuery(name = "MvUsuarios.findByPassword", query = "SELECT m FROM MvUsuarios m WHERE m.password = :password")
    , @NamedQuery(name = "MvUsuarios.findByFechaCreacion", query = "SELECT m FROM MvUsuarios m WHERE m.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "MvUsuarios.findByFechaModificacion", query = "SELECT m FROM MvUsuarios m WHERE m.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "MvUsuarios.findByTwoFactAuth", query = "SELECT m FROM MvUsuarios m WHERE m.twoFactAuth = :twoFactAuth")
    , @NamedQuery(name = "MvUsuarios.findByCorreoElectronico", query = "SELECT m FROM MvUsuarios m WHERE m.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "MvUsuarios.findByEstado", query = "SELECT m FROM MvUsuarios m WHERE m.estado = :estado")})
public class MvUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "usr")
    private String usr;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Size(max = 400)
    @Column(name = "two_fact_auth")
    private String twoFactAuth;
    @Size(max = 400)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;

    public MvUsuarios() {
    }

    public MvUsuarios(Integer id) {
        this.id = id;
    }

    public MvUsuarios(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getTwoFactAuth() {
        return twoFactAuth;
    }

    public void setTwoFactAuth(String twoFactAuth) {
        this.twoFactAuth = twoFactAuth;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MvUsuarios)) {
            return false;
        }
        MvUsuarios other = (MvUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marvel.developer.entities.MvUsuarios[ id=" + id + " ]";
    }
    
}
