package com.fdm.jpa.inheritence.joinSubClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Television extends ElecticalDevice {

	private int maxVolume;

	public Television() {
		super();
	}

	public Television(int wattage, int maxVolume) {
		super(wattage);
		this.maxVolume = maxVolume;
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}

}
