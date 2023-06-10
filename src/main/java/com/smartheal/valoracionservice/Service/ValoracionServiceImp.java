package com.smartheal.valoracionservice.Service;

import com.smartheal.valoracionservice.Entity.Valoracion;
import com.smartheal.valoracionservice.Repository.ValoracionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValoracionServiceImp implements ValoracionService{


    @Autowired
    private ValoracionRepository valoracionRepository;

    @Override
    public List<Valoracion> findAll() {
        return valoracionRepository.findAll();
    }

    @Override
    public List<Valoracion> findAllCustom() {
        return valoracionRepository.findAllCustom();
    }

    @Override
    public Optional<Valoracion> findById(long Id) {
        return valoracionRepository.findById(Id);
    }

    @Override
    public List<Valoracion> findByUserId(int medicId) {
        return valoracionRepository.findByUserId(medicId);
    }

    @Override
    public Valoracion add(Valoracion v) {
        return valoracionRepository.save(v);
    }

    @Override
    public Valoracion update(Valoracion v) {
        Valoracion valoracion = valoracionRepository.getById(v.getIdValor());
        BeanUtils.copyProperties(v,valoracion);
        return valoracionRepository.save(valoracion);
    }

    @Override
    public Valoracion delete(Valoracion v) {
        Valoracion valoracion = valoracionRepository.getById(v.getIdValor());
        valoracion.setState(false);
        return valoracionRepository.save(valoracion);
    }

    @Override
    public Double calcularPromedioPuntosPorUsuario(int medicId) {
        List<Valoracion> valoraciones = valoracionRepository.findByMedicId(medicId);
        if (valoraciones.isEmpty()) {
            return 0.0; // Devuelve 0 si no hay valoraciones para ese usuario
        }

        int sumaPuntos = 0;
        for (Valoracion valoracion : valoraciones) {
            sumaPuntos += valoracion.getPoint();
        }

        return (double) sumaPuntos / valoraciones.size();
    }


}
