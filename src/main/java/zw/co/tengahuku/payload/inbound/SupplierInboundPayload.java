package zw.co.tengahuku.payload.inbound;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;


import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierInboundPayload implements Payload{
	
	private String name;
	 @JsonProperty(value = "address")
	private String physicalAddress;
	private String town;
	private String city;
	private String contactPerson;
	private String alternativeContactPerson;
	private String cellNumber;
	private String telephoneNumberOne;
	private String telephoneNumberTwo;
	private String emailAddress;
	

}
