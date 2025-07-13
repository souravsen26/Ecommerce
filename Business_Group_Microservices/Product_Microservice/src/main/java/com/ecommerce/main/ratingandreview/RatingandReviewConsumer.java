package com.ecommerce.main.ratingandreview;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.main.dto.GlobalResponseEntity;
//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.DiscoveryClient;

@Component
public class RatingandReviewConsumer {

	@Autowired
	private DiscoveryClient client ;
	
	public ResponseEntity<GlobalResponseEntity> getRatingandReviewUrl(String productName) {
		
		List<ServiceInstance> InstanceInfoList= client.getInstances("RATINGANDREVIEWSERVICE") ;
		
		ServiceInstance InstanceInfo = InstanceInfoList.get(0) ;
		
		URI url =InstanceInfo.getUri();
		
		RestTemplate template = new RestTemplate() ;
		
		HttpHeaders headers = new HttpHeaders() ;
		
		HttpEntity request = new HttpEntity(headers) ;
		
		ResponseEntity<GlobalResponseEntity> responseEntity = template.exchange(url+"/ratingandreviewservice/getReviews/"+productName,HttpMethod.GET,request,GlobalResponseEntity.class) ;
		
		return responseEntity ;
		
         
		
	}
	
	
	
}
