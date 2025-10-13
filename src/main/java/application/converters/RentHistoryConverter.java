package application.converters;

import application.dtos.RentHistoryDTO;
import application.entities.RentHistory;

public class RentHistoryConverter {

  public static RentHistoryDTO toDto(RentHistory entity, String viewType){
    RentHistoryDTO rentHistoryDTO = new RentHistoryDTO();
    if(viewType.equals("CLIENT")){
      rentHistoryDTO.setMovie(MovieConverter.toDto(entity.getMovie()));
    }else if(viewType.equals("MOVIE")){
      rentHistoryDTO.setClient(ClientConverter.toDto(entity.getClient()));
    }
    rentHistoryDTO.setRentTime(entity.getRented_time());
    return rentHistoryDTO;
  }

}
