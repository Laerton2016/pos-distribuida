/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.distribuido;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class Servidor extends UnicastRemoteObject implements IServidor{
    private int idCliente = 0;
    private ICliente[] clientesConectados = new Cliente[10];

    public Servidor() throws RemoteException {
    
    }

    
    @Override
    public void conectar(String idDoCliente, String mensagem) throws RemoteException {
        int id = Integer.getInteger(idDoCliente);
        ICliente cliente = clientesConectados[id];
        for (int i = 0; i < clientesConectados.length; i++) {
            if (i != id){
                ICliente clientesConectado = clientesConectados[i];
                clientesConectado.atualizar(idCliente +"" , mensagem);
            }
        }
    }

    @Override
    public String inscrever(String nick, ICliente cliente) throws RemoteException {
        idCliente++;
        try {
            clientesConectados[idCliente] = (ICliente) Naming.lookup("cliente");
        } catch (NotBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCliente +"";
    }

    @Override
    public void sairDoChat(String id) throws RemoteException {
        clientesConectados[Integer.getInteger(id)] = null;
	
    }

  
    
}
