package com.abserver.datasharing.domain.enums;

public enum Status {

    OPEN(0, "OPEN"), FINISHED(1, "FINISHED"), CANCELED(2, "CANCELED");

	private Integer cod;
	private String description;

	private Status(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Status x : Status.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status inválido! " + cod);

	}
}
