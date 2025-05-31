package org.example;

public class Cuenta {
    private String numerocuenta;
    private double saldo;

    public Cuenta(String numerocuenta, double saldo) {
        this.numerocuenta = numerocuenta;
        this.saldo = saldo;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
