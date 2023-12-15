package cl.ucn.disc.as.services;

import cl.ucn.disc.as.exceptions.SistemaException;
import cl.ucn.disc.as.model.Edificio;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.model.Departamento;
import cl.ucn.disc.as.model.Contrato;
import cl.ucn.disc.as.model.Pago;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface Sistema {

    void populate();

    /**
     * Agregar un edificio al sistema.
     *
     * @param edificio El edificio a agregar.
     * @return El edificio agregado.
     * @throws SistemaException Si ocurre un error al agregar el edificio.
     */
    Edificio add(Edificio edificio) throws SistemaException;

    /**
     * Agregar una persona al sistema.
     *
     * @param persona La persona a agregar.
     * @return La persona agregada.
     * @throws SistemaException Si ocurre un error al agregar la persona.
     */
    Persona add(Persona persona) throws SistemaException;

    /**
     * Agregar un departamento al sistema.
     *
     * @param departamento El departamento a agregar.
     * @return El departamento agregado.
     * @throws SistemaException Si ocurre un error al agregar el departamento.
     */
    Departamento add(Departamento departamento) throws SistemaException;

    /**
     * Realizar un contrato entre una persona y un departamento en una fecha específica.
     *
     * @param duenio      La persona que será dueña del contrato.
     * @param departamento El departamento objeto del contrato.
     * @param fechaPago  La fecha de pago del contrato.
     * @return El contrato realizado.
     * @throws SistemaException Si ocurre un error al realizar el contrato.
     */
    Contrato realizarContrato(Persona duenio, Departamento departamento, Instant fechaPago) throws SistemaException;

    /**
     * Obtener la lista de todos los contratos en el sistema.
     *
     * @return La lista de contratos.
     */
    List<Contrato> getContratos();

    /**
     * Obtener la lista de todas las personas en el sistema.
     *
     * @return La lista de personas.
     */
    List<Persona> getPersonas();

    /**
     * Obtener la lista de pagos asociados a una persona por su RUT.
     *
     * @param rut El RUT de la persona.
     * @return La lista de pagos asociados a la persona.
     */
    List<Pago> getPagos(String rut);
    Optional<Persona> getPersona(String rut);

}
