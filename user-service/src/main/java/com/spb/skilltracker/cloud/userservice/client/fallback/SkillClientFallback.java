package com.spb.skilltracker.cloud.userservice.client.fallback;

import com.spb.skilltracker.cloud.userservice.client.SkillClient;

import java.util.List;

public class SkillClientFallback implements SkillClient {

    @Override
    public List<String> getSkills() {
        return List.of();
    }
}
