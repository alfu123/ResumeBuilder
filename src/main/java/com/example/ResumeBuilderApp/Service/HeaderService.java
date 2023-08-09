package com.example.ResumeBuilderApp.Service;

import com.example.ResumeBuilderApp.Dao.HeaderDao;
import com.example.ResumeBuilderApp.Entity.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {

    @Autowired
    HeaderDao headerDao;

    public Header addHeaderDetails(Header header){
        return headerDao.save(header);
    }
}
