package com.UTN.JPATP1.entidades;

import com.UTN.JPATP1.enumeraciones.EstadoPedido;
import com.UTN.JPATP1.enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido extends BaseEntidad {
    private EstadoPedido estadoPedido;
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private double total;

    // Relación ONE TO ONE unidireccional entre Pedido y Factura
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    // Relación ONE TO MANY unidireccional entre Pedido y DetallePedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedido = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePedido1){

        detallePedido.add(detallePedido1);
    }


}
