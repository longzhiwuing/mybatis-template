package com.lzwing.mybatisspringxmldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzwing.mybatisspringxmldemo.mapper")
public class MybatisSpringXmlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisSpringXmlDemoApplication.class, args);
	}
}
