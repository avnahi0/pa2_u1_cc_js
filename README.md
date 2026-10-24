## Preguntas de Análisis

### 1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?
* **IoC (Inversión de Control):** Se aplica al dejar que Quarkus (a través de ArC) controle la creación y el ciclo de vida de los objetos en vez de crearlos a mano. En ningún momento usamos `new` para instanciar clases como `VentaService` o `Auditoria`; el contenedor se encarga de crearlas e iniciarlas automáticamente.
* **DI (Inyección de Dependencias):** Se aplica de forma puntual en las clases donde es necesario usar esas dependencias:
  * **Por atributo:** En `VentaService` cuando usamos `@Inject` sobre `Auditoria`, y en `AppTienda` cuando inyectamos `VentaService`.
  * **Por constructor:** En el constructor de `VentaService`, donde recibimos como parámetros las dos calculadoras de descuento (`CalculadoraDescuento`).

---

### 2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?
Cumplen la función de "etiquetar" o diferenciar las implementaciones. Aqui use `@Named("regular")` y `@Named("vip")`. 
Son indispensables porque use una sola interfaz (`CalculadoraDescuento`) implementada por dos clases diferentes (`DescuentoRegular` y `DescuentoVIP`). Si solo utilizamos a Quarkus para inyectar la interfaz sin el `@Named`, el contenedor no tendría forma de adivinar cuál de las dos necesitamos en cada caso.

---

### 3. ¿Cuál es la diferencia entre `@ApplicationScoped` y `@Dependent`?
La diferencia está en la cantidad de instancias que se crean y cómo viven en la memoria:
* Con **`@ApplicationScoped`**, se crea una única instancia para toda la aplicación y todos los componentes que la llamen comparten ese mismo objeto y se aplica cunado es logica de negocio.
* Con **`@Dependent`**, el bean no se comparte; su ciclo de vida depende de la clase donde se inyecta. Si dos clases diferentes inyectan un bean `@Dependent`, cada una recibe una instancia completamente nueva y separada.

---

### 4. ¿Por qué las instancias `@ApplicationScoped` pueden reutilizarse entre varias ventas?
Porque son servicios que no guardan estado de un cliente o venta específica (son *stateless*). Clases como `VentaService` o las calculadoras de descuento solo reciben el monto por parámetro, calculan el porcentaje y lo devuelven; no almacenan variables temporales de una venta en particular. Por eso la misma instancia puede procesar la Venta 1, la Venta 2 y las demás sin ningún problema de que se mezclen los datos.

---

### 5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de `CalculadoraDescuento`?
Quarkus detectará que existen dos beans disponibles (`DescuentoRegular` y `DescuentoVIP`) que cumplen con la interfaz `CalculadoraDescuento`, pero al no tener el qualifier no sabrá cuál asignar. Por lo tanto, el proyecto fallará al compilar o al iniciar arrojando un error de ambigüedad (`AmbiguousResolutionException`), bloqueando la ejecución para evitar comportamientos incorrectos.