# Sistema de Urgencias de Hospital

## Descripción
Este sistema de urgencias permite registrar pacientes que llegan en urgencias con sus datos para identificarlos. Los doctores pueden gestionar el estado del paciente, internarlo, cambiarlo de área o darle de alta. También cuenta con un administrador que puede observar y realizar todos los movimientos dentro del sistema.

El sistema está dividido en paquetes MODELO-VISTA-CONTROLADOR para tener una mejor estructura de proyecto. Está diseñado para proporcionar funcionalidad al sistema y facilitar su uso por parte del usuario.

## Métodos Usados

- **`cargarTabla()`**: Conecta a una base de datos, ejecuta una consulta SQL para obtener un subconjunto de registros de la tabla historial con paginación (usando `LIMIT` y `OFFSET`), y carga los resultados en un `JTable` en la interfaz de usuario.

- **`buscarPaciente(String criterio)`**: Busca registros de pacientes en una base de datos cuyo nombre coincide parcialmente con el criterio de búsqueda proporcionado. La consulta SQL filtra los resultados con `LIKE` y aplica paginación usando `LIMIT` y `OFFSET`. Los resultados se cargan en un `DefaultTableModel`, que luego se asigna a un `JTable` (`tblHistorial`).

- **`generarCURP()`**: Genera una CURP basada en los datos ingresados por el usuario, como nombre, apellidos, fecha de nacimiento, estado y sexo.

- **`generarRFC()`**: Genera un RFC basado en los datos ingresados por el usuario, como nombre, apellidos y fecha de nacimiento.

- **`generarPDF(String Nombre, String RFC, String fecha, String condicion, String notas)`**: Crea un archivo PDF con información de un paciente utilizando la biblioteca iText.

- **`createEmail()`**: Crea un correo electrónico.

- **`createsendEmail()`**: Envía un correo electrónico.

## Usos

1. **Gestión de Pacientes en Urgencias:**
   - **Registro Rápido**: Captura rápidamente la información básica de los pacientes al llegar a urgencias, lo que es crucial para la atención inmediata.
   - **Monitoreo del Estado**: Los doctores pueden actualizar y monitorear el estado del paciente en tiempo real, ayudando a priorizar la atención según la gravedad.

2. **Asignación y Cambio de Áreas:**
   - **Internación**: Permite a los doctores internar a los pacientes en diferentes áreas del hospital según sus necesidades médicas.
   - **Cambio de Área**: Si el estado del paciente cambia, pueden ser trasladados a otras áreas (por ejemplo, de urgencias a cuidados intensivos).

3. **Documentación y Seguimiento:**
   - **Historial Médico**: Almacena el historial médico y los tratamientos aplicados, lo que facilita la continuidad del cuidado y la toma de decisiones informadas.
   - **Generación de Informes**: Facilita la creación de informes de salida, estado del paciente, y notas médicas que pueden ser consultados en cualquier momento.

4. **Eficiencia Operativa:**
   - **Reducción de Errores**: Minimiza los errores en el manejo de la información del paciente al centralizar y estandarizar los datos.
   - **Comunicación**: Mejora la comunicación entre el personal médico, ya que todos pueden acceder a la información actualizada del paciente.

## Requisitos

- Java JDK 8 o superior.
- IDE con soporte para Swing (por ejemplo, NetBeans o IntelliJ IDEA).
- Librerías necesarias:
  - `jCalendar.jar`
  - `java-mail-1.4.jar`
  - `itextpdf-5.5.9.jar`
  - `io-7.1.4.jar`
  - `activation-1.1.1.jar`
  - `javax-inject.jar`
  - `mysql-connector-java-8.0.27.jar`

## Instalación

1. Descarga los archivos y compila el proyecto, importando todas las librerías necesarias.
2. Descarga la base de datos para guardar los datos.
3. En la clase de conexión, cambia la dirección y contraseña de la base de datos según tus configuraciones.
4. Compila el proyecto y comienza a realizar pruebas.

## Autores

- González Vásquez Miguel Ángel
- Hernández Lázaro Paola
