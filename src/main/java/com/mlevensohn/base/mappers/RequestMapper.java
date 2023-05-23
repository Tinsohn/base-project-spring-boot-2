package com.mlevensohn.base.mappers;

import com.mlevensohn.base.entities.User;
import com.mlevensohn.base.controllers.payload.req.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    User registerRequestToUser(RegisterRequest request);

}
