package cl.ucn.disc.as.services;

import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.model.Contrato;
import cl.ucn.disc.as.model.Pago;
import cl.ucn.disc.as.model.Departamento;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.List;

@Slf4j
public class SistemaImpl implements Sistema {

    private final Database database;

    public SistemaImpl(Database database) {
        this.database = database;
    }

    @Override
    public Edificio add(Edificio edificio) {
        try {
            this.database.save(edificio);
            return edificio;
        } catch (PersistenceException ex) {
            log.error("Error al agregar un edificio", ex);
            throw new SistemaException("Error al agregar un edificio", ex);
        }
    }


    @Override
    public Persona add(Persona persona) {
        try {
            this.database.save(persona);
            return persona;
        } catch (PersistenceException ex) {
            log.error("Error al agregar una persona", ex);
            throw new SistemaException("Error al agregar una persona", ex);
        }
    }


    @Override
    public Departamento add(Departamento departamento) {
        return null;
    }

    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {
        return null;
    }

    @Override
    public List<Contrato> getContratos() {
        return null;
    }

    @Override
    public List<Persona> getPersonas() {
        return null;
    }

    @Override
    public List<Pago> getPagos(String rut) {
        return null;
    }
}
