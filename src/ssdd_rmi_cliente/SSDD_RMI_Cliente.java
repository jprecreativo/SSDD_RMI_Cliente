package ssdd_rmi_cliente;

import interfaces.PantallaInicial;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SSDD_RMI_Cliente 
{
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException 
    {
        PantallaInicial inicial = new PantallaInicial();
        InterfazMultas stub = (InterfazMultas) Naming.lookup("rmi://localhost:12345/Multas");
        
        inicial.setVisible(true);
    }
}
