package com.backsllash.spring5webapp.domain;

import com.backsllash.spring5webapp.utils.toString;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Entity implements Serializable {
	@Override
	public String toString() {
		return( new toString( this ).toString() );
	}
}
