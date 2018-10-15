/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.distribuido;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author laerton
 */
public class NodeShar 
{
    public static void main(String[] args) throws RemoteException, MalformedURLException{
		//
		//System.setSecurityManager(new RMISecurityManager());
		//
		Servidor servidor = new Servidor();
		//
		try {
			Naming.rebind("rmi://localhost:1099/servidor", servidor);
		} 
		catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
