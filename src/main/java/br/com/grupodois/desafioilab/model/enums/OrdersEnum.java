package br.com.grupodois.desafioilab.model.enums;

public enum OrdersEnum {

	OPEN("OPEN"),
	IN_PROGRESS("IN PROGRESS"),
	DELIVERED("DELIVERED");
	
	private String status;

	private OrdersEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public static String fromString(String status) {
		for (OrdersEnum o : OrdersEnum.values()) {
			
			if (o.name().equals(status.toUpperCase())){
				return o.getStatus();
			}
			 
		}
		
		throw new IllegalArgumentException("Status inválido para o pedido.");
	}
	
}
