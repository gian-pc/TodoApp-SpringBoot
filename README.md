TodoApp SpringBoot
1. Configuración build.gradle
2. domains
   - Creamos dos clases Todo y TodoType en domains
   - Se genera la clases Todo y TodoType dentro de la estructura domains
   - Además se agrega la anotación @Data de lombock
3. controllers
   - Creamos un primer endpoint en TodoTypeController: http://localhost:8080/api/todoType/hello
   - Creamos otro endpoint de lectura: http://localhost:8080/api/todoType/read
