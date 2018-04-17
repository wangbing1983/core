package com.exorcist.msa.core.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping
public @interface RestApiController {
  String name() default "";

  @AliasFor("path")
  String[] value() default {"/api"};

  @AliasFor("value")
  String[] path() default {"/api"};

  RequestMethod[] method() default {};

  String[] params() default {};

  String[] headers() default {};

  String[] consumes() default {};

  String[] produces() default {};
}

