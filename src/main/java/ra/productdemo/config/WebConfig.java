package ra.productdemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// chú thích lớp cấu hinh
@Configuration
// cho phép sử dụng webb mvc
@EnableWebMvc
// tự đọng quét và phat hiện component (thành phần) để tạo Bean
@ComponentScan(basePackages = {"ra.productdemo"})
// Bean - là 1 thành phần của ứng dụng sử dụng nguyen lí singleton(đơn)
// Dependencies injection - tiêm phụ thuộc

public class WebConfig implements WebMvcConfigurer {

    // cấu hình view thông qua bean ViewResolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/views/");
        return resolver;
    }

    // cấu hình đường dẫn

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**","/js/**")
                .addResourceLocations("/css/","/js/");
    }
}
