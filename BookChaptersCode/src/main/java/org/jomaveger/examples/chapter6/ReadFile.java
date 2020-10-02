package org.jomaveger.examples.chapter6;

import org.jomaveger.functional.control.Result;
import org.jomaveger.functional.data.ImmutableList;
import org.jomaveger.functional.io.FileReader;
import org.jomaveger.functional.io.Input;
import org.jomaveger.functional.tuples.Tuple2;

public class ReadFile {

	private static String path = System.getProperty("user.dir") + "/data.txt";

	public static void main(String... args) {
		Result<Input> rInput = FileReader.fileReader(path);

		Result<ImmutableList<Person>> rList = rInput.map(input -> ImmutableList.unfold(input, ReadFile::person));
		rList.forEachOrFail(list -> list.forEach(System.out::println));
	}

	public static Result<Tuple2<Person, Input>> person(Input input) {
		return input.readInt("Enter ID:")
			.flatMap(id -> id._2.readString("Enter first name:")
				.flatMap(firstName -> firstName._2.readString("Enter last name:")
					.map(lastName -> new Tuple2<>(Person.apply(id._1, firstName._1, lastName._1), 
										lastName._2))));
	}

}
