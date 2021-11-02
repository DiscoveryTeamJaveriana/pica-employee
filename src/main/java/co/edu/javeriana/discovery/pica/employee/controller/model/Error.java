package co.edu.javeriana.discovery.pica.employee.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class Error   {
  @JsonProperty("Codigo")
  private String codigo = null;

  @JsonProperty("Mensaje")
  private String mensaje = null;
}

