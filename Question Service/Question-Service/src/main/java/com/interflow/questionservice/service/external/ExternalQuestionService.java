package com.interflow.questionservice.service.external;

import com.interflow.SmallQuestionOuterClass;
import com.interflow.questionservice.repository.QuestionsRepository;
import com.interflow.questionservice.dto.response.SmallQuestion;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import question.UserServiceContractGrpc;
import question.UserServiceContractOuterClass;

import java.util.List;
import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
public class ExternalQuestionService extends UserServiceContractGrpc.UserServiceContractImplBase {

    private final QuestionsRepository questionsRepository;

    @Override
    public void getSmallQuestions(
            UserServiceContractOuterClass.SmallQuestionRequest request,
            StreamObserver<UserServiceContractOuterClass.SmallQuestionsList> responseObserver) {
        try {
            UUID userId = UUID.fromString(request.getId());

            // Fetch from DB
            List<SmallQuestion> dbQuestions = questionsRepository.getQuestionsWIthUserId(userId);

            // Convert to proto objects
            UserServiceContractOuterClass.SmallQuestionsList.Builder responseBuilder =
                    UserServiceContractOuterClass.SmallQuestionsList.newBuilder();

            for (SmallQuestion q : dbQuestions) {
                // Convert createdAt string -> protobuf Timestamp
                 SmallQuestionOuterClass.SmallQuestion protoResponse =  SmallQuestionOuterClass.SmallQuestion
                        .newBuilder()
                        .setId(q.getId().toString())
                        .setTitle(q.getTitle())
                        .setQuestion(q.getQuestion())
                        .setUpVote(q.getUpVotes())
                        .setDownVote(q.getDownVotes())
                        .setCreatedAt(q.getCreatedAt())
                        .setViewedBy(q.getViewedBy())
                        .addAllTags(q.getTags())
                        .build();

//                 add to the response
                responseBuilder.addSmallQuestions(protoResponse);
            }

            // Send response
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException()
            );
        }
    }
}
