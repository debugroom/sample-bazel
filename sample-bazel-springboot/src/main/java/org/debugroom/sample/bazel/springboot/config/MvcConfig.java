package org.debugroom.sample.bazel.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("org.debugroom.sample.bazel.springboot.app.web")
@Configuration
public class MvcConfig implements WebMvcConfigurer {
}
