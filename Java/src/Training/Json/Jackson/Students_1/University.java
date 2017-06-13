package Training.Json.Jackson.Students_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class University {
	public static List<Students> students = new ArrayList<>();
	public static void addStudentFromFile(String filepath) throws IOException {
		students.add(new ObjectMapper().readValue(new File(filepath), new TypeReference<Students>(){}));
	}
	public static void writeStudentToFile(Students student, String filepath) throws IOException {
		new ObjectMapper().writerFor(new TypeReference<Students>(){}).writeValue(new File(filepath), student);
	}
}