import javax.swing.JFrame;

public abstract class Pantalla extends JFrame 
{
    public void inicializar(int ancho, int alto, String title)
    {
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(title);
    }
}
