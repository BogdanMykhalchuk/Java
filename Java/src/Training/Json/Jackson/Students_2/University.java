package Training.Json.Jackson.Students_2;

import Training.Json.Jackson.Students_1.Students;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class University {
	public void objectToFile(String filepath, Student student) throws IOException {
		new ObjectMapper().writeValue(new File(filepath), student);
	}
	public Student getObjectFromFile(String filepath) throws IOException {
		return new ObjectMapper().readValue(new File(filepath), new TypeReference<Student>(){});
	}
	public List<Students> getGraduatedStudents(List<Students> students) {
		return students.stream().filter(s -> s.isGraduated() == true).collect(Collectors.toList());
	}
}