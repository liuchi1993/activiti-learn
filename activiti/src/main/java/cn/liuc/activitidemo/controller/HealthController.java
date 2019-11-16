package cn.liuc.activitidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019/11/16 14:28
 */
@RestController
@RequestMapping(value = "/health")
public class HealthController {

    @GetMapping
    public String health() {
        return "ok";
    }
}
