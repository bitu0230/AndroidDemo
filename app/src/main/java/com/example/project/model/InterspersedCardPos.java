package com.example.project.model;

import com.google.gson.annotations.SerializedName;

public class InterspersedCardPos{

	@SerializedName("Lokasi toko")
	private int lokasiToko;

	@SerializedName("RAM")
	private int rAM;

	public int getLokasiToko(){
		return lokasiToko;
	}

	public int getRAM(){
		return rAM;
	}
}