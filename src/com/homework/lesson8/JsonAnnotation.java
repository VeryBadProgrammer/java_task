package com.homework.lesson8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class JsonAnnotation {
    public String serialize(Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (Field field : fields) {
            field.setAccessible(true);
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
            stringBuilder.append(":");
            if (field.getType() == String.class) {
                stringBuilder
                        .append("\"")
                        .append(field.get(clazz.getDeclaredConstructor().newInstance()))
                        .append("\",\n");
            } else {
                stringBuilder
                        .append(field.get(clazz.getDeclaredConstructor().newInstance()))
                        .append(",\n");
            }
        }
        stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.length(),"");
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }

    public <T> T deserialize(String string, Class<T> clazz) throws Exception {
        String[] split = string.trim()
                .replaceAll("\\{", "")
                .replaceAll("}", "")
                .replaceAll("\"", "")
                .replaceAll("\n", "")
                .trim()
                .split(",");
        Map<String, String> collect = Arrays.stream(split)
                .collect(Collectors.toMap(
                        (x) -> x.split(":")[0].trim(),
                        (y) -> y.split(":")[1].trim()));
        List<Object> obj = new ArrayList<>();
        List<Class<?>> parameterTypes = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonIgnore.class)) {
                continue;
            }
            Class<?> type = field.getType();
            parameterTypes.add(type);
            String filedName = field.getName();
            if (field.isAnnotationPresent(JsonName.class)) {
                filedName = field.getAnnotation(JsonName.class).value();
            }
            if (type == int.class) {
                obj.add(Integer.parseInt(collect.get(filedName)));
            } else if (type == double.class) {
                obj.add(Double.parseDouble(collect.get(filedName)));
            } else {
                obj.add(collect.get(filedName));

            }
        }
        final Constructor<T> constructor = clazz.getConstructor(parameterTypes.toArray(Class<?>[]::new));
        return constructor.newInstance(obj.toArray(Object[]::new));
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
