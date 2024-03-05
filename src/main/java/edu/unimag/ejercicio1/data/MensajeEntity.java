package edu.unimag.ejercicio1.data;

import java.time.LocalDate;

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
@Table(name = "mensajes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter
@Getter
public class MensajeEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String creador;
    private String destinatario;
    @Column(name = "create_at")
    private LocalDate createAt;
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    UsuarioEntity usuario;
}
