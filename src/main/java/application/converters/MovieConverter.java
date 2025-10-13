package application.converters;

import application.dtos.MovieDTO;
import application.entities.Client;
import application.entities.Movie;
import java.util.stream.Collectors;

public class MovieConverter {

  public static MovieDTO toDto(Movie entity) {
    MovieDTO dto = new MovieDTO();

    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setDescription(entity.getDescription());
    dto.setRented(entity.getRented());
    dto.setRentedTime(entity.getRentedTime());
    dto.setClient(entity.getClient());
    dto.setImageUrl(entity.getImageUrl());

    dto.setNameOfLikers(entity.getNameOfLikers().stream().map(Client::getName).collect(
        Collectors.toList()));

    dto.setComments(CommentConverter.toDto(entity));

    return dto;
  }

}
