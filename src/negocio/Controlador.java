package negocio;
public class Controlador {

    private TopTwenty leaderboard;
    // private ArrayList<Partida> partidas;
    private Partida partida;
    private Barra barra;
    private static Controlador instancia;

    private Controlador() {
        // this.partidas = new ArrayList<Partida>();
        // this.partidas.add(new Partida());
        this.partida = new Partida();
    }

    public static Controlador getInstance() {
        if (instancia == null)
            instancia = new Controlador();
        return instancia;
    }

    public void iniciarJuego() {
        partida.iniciarJuego();
    }

    public void jugar() {
        if (!partida.estaJugando())
            partida.jugar();
    }

    public void play() {
        partida.play();
    }

    public void pausar() {
        partida.pausar();
    }

    /**
     * A pasarle a la instancia de barra de la partida actual
     * @param direccion Tiene que ser "izquierda" o "derecha"
     */
    public void moverBarra(String direccion) {
        barra.moverBarra(direccion);
    }

    public void ingresarNombre(String nombre) {
        //if vidas = 0 caja de texto para poner nombre
        leaderboard.ingresarNombre(nombre);
    }

    public void renaudarJuego(){
        partida.play();
        partida.jugar();
    }
}
