package br.com.grupodois.desafioilab.model.enums;

public enum TrackingStatusEnum {

	DELIVERED(1),
	CANCELED(2);
	
	private int code;

	private TrackingStatusEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TrackingStatusEnum valueOf(int code) {
		for(TrackingStatusEnum value : TrackingStatusEnum.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Código de status de rastreio inválido.");
	}
}
