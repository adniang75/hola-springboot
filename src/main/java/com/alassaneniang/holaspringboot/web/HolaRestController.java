package com.alassaneniang.holaspringboot.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping( path = "/api" )
@ConfigurationProperties( prefix = "helloapp" )
public class HolaRestController {

    private String saying;

    /* same as
    @RequestMapping(method=RequestMethod.GET, value="/hola", produces="text/plain")*/
    @GetMapping( path = "/hola", produces = "text/plain" )
    public String hola () throws UnknownHostException {

        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostAddress();
        } catch ( UnknownHostException exception ) {
            hostname = "unknown";
        }
        return saying + " " + hostname;

    }

    public String getSaying () {
        return saying;
    }

    public void setSaying ( String saying ) {
        this.saying = saying;
    }
}
