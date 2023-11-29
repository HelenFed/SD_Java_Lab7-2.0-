package com.lab111.labwork7;

/*
Клас одного з типів фігури - трикутник, який наслідує абстрактний клас GraphicElement.
Використовує конструктор super, де уже визначений тип фігури як "triangle", бо якщо ми створюємо об'єкт Triangle,
то очевидно, що він типу triangle
 */

public class Triangle extends GraphicElement{
	public Triangle(String color, int[] position, int size) {
		super("triangle", color, position, size);
	}
}
