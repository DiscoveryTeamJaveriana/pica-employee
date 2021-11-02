package co.edu.javeriana.discovery.pica.employee.service.impl;

import co.edu.javeriana.discovery.pica.employee.controller.model.ReqPostEmpleado;
import co.edu.javeriana.discovery.pica.employee.controller.model.RespGetEmpleado;
import co.edu.javeriana.discovery.pica.employee.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class EmployeeService implements IEmployeeService {
    @Override
    public void postEmpleado(ReqPostEmpleado request, String rquid) {
        log.info("Panic implement me !");

    }

    @Override
    public ArrayList<RespGetEmpleado> getEmpleados(String rquid) {
        log.info("Panic implement me !");
        ArrayList<RespGetEmpleado> respGetEmpleados = new ArrayList<RespGetEmpleado>();
        RespGetEmpleado respGetEmpleado = new RespGetEmpleado();
        respGetEmpleado.setCodigo("1234");
        respGetEmpleado.setNombre("Mauro");
        respGetEmpleado.setIdentificacion("123456789");
        respGetEmpleado.setRol("Jardinero");
        respGetEmpleado.setCorreo("mauro@gmail.com");
        respGetEmpleado.setTelefono("310310310");
        RespGetEmpleado respGetEmpleado2 = new RespGetEmpleado();
        respGetEmpleado2.setCodigo("1234");
        respGetEmpleado2.setNombre("Mauro");
        respGetEmpleado2.setIdentificacion("123456789");
        respGetEmpleado2.setRol("Jardinero");
        respGetEmpleado2.setCorreo("mauro@gmail.com");
        respGetEmpleado2.setTelefono("310310310");
        respGetEmpleados.add(respGetEmpleado);
        respGetEmpleados.add(respGetEmpleado2);
        return respGetEmpleados;
    }

    @Override
    public RespGetEmpleado getEmpleado(String codigo, String rquid) {
        log.info("Panic implement me !");
        RespGetEmpleado respGetEmpleado = new RespGetEmpleado();
        respGetEmpleado.setCodigo("1234");
        respGetEmpleado.setNombre("Mauro");
        respGetEmpleado.setIdentificacion("123456789");
        respGetEmpleado.setRol("Jardinero");
        respGetEmpleado.setCorreo("mauro@gmail.com");
        respGetEmpleado.setTelefono("310310310");
        return respGetEmpleado;
    }
}
