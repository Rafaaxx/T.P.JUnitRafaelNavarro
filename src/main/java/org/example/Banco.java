package org.example;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public void agregarcuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public double consultarsaldo(String numerocuenta) {

            Cuenta c= buscarcuenta(numerocuenta);
            if (c==null){
            throw new RuntimeException("No existe la cuenta");
        }
            return c.getSaldo();
    }

    public Cuenta buscarcuenta(String numerocuenta) {
        for (Cuenta c : cuentas) {
         if (c.getNumerocuenta().equals(numerocuenta)){
             return c;
         }
        }
        return null;
    }
    public void depositar (String numerocuenta, double monto){
        Cuenta c= buscarcuenta(numerocuenta);
        if (c==null){
            throw new RuntimeException("No existe la cuenta");
        }
        if (monto<0) {
            throw new IllegalArgumentException("El monto es negativo.");
        }
        c.setSaldo(c.getSaldo()+monto);
        System.out.println("Monto depositado, el saldo ahora es "+c.getSaldo());

    }
 public void retirar(String numerocuenta, double monto){
     Cuenta c= buscarcuenta(numerocuenta);
     if (c==null){
         throw new RuntimeException("No existe la cuenta");
     }
     if (monto<0) {
         throw new IllegalArgumentException("El monto es negativo.");
     }
     if (monto>c.getSaldo()){
         throw new SaldoInsuficienteException("El monto a retirar es mayor que el saldo");
     }
     c.setSaldo(c.getSaldo()-monto);
 }
}