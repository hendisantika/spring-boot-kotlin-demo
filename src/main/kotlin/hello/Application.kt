package hello

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

	private val log = LoggerFactory.getLogger(Application::class.java)

	@Bean
	fun init(repository: CustomerRepository) = CommandLineRunner {
			// save a couple of customers
			repository.save(Customer("Hendi", "Santika"))
			repository.save(Customer("Sasuke", "Uchiha"))
			repository.save(Customer("Uzumaki", "Naruto"))
			repository.save(Customer("Sakura", "Haruno"))
			repository.save(Customer("Hatake", "Kakashi"))

		// fetch all customers
		log.info("Customers found with findAll():")
		log.info("-------------------------------")
		for (customer in repository.findAll()) {
			log.info(customer.toString())
		}
		log.info("")

		// fetch an individual customer by ID
		val customer = repository.findById(1L)
		log.info("Customer found with findById(1L):")
		log.info("--------------------------------")
		log.info(customer.toString())
		log.info("")

		// fetch customers by last name
		log.info("Customer found with findByLastName('Naruto'):")
		log.info("--------------------------------------------")
		for (Naruto in repository.findByLastName("Naruto")) {
			log.info(Naruto.toString())
		}
		log.info("")
	}

}

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args)
}
