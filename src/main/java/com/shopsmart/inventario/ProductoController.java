package com.shopsmart.inventario;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/productos") // Esta es la URL base
public class ProductoController {

    // Lista temporal para guardar productos mientras el programa esté corriendo
    private List<Producto> inventario = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong();

    public ProductoController() {
        // Agregamos uno por defecto para probar rápido
        inventario.add(new Producto(contadorId.incrementAndGet(), "Teclado Mecánico", 45.0, 10));
    }

    // GET /productos -> Retorna la lista
    @GetMapping
    public List<Producto> obtenerTodos() {
        return inventario;
    }

    // POST /productos -> Agrega un producto nuevo
    @PostMapping
    public Producto agregar(@RequestBody Producto nuevo) {
        nuevo.setId(contadorId.incrementAndGet());
        inventario.add(nuevo);
        return nuevo;
    }
}