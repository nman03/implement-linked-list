package implLinkedList;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	public MyLinkedList() {
	}

	public MyLinkedList(E[] list) {
		super(list);
	}

	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}

	public E getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return tail.element;
		}
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		if (tail == null)
			tail = head;
	}

	public void addLast(E e) {
		if (tail == null) {
			head = tail = new Node<>(e);
		}
		else {
			tail.next = new Node<>(e);
			tail = tail.next;
		}
		size++;
	}
	
	@Override
	public void add(E e) {
		addLast(e);
	}

	@Override
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		}
		else if (index >= size) {
			addLast(e);
		}
		else {
			Node<E> current = head;

			for (int i = 1 ; i < index ; i++) {
				current = current.next;
			}

			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}

	}

	@Override
	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override	
	public boolean contains(E e) {
		Node<E> current = head;

		while (current != null) {
			if (current.element.equals(e)) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		else if (index == 0) {
			return getFirst();
		}
		else if (index == size - 1) {
			return getLast();
		}
		else {
			Node<E> current = head;

			for (int i = 0; i < index; i++) {
				current = current.next;
			}

			return current.element;
		}	
	}

	@Override
	public int indexOf(E e) {
		Node<E> current = head;

		for (int i = 0 ; i < size ; i++) {
			if (current.element.equals(e)) {
				return i;
			}
			current = current.next;
		}

		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int lastIndexOf(E e) {
		Node<E> current = head;
		int index = -1;

		for (int i = 0 ; i < size ; i++) {
			if (current.element.equals(e)) {
				index = i;
			}
			current = current.next;
		}

		return index;
	}

	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		else {
			Node<E> current = head;
			head = current.next;
			size--;

			if (head == null) {
				tail = null;
			}

			return current.element;
		}
	}

	public E removeLast() {
		if (size == 0) {
			return null;
		}
		else if (size == 1) {
			Node<E> current = head;
			head = tail = null;
			size = 0;
			return current.element;
		}
		else {
			Node<E> current = head;

			for (int i = 0 ; i < size - 2 ; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}	
	}

	@Override
	public boolean remove(E e) {
		Node<E> current = head;

		for (int i = 0 ; i < size ; i++) {
			if (current.element.equals(e)) {
				remove(i);
				return true;
			}
			current = current.next;
		}

		return false;
	}

	@Override	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		else if (index == 0) {
			return removeFirst();
		}
		else if (index == size - 1) {
			return removeLast();
		}
		else {
			Node<E> current = head;

			for (int i = 1 ; i < index ; i++) {
				current = current.next;
			}

			Node<E> temp = current.next;
			current.next = temp.next;
			size--;

			return current.element;
		}

	}

	@Override
	public E set(int index, E e) {
		if (index < 0 || index >= size) {
			return null;
		}
		else if (index == 0) {
			E temp = head.element;
			head.element = e;

			return temp;
		}
		else if (index == size - 1) {
			E temp = tail.element;
			tail.element = e;
	
			return temp;
		}
		else {
			Node<E> current = head;

			for (int i = 0 ; i < index ; i++) {
				current = current.next;
			}
		
			E temp = current.element;
			current.element = e;;
			
			return temp;
		}	
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;

		for (int i = 0 ; i < size ; i++) {
			result.append(current.element);
			if (i < size -1) {
				result.append(", ");
			}
			current = current.next;
		}

		return result.toString() + "]";
	}

	public int size() {
		return size;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head; 

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
}
