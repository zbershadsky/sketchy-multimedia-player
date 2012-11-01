package com.paziy.sketchy.request.model;

import com.paziy.sketchy.request.controllers.VKUrlManagerConstants;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParameterList {
	private List<APIParameter> params;
	
	public ParameterList(APIParameter ... params) {
		this.params = new LinkedList<APIParameter>();
		
		this.params.addAll(Arrays.asList(params));
	}
	
	public APIParameter get(int index) {
		return params.get(index);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (APIParameter parameter : params) {
			builder.append(parameter.toString() + VKUrlManagerConstants.AND);
		}
		
		builder.deleteCharAt(builder.length() - 1);
		
		return builder.toString();
	}
}
