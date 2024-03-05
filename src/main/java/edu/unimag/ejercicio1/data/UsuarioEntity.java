package edu.unimag.ejercicio1.data;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UsuarioEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private Integer edad;
    @Column(nullable = false)
    private String password;
    @Column(name = "rep_password", nullable = false)
    private String repPassword;
    private Boolean enabled;
    private String foto;
    private String rol;
    private LocalDateTime createAt;

    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="partidas_usuarios", joinColumns= @JoinColumn( name="id_usuario", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(
    name="id_partidas",
    referencedColumnName="id"))
    List<PartidaEntity> partidas;

    @OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    List<MensajeEntity> mensajes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<SugerenciaEntity> sugerencias;

}


