package com.example.springboot;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 在启动类中添加对mapper包扫描@MapperScan
@MapperScan("com.example.springboot")
@NacosPropertySource(dataId = "nacos-test", autoRefreshed = true)
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
