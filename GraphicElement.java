package com.lab111.labwork7;

/*
Абстрактний клас для усіх фігур (його наслідують коло, квадрат і трикутник).
Визначає конструктор для характеристик фігури, методи для повернення та зміни (getters, setters) цих характеристик,
а також метод створення memento, та повернення фігури у стан, визначений цим memento
 */

abstract class GraphicElement {
    private String shape;
    private String color;
    private int[] position;
    private int size;

    /*
    Конструктор для фігур, який визначає тип фігури, її колір, позицію і розмір.
    Позиція зразу визиває метод для встановки, бо позиція має становити саме 2 координати,
    що і перевіряється в методі setPosition
     */
    public GraphicElement(String shape, String color, int[] position, int size){
        this.shape = shape;
        this.color = color;
        setPosition(position);
        this.size = size;
    }

    /*
    Setters для характеристик фігури. Якщо позиція складається не з двох чисел (координат x, y), то повернеться помилка
     */
    public void setPosition(int[] position) {
        if (position == null || position.length != 2) {
            throw new IllegalArgumentException("Position must have exactly two coordinates (x and y).");
        }
        this.position = position.clone();
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setSize(int size){
        this.size = size;
    }

    /*
    Метод створення memento, який зберігає усі поточні характеристики
     */
    public Memento createMemento(){
        return new Memento(shape, color, position, size);
    }

    /*
    Метод який повертає характеристики зі збереженого раніше memento
     */
    public void restoreFromMemento(Memento memento){
        this.shape = memento.getShape();
        this.color = memento.getColor();
        this.position = memento.getPosition();
        this.size = memento.getSize();
    }

    /*
    Getters для повернення характеристик фігури
     */
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
