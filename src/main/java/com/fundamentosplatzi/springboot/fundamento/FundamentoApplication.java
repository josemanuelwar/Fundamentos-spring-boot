package com.fundamentosplatzi.springboot.fundamento;

import com.fundamentosplatzi.springboot.fundamento.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamento.bean.MyBeanImplemetUser;
import com.fundamentosplatzi.springboot.fundamento.bean.MyBeanWithDependecy;
import com.fundamentosplatzi.springboot.fundamento.bean.User;
import com.fundamentosplatzi.springboot.fundamento.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamento.entity.Usuario;
import com.fundamentosplatzi.springboot.fundamento.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamento.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamento.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentoApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentoApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependecy myBeanWithDependecy;
	private MyBeanImplemetUser myBeanImplemetUser;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;
	public FundamentoApplication(
			@Qualifier("ComponentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependecy myBeanWithDependecy,
			MyBeanImplemetUser myBeanImplemetUser,
			UserPojo userPojo,
			UserRepository userRepository,
			UserService userService){
		this.componentDependency=componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependecy=myBeanWithDependecy;
		this.myBeanImplemetUser=myBeanImplemetUser;
		this.userPojo=userPojo;
		this.userRepository=userRepository;
		this.userService=userService;
	}
	public static void main(String[] args) {

		SpringApplication.run(FundamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
		this.getInformationJpsqlFromUser();
		this.saveWhitErroTransactional();

	}

	private void saveWhitErroTransactional(){
		Usuario test1 = new Usuario("TesteTransaction1",
				"TesteTransaction1@gmail.com",LocalDate.now());
		Usuario test2 = new Usuario("TesteTransaction2",
				"TesteTransaction2@gmail.com",LocalDate.now());
		Usuario test3 = new Usuario("TesteTransaction3",
				"TesteTransaction1@gmail.com",LocalDate.now());
		Usuario test4 = new Usuario("TesteTransaction4",
				"TesteTransaction4@gmail.com",LocalDate.now());
		List<Usuario> user = Arrays.asList(test1,test2,test3,test4);
		try {
			this.userService.saveTransactional(user);
		}catch (Exception e){
			LOGGER.error("Este es una exception dentro del metodo transaccional "+e);
		}

		this.userService.getAllUsers().stream().forEach(usser -> LOGGER.info(
				"Este es el usuario dentro del metodo transaccional "+ usser
		));
	}

	private void saveUsersInDataBase(){
		Usuario usuario1= new Usuario("jose manuel",
				"josemanuelwar@hotmail.com",
				LocalDate.of(2026,10,13));
		Usuario usuario2= new Usuario("Goku",
				"goku@hotmail.com",
				LocalDate.of(2022,06,20));
		Usuario usuario3= new Usuario("thalliro",
				"thalliro@hotmail.com",
				LocalDate.of(2023,01,31));
		Usuario usuario4= new Usuario("Saitama",
				"saitama@hotmail.com",
				LocalDate.of(2017,02,15));
		Usuario usuario5= new Usuario("Reku",
				"Reku@hotmail.com",
				LocalDate.of(2018,05,05));
		List<Usuario> list= Arrays.asList(usuario1,usuario2,usuario3,usuario4,usuario5);
		list.stream().forEach(userRepository::save);


	}

	private void getInformationJpsqlFromUser(){
		userRepository.findByName("Goku")
				.stream()
				.forEach(user-> LOGGER.info("usuario con query "+ user));
		LOGGER.info("Usuario con query method findByEmailAndName"+userRepository.findByEmailAndName("thalliro@hotmail.com","thalliro")
				.orElseThrow(()->new RuntimeException("Usuario no encontrdo")));

		userRepository.findByNameLike("%jose%").stream()
				.forEach(user->LOGGER.info("usuario findByNameLike "+user));

		userRepository.findByNameOrEmail(null,"Reku@hotmail.com").stream()
				.forEach(user-> LOGGER.info("usuario findByNameOrEmail "+user));

		userRepository.findByNameOrEmail("Reku",null).stream()
				.forEach(user->LOGGER.info("Usuario buscado por nombre "+user));

		userRepository.findByBirthDateBetween(LocalDate.of(2017, 01,01),
				LocalDate.of(2024,01,01))
				.stream()
				.forEach(user->LOGGER.info("usuario encontrados por fechas findByBirthDateBetween"+
						user));
		userRepository.findByNameLikeOrderByIdDesc("%o%")
				.stream().forEach(user->LOGGER.info("Ordenamos la data "+user));

		/*/LOGGER.info("El usuario apartir del named parameter es: "+
				userRepository.getAllByBrithDateAndEmail(
						LocalDate.of(2017,02,15),
						"Reku@hotmail.com")
				.orElseThrow(()->
						new RuntimeException("no se encontro el usuario a " +
								"partir del baned parametr")));*/


	}
	private void ejemplosAnteriores(){
		this.componentDependency.saludar();
		this.myBean.print();
		this.myBeanWithDependecy.printWithDependency();
		this.myBeanImplemetUser.impirmir();
		System.out.println("Email: "
				.concat(userPojo.getEmail())
				.concat(" Paswword: ")
				.concat(this.userPojo.getPassword())+" Edad: "
				+ this.userPojo.getAge());
		try{
			int value = 10/0;
			LOGGER.debug("Mi valor: "+value);
		}catch (Exception e){
			LOGGER.error("este es un error por divicion de cero ".concat(e.getMessage()) );
		}
	}
}
