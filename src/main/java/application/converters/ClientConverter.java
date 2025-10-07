package application.converters;

import application.dtos.ClientDTO;
import application.entities.Client;
import java.util.stream.Collectors;

public class ClientConverter {

  public static ClientDTO toDto(Client entity) {
    ClientDTO dto = new ClientDTO();

    dto.setId(entity.getId().intValue());
    dto.setName(entity.getName());

    return dto;
  }

}
