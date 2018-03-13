package zw.co.tengahuku.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zw.co.tengahuku.payload.inbound.SupplierInboundPayload;
import zw.co.tengahuku.service.impl.SupplierService;
import zw.co.tengahuku.service.mapper.PayloadMapper;

@RestController
@RequestMapping(value = "/tengahuku/api")
public class SupplierAPIController {
	
	 private static final Logger log = LoggerFactory.getLogger(SupplierAPIController.class);
	 
	 @Autowired
	 SupplierService supplierService;
	 
	 @Autowired
	 PayloadMapper payloadMapper;
	 
	 @RequestMapping(value="/user.json/createSupplier",method=RequestMethod.POST, produces = "application/json")
	 public ResponseEntity<?> createSupplier(@RequestBody SupplierInboundPayload supplierInboundPayload){
		 
		 try{
		 
		supplierService.saveSupplier(payloadMapper.map(supplierInboundPayload));
		 }catch(Exception ex){
			 log.error("Failed to create Supplier" + ex.getMessage());
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 return new ResponseEntity<>(HttpStatus.OK);
		 
	 }

}
