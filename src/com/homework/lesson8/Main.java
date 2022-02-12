package com.homework.lesson8;

//Аннотации и рефлексия
//
//Аннотированная де\сериализация.
//
//Создайте класс, который может записывать любой объект в упрощенном формате JSON:
//
//- Объект начинается с { и заканчивается }
//
//- Свойство это пара "ключ:значение"
//
//- Все свойства отделены друг от друга точкой с запятой
//
//- Все названия свойств в двойных кавычках
//
//- Значениями свойств могут быть только строки ( в двойных кавычках) или числа (с плавающей точкой, без кавычек)
//
//- Создайте аннотацию @JsonName, чтобы определять имя свойства в JSON формате
//
//- Создайте аннотацию @JsonIgnore, чтобы исключить поля из сериализации
//
//Например, класс Person {
//
//@JsonName("name")
//
//String firstName="Vasya";
//
//@JsonName("years")
//
//double age=12
//
//@JsonIgnore
//
//String password;
//
//}
//
//будет выглядеть так
//
//{
//
//"name":"Vasya",
//
//"age":12
//
//}
//
//Создайте класс, который может читать любой объект в упрощенном формате JSON.
//
//например ,deserialize(<пример выше>, Person.class) вернет экземпляр Person{name="Vasya",age=12,password=null}
public class Main {
    public static void main(String[] args) throws Exception {
        JsonAnnotation jsonAnnotation = new JsonAnnotation();
        String serialize = jsonAnnotation.serialize(Person.class);
        System.out.println(serialize);
        System.out.println(jsonAnnotation.deserialize(serialize, Person.class).toString());
    }
}
