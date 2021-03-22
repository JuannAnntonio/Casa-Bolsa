package com.phi.proyect.enums;

public enum InstrumentoEnum {
	
	FWD__SWAP_STARTING(1,"Fwd Swap Starting"),
	SWAP_TIIE(2,"Swap TIIE"),
	SWAP_TIIE_SIDE(9,"Swap TIIE SIDE"),
	OPCION_CAP(11,"Opcion Cap"),
	OPCION_FLOOR(12,"Opcion Floor"),
	FORWARD(13,"Forward"),
	BONOS_M(20,"Bonos M"),
	BONDES_D(21,"Bondes D"),
	BPAG(22,"BPAG"),
	BONOS_CORPORATIVOS(30,"Bonos Corporativos");
	
	private Integer id;
	private String nombre;

	private InstrumentoEnum(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

}
