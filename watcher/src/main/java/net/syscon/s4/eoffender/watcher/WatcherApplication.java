package net.syscon.s4.eoffender.watcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import net.syscon.s4.eoffender.watcher.config.WatcherService;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "net.syscon.s4.eoffender.watcher")
public class WatcherApplication extends SpringBootServletInitializer {
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WatcherApplication.class, args);
		context.getBean(WatcherService.class).startWatchService();
	}
	
}
