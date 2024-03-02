package com.example.grpc_demo.server;

import com.example.StudentResponse;
import com.example.StudentServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@GRpcService
public class Server extends StudentServiceGrpc.StudentServiceImplBase {
    Logger logger = LoggerFactory.getLogger(Server.class);
    @Override
    public void getStudent(com.example.StudentRequest request,
                           io.grpc.stub.StreamObserver<com.example.StudentResponse> responseObserver) {

        logger.info("got request = "+ request.getId());
        StudentResponse studentResponse = StudentResponse.newBuilder().setAge(10).setName("devansh").build();
            responseObserver.onNext(studentResponse);
            responseObserver.onCompleted();
        }
}
