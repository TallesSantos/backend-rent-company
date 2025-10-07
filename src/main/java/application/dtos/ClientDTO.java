package application.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ClientDTO {

  private Integer id;

  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
