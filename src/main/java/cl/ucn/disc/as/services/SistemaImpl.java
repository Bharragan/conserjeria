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
        try {
            this.database.save(departamento);
            return departamento;
        } catch (PersistenceException ex) {
            log.error("Error al agregar un departamento", ex);
            throw new SistemaException("Error al agregar un departamento", ex);
        }
    }


    @Override
    public Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) {
        try {
            Contrato contrato = new Contrato(duenio, departamento, fechaPago);

            this.database.save(contrato);

            return contrato;
        } catch (PersistenceException ex) {
            log.error("Error al realizar un contrato", ex);
            throw new SistemaException("Error al realizar un contrato", ex);
        }
    }

    @Override
    public List<Contrato> getContratos() {
        List<Contrato> contratos = database.find(Contrato.class).findList();
        return contratos;
    }

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personas = database.find(Persona.class).findList();
        return personas;
    }

    @Override
    public List<Pago> getPagos(String rut) {
        List<Pago> pagos = database.find(Pago.class)
                .where()
                .eq("rut", rut)
                .findList();
        return pagos;
    }
}