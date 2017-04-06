import javax.swing.JFrame;

/**
 * La calse abstracta 'Pantalla' servirá de modelo para todas las pantallas de la aplicación.
 * @author jose_
 */
public abstract class Pantalla extends JFrame 
{
    /**
     * Sirve para inicializar una pantalla.
     * @param ancho Ancho que tendrá la pantalla.
     * @param alto Alto que tendrá la pantalla.
     * @param title Título de la pantalla.
     */
    public void inicializar(int ancho, int alto, String title)
    {
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(title);
    }
}
