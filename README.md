# Sistema de Inventario - Arquitectura CQRS (UFPS)

Este proyecto implementa el patrón **CQRS** (Command Query Responsibility Segregation) para la gestión de inventarios. La arquitectura separa completamente la lógica de **escritura** de la lógica de **lectura**, permitiendo que cada stack evolucione y se optimice de forma independiente.

## 🏗️ Organización de Stacks
- **Command Side**: Enfocado en la integridad y reglas de negocio. Utiliza una entidad `Producto` con lógica interna para proteger el stock disponible.
- **Query Side**: Enfocado en la velocidad y presentación. Utiliza el modelo `ProductoView` (Record) que entrega datos desnormalizados y estados pre-calculados (DISPONIBLE/BAJO/AGOTADO).

## 🚀 Guía de Uso
1. **POST /productos**: Crea un producto en el sistema de escritura.
2. **PATCH /productos/{id}/stock**: Modifica existencias enviando un comando de actualización.
3. **GET /productos**: Consulta el inventario desde el sistema de lectura optimizado.

## ✅ Checkpoints de Verificación
* Los **Command Handlers** no retornan listas de datos, solo confirmaciones o IDs.
* Los **Query Handlers** tienen prohibido modificar datos en la base de datos.
* El estado del stock se calcula automáticamente en la vista de lectura.

## 🧑‍💻 Autor
* **Juan Diego Contreras Garcia**
* **UFPS - 2026**
