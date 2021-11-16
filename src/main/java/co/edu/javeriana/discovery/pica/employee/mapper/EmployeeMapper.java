package co.edu.javeriana.discovery.pica.employee.mapper;

import co.edu.javeriana.discovery.pica.employee.controller.model.ReqPostEmpleado;
import co.edu.javeriana.discovery.pica.employee.controller.model.RespGetEmpleado;
import co.edu.javeriana.discovery.pica.employee.repository.model.Employee;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {

    public static RespGetEmpleado mapEmployeeToRespGetEmpleado(final Employee employee) {

        RespGetEmpleado respGetEmpleado = new RespGetEmpleado();
        respGetEmpleado.setCodigo(employee.getId());
        respGetEmpleado.setNombre(employee.getName());
        respGetEmpleado.setIdentificacion(employee.getIdentification());
        respGetEmpleado.setRol(employee.getRole());
        respGetEmpleado.setCorreo(employee.getEmail());
        respGetEmpleado.setTelefono(employee.getPhone());

        return respGetEmpleado;
    }

    public static Employee mapReqPostEmpleadoToEmployee(final ReqPostEmpleado reqPostEmpleado) {

        return Employee.builder()
                .name(reqPostEmpleado.getNombre())
                .identification(reqPostEmpleado.getIdentificacion())
                .role(reqPostEmpleado.getRol())
                .email(reqPostEmpleado.getCorreo())
                .phone(reqPostEmpleado.getTelefono())
                .build();
    }
}
