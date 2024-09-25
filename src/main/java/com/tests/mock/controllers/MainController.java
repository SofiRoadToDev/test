package com.tests.mock.controllers;

import com.tests.mock.DTO.TareaDTO;
import com.tests.mock.entities.Tarea;
import com.tests.mock.esceptions.ElemenAlreadyExistsException;
import com.tests.mock.esceptions.ElementNotFoundException;
import com.tests.mock.mappers.TareaMapper;
import com.tests.mock.repositories.CategoriaRepository;
import com.tests.mock.repositories.TareaRepository;
import com.tests.mock.services.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class MainController {

    private TareaService tareaService;
    private CategoriaRepository categoriaRepository;

    @GetMapping()
    public ResponseEntity<?>getTareas(){
        return ResponseEntity.ok(tareaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getTareas(@PathVariable Long id) throws ElementNotFoundException {
        return ResponseEntity.ok(tareaService.findById(id));
    }

    @GetMapping("/filtro-categoria/{categoria}")
    public ResponseEntity<?>getTareasByCateoria(@PathVariable String categoria){
        // No verificamos que exista la categoria pero debe elegirse de un select.
        return ResponseEntity.ok(tareaService.findByCategoria(categoria));
    }

    @PostMapping()
    public ResponseEntity<?>crearTarea(@RequestBody TareaDTO tareaDTO) throws ElemenAlreadyExistsException {
        TareaDTO tareaCreada = tareaService.crearTarea(tareaDTO);
        return ResponseEntity
                .created(URI.create(String.format("/tarea/%s%",tareaCreada.getId())))
                .body(tareaCreada);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarTarea(@RequestBody TareaDTO tareaDTO){
        TareaDTO tareaActualizada = tareaService.crearTarea(tareaDTO);
        return ResponseEntity
                .created(URI.create(String.format("/tarea/%s%",tareaActualizada.getId())))
                .body(tareaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?>eliminarTarea(@PathVariable Long id)throws ElementNotFoundException{
        tareaService.borrarTarea(id);
        return ResponseEntity.noContent().build();
    }




}
