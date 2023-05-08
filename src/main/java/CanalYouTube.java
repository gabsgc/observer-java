import java.util.Observable;

public class CanalYouTube extends Observable {
    private String canal;
    private String tituloVideo;

    public CanalYouTube(String canal, String novoVideo) {
        this.canal = canal;
        this.tituloVideo = novoVideo;
    }

    public void publicarVideo() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "CanalYouTube{" +
                "canal='" + canal + '\'' +
                ", tituloVideo='" + tituloVideo + '\'' +
                '}';
    }
}
