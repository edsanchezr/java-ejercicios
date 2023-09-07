package mx.helixiar.primos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalculaPrimos {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Introduce el numero inicial: ");
		int inicio = input.nextInt();
		System.out.print("Introduce el numero final: ");
		int fin = input.nextInt();
		
		if (fin < inicio) {
			System.out.println("El numero final no puede ser menor al inicial.");
		} else {
			long time = System.currentTimeMillis();
			List <Integer> primeNumbers = getList(inicio, fin);
			primeNumbers = getPrimeNumbers(primeNumbers, fin);
			time = System.currentTimeMillis() - time;
			System.out.println("Los numeros primos del " + inicio + " al " + fin + " son: " + primeNumbers.size());
			System.out.println(primeNumbers);
			System.out.println("Tiempo procesamiento: " + time + " ms.");
		}
		
	}
	
	private static List<Integer> getList (int init, int end) {
		List <Integer> list = new ArrayList <> ();
		for (int i = init; i <= end; i ++) {
			list.add(i);
		}
		return list.stream()
				.sorted()
				.collect(Collectors.toList());
	}
	
	private static List <Integer> getPrimeNumbers (List <Integer> list, int endValue) {
		List <Integer> primeNumbers = new ArrayList <> ();
		primeNumbers.addAll(list);
		
		for (int i = 0; i < list.size(); i ++) {
			int valueToCompare = list.get(i);
			if (valueToCompare < 2) {
				primeNumbers.remove(i);
			} else {
				primeNumbers = removeMultiplyNumbersOfList(primeNumbers, valueToCompare, endValue);
			}
		}
		
		return primeNumbers;
	}
	
	private static List <Integer> removeMultiplyNumbersOfList (
			List <Integer> primeList, int value, int end) {
		for (int i = 2; i <= primeList.size(); i ++) {
			int multiply = value * i;
			if (multiply <= end) {
				primeList.removeIf (x -> x == multiply);
			} else {
				break;
			}
		}
		return primeList;
	}

}
