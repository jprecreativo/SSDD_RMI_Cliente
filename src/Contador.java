import java.util.TimerTask;
import java.util.Timer;

/**
 * Se usará para contar el tiempo.
 * @author jose_
 */
public class Contador extends TimerTask
{
    private final Timer tiempo = new Timer();
    private int segundos;
    private boolean timeout;
    
    public Contador()
    {
        tiempo.schedule(this, 0, 1000);
        segundos = 0;
        timeout = false;
    }
    
    @Override
    public void run() 
    {
        segundos++;
        
        if(segundos > 300)   // Si han pasado 5 minutos.
        {
            tiempo.cancel();
            timeout = true;
        }
    }
    
    /**
     * Resetea al contador, poniendo los segundos a 0.
     */
    public void reset()
    {
        segundos = 0;
    }
    
    public boolean getTimeout()
    {
        return timeout;
    }
}
