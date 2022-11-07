package com.bryan.bcnuwejump2digital.service;

import com.bryan.bcnuwejump2digital.dto.ICountCompanyDTO;
import com.bryan.bcnuwejump2digital.model.Company;
import com.bryan.bcnuwejump2digital.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }


    public List<Company> findAll() {
        return repository.findAll();
    }

    public List<Company> findAllAndSortDescByFounded() {
        return repository.findAllAndOrderByFoundedDesc();
    }

    public List<Company> findAllAndSortAscByFounded() {
        return repository.findAllAndOrderByFoundedAsc();
    }

    public List<ICountCompanyDTO> countByIndustry() {
        return repository.countByIndustry();
    }

    public List<Company> findAllAndSortByFounded() {
        return repository.findAllAndOrderBySizeAsc();
    }

    public HashMap<String, List<ICountCompanyDTO>> countByIndustrySizeAndFounded() {
        HashMap<String, List<ICountCompanyDTO>> mapResponse = new HashMap<String, List<ICountCompanyDTO>>();

        mapResponse.put("countByIndustry", repository.countByIndustry());
        mapResponse.put("countByYearFounded", repository.countByFounded());
        mapResponse.put("countBySize", repository.countBySize());


        return mapResponse;
    }
}
