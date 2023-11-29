package com.lab111.labwork7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Клас Caretaker відповідає за збереження об'єктів Memento.
Для надання можливості об'єкту повернення в будь-який попередній стан, клас створює
список об'єктів Memento
 */

class Caretaker {
	/*
	Розділення Mementos за критерієм типу фігури, тобто
	для кожного різного типу фігури буде свій список
	 */
	private Map<String, List<Memento>> mementoMap = new HashMap<>();

	public void addMemento(Memento memento) {
		String shapeType = memento.getShape();

		//Якщо відустній тип фігури, то створюється новий список
		mementoMap.putIfAbsent(shapeType, new ArrayList<>());

		//Додавання Memento до відповідного списку
		mementoMap.get(shapeType).add(memento);
	}

	//Метод отримання Memento відповідного типу
	public List<Memento> getMementos(String shapeType) {
		return mementoMap.getOrDefault(shapeType, new ArrayList<>());
	}
}
