package com.UTN.JPATP1.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@MappedSuperclass //Convierte la clase en una superclase
@Data   //Nos facilita algunos metodos
@NoArgsConstructor  //Nos sirve para cuando queremos crear objetos sin aportar valores iniciales a los campos
@AllArgsConstructor //Es util cuando queremos crear un objeto y llenar los campos inmediatamente (ahorro de codigo)

public class BaseEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
}
