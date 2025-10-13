package application.converters;

import application.dtos.ClientDTO;
import application.dtos.UserDTO;
import application.dtos.user.AddressDTO;
import application.dtos.user.PermissionDTO;
import application.dtos.user.PhoneDTO;
import application.entities.Address;
import application.entities.Permission;
import application.entities.Phone;
import application.entities.User;
import java.util.ArrayList;
import java.util.List;

public class UserConverter {


  public static UserDTO toDto(User entity) {

    UserDTO userDTO = new UserDTO();
    userDTO.setId(entity.getId());
    userDTO.setName(entity.getName());
    userDTO.setEmail(entity.getEmail());
    userDTO.setUserType(entity.getUserType().toString());

    List<AddressDTO> addresses = new ArrayList<>();
    for (Address address : entity.getAddresses()) {
      AddressDTO addressDTO = new AddressDTO();
      addressDTO.setId(addressDTO.getId());
      addressDTO.setCountry(address.getCountry());
      addressDTO.setState(address.getState());
      addressDTO.setCity(address.getCity());
      addressDTO.setStreetAddress(address.getStreetAddress());
      addressDTO.setNumber(address.getNumber());
      addressDTO.setComment(address.getComment());
      addresses.add(addressDTO);
    }
    userDTO.setAddresses(addresses);

    List<PhoneDTO> phones = new ArrayList<>();
    for (Phone phone : entity.getPhone()) {
      PhoneDTO phoneDTO = new PhoneDTO();
      phoneDTO.setId(phone.getId());
      phoneDTO.setPhoneNumber(phone.getPhoneNumber());
      phones.add(phoneDTO);
    }
    userDTO.setPhone(phones);

    List<PermissionDTO> permissions = new ArrayList<>();
    for (Permission permission : entity.getPermissionRoles()) {
      PermissionDTO permissionDTO = new PermissionDTO();
      permissionDTO.setId(permission.getId());
      permissionDTO.setName(permission.getName());
      permissionDTO.setDescription(permission.getDescription());
      permissions.add(permissionDTO);
    }
    userDTO.setPermissionRoles(permissions);

    ClientDTO clientDTO = new ClientDTO();
    if(entity.getClient()!= null){
      clientDTO.setId(entity.getClient().getId().intValue());
      clientDTO.setName(entity.getClient().getName());

    }
    userDTO.setClient(clientDTO);

    return userDTO;
  }

}
