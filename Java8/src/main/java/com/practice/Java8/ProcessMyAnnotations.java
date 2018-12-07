package com.practice.Java8;

import java.lang.reflect.Field;

public class ProcessMyAnnotations {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
         Class<LambdaExp1> lambdaExp1 = LambdaExp1.class;
//         for(Method method : lambdaExp1.getMethods()){
//        	 MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
//        	 if(myAnnotation!=null){
//        		 System.out.println(" Method Name : " + method.getName());
//        		 System.out.println(" Author : " + myAnnotation.author());
//        		 
//        	 }
//         }
         for(Field field : lambdaExp1.getDeclaredFields()){
        	 MyAutowiring myAutowiring = field.getAnnotation(MyAutowiring.class);
        	 if(myAutowiring!=null){
        		 Class fieldType = field.getType();
        		 field = (Field) fieldType.newInstance();
        	 }
         }
         
         LambdaExp1 exp1 = new LambdaExp1();
         exp1.getLambdaExp2().testAutowiringAnnotation();
         
	}
}
