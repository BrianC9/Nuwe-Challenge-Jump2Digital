package com.bryan.bcnuwejump2digital.controller;

import com.bryan.bcnuwejump2digital.dto.ICountCompanyDTO;
import com.bryan.bcnuwejump2digital.model.Company;
import com.bryan.bcnuwejump2digital.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v2/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/orderByFounded/{direction}")
    public ResponseEntity<List<Company>> findAllAndOrderByFounded(@PathVariable String direction) {
        return ResponseEntity.ok(companyService.findAllAndOrderByFounded(direction));
    }

    @GetMapping("/orderBySize/{direction}}")
    public ResponseEntity<List<Company>> findAllAndOrderBySize(@PathVariable String direction) {
        return ResponseEntity.ok(companyService.findAllAndOrderBySize(direction));
    }

    @GetMapping("/countCompanies")
    public ResponseEntity<HashMap<String, List<ICountCompanyDTO>>> countByIndustry() {
        return ResponseEntity.ok(companyService.countByIndustrySizeAndFounded());
    }


}
