import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InscritoTest {

    @Test
    void quandoTiverUmNovoVideo_deveNotificarUmInscrito() {
        CanalYouTube canalYouTube = new CanalYouTube("Rocketseat", "Keyframes no React Native");
        Inscrito inscrito = new Inscrito("Gabi");
        inscrito.inscrever(canalYouTube);
        canalYouTube.publicarVideo();
        assertEquals("Gabi! Novo vídeo adicionado no CanalYouTube{canal='Rocketseat', " +
                "tituloVideo='Keyframes no React Native'}", inscrito.getUltimaNotificacao());
    }

    @Test
    void quandoTiverUmNovoVideo_deveNotificarInscritos() {
        CanalYouTube canalYouTube = new CanalYouTube("Rocketseat", "Keyframes no React Native");
        Inscrito inscrito = new Inscrito("Gabi");
        Inscrito inscrito1 = new Inscrito("Peter");
        inscrito.inscrever(canalYouTube);
        inscrito1.inscrever(canalYouTube);
        canalYouTube.publicarVideo();
        assertEquals("Gabi! Novo vídeo adicionado no CanalYouTube{canal='Rocketseat', " +
                "tituloVideo='Keyframes no React Native'}", inscrito.getUltimaNotificacao());
        assertEquals("Peter! Novo vídeo adicionado no CanalYouTube{canal='Rocketseat', " +
                "tituloVideo='Keyframes no React Native'}", inscrito1.getUltimaNotificacao());
    }

    @Test
    void quandoTiverUmNovoVideoNoCanalB_deveNotificarInscritoCanalB() {
        CanalYouTube canalYouTubeA = new CanalYouTube("Rocketseat", "Keyframes no React Native");
        CanalYouTube canalYouTubeB = new CanalYouTube("Alura", "O poder da educação e da diversidade na" +
                " área Tech");
        Inscrito inscrito = new Inscrito("Gabi");
        Inscrito inscrito1 = new Inscrito("Peter");
        inscrito.inscrever(canalYouTubeA);
        inscrito1.inscrever(canalYouTubeB);
        canalYouTubeB.publicarVideo();
        assertNull(inscrito.getUltimaNotificacao());
        assertEquals("Peter! Novo vídeo adicionado no CanalYouTube{canal='Alura', " +
                "tituloVideo='O poder da educação e da diversidade na área Tech'}", inscrito1.getUltimaNotificacao());
    }

    @Test
    void quandoNaoForInscrito_naoDeveNotificar() {
        CanalYouTube canalYouTube = new CanalYouTube("Alura", "O poder da educação e da diversidade na" +
                " área Tech");
        Inscrito inscrito = new Inscrito("Gabi");
        canalYouTube.publicarVideo();
        assertNull(inscrito.getUltimaNotificacao());
    }
}