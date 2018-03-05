package zw.co.tengahuku.mapperfacade;


import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory.Builder;
import org.joda.money.BigMoney;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import zw.co.tengahuku.utilities.DateTimePeriod;


@Configuration
public class OrikaMapperFactoryConfig {
	//DateTimePeriod dateTimePeriod;
	private static final Logger log = LoggerFactory.getLogger(OrikaMapperFactoryConfig.class);
	
	 public OrikaMapperFactoryConfig() {
	    }
	 
	 @Bean
	    public MapperFactory mapperFactory() {
	        log.debug("Configuring base mapper factory");
	        MapperFactory mapperFactory = (new Builder()).build();
	        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(new Type[]{BigMoney.class}));
	        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(new Type[]{LocalDate.class}));
	        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(new Type[]{LocalTime.class}));
	        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(new Type[]{ZonedDateTime.class}));
	        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(new Type[]{LocalDateTime.class}));
	        mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(new Type[]{ZoneOffset.class}));
	        //mapperFactory.getConverterFactory().registerConverter(new PassThroughConverter(new Type[]{dateTimePeriod}));
	        return mapperFactory;
	    }
	 
}
