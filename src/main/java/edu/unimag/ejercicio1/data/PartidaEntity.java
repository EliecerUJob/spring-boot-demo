package edu.unimag.ejercicio1.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partidas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class PartidaEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String creador;
    private String deporte;
    private String ciudad;
    private String provincia;
    private LocalDate fecha;
    @Column(name = "hora_comienzo")
    private LocalTime horaComienzo;
    @Column(name = "hora_final")
    private LocalTime horaFinal;
    private Integer participantes;
    private Integer suplentes;
    private String comentarios;

    @ManyToMany(mappedBy="partidas", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    List<UsuarioEntity> usuarios;
}
