package br.com.grupodois.desafioilab.dto;

public class RequestTrackingStatusDTO {
	private Long orderId; 
	private Long dpId; 
	private String status;
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getDpId() {
		return dpId;
	}
	public void setDpId(Long dpId) {
		this.dpId = dpId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
}
