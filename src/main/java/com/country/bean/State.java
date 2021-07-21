package com.country.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State {
	private int stateID;
	private String stateName;
	private long population;

}
