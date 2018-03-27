package zw.co.tengahuku.payload.inbound;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInboundPayload {
	
	private Long orderId;
	private Long customerId;
	private Long employeeId;
	private Date orderDate;
	private Date requiredDate;
	private Boolean deliveryRequired;
	private Date deliveredDate;
	 @JsonProperty(value = "address")
	private String deliveryAddress;
	 @JsonProperty(value = "town")
	private String deliveryTown;
	private Long delivererId;
	private String status;
	private String updatedByUser;

}
