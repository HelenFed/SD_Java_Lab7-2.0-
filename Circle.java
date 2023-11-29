package com.lab111.labwork7;

/*
Клас одного з типів фігури - коло, який наслідує абстрактний клас GraphicElement.
Використовує конструктор super, де уже визначений тип фігури як "circle", бо якщо ми створюємо об'єкт Circle,
то очевидно, що він типу circle
 */

public class Circle extends GraphicElement{
	public Circle(String color, int[] position, int size) {
		super("circle", color, position, size);
	}
}
