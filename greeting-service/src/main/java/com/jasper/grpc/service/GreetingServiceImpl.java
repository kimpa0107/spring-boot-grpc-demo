package com.jasper.grpc.service;

import com.jasper.grpc.GreetingRequest;
import com.jasper.grpc.GreetingResponse;
import com.jasper.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

	@Override
	public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
		String message = request.getMessage();
		System.out.println("Received message: " + message);

		GreetingResponse build = GreetingResponse.newBuilder()
			.setMessage("Received your " + message + ". Hello from server.")
			.build();
		responseObserver.onNext(build);
		responseObserver.onCompleted();
	}

}
