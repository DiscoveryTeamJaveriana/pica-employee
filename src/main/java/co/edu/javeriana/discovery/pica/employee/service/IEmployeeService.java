package co.edu.javeriana.discovery.pica.employee.service;

import co.edu.javeriana.discovery.pica.employee.controller.model.ReqPostEmpleado;
import co.edu.javeriana.discovery.pica.employee.controller.model.RespGetEmpleado;

import java.util.List;

public interface IEmployeeService {
    void postEmpleado (ReqPostEmpleado request, String rquid);
    List<RespGetEmpleado> getEmpleados (String rquid);
    RespGetEmpleado getEmpleado (String codigo, String rquid);
}
