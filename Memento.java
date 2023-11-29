package com.lab111.labwork7;

/*
Клас який по суті робить копію поточний стан об'єкта.
Основна мета Memento - надати можливість повернутися до попереднього стану об'єкта
без розкриття його внутрішньої реалізації.
 */

public class Memento {
    private String shape;
    private String color;
    private int[] position;
    private int size;

    /*
    Конструктор, який створює об'єкт Memento на основі поточного стану оригінатора
     */
    public Memento(String shape, String color, int[] position, int size){
        this.shape = shape;
        this.color = color;
        this.position = position.clone();
        this.size = size;
    }

    /*
    Метода повернення конкретних полів об'єкту Memento
     */
    public String getShape(){
        return shape;
    }

    public String getColor(){
        return color;
    }

    public int[] getPosition(){
        return position;
    }

    public int getSize(){
        return size;
    }
}
