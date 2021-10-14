package com.alassaneniang.holaspringboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping( path = "/api" )
public class HolaRestController {

    /* same as
    @RequestMapping(method=RequestMethod.GET, value="/hola", produces="text/plain")*/
    @GetMapping( path = "/hola", produces = "text/plain" )
    public String hola () throws UnknownHostException {

        String hostname;
        try {
            hostname = InetAddress
                    .getLocalHost()
                    .getHostAddress();
        } catch ( UnknownHostException exception ) {
            hostname = "unknown";
        }
        return "Hola Spring Boot de " + hostname;

    }
}
