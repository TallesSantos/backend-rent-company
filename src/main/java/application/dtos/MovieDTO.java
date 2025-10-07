package application.dtos;

import application.entities.Client;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class MovieDTO {

  private Long id;

  private String name;

  private String description;

  private Boolean isRented;

  private Date rentedTime;

  private Client client;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getRented() {
    return isRented;
  }

  public void setRented(Boolean rented) {
    isRented = rented;
  }

  public Date getRentedTime() {
    return rentedTime;
  }

  public void setRentedTime(Date rentedTime) {
    this.rentedTime = rentedTime;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
