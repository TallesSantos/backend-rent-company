package application.dtos;

import java.time.LocalDateTime;

public class RentHistoryDTO {

  private MovieDTO movie;

  private ClientDTO client;

  private LocalDateTime rentTime;

  public MovieDTO getMovie() {
    return movie;
  }

  public void setMovie(MovieDTO movie) {
    this.movie = movie;
  }

  public ClientDTO getClient() {
    return client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }

  public LocalDateTime getRentTime() {
    return rentTime;
  }

  public void setRentTime(LocalDateTime rentTime) {
    this.rentTime = rentTime;
  }
}
