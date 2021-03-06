package com.github.diegopacheo.sandbox.java.spring.tx.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.github.diegopacheo.sandbox.java.spring.tx.domain.model.Person;

@Configuration
public class RedisConfiguration {
	
	 @Bean
   ReactiveRedisOperations<String, Person> redisOperations(ReactiveRedisConnectionFactory factory) {
		 	 Jackson2JsonRedisSerializer<Person> serializer = new Jackson2JsonRedisSerializer<>(Person.class);
       RedisSerializationContext.RedisSerializationContextBuilder<String, Person> builder = RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
       RedisSerializationContext<String, Person> context = builder.value(serializer).build();
       return new ReactiveRedisTemplate<>(factory, context);
   }
	
}
