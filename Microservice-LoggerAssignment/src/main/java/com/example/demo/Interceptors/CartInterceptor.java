package com.example.demo.Interceptors;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartInterceptor implements HandlerInterceptor {

    final Logger log = LoggerFactory.getLogger(CartInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String customerId = request.getParameter("customerId");
            String customerName = request.getParameter("customerName");

            log.info("Date and Time of the request reaching the service: " + LocalDateTime.now().toString());
            log.info("Request being passed to the pre-handler.");

            if (!(customerName.length() == 10 && customerId.length() == 4 && customerName.matches("[a-zA-Z]+"))) {

                log.warn(
                        "customerId and customerName should follow 4 and 10 length criteria respectively, without any number and special character!!");
                log.info("Customer Id is " + customerId);
                log.info("Customer Name is " + customerName);
                ResponseEntity<String> errorResponse = ResponseEntity.badRequest().body(
                        "customerId and customerName should follow 4 and 10 length criteria respectively, without any number and special character!!");
                response.getWriter().write(errorResponse.getBody());
                response.setStatus(401);

                return false;
            }

            log.info("Request being passed to the service.");
            log.info("Customer Id is " + customerId);
            log.info("Customer Name is " + customerName);

            return true;
        } catch (Exception e) {
            log.error("Internal Server Error", e.getMessage());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.info(" Response recieved from service.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("Response sent to client");
    }

}
