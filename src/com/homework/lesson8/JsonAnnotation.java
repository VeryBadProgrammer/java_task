package com.homework.lesson8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class JsonAnnotation {
    public String serialize(Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonIgnore.class)) {
                continue;
            }
            if (field.isAnnotationPresent(JsonName.class)) {
                stringBuilder.append("\"")
                        .append(field.getAnnotation(JsonName.class).value())
                        .append("\"");
            } else {
                stringBuilder.append("\"")
                        .append(field.getName())
                        .append("\"");
            }
            //How we can convert to type?
//            if (field.getType() instanceof Number)
            stringBuilder.append(":")
                    .append("\"")
                    .append(field.get(clazz.getDeclaredConstructor().newInstance()))
                    .append("\",\n");
        }

        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }

    public  <T> T deserialize(String string, Class<T> clazz) throws Exception{
        string = string.trim()
                .replace("{","")
                .replace("}","")
                .trim();
        T obj = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();

//        for (Field field : fields) {
//            if (field.isAnnotationPresent(JsonIgnore.class)) {
//                field.set(field.getType(), )
//            }
//            if (field.isAnnotationPresent(JsonName.class)) {
//                stringBuilder.append("\"")
//                        .append(field.getAnnotation(JsonName.class).value())
//                        .append("\"");
//            } else {
//                stringBuilder.append("\"")
//                        .append(field.getName())
//                        .append("\"");
//            }
//            //How we can convert to type?
////            if (field.getType() instanceof Number)
//            stringBuilder.append(":")
//                    .append("\"")
//                    .append(field.get(clazz.getDeclaredConstructor().newInstance()))
//                    .append("\",\n");
//        }
        return obj;
    }

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface JsonName {
    String value() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface JsonIgnore {
    String info() default "";
}
