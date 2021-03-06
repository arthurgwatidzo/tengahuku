package zw.co.tengahuku.service.mapper;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import zw.co.tengahuku.commons.GenericTransformer;
import zw.co.tengahuku.model.Order;
import zw.co.tengahuku.model.Supplier;
import zw.co.tengahuku.payload.inbound.OrderInboundPayload;
import zw.co.tengahuku.payload.inbound.SupplierInboundPayload;

@Component
public class PayloadMapper {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(PayloadMapper.class);

	 
	 public Supplier map(SupplierInboundPayload supplierInboundPayload){
		 
		 LOGGER.debug("Payload Mapper - Transforming SupplierInboundPayload to Supplier Entity");
		 if (supplierInboundPayload == null) {
	            return null;
	        }
		 
		 Supplier supplier = (Supplier) GenericTransformer.transform(supplierInboundPayload, Supplier.class);
		 supplier.setAlternativeContactPerson(supplierInboundPayload.getAlternativeContactPerson());
		 supplier.setCellNumber(supplierInboundPayload.getCellNumber());
		 supplier.setCity(supplierInboundPayload.getCity());
		 supplier.setContactPerson(supplierInboundPayload.getContactPerson());
		 supplier.setEmailAddress(supplierInboundPayload.getEmailAddress());
		 //supplier.setId(supplier.getId());
		 supplier.setName(supplierInboundPayload.getName());
		 supplier.setPhysicalAddress(supplierInboundPayload.getPhysicalAddress());
		 supplier.setTelephoneNumberOne(supplierInboundPayload.getTelephoneNumberOne());
		 supplier.setTelephoneNumberTwo(supplierInboundPayload.getTelephoneNumberTwo());
		 supplier.setTown(supplierInboundPayload.getTown());
		 
		return supplier;
		 
	 }
	 
	 public Order map(OrderInboundPayload orderInboundPayload ){
		 
		 
		 LOGGER.debug("Payload Mapper - Transforming OrderInboundPayload to Order Entity");
		 if (Objects.isNull(orderInboundPayload)) {
	            return null;
	        }
		 
		 Order order = (Order) GenericTransformer.transform(orderInboundPayload, Order.class);
		 order.setDeliveredDate(orderInboundPayload.getDeliveredDate());
		 order.setDelivererId(orderInboundPayload.getDelivererId());
		 order.setUpdatedByUser(orderInboundPayload.getUpdatedByUser());
		 order.setDeliveryRequired(orderInboundPayload.getDeliveryRequired());
		 order.setOrderDate(orderInboundPayload.getOrderDate());
		 order.setDeliveryAddress(orderInboundPayload.getDeliveryAddress());
		 order.setRequiredDate(orderInboundPayload.getRequiredDate());
		 order.setStatus(orderInboundPayload.getStatus());
		 order.setUpdatedByUser(orderInboundPayload.getUpdatedByUser());
		 
		 
		 
		 return order;
	 }
	 
}
