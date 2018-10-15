/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.distribuido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class NodeCliente {

    
    public static void main(String[] args) throws RemoteException {
		Cliente cliente = new Cliente();
                try {
			Naming.rebind("cliente", cliente);
			
			IServidor servidor = (IServidor) Naming.lookup("rmi://localhost:1099/servidor");
			System.out.println(servidor);
			//
			String idCliente = servidor.inscrever("Laerton", cliente);
			System.out.println("Id do cliente: " + idCliente);
			//
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Entre com um nome e depois a sua mensagem: ");
			String _nome = reader.readLine();
			String _mess = reader.readLine();
			while(_mess.compareTo("end") != 0){
                                servidor.conectar(idCliente, _mess);
				_mess = reader.readLine();
			}
			//
			servidor.sairDoChat(idCliente);
			System.out.println("saiu");
			System.exit(0);
			
		} 
		catch (IOException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
   
}
