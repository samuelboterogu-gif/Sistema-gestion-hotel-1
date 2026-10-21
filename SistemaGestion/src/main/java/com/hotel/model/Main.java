package com.hotel.model;

import com.hotel.model.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTION DE HOTEL ===");
        
        // 1. Crear y mostrar datos del cliente
        Cliente cliente = new Cliente(1, "felipe guerra", "123456789", "felipe@email.com", "3301234567");
        System.out.println("-> Cliente Registrado: " + cliente.getNombre() + " (Correo: " + cliente.getCorreo() + ")");

        // 2. Crear y mostrar datos de la habitación
        Habitacion habitacion = new Habitacion(205, "Suite", 130.0, "Disponible");
        System.out.println("-> Habitación Creada: N° " + habitacion.getNumeroHabitacion() + " | Tipo: " + habitacion.getTipo() + " | Precio por noche: $" + habitacion.getPrecioPorNoche());

        // 3. Solicitar una reserva
        Date inicio = new Date();
        Date fin = new Date(inicio.getTime() + (1000L * 60 * 60 * 24 * 7)); 
        Reserva reserva = cliente.solicitarReserva(inicio, fin, habitacion);
        System.out.println("-> Reserva solicitada con éxito. Estado actual: " + reserva.getEstadoReserva());

        // 4. Recepcionista hace el Check-In
        Recepcionista recepcionista = new Recepcionista(2, "ana lopera", "987654321", "ana@hotel.com", "3007654321", "EMP-008", "Mañana");
        recepcionista.registrarCheckIn(reserva);
        System.out.println("-> Recepcionista (" + recepcionista.getNombre() + ") realizó el Check-In. Estado de la reserva: " + reserva.getEstadoReserva());

        // 5. Check-Out y Factura
        Factura factura = recepcionista.registrarCheckOut(reserva);
        System.out.println("-> Check-Out realizado. Factura emitida # " + factura.getIdFactura() + " por un total de: $" + factura.getTotalPagar());
        
        System.out.println("=== SIMULACION FINALIZADA CON EXITO ===");
    }
}