package com.kushal.hibernate.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DAUGHTER_DISC")
public class Daughter extends Parent {
	private String daughterName;

	public String getDaughterName() {
		return daughterName;
	}
	public void setDaughterName(String daughterName) {
		this.daughterName = daughterName;
	}
}
