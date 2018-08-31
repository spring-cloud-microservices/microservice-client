package com.quadbaze.microservice.client.feign.resource;

import com.quadbaze.microservice.client.feign.circuitbreaker.EmployeeSearchFallbackFactory;
import com.quadbaze.microservice.common.core.Route;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

/**
 * @author Olatunji O. Longe: Created on (29/05/2018)
 * Ref: http://nphumbert.github.io/blog/2017/07/23/setup-a-circuit-breaker-with-hystrix/
 */

@Service
@FeignClient(name = Route.Search.SERVICE_NAME, fallbackFactory = EmployeeSearchFallbackFactory.class)
public interface EmployeeSearchClient {

    @GetMapping("/search/employee/{id}")
    Object findById(@PathVariable(value = "id") Long id);

    @GetMapping("/search/employees")
    Collection<Object> findAll();
}
