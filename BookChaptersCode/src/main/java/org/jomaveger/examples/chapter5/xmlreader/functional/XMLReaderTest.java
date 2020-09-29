package org.jomaveger.examples.chapter5.xmlreader.functional;

import org.apache.log4j.Logger;
import org.jomaveger.functional.control.Result;
import org.jomaveger.functional.data.ImmutableList;
import org.jomaveger.functional.functions.Executable;
import org.jomaveger.functional.tuples.Tuple2;

public class XMLReaderTest {
	
	private static final Logger log = Logger.getLogger(XMLReaderTest.class);

	private final static Tuple2<String, ImmutableList<String>> format = new Tuple2<>(
			"First Name : %s\n" + "\tLast Name : %s\n" + "\tEmail : %s\n" + "\tSalary : %s",
			ImmutableList.of("firstname", "lastname", "email", "salary"));

	public static void main(String... args) {
		Executable program = XMLReader.readXmlFile(XMLReaderTest::getXmlFilePath, 
				XMLReaderTest::getRootElementName, format,
				XMLReaderTest::processList);
		program.exec();
	}

	private static Result<String> getXmlFilePath() {
		return Result.of(System.getProperty("user.dir") + "/file.xml");
	}

	private static Result<String> getRootElementName() {
		return Result.of("staff");
	}

	private static <T> void processList(ImmutableList<T> list) {
		list.forEach(log::info);
	}
}
