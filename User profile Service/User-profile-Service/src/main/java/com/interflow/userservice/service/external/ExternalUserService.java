package com.interflow.userservice.service.external;

import com.interflow.QuestionServiceContractGrpc;
import com.interflow.userservice.entity.User;
import com.interflow.userservice.exception.custom.ResourceNotFoundException;
import com.interflow.userservice.repository.UserRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import user.UserRequestOuterClass;
import user.UserResponseOuterClass;

import java.util.UUID;


@GrpcService
@RequiredArgsConstructor
public class ExternalUserService extends QuestionServiceContractGrpc.QuestionServiceContractImplBase {

    private final UserRepository userRepository;

    @Override
    public void getUser(UserRequestOuterClass.UserRequest request, StreamObserver<UserResponseOuterClass.UserResponse> responseObserver) {

      try {
          User user = userRepository.findById(UUID.fromString(request.getId()))
                  .orElseThrow(() -> new ResourceNotFoundException("The user not found by the id: " + request.getId()));

          UserResponseOuterClass.UserResponse response = UserResponseOuterClass.UserResponse.newBuilder()
                  .setId(user.getId().toString())
                  .setName(user.getUserName())
                  .build();

          responseObserver.onNext(response);
          responseObserver.onCompleted();
      }
      catch (ResourceNotFoundException e){
            responseObserver.onError(
                    Status.NOT_FOUND.
                            withDescription("No user found with this id")
                            .asException()
            );
      } catch (Exception e) {
          responseObserver.onError(
                  Status.INTERNAL
                          .withDescription(e.getMessage())
                          .asRuntimeException()
          );
      }

    }
}
