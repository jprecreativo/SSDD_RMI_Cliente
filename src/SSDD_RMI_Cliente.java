import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class SSDD_RMI_Cliente 
{
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException 
    {
        String ip, puerto;
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce la ip: ");
        ip = teclado.nextLine();
        
        System.out.print("Introduce el puerto: ");
        puerto = teclado.nextLine();
        
        if("".equals(ip))
            ip = "localhost";
        
        if("".equals(puerto))
            puerto = "12345";
        
        final InterfazMultas stub = (InterfazMultas) Naming.lookup("rmi://" + ip + ":" + puerto + "/Multas");
        new PantallaInicial(stub).setVisible(true);
    }
}
