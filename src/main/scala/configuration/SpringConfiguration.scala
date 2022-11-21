package cat.cultura.eventfinder
package configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EnableTransactionManagement
@Configuration
@Autowired
@EnableJpaRepositories(basePackages = Array("cat.cultura.eventfinder"))
class SpringConfiguration {

}
