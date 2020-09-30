package com.tghr.comm.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {

//	public static ModelMapper getModelMapper() {
//		return new ModelMapper();
//	}
	
    public static <D, E> D  convertToDTO(E source, Class<? extends D> classLiteral) {    
        return new ModelMapper().map(source, classLiteral);
    }

}
