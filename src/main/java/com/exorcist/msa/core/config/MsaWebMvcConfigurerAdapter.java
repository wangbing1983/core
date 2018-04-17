package com.exorcist.msa.core.config;


import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class MsaWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
  public static final Charset UTF8 = Charset.forName("UTF-8");

  public MsaWebMvcConfigurerAdapter() {
  }

  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.clear();
    converters.add(this.getStringConverter());
    converters.add(this.getJsonConverter());
  }

  private HttpMessageConverter getJsonConverter() {
    MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
    List<MediaType> mediaTypes = Lists.newArrayList();
    mediaTypes.add(new MediaType("application", "json", UTF8));
    mediaTypes.add(new MediaType("application", "*+json", UTF8));
    mediaTypes.add(new MediaType(MediaType.TEXT_PLAIN, UTF8));
    messageConverter.setSupportedMediaTypes(mediaTypes);
    return messageConverter;
  }

  private HttpMessageConverter getStringConverter() {
    StringHttpMessageConverter messageConverter = new StringHttpMessageConverter();
    List<MediaType> mediaTypes = Lists.newArrayList();
    mediaTypes.add(new MediaType(MediaType.TEXT_PLAIN, UTF8));
    messageConverter.setSupportedMediaTypes(mediaTypes);
    return messageConverter;

