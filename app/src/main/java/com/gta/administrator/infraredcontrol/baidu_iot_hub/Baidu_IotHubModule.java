package com.gta.administrator.infraredcontrol.baidu_iot_hub;
//
//import com.baidubce.BceClientConfiguration;
//import com.baidubce.auth.BceV1Signer;
//import com.baidubce.auth.DefaultBceCredentials;
//import com.baidubce.http.BceHttpClient;
//import com.baidubce.http.HttpMethodName;
//import com.baidubce.http.handler.BceErrorResponseHandler;
//import com.baidubce.http.handler.BceJsonResponseHandler;
//import com.baidubce.http.handler.HttpResponseHandler;
//import com.baidubce.internal.InternalRequest;
//import com.baidubce.model.AbstractBceResponse;
//
//import org.eclipse.paho.client.mqttv3.MqttClient;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//
//import java.net.URI;
//import java.security.KeyStore;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.BceV1Signer;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.http.BceHttpClient;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceJsonResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.model.AbstractBceResponse;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 * Created by yanwen on 16/10/12.
 */
public class Baidu_IotHubModule {
    // Access Key ID
    private static final String AK = "af656357a5844e67b008b4b889ef207f";//"039557ee1e2b4c43956ee277288ef046";
    // Secret Key ID
    private static final String SK = "ec7958abb69541b9957b594a1dda82eb";//"10667bdc236b4c9eb86bebb8a87e0cc6";
	// Host Body
	private static final String HostBody = "iot.gz.baidubce.com";
	// Host
	private static final String Host = "http://iot.gz.baidubce.com";
	// Get endpoint list
	private static final String URI_EndpointList = "/v1/endpoint";


    public List<String> getEndpointList() {
		List<String> endpoints = new ArrayList<>();



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

		return endpoints;

    }

	public static void request()  {
		String endpoint = "ssl://endpoint_one.mqtt.iot.gz.baidubce.com:1884";    //输入创建endpoint返回的地址
		String username = "endpoint_one/thing01"; //输入创建thing返回的username
		String password = "S1JKbYM1g4uyKGIPWp+XZcyp0NEe74Lb8ekX62I6NtU="; //输入创建principal返回的password
		String topic = "test-iot-service"; //订阅的消息主题，本例是指订阅b号楼第五层的温度

        TrustManagerFactory tmf = null;
        try {
            tmf = TrustManagerFactory.getInstance("X509");
            try {
                tmf.init((KeyStore)null);
            } catch (KeyStoreException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

		TrustManager[] trustManagers = tmf.getTrustManagers();

        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            ctx.init(null, trustManagers, null);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(true);
		options.setUserName(username);
		options.setPassword(password.toCharArray());
		options.setSocketFactory(ctx.getSocketFactory());

        MqttClient client = null;
        try {
            client = new MqttClient(endpoint, "java-client");
        } catch (MqttException e) {
            e.printStackTrace();
            return;
        }
        try {
            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
        }

        MqttMessage message = new MqttMessage();
		message.setPayload("15".getBytes());
        try {
            client.publish(topic, message);
        } catch (MqttException e) {
            e.printStackTrace();
        }

        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
