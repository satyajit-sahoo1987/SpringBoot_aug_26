package com.example.many_to_many;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class ManyToManyApplication {
private final StudentRepository studentRepository;
private final SubjectRepository subjectRepository;
	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			oneWayBinding();

//			Save using inverse side
			Student student1 = Student.builder()
					.studentName("A")
					.studentEmail("amit@gmail.com")
					.build();
			Student student2 = Student.builder()
					.studentName("B")
					.studentEmail("satya@gmail.com")
					.build();
			Student student3 = Student.builder()
					.studentName("C")
					.studentEmail("rahul@gmail.com")
					.build();

			Subject subject1 = Subject.builder().subjectName("C").students(List.of(student1, student2, student3)).build();
			Subject subject2 = Subject.builder().subjectName("Java").students(List.of(student1, student2, student3)).build();
			Subject subject3 = Subject.builder().subjectName("C++").students(List.of(student1, student2, student3)).build();
			Subject subject4 = Subject.builder().subjectName("Python").students(List.of(student1, student2, student3)).build();

student1.setSubjects(List.of(subject1,subject2,subject3,subject4));
student2.setSubjects(List.of(subject1,subject2,subject3,subject4));
student3.setSubjects(List.of(subject1,subject2,subject3,subject4));

//			subjectRepository.saveAll(List.of(subject1, subject2, subject3));
            //=========UPDATE==============
//			Subject subject=subjectRepository.findById(42).orElseThrow();
//			subject.setSubjectName(".NET");
//			subjectRepository.save(subject);
			//========Delete======
//    subjectRepository.deleteAll();
//	Subject subject=subjectRepository.findById(38).orElseThrow();
//	subjectRepository.delete(subject);
//====================extract===============
//			subjectRepository.findAll().forEach(sub -> {
//				sub.getStudents().forEach(std -> {
//					System.out.println(sub.getSubjectName() + "\t->\t" + std.getStudentName());
//				});
//			});

		};
	}


	private void oneWayBinding(){
//==============SAVE==============
		Subject subject1=Subject.builder().subjectName("C").build();
		Subject subject2=Subject.builder().subjectName("Java").build();
		Subject subject3=Subject.builder().subjectName("C++").build();
		Subject subject4=Subject.builder().subjectName("Python").build();

		Student student1=Student.builder()
				.studentName("Amit")
				.studentEmail("amit@gmail.com").subjects(List.of(subject1,subject2,subject3))
				.build();
		Student student2=Student.builder()
				.studentName("Satya")
				.studentEmail("satya@gmail.com").subjects(List.of(subject1,subject2,subject3))
				.build();
		Student student3=Student.builder()
				.studentName("Rahul")
				.studentEmail("rahul@gmail.com").subjects(List.of(subject1,subject2,subject3))
				.build();
		studentRepository.saveAll(List.of(student1,student2,student3));

		//update
//Student updateStudent=studentRepository.findById(25).orElseThrow();
//updateStudent.setStudentName("Akshya123");
//updateStudent.setStudentEmail("akshya123@gmail.com");
//Subject updateSubject=subjectRepository.findById(27).orElseThrow();
//updateSubject.setSubjectName("cOMPUTER nETWORK");
//subjectRepository.save(updateSubject);
//
//studentRepository.save(updateStudent);


		//delete
//studentRepository.deleteAll();
		studentRepository.deleteById(49);
//		Student delstudent=studentRepository.findById(25).orElseThrow();
//		Subject delsubject=subjectRepository.findById(27).orElseThrow();
//		delstudent.getSubjects().remove(delsubject);
//		studentRepository.save(delstudent);
		//Extract
		studentRepository.findAll().forEach(student->{
			student.getSubjects().forEach(subject->{
				System.out.println(student.getStudentName()+"\t->\t"+subject.getSubjectName());
			});
		});
	}
}
