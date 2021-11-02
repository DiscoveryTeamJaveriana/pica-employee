package co.edu.javeriana.discovery.pica.employee.controller;

import co.edu.javeriana.discovery.pica.employee.controller.model.ReqPostEmpleado;
import co.edu.javeriana.discovery.pica.employee.controller.model.RespGetEmpleado;
import co.edu.javeriana.discovery.pica.employee.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/c3p/v1/Portal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    private static final String RQUID = "X-RqUID";
    private static final String CODIGO = "Codigo";

    private IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/Empleado")
        public ResponseEntity<Void> postEmpleado(@RequestBody ReqPostEmpleado reqPostEmpleado, @RequestHeader(value=RQUID) String xRqUID ) {
        log.info("Creating Employee for RqUID {}", xRqUID);
        employeeService.postEmpleado(reqPostEmpleado, xRqUID);
        return new ResponseEntity<>(putRqUIDHeader(xRqUID),HttpStatus.CREATED);
    }

    @GetMapping("/Empleados")
    public ResponseEntity< ArrayList<RespGetEmpleado>> getEmpleados(@RequestHeader(value=RQUID) String xRqUID ) {
        log.info("Get Employees for RqUID {}", xRqUID);
        ArrayList<RespGetEmpleado> response = employeeService.getEmpleados(xRqUID);
        return new ResponseEntity<>(response, putRqUIDHeader(xRqUID), HttpStatus.OK);
    }

    @GetMapping("/Empleado/{Codigo}")
    public ResponseEntity<RespGetEmpleado> getEmpleado(@RequestHeader(value=RQUID) String xRqUID, @PathVariable(CODIGO) String codigo) {
        log.info("Get Employee for RqUID {}", xRqUID);
        RespGetEmpleado response = employeeService.getEmpleado(codigo, xRqUID);
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
    }

    private HttpHeaders putRqUIDHeader(String rquid) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(RQUID,rquid);
        return headers;
    }
}
