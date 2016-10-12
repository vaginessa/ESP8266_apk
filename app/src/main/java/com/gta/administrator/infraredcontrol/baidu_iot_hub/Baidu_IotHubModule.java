package com.gta.administrator.infraredcontrol.baidu_iot_hub;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanwen on 16/10/12.
 */
public class Baidu_IotHubModule {
    // Access Key ID
    private static final String AK = "039557ee1e2b4c43956ee277288ef046";
    // Secret Key ID
    private static final String SK = "10667bdc236b4c9eb86bebb8a87e0cc6";
	// Host Body
	private static final String HostBody = "iot.gz.baidubce.com";
	// Host
	private static final String Host = "http://iot.gz.baidubce.com";
	// Get endpoint list
	private static final String URI_EndpointList = "/v1/endpoint";


    public List<String> getEndpointList() {
		List<String> endpoints = new ArrayList<>();

/*

		DefaultBceCredentials BceCredentials = new DefaultBceCredentials(AK, SK);

		BceClientConfiguration config= new BceClientConfiguration();
		config.setCredentials(BceCredentials);

		URI uri = URI.create(Host + URI_EndpointList) ;
		InternalRequest request = new InternalRequest(HttpMethodName.GET,uri);

		request.addHeader("Content-Type", "application/json; charset=utf-8");
		request.addHeader("Host", HostBody);
		BceHttpClient client = new BceHttpClient(config, new BceV1Signer());

		HttpResponseHandler hanlder1 = new BceJsonResponseHandler();
		HttpResponseHandler hanler2 = new BceErrorResponseHandler();
		client.execute(request, AbstractBceResponse.class, new HttpResponseHandler[]{hanlder1, hanler2});
*/

		return endpoints;

    }




}
