package co.edu.javeriana.discovery.pica.employee.controller;

import co.edu.javeriana.discovery.pica.employee.controller.model.ReqPostEmpleado;
import co.edu.javeriana.discovery.pica.employee.controller.model.RespGetEmpleado;
import co.edu.javeriana.discovery.pica.employee.service.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
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

    private static final String XRQUID = "X-RqUID";
    private static final String CODIGO = "Codigo";
    private static final String REQUEST = "Request";
    private static final String RESPONSE = "Response";
    private static final String RESPONSECODE = "ResponseCode";
    private static final String RQUID = "RqUID";

    private IEmployeeService employeeService;

    @Autowired
    private Tracer tracer;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/Empleado")
        public ResponseEntity<Void> postEmpleado(@RequestBody ReqPostEmpleado reqPostEmpleado, @RequestHeader(value=XRQUID) String xRqUID ) throws JsonProcessingException {
        log.info("Creating Employee for RqUID {}", xRqUID);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reqPostEmpleado);
        EmployeeController.this.tracer.currentSpan().tag(REQUEST,json);
        EmployeeController.this.tracer.currentSpan().tag(RQUID,xRqUID);
        employeeService.postEmpleado(reqPostEmpleado, xRqUID);
        EmployeeController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.CREATED.toString());
        return new ResponseEntity<>(putRqUIDHeader(xRqUID),HttpStatus.CREATED);
    }

    @GetMapping("/Empleados")
    public ResponseEntity< ArrayList<RespGetEmpleado>> getEmpleados(@RequestHeader(value=XRQUID) String xRqUID ) throws JsonProcessingException {
        log.info("Get Employees for RqUID {}", xRqUID);
        EmployeeController.this.tracer.currentSpan().tag(RQUID,xRqUID);
        ArrayList<RespGetEmpleado> response = employeeService.getEmpleados(xRqUID);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(response);
        EmployeeController.this.tracer.currentSpan().tag(RESPONSE,json);
        EmployeeController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.OK.toString());
        return new ResponseEntity<>(response, putRqUIDHeader(xRqUID), HttpStatus.OK);
    }

    @GetMapping("/Empleado/{Codigo}")
    public ResponseEntity<RespGetEmpleado> getEmpleado(@RequestHeader(value=XRQUID) String xRqUID, @PathVariable(CODIGO) String codigo) throws JsonProcessingException {
        log.info("Get Employee for RqUID {}", xRqUID);
        EmployeeController.this.tracer.currentSpan().tag(RQUID,xRqUID);
        RespGetEmpleado response = employeeService.getEmpleado(codigo, xRqUID);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(response);
        EmployeeController.this.tracer.currentSpan().tag(RESPONSE,json);
        EmployeeController.this.tracer.currentSpan().tag(RESPONSECODE,HttpStatus.OK.toString());
        return new ResponseEntity<>(response,putRqUIDHeader(xRqUID),HttpStatus.OK);
    }

    private HttpHeaders putRqUIDHeader(String rquid) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(RQUID,rquid);
        return headers;
    }
}
