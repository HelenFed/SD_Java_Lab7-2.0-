package com.lab111.labwork7;

import java.util.Arrays;
import java.util.List;

/*
Клас для перевірки роботи програми.
Створюються фігури різних типів, після чого змінюються їх параметри, а потім відновляюються через memento.
 */

public class Client {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Ваірант завдання
		int var = 1128 % 8;
		System.out.println("Варіант завдання: " + var);

		//Створення фігур, над якими будемо проводити зміни (можна було б і трикутник, але немає потреби, бо двох фігур достатньо)
		Circle circle = new Circle("yellow", new int[]{20, 40}, 9);
		Square square = new Square("red", new int[]{29, 20}, 4);
		Caretaker caretaker = new Caretaker();

		//Зберігаємо початковий стан фігур
		caretaker.addMemento(circle.createMemento());
		caretaker.addMemento(square.createMemento());

		//Почнемо пробувати змінювати щось в колі
		System.out.println("\nCircle:\nNew memento added (0): initial circle");

		/*
		Зміна кольору кола і розміру, координати незмінні
		жовтий -> синій; 9 -> 2; (20, 40)
		 */
		circle.setColor("blue");
		circle.setSize(2);

		//Запис нового поточного стану
		caretaker.addMemento(circle.createMemento());
		System.out.println("New memento added (1): changed circle color and size (blue, 2)");

		/*
		Зміна координат кола і запис нового поточного стану
		синій; 2; (20, 40) -> (66, 66)
		 */
		circle.setPosition(new int[]{66, 66});
		caretaker.addMemento(circle.createMemento());
		System.out.println("New memento added (2), changed circle position (66, 66)");

		//Створення списку пам'яток, які проведені над колом
		List<Memento> circleMementos = caretaker.getMementos("circle");

		//Виведення усіх пам'яток, зроблених для кола. Стани змінювалися послідовно (у відмінності від квадрата далі)
		if (!circleMementos.isEmpty()) {
			for (Memento memento : circleMementos){
				circle.restoreFromMemento(memento);
				System.out.println("Memento " + circleMementos.indexOf(memento) + ": circle color: "
						+ circle.getColor() + ", size: " + circle.getSize()
						+ ", coordinates: " + Arrays.toString(circle.getPosition()));
			}
		}

		//Починаємо змінювати квадрат
		System.out.println("\nSquare:\nNew memento added (0): initial square");

		/*
		Зміна кольору квадрату, координати і розмір незмінні
		червоний -> фіолетовий; 4; (29, 20)
		 */
		square.setColor("purple");

		//Запис нового поточного стану
		caretaker.addMemento(square.createMemento());
		System.out.println("New memento added (1): changed square color (purple)");

		/*
		Зміна розміру квадрату, координати незмінні
		фіолетовий; 4 -> 20; (29, 20)
		 */
		square.setSize(20);
		caretaker.addMemento(square.createMemento());
		System.out.println("New memento added (2): changed square size (20)");

		/*
		Створення списку пам'яток, які проведені над квадратом,
		що показує можливість запису у різні списки за типом фігур
		 */
		List<Memento> squareMementos = caretaker.getMementos("square");

		/*
		Повертаємо стан квадрату в початковий (0)
		фіолетовий -> червоний; 20 -> 4; (29, 20)
		 */
		if (!squareMementos.isEmpty()) {
			square.restoreFromMemento(squareMementos.get(0));
		}

		/*
		Зміна координат квадрату, колір і розмір незмінні
		червоний; 4; (29, 20) -> (66, 66)
		 */
		square.setPosition(new int[]{66, 66});
		caretaker.addMemento(square.createMemento());
		System.out.println("New memento added (3): returned to initial state and changed coordinates (red, 4, [66, 66])");

		/*
		Виведення усіх пам'яток, зроблених для квадрату.
		Стани змінювалися нелінійно (один стан було відновлено і потім далі знову змінено)
		 */
		if (!squareMementos.isEmpty()) {
			for (Memento memento : squareMementos){
				square.restoreFromMemento(memento);
				System.out.println("Memento " + squareMementos.indexOf(memento) + ": square color: "
						+ square.getColor() + ", size: " + square.getSize()
						+ ", coordinates: " + Arrays.toString(square.getPosition()));
			}
		}
	}
}
