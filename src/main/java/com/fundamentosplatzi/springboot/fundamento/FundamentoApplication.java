package com.fundamentosplatzi.springboot.fundamento;

import com.fundamentosplatzi.springboot.fundamento.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamento.bean.MyBeanImplemetUser;
import com.fundamentosplatzi.springboot.fundamento.bean.MyBeanWithDependecy;
import com.fundamentosplatzi.springboot.fundamento.bean.User;
import com.fundamentosplatzi.springboot.fundamento.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamento.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentoApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentoApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependecy myBeanWithDependecy;

	private MyBeanImplemetUser myBeanImplemetUser;

	private UserPojo userPojo;
	public FundamentoApplication(
			@Qualifier("ComponentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependecy myBeanWithDependecy,
			MyBeanImplemetUser myBeanImplemetUser,
			UserPojo userPojo){
		this.componentDependency=componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependecy=myBeanWithDependecy;
		this.myBeanImplemetUser=myBeanImplemetUser;
		this.userPojo=userPojo;
	}
	public static void main(String[] args) {

		SpringApplication.run(FundamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
