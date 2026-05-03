@RestController
@RequestMapping("/api/inventario")
public class ProductoController {
    // Inyección de handlers de comando y consulta...

    // COMANDO: Cambia el estado del sistema
    @PatchMapping("/productos/{id}/stock")
    public Map<String, String> actualizarStock(@PathVariable String id, @RequestBody ActualizarStockCommand cmd) {
        String msg = stockHandler.handle(new ActualizarStockCommand(id, cmd.delta(), cmd.motivo()));
        return Map.of("mensaje", msg);
    }

    // CONSULTA: Solo retorna datos[cite: 5]
    @GetMapping("/productos")
    public List<ProductoView> listar(@RequestParam(defaultValue = "false") boolean soloDisponibles) {
        return listarHandler.handle(new ListarProductosQuery(soloDisponibles));
    }
}