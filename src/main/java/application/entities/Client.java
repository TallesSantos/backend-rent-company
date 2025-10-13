package application.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private final List<Movie> movies = new ArrayList<>();

  @OneToMany(mappedBy = "client")
  private List<RentHistory> rentHistory;

  // Getters e setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public List<Movie> getMovies() {
    return movies;
  }

  public List<RentHistory> getRentHistory() {
    return rentHistory;
  }

  public void setRentHistory(List<RentHistory> rentHistory) {
    this.rentHistory = rentHistory;
  }
}
