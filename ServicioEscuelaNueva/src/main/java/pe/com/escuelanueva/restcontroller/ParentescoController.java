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
import pe.com.escuelanueva.entity.ParentescoEntity;
import pe.com.escuelanueva.service.ParentescoService;

/**
 *
 * @author Harold Mallma
 */

@RestController
@RequestMapping("/parentesco")
public class ParentescoController {
    @Autowired
    private ParentescoService parentescoservice;
    
    @GetMapping
    public List<ParentescoEntity> findAll(){
        return parentescoservice.findAll();
    }
    
    @GetMapping("/custom")
    public List<ParentescoEntity> findAllCustom(){
        return parentescoservice.findAllCustom();
    }
    
    
     @PostMapping
    public ParentescoEntity add(@RequestBody ParentescoEntity p){
        return parentescoservice.add(p);
    }
    
    @GetMapping("/{id}")
    public Optional<ParentescoEntity> findById(@PathVariable Long id){
        return parentescoservice.findById(id);
    }
    
    @PutMapping("/{id}")
    public ParentescoEntity update(@PathVariable long id,@RequestBody ParentescoEntity p){
            p.setCodigo(id);
        return parentescoservice.add(p);
    }
    
     @DeleteMapping("/{id}")
    public ParentescoEntity delete(@PathVariable long id){
            ParentescoEntity objparentesco = new ParentescoEntity ();
            objparentesco.setEstado(false);
        return parentescoservice.delete(ParentescoEntity.builder().codigo(id).build());
    }
}
