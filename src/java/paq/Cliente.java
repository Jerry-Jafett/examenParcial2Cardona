/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq;

/**
 *
 * @author Gerardo
 */
public class Cliente {
    private int id, saldo;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
                    
    @Override
    public String toString(){
        String res = "ID: " + id + " Nom: " + nombre + " Saldo: " + saldo;
        return res;
    }
}
