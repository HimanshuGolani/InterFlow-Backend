package com.interflow.userservice.util.mapping;
import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.response.User;
import com.interflow.userservice.util.dto.response.UserLargeDetails;
import com.interflow.userservice.util.dto.response.UserShortDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = {User.class, com.interflow.userservice.entity.User.class, UserLargeDetails.class, UserShortDetails.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userToResponse(com.interflow.userservice.entity.User user);
    com.interflow.userservice.entity.User userToEntity(UserCreationDto user);

    UserShortDetails shortDetailsFromEntity(com.interflow.userservice.entity.User user);

    @Mappings({
            @Mapping(target = "questionIds", ignore = true),
    })    UserLargeDetails largeDetailsFromEntity(com.interflow.userservice.entity.User user);

}
