package org.controller.demo.SpringBoot_Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/basic")
public class BasicApi {
    @GetMapping("/")
    public String haiThere(){
        return "Welcome to Zealous";
    }
    //@GetMapping("/backends")
    @RequestMapping(value = "/backends",method = RequestMethod.GET)
    public List<String> heyThere(){
        return Stream.of("Flask","DJango","Express").collect(Collectors.toList());
    }
}
