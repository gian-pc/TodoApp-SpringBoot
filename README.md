TodoApp SpringBoot
1. Configuración build.gradle
2. domains
   - Creamos dos clases Todo y TodoType en domains
   - Se genera la clases Todo y TodoType dentro de la estructura domains
   - Además se agrega la anotación @Data de lombock
3. controllers
   - TodoTypeController: Creamos 2 endopoints
     - http://localhost:8080/api/todoType/hello
     - http://localhost:8080/api/todoType/read
   - TodoController: Aquí se implementarán  todas las  operaciones  REST
     - create
     - read
     - update
     - delete
4. services
   - TodoServices
   - TodoTypeServices
5. Test
   - Test Unitarios
   - Test de Integración 