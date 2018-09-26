package com.gustavofonseca.tp1;

import android.content.Intent;
import android.provider.ContactsContract;

public class Pessoa {

    private String nome;
    private String numero;
    private String email;

    public Pessoa()
    {
        nome = "";
        numero = "";
        email = "";
    }

    public Pessoa(String nome, String numero, String email)
    {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setNum(String numero)
    {
        this.numero = numero;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNome()
    {
        return nome;
    }

    public String getNum()
    {
        return numero;
    }

    public String getEmail()
    {
        return email;
    }



}
