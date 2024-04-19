package com.example.demo.model;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "tb_leitura")
public class Leitura {
    //valor e data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor")
    private String valor;
    @Column(name = "data")
    private String data;
    @Column(name = "sensor_id")
    private Long sensorId;
}
