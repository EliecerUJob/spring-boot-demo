package edu.unimag.ejercicio1.data;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sugerencias")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter
@Getter
public class SugerenciaEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripcion;
    @Column(name = "create_at")
    private LocalTime createAt;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
}
