package com.smartheal.valoracionservice.Service;

import com.smartheal.valoracionservice.Entity.Valoracion;

import java.util.List;
import java.util.Optional;

public interface ValoracionService {

    public List<Valoracion> findAll();

    public List<Valoracion> findAllCustom();

    public Optional<Valoracion> findById(long Id);

    public List<Valoracion> findByUserId(int medicId);

    public Valoracion add(Valoracion v);

    public Valoracion update(Valoracion v);

    public Valoracion delete(Valoracion v);

    Double calcularPromedioPuntosPorUsuario(int medicId);
}
