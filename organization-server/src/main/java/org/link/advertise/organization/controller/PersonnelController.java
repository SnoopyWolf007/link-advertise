package org.link.advertise.organization.controller;

import lombok.extern.slf4j.Slf4j;
import org.link.advertise.core.entity.PersonnelInfo;
import org.link.advertise.core.model.LinkResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: changmingjiang
 * @Date: 2020/6/19 14:57
 */
@RestController
@RequestMapping("/personnel")
@Slf4j
public class PersonnelController {

    @PostMapping("/add")
    public LinkResponse add(@RequestBody PersonnelInfo personnelInfo){

        return LinkResponse.SUCCESS;
    }

    @PostMapping("/del")
    public LinkResponse del(@RequestParam("code") String code){

        return LinkResponse.SUCCESS;
    }

    @PostMapping("/findAll")
    public LinkResponse findAll(){

        return LinkResponse.SUCCESS;
    }
}
