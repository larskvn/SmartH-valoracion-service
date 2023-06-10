package com.smartheal.valoracionservice.Repository;

import com.smartheal.valoracionservice.Entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoracionRepository  extends JpaRepository<Valoracion, Long> {

    @Query("Select v from Valoracion v where v.state='1' ")
    List<Valoracion> findAllCustom();

    @Query("SELECT v FROM Valoracion v WHERE v.medicId = :medicId")
    List<Valoracion> findByUserId(@Param("medicId") int medicId);


    @Query("SELECT v FROM Valoracion v WHERE v.medicId = :medicId")
    List<Valoracion> findByMedicId(int medicId);
}
