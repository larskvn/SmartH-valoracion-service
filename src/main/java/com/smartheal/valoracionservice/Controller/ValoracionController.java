package com.smartheal.valoracionservice.Controller;

import com.smartheal.valoracionservice.Entity.Valoracion;
import com.smartheal.valoracionservice.Service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/valoracion")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    @GetMapping
    private List<Valoracion> findAll(){
        return valoracionService.findAll();
    }

    @GetMapping("/Custom")
    public List<Valoracion> findAllCustom(){
        return valoracionService.findAllCustom();

    }

    @GetMapping("/{id}")
    public Optional<Valoracion> findById(@PathVariable Long id){
        return valoracionService.findById(id);
    }

    @GetMapping("/byuser/{medicId}")
    public ResponseEntity<List<Valoracion>> getByUserId(@PathVariable("medicId") int medicId){
        List<Valoracion> valoracions= valoracionService.findByUserId(medicId);
        if (valoracions.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(valoracions);

    }
    @GetMapping("/{medicId}/promedio")
    public double calcularPromedioPuntos(@PathVariable int medicId) {
        return valoracionService.calcularPromedioPuntosPorUsuario(medicId);
    }




    @PostMapping
    public Valoracion add(@RequestBody Valoracion v){
        return valoracionService.add(v);
    }

    @PutMapping("/{id}")
    public Valoracion update(@PathVariable Long id, @RequestBody Valoracion v){
        v.setIdValor(id);
        return valoracionService.update(v);

    }

    @DeleteMapping("/{id}")
    public Valoracion delete(@PathVariable Long id){
        Valoracion objadmin = new Valoracion();
        objadmin.setState(false);
        return valoracionService.delete(Valoracion.builder().idValor(id).build());
    }


}
