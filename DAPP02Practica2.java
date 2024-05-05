package org.uv.dapp02practica2;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DAPP02Practica2 {

    public static void main(String[] args) {
        SpringApplication.run(DAPP02Practica2.class, args);
    }

    @RestController
    public static class HelloWorldController {

        @Autowired
        private RepositoryEmpleado repositoryEmpleado;

        @GetMapping("/")
        public String helloWorld() {
            return "Hello World!";
        }

        @GetMapping(value = "/empleado/{id}", produces = "application/json")
        public Empleado getEmpleado(@PathVariable("id") Long id) {
            Optional<Empleado> res = repositoryEmpleado.findById(id);
            return res.orElse(null);
        }

        @PutMapping(value = "/empleado/{id}", produces = "application/json")
        public Empleado putEmpleado(@PathVariable("id") Long id, @RequestBody Empleado emp) {
            Optional<Empleado> optionalEmpleado = repositoryEmpleado.findById(id);
            if (optionalEmpleado.isPresent()) {
                Empleado empleado = optionalEmpleado.get();
                empleado.setClave(emp.getClave());
                empleado.setNombre(emp.getNombre());
                empleado.setDireccion(emp.getDireccion());
                empleado.setTelefono(emp.getTelefono());
                return repositoryEmpleado.save(empleado);
            } else {
                return null;
            }
        }

        @PostMapping(value = "/empleado", produces = "application/json")
        public Empleado postEmpleado(@RequestBody Empleado emp) {
            return repositoryEmpleado.save(emp);
        }

        @DeleteMapping(value = "/empleado/{id}", produces = "application/json")
        public void deleteEmpleado(@PathVariable("id") Long id) {
            repositoryEmpleado.deleteById(id);
        }
    }
}
    

//    @RestController
//    public static class HelloWorldController {
// 
//        
//     @GetMapping("/")
//        public String helloWorld() {
//            return "Hello World!";
//        }
//
////        @GetMapping("/msg")
////        public DTOUsuario msg() {
////            return new DTOUsuario("jabon", "zote");
////        }
////
////        @GetMapping("/msg/{id}")
////        public DTOUsuario msg(@PathVariable("id") Long id) {
////            return new DTOUsuario("jabon" + id, "zote" + id);
////        }
////
////        @PostMapping("/msg")
////        public String msg2(@RequestBody DTOUsuario usr) {
////            String msg = "se recibio " + usr.getNombre() + "--" + usr.getDescripcion()+ "--" + usr.getTelefono();
////            return "{ \"msg\": \"" + msg + "\" }";
////        }
////
////        @PutMapping("/msg")
////        public String msg3(@RequestBody DTOUsuario usr) {
////            String msg = "se editó " + usr.getNombre() + "--" + usr.getDescripcion()+ "--" + usr.getTelefono();
////            return "{ \"msg\": \"" + msg + "\" }";
////        }
////
////        @DeleteMapping("/msg/{id}")
////        public String msg4(@PathVariable Long id) {
////            String msg = "se eliminó el empleado con ID: " + id;
////            return "{ \"msg\": \"" + msg + "\", \"id\": " + id + " }";
////        }
//        
//        @Autowired
//        private RepositoryEmpleado repositoryEmpleado;
//       @GetMapping(value = "/empleado/{id}", produces = "application/json")
//  public Empleado getEmpleado(@PathVariable("id")Long id){
//           Optional<Empleado> res = repositoryEmpleado.findById(id);
//           if (res.isPresent()){
//           return res.get();
//           }
//           else 
//               return null;
//  }
//  
//  @PutMapping(value = "/empleado/{id}", produces = "application/json")
//     public Empleado putempleado(@PathVariable("id")Long id, @RequestBody  Empleado emp){
//        Optional<Empleado> optionalEmpleado = repositoryEmpleado.findById(id);
//
//        if (optionalEmpleado.isPresent()) {
//            Empleado empleado = optionalEmpleado.get();
//            empleado.setClave(emp.getClave());
//            empleado.setNombre(emp.getNombre());
//            empleado.setDireccion(emp.getDireccion());
//            empleado.setTelefono(emp.getTelefono());
//            repositoryEmpleado.save(empleado);
//            
//            return empleado;
//        } else {
//            return null;
//        }
//    }
//     
//       @GetMapping(value = "/empleado/{id}", produces = "application/json")
//  public Empleado putEmp(@PathVariable("id")Long id,@RequestBody Empleado emp){
//           repositoryEmpleado.save(emp);
//           return emp;
//                  
//  }
//  
//   @GetMapping(value = "/empleado/{id}", produces = "application/json")
//  public Empleado deleteempleado (@PathVariable("id")Long id,@RequestBody Empleado emp){
//           repositoryEmpleado.delete(emp);
//           return emp;
//                  
//  }
//  
//  
//  
//
//    }
//}
