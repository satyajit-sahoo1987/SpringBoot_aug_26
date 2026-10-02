package com.example.one_to_one;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {
private final StudentRepository studentRepository;
private final AddressRepository addressRepository;
	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner() {
	return args -> {
//		owningSideOperation();

		//=======INVERSE SIDE OPERATION==========

		Student student=Student.builder()
				.studentName("Sima")
				.studentEmail("sima123@gmail.com")
				.build();
		Address address=Address.builder()
				.city("Keonjhar")
				.state("Odhisha")
				.country("India")
				.student(student)
				.build();

         student.setAddress(address);
//		addressRepository.save(address);

		//======update========
//		Address existingAddress=addressRepository.findById(6).orElseThrow();
//	existingAddress.setCity("Jajpur");
//	Student existingStudent=existingAddress.getStudent();
//	existingStudent.setStudentName("Rahul");
//		existingStudent.setStudentEmail("rahulbarsha@gmail.com");
//
//	addressRepository.save(existingAddress);

	//=========delete==========
		addressRepository.deleteById(5);
	};
}
private void owningSideOperation(){
				Address address=Address.builder()
						.city("Sambalpur")
						.state("Odhisha")
						.country("India")
						.build();

				Student student=Student.builder()
						.studentName("Sima")
						.studentEmail("sima123@gmail.com")
						.address(address)
						.build();

//			studentRepository.save(student);//error-because when we try to save owing side
				//inverse side should must be present in the database

				//1.Manually save Address Object then Save Student Object
//			addressRepository.save(address);
//			studentRepository.save(student);
				//2.use Cascading
//			studentRepository.save(student);


				//========UPDATE========
//	Student existingStudent=studentRepository.findById(5).orElseThrow();
//	existingStudent.setStudentName("Rahul");
//	existingStudent.setStudentEmail("rahul143@gmail.com");
//	Address existingAddress=existingStudent.getAddress();
//	existingAddress.setCity("Jajpur");
//	studentRepository.save(existingStudent);

				//===========REMOVE=========
				studentRepository.deleteById(7);

//======================Retrive==========
				Student studentWithRoll=studentRepository.findById(8).orElseThrow();
				System.out.println("Student Name :"+studentWithRoll.getStudentName());
				System.out.println("Student Email :"+studentWithRoll.getStudentEmail());
				Address studentWithRollAddress=studentWithRoll.getAddress();
				System.out.println("Address city :"+studentWithRollAddress.getCity());
				System.out.println("Address state :"+studentWithRollAddress.getState());
				System.out.println("Address country:"+studentWithRollAddress.getCountry());
			}
		}


