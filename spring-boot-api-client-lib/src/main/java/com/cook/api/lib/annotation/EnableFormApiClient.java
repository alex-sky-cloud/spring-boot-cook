package com.cook.api.lib.annotation;

import com.cook.api.lib.configuration.FormApiClientConfiguration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(FormApiClientConfiguration.class)
public @interface EnableFormApiClient {}
