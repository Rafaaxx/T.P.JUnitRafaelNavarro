package org.example;

public class ExcepcionEdad extends RuntimeException {
    public ExcepcionEdad() {
        super("La edad no puede ser negativa");
    }
}
