package pers.ethan.socketserver;

import java.io.Serializable;

public class ShopMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 991538374783197188L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
