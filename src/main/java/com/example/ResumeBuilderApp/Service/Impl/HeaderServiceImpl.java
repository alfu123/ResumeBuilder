package com.example.ResumeBuilderApp.Service.Impl;

import com.example.ResumeBuilderApp.Dao.ExperienceDao;
import com.example.ResumeBuilderApp.Dao.HeaderDao;
import com.example.ResumeBuilderApp.Entity.Experience;
import com.example.ResumeBuilderApp.Entity.Header;
import com.example.ResumeBuilderApp.Service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderService {

    @Autowired
    HeaderDao headerDao;
    @Override
    public Header addHeaderDetails(Header header){


        return headerDao.save(header);
    }
}
