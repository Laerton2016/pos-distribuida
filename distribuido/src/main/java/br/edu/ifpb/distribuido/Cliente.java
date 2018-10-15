/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.distribuido;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author laerton
 */
public class Cliente extends UnicastRemoteObject implements ICliente {

    private String id = "";
    public Cliente() throws RemoteException
    {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    @Override
    public void atualizar(String nick, String mensagem) throws RemoteException {
        System.out.println(nick + " - " + mensagem);
    }


    
}
