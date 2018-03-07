package zw.co.tengahuku.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zw.co.tengahuku.commons.GenericTransformer;
import zw.co.tengahuku.dto.CustomerDTO;
import zw.co.tengahuku.dto.PaymentDTO;
import zw.co.tengahuku.dto.UserDTO;
import zw.co.tengahuku.model.Customer;
import zw.co.tengahuku.model.Payment;
import zw.co.tengahuku.model.User;

public class BusinessMapper {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(BusinessMapper.class);
	 
	 public static User map(UserDTO userDTO){
		 
		 LOGGER.debug("Business Mapper - Transforming UserDTO to User Entity");
		 if (userDTO == null) {
	            return null;
	        }
		 
		 User user = (User) GenericTransformer.transform(userDTO, User.class);
		
		 user.setAccountLocked(userDTO.getAccountLocked());
		 user.setEmailUserName(userDTO.getEmailUserName());
		 user.setId(userDTO.getId());
		 user.setPassword(userDTO.getPassword());
		 user.setUserRole(userDTO.getUserRole());
		
		return user;
		 
	 }
	 
	 
	 public static UserDTO map(User user){
		 
		 LOGGER.debug("Business Mapper - Transforming User Entity to UserDTO");
		 if(user==null){
			return null; 
		 }
		 
		 UserDTO userDTO = (UserDTO) GenericTransformer.transform(user, UserDTO.class);
		 userDTO.setId(userDTO.getId());
		 userDTO.setAccountLocked(user.getAccountLocked());
		 userDTO.setEmailUserName(userDTO.getEmailUserName());
		 userDTO.setUserRole(user.getUserRole());
		 userDTO.setPassword(user.getPassword());
		 
		 return userDTO;
	 }
	 
	 
	 public static Customer map(CustomerDTO customerDTO){
		 
		 LOGGER.debug("Business Mapper - Transforming CustomerDTO to Customer Entity");
		 if (customerDTO == null) {
	            return null;
	        }
		 
		 Customer customer = (Customer) GenericTransformer.transform(customerDTO, Customer.class);
		 customer.setId(customerDTO.getId());
		 customer.setCity(customerDTO.getCity());
		 customer.setCompanyName(customerDTO.getCompanyName());
		 customer.setContactName(customerDTO.getContactName());
		 customer.setContactTitle(customerDTO.getContactTitle());
		 customer.setDeliveryAddress(customerDTO.getDeliveryAddress());
		 customer.setEmailAddress(customerDTO.getEmailAddress());
		 customer.setEnabled(customerDTO.getEnabled());
		 customer.setTelephoneNumber(customerDTO.getTelephoneNumber());
		
		 
		 return customer;
		 
	 }
	 
	 public static CustomerDTO map(Customer customer){
		 LOGGER.debug("Business Mapper - Transforming  Customer Entity to CustomerDTO");
		 if(customer==null){
			return null; 
		 }
		 
		 CustomerDTO customerDTO = (CustomerDTO) GenericTransformer.transform(customer, CustomerDTO.class);
		 customerDTO.setCity(customer.getCity());
		 customerDTO.setCompanyName(customer.getCompanyName());
		 customerDTO.setContactName(customer.getContactName());
		 customerDTO.setContactTitle(customer.getContactTitle());
		 customerDTO.setDeliveryAddress(customer.getDeliveryAddress());
		 customerDTO.setEmailAddress(customer.getEmailAddress());
		 customerDTO.setPayments(mapPayments(customer.getPayments()));
		 
		 return customerDTO;
	 }
	 
	 public static  List<Payment> mapPaymentDTOs(List<PaymentDTO> paymentDTOs){
		 
		 LOGGER.debug("Business Mapper - Transforming  Payment Entity List to PaymentDTO List");
		 List<Payment> payments = new ArrayList<>();
		 
		 paymentDTOs.forEach(paymentDTO->{
			 payments.add(map(paymentDTO));
		 });
		 
		 return payments;
		 
	 }
	 
	 public static List<PaymentDTO> mapPayments(List<Payment> payments){
		 LOGGER.debug("Business Mapper - Transforming PaymentDTO Entity List to Payment List");
		 List<PaymentDTO> paymentDTOs = new ArrayList<>();
		 payments.forEach(payment->{
			 paymentDTOs.add(map(payment));
		 });
		 
		 return paymentDTOs;
	 }
	 
	 public static PaymentDTO map(Payment payment){
		 LOGGER.debug("Business Mapper - Transforming  Payment Entity to PaymentDTO");
		 if(payment==null){
			return null; 
		 }
		 
		 CustomerDTO customerDTO = map(payment.getCustomer());
		 PaymentDTO paymentDTO = (PaymentDTO) GenericTransformer.transform(payment, PaymentDTO.class);
		 paymentDTO.setCustomerDTO(customerDTO);
		 paymentDTO.setId(payment.getId());
		 paymentDTO.setPaymentAmount(payment.getPaymentAmount());
		 paymentDTO.setPaymentDate(payment.getPaymentDate());
		 paymentDTO.setPaymentDescription(payment.getPaymentDescription());
		 paymentDTO.setPaymentType(payment.getPaymentType());
		 
		 
		 return paymentDTO;
	 }
	 
	 public static Payment map(PaymentDTO paymentDTO){
		 LOGGER.debug("Business Mapper - Transforming PaymentDTO to Payment Entity");
		 if (paymentDTO == null) {
	            return null;
	        }
		 
		 Customer customer = map(paymentDTO.getCustomerDTO());
		 Payment payment = (Payment) GenericTransformer.transform(paymentDTO, Payment.class);
		 payment.setId(paymentDTO.getId());
		 payment.setPaymentAmount(paymentDTO.getPaymentAmount());
		 payment.setPaymentDate(paymentDTO.getPaymentDate());
		 payment.setPaymentDescription(paymentDTO.getPaymentDescription());
		 payment.setCustomer(customer);
		 
		 return payment;
		 
	 }
	 

}
