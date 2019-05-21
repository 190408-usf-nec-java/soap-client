package com.revature.clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.revature.models.generated.GetHeroRequest;
import com.revature.models.generated.GetHeroResponse;

//WebServiceGatewaySupport is a Spring class that gives some basic abstract
// definition of how to send requests to a SOAP server
public class SuperHeroClient extends WebServiceGatewaySupport {
	
	public GetHeroResponse getHero(String name) {
		// Setting up request object to send
		GetHeroRequest request = new GetHeroRequest();
		request.setName(name);
		
		// getWebServiceTemplate is used to send requests and defined on WebServiceGatewaySupport
		GetHeroResponse response = (GetHeroResponse) getWebServiceTemplate()
				//URL to send request to with the request payload
					.marshalSendAndReceive("http://localhost:8080/ws", request,
							// Callback registered to marshal response using WSDL definition
							new SoapActionCallback("http://www.example.org/SuperHero"));
		
		return response;
	}
}
