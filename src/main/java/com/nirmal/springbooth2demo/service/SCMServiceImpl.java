package com.nirmal.springbooth2demo.service;

import com.nirmal.springbooth2demo.repository.SCMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCMServiceImpl implements SCMService {
    @Autowired
    private final SCMRepository scmRepository;

    public SCMServiceImpl(SCMRepository scmRepository) {
        this.scmRepository = scmRepository;
    }
}