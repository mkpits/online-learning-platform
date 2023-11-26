package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.Options;
import com.mkpits.learningplatform.repository.OptionsRepo;
import com.mkpits.learningplatform.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OptionsServiceImpl implements OptionsService {
    @Autowired
    OptionsRepo optionsRepo;
    @Override
    public List<Options> getQueAndOptByTag(String tag) {
        List<Options> optionsList = optionsRepo.findQueAndOptionByTag(tag);
        return optionsList;
    }
}
