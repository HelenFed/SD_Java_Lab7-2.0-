package com.lab111.labwork7;

/*
Клас одного з типів фігури - квадрат, який наслідує абстрактний клас GraphicElement.
Використовує конструктор super, де уже визначений тип фігури як "square", бо якщо ми створюємо об'єкт Square,
то очевидно, що він типу square
 */

public class Square extends GraphicElement{
	public Square(String color, int[] position, int size) {
		super("square", color, position, size);
	}
}
