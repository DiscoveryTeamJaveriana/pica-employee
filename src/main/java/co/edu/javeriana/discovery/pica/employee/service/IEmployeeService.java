package co.edu.javeriana.discovery.pica.employee.service;

import co.edu.javeriana.discovery.pica.employee.controller.model.ReqPostEmpleado;
import co.edu.javeriana.discovery.pica.employee.controller.model.RespGetEmpleado;

import java.util.ArrayList;

public interface IEmployeeService {
   void  postEmpleado (ReqPostEmpleado request, String rquid);
    ArrayList<RespGetEmpleado> getEmpleados (String rquid);
    RespGetEmpleado getEmpleado (String codigo, String rquid);
}