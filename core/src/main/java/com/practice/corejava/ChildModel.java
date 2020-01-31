package com.practice.corejava;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("child")
public class ChildModel extends Model{
	private int x = 20;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChildModel [x=");
		builder.append(x);
		builder.append("]");
		return builder.toString();
	}

}
