package com.zyy.mowa.config;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author USER
 * @date 2020/05/25
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(DatetoString);
        modelMapper.addConverter(StringToDate);
        return modelMapper;
    }

    /**
     * 自定义转换规则,将int的genderId翻译为String类型的gender，如1-->"女"
     */
    public static Converter<Date, String> DatetoString = new AbstractConverter<Date, String>() {
        @Override
        protected String convert(Date time) {
            String dateString;
            if (time != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateString = formatter.format(time);
            } else {
                dateString = null;
            }
            return dateString;
        }
    };
    public static Converter<String, Date> StringToDate = new AbstractConverter<String, Date>() {
        @Override
        protected Date convert(String time) {
            if (time != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ParsePosition pos = new ParsePosition(8);
                Date currentTime_2 = formatter.parse(time, pos);
                return currentTime_2;
            } else {
                return null;
            }

        }
    };

}
