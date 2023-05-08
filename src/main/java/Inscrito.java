import java.util.Observable;
import java.util.Observer;

public class Inscrito implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Inscrito(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void inscrever(CanalYouTube canalYouTube) {
        canalYouTube.addObserver(this);
    }

    @Override
    public void update(Observable canal, Object arg) {
        this.ultimaNotificacao = this.nome + "! Novo vídeo adicionado no " + canal.toString();
    }
}
