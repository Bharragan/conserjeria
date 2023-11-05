package cl.ucn.disc.as;

import cl.ucn.disc.as.ui.ApiRestServer;
import cl.ucn.disc.as.ui.WebController;
import lombok.extern.slf4j.Slf4j;
import io.javalin.Javalin;


/**
 * Clase Main para probar funcionalidades del sistema.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {

        log.debug("Iniciando el sistema...");

        log.debug("Library path : {}", System.getProperty("java.library.path"));

        //Start the API Rest Server
        Javalin app = ApiRestServer.start(7070,new WebController());

        log.debug("Sistema deteniendose...");

        app.stop();

        log.debug("Sistema finalizado...");
    }
}
