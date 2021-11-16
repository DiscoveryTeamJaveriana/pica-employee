package co.edu.javeriana.discovery.pica.employee.service.impl;

import co.edu.javeriana.discovery.pica.employee.controller.model.ReqPostEmpleado;
import co.edu.javeriana.discovery.pica.employee.controller.model.RespGetEmpleado;
import co.edu.javeriana.discovery.pica.employee.mapper.EmployeeMapper;
import co.edu.javeriana.discovery.pica.employee.repository.EmployeeRepository;
import co.edu.javeriana.discovery.pica.employee.repository.model.Employee;
import co.edu.javeriana.discovery.pica.employee.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void postEmpleado(ReqPostEmpleado request, String rquid) {

        Employee employee = EmployeeMapper.mapReqPostEmpleadoToEmployee(request);
        employeeRepository.save(employee);

    }

    @Override
    public List<RespGetEmpleado> getEmpleados(String rquid) {

        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::mapEmployeeToRespGetEmpleado)
                .collect(Collectors.toList());
    }

    @Override
    public RespGetEmpleado getEmpleado(String codigo, String rquid) {

        return EmployeeMapper.mapEmployeeToRespGetEmpleado(employeeRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("No Employee")));
        //TODO: Add ControllerAdvice for exception control
    }
}
