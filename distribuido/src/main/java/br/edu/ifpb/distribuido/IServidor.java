/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.distribuido;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author laerton
 */
public interface IServidor extends Remote{
        void conectar(String idDoCliente, String mensagem ) throws RemoteException;
        String inscrever(String nick, ICliente cliente)throws RemoteException;
        void sairDoChat(String id)throws RemoteException;
    
}
