package com.quadbaze.microservice.client.feign.circuitbreaker;

import com.quadbaze.microservice.client.feign.resource.EmployeeSearchClient;
import com.quadbaze.microservice.common.core.MicroService;
import com.quadbaze.microservice.common.services.CircuitBreakerService;
import com.quadbaze.microservice.domain.entities.Employee;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Olatunji O. Longe: Created on (17/06/2018)
 */
@Component
public class EmployeeSearchFallbackFactory extends CircuitBreakerService implements FallbackFactory<EmployeeSearchClient> {

    @Override
    public EmployeeSearchClient create(Throwable throwable) {

        return new EmployeeSearchClient() {

            @Override
            public Object findById(Long id) {
                logConnectionException(throwable, MicroService.SEARCH);
                return new Employee();
            }

            @Override
            public Collection<Object> findAll() {
                logConnectionException(throwable, MicroService.SEARCH);
                return Arrays.asList(new Employee());
            }
        };
    }
}
