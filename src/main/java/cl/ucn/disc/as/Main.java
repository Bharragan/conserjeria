package cl.ucn.disc.as;

import cl.ucn.disc.as.model.Edificio;
import io.ebean.DB;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.services.Sistema;
import cl.ucn.disc.as.services.SistemaImpl;

/**
 * Clase Main para probar funcionalidades del sistema.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.debug("Starting main WEWEWEWEWEWE");

        Database database = DB.getDefault();

        Sistema sistema = new SistemaImpl(database);

        try {
            Persona persona = new Persona("202135919", "Nicolas", "Henriquez", "nhp@gmail.com", "56945078467");
            sistema.add(persona);
            log.debug("Persona agregada: {}", persona);
        } catch (SistemaException e) {
            log.error("Error al agregar persona al sistema", e);
        }

        try {
            Edificio edificio = new Edificio("Lomas del mar", "Pedro Aguirre Cerda 10585");
            log.debug("Edificio before db: {}", edificio);
        } catch (SistemaException e) {
            log.error("Error al agregar edificio al sistema", e);
        }




        log.debug("Done.");
    }
}
