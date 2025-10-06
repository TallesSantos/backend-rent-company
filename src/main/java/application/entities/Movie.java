package application.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = true)
  private String description;

  @Column(name ="is_rented")
  private Boolean isRented;

  @Column(name = "rented_time")
  private Date rentedTime;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "client_id")
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
