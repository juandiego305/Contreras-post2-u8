package com.example.inventariocqrs.query.model;

public record ProductoView(
    String id,
    String nombre,
    int stockDisponible,
    String estadoStock // "DISPONIBLE", "BAJO", "AGOTADO"[cite: 5]
) {
    public static String calcularEstado(int stock) {
        if (stock == 0) return "AGOTADO";
        return (stock < 5) ? "BAJO" : "DISPONIBLE";
    }
}