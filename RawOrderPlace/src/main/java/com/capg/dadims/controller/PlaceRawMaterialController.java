package com.capg.dadims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dadims.entity.RawMaterialOrderDetails;
import com.capg.dadims.service.RawMaterialService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value="/rawmaterial")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaceRawMaterialController {

	@Autowired
	RawMaterialService materialService;
	
	
	/**
	 * @author bhavana : This addRawMaterials method will add the raw material order
	 *         details into the entity of rawmaterialorderdetails bean
	 **/

	@PostMapping(value="/placeorder")
	@HystrixCommand(fallbackMethod = "whenpostnotwork") // HystrixCommand
	public ResponseEntity<RawMaterialOrderDetails> addRawMaterialOrder(@RequestBody RawMaterialOrderDetails materialOrderDetails){
	

		RawMaterialOrderDetails rawMaterialOrderDetails = materialService.addRawMaterialOrder(materialOrderDetails);
		return new ResponseEntity<RawMaterialOrderDetails>(rawMaterialOrderDetails,new HttpHeaders(),HttpStatus.OK);
		/**
		 * Here service layer will return bean if data is added successfully
		 */
	}

public ResponseEntity<RawMaterialOrderDetails> whenpostnotwork(RawMaterialOrderDetails materialOrderDetails){
	return new ResponseEntity<>(null,new HttpHeaders(),HttpStatus.BAD_REQUEST);
}
}
