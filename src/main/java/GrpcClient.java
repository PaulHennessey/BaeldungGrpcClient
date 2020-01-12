import com.paul.grpc.HelloRequest;
import com.paul.grpc.HelloResponse;
import com.paul.grpc.HelloServiceGrpc;
import com.paul.grpc.HelloServiceGrpc.HelloServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient 
{
	public static void main(String[] args) 
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		// stubs = generate from proto files.
		
		HelloServiceBlockingStub helloStub = HelloServiceGrpc.newBlockingStub(channel);
		
		HelloRequest helloRequest = HelloRequest.newBuilder().setFirstName("Paul").setLastName("Hennessey").build();
		
		HelloResponse response = helloStub.hello(helloRequest);
		
		System.out.println(response.getGreeting());
		
	}

}
