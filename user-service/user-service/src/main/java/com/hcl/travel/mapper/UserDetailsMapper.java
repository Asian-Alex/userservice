package com.hcl.travel.mapper;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.hcl.travel.model.UserDetails;
import com.hcl.travel.request.UserDetailsRequest;
import com.hcl.travel.response.UserDetailsResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDetailsMapper {
  
  @Mapping(target = "guid", expression = "java(getGUID())")
  UserDetails getUserDetails(UserDetailsRequest userDetailsRequest);
  
  @Mapping(target = "first_name", source = "firstName")
  UserDetailsResponse getUserDetailsResponse(UserDetails userDetails);
  
  default String getGUID() {
    return UUID.randomUUID().toString();
}

}
