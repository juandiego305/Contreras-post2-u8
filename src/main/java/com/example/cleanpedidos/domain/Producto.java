package com.example.inventariocqrs.domain;

import java.math.BigDecimal;

public class Producto {
    private final String id;
    private int stockDisponible;

    // Regla de negocio: No se puede reducir más de lo que hay
    public void reducirStock(int unidades) {
        if (unidades > this.stockDisponible) {
            throw new RuntimeException("Stock insuficiente para el producto: " + id);
        }
        this.stockDisponible -= unidades;
    }

    public void incrementarStock(int unidades) {
        if (unidades <= 0) throw new IllegalArgumentException("Unidades deben ser positivas");
        this.stockDisponible += unidades;
    }
    // Constructor y Getters...
}