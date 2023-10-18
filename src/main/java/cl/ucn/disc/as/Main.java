package cl.ucn.disc.as;

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

        // Inicializar la base de datos de Ebean
        Database database = DB.getDefault();

        // Crear una instancia del sistema
        Sistema sistema = new SistemaImpl(database);

        // Agregar una persona al sistema
        try {
            Persona persona = new Persona("202135919", "Nicolas", "Henriquez", "nhp@gmail.com", "56945078467");
            sistema.add(persona);
            log.debug("Persona agregada: {}", persona);
        } catch (SistemaException e) {
            log.error("Error al agregar persona al sistema", e);
        }

        log.debug("Done.");
    }
}
