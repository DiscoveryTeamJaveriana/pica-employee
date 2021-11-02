package co.edu.javeriana.discovery.pica.employee.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class RespGetEmpleado   {
  @JsonProperty("Codigo")
  private String codigo = null;

  @JsonProperty("Nombre")
  private String nombre = null;

  @JsonProperty("Identificacion")
  private String identificacion = null;

  @JsonProperty("Rol")
  private String rol = null;

  @JsonProperty("Correo")
  private String correo = null;

  @JsonProperty("Telefono")
  private String telefono = null;

}

