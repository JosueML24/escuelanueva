/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.escuelanueva.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.escuelanueva.entity.DistritoEntity;
import pe.com.escuelanueva.service.DistritoService;

/**
 *
 * @author Harold Mallma
 */
@RestController
@RequestMapping("/distrito")
public class DistritoController {
    @Autowired
    private DistritoService distritoservice;
    
    @GetMapping
    public List<DistritoEntity> findAll(){
        return distritoservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<DistritoEntity> findAllCustom(){
        return distritoservice.findAllCustom();
    }
    
    
     @PostMapping
    public DistritoEntity add(@RequestBody DistritoEntity d){
        return distritoservice.add(d);
    }
    
    @GetMapping("/{id}")
    public Optional<DistritoEntity> findById(@PathVariable Long id){
        return distritoservice.findById(id);
    }
    
    @PutMapping("/{id}")
    public DistritoEntity update(@PathVariable long id,@RequestBody DistritoEntity d){
            d.setCodigo(id);
        return distritoservice.add(d);
    }
    
     @DeleteMapping("/{id}")
    public DistritoEntity delete(@PathVariable long id){
            DistritoEntity objpdistrito = new DistritoEntity ();
            objpdistrito.setEstado(false);
        return distritoservice.delete(DistritoEntity.builder().codigo(id).build());
    }
}
