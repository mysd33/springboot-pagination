package com.example;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.fw.web.page.PageInfoDialect;

@Configuration
public class WebConfig  implements WebMvcConfigurer{
	@Value("${pagination.maxPageSize:100}")
	private int maxPageSize;
	@Value("${pagination.defaultPage:0}")
	private int page;
	@Value("${pagination.defaultPageSize:5}")
	private int size;
	
	/**
	 * ページネーションの設定
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setMaxPageSize(maxPageSize);		
		resolver.setFallbackPageable(PageRequest.of(page, size));
		resolvers.add(resolver);
	}
	
	/**
	 * ページネーションのページリンクで使用するThymeleafのカスタムDialectの設定
	 */
	@Bean
	public PageInfoDialect pageInfoDialect() {
		return new PageInfoDialect();
	}
	
	/**
	 * ModelMappperの設定
	 * 
	 */
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
