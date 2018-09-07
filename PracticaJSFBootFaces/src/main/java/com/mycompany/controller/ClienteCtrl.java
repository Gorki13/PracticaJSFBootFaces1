/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.controllerimpl.ClienteCtrlImpl;
import com.mycompany.dao.ClienteDAO;
import com.mycompany.modell.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "categoriaCtrl")
@SessionScoped
public class ClienteCtrl implements Serializable{
    private Cliente selected;
    private boolean est;
    ClienteDAO catdao;
    private ArrayList<Cliente> list = new ArrayList<>();

    public ClienteCtrl() {
        this.selected = new Cliente();
        this.catdao = new ClienteCtrlImpl();
    }
    public void createCliente(){
        if(catdao.createCliente(selected)){
            System.out.println("Insertado");
        }else{
            System.out.println("Error al insertar");
        }
    }
    public ArrayList<Cliente> getList(){
        catdao = new ClienteCtrlImpl();
        list = catdao.readCliente();
        return list;
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }
    
    
}
