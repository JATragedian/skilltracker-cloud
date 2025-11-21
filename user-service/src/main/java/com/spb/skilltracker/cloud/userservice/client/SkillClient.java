package com.spb.skilltracker.cloud.userservice.client;

import com.spb.skilltracker.cloud.userservice.client.fallback.SkillClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "skill-service", fallback = SkillClientFallback.class)
public interface SkillClient {

    @GetMapping("/skills")
    List<String> getSkills();
}
