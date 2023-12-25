package com.nirmal.springbooth2demo.service;

import com.nirmal.springbooth2demo.repository.SAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SAMServiceImpl implements SAMService {
    @Autowired
    private final SAMRepository samRepository;

    public SAMServiceImpl(SAMRepository samRepository) {
        this.samRepository = samRepository;
    }
}