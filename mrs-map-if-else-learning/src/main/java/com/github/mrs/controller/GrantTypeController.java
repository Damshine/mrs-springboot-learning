package com.github.mrs.controller;

import com.github.mrs.service.QueryGrantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 查询发放Controller
 * date: 2023/7/21 14:22
 * author: MR.孙
 */
@RestController
public class GrantTypeController {

    @Autowired
    private QueryGrantTypeService queryGrantTypeService;


    @GetMapping("/grantType")
    public String getGrantType(@RequestParam("resourceType") String resourceType) {

        return queryGrantTypeService.getResult(resourceType);

    }


}
