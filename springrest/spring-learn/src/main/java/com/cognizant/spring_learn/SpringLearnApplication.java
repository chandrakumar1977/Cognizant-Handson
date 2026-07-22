package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        LOGGER.info("START");

        SpringApplication.run(SpringLearnApplication.class, args);

        displayDate();

        displayCountry();
        displayCountries();

        LOGGER.info("END");
    }
    public static void displayDate() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format =
                context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date", e);
        }

        LOGGER.info("END");
    }
    public static void displayCountry() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                context.getBean("country", Country.class);

        LOGGER.debug("Country : {}", country);

        LOGGER.info("END");
    }
    @SuppressWarnings("unchecked")
    public static void displayCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        java.util.ArrayList<Country> countries =
                context.getBean("countryList", java.util.ArrayList.class);

        LOGGER.debug("Country List : {}", countries);

        LOGGER.info("END");
    }
}