package com.hcl.travel.mapper;

import com.hcl.travel.model.UserDetails;
import com.hcl.travel.request.UserDetailsRequest;
import com.hcl.travel.response.UserDetailsResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-07T14:57:47-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Amazon.com Inc.)"
)
@Component
public class UserDetailsMapperImpl implements UserDetailsMapper {

    @Override
    public UserDetails getUserDetails(UserDetailsRequest userDetailsRequest) {
        if ( userDetailsRequest == null ) {
            return null;
        }

        UserDetails userDetails = new UserDetails();

        userDetails.setFirstName( userDetailsRequest.getFirstName() );
        userDetails.setLastName( userDetailsRequest.getLastName() );

        userDetails.setGuid( getGUID() );

        return userDetails;
    }

    @Override
    public UserDetailsResponse getUserDetailsResponse(UserDetails userDetails) {
        if ( userDetails == null ) {
            return null;
        }

        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();

        userDetailsResponse.setFirstName( userDetails.getFirstName() );
        userDetailsResponse.setLastName( userDetails.getLastName() );
        userDetailsResponse.setGuid( userDetails.getGuid() );

        return userDetailsResponse;
    }
}
