package application.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = true)
  private String description;

  @Column(name = "is_rented")
  private Boolean isRented;

  @Column(name = "rented_time")
  private Date rentedTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private Client client;

  @Column(name = "image_url")
  private String imageUrl;

  @OneToMany(mappedBy = "movie")
  private List<RentHistory> rentHistory;

  @ManyToMany
  @JoinTable(
      name = "movie_like",
      joinColumns = @JoinColumn(name = "movie_id"), // FK da entidade atual
      inverseJoinColumns = @JoinColumn(name = "client_id") // FK da outra entidade
  )
  private List<Client> nameOfLikers;

  @OneToMany(mappedBy = "movie")
  private List<Comment> comments;

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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public List<RentHistory> getRentHistory() {
    return rentHistory;
  }

  public void setRentHistory(List<RentHistory> rentHistory) {
    this.rentHistory = rentHistory;
  }

  public List<Client> getNameOfLikers() {
    return nameOfLikers;
  }

  public void setNameOfLikers(List<Client> nameOfLikers) {
    this.nameOfLikers = nameOfLikers;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }
}
