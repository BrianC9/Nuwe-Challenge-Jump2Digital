package com.bryan.bcnuwejump2digital.service;

import com.bryan.bcnuwejump2digital.dto.ICountCompanyDTO;
import com.bryan.bcnuwejump2digital.exception.EndpointNotDefinedException;
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

    public List<Company> findAllAndOrderByFounded(String direction) {
        if (direction.equalsIgnoreCase("asc")) {
            return repository.findAllAndOrderByFoundedAsc();

        } else if (direction.equalsIgnoreCase("desc")) {
            return repository.findAllAndOrderByFoundedDesc();

        } else {
            throw new EndpointNotDefinedException("Specify asc for ascending or desc fro descending direction");
        }
    }

    public List<Company> findAllAndOrderBySize(String direction) {
        if (direction.equalsIgnoreCase("asc")) {
            return repository.findAllAndOrderBySizeAsc();

        } else if (direction.equalsIgnoreCase("desc")) {
            return repository.findAllAndOrderBySizeDesc();

        } else {
            throw new EndpointNotDefinedException("Specify asc for ascending or desc for descending direction");
        }
    }

    public HashMap<String, List<ICountCompanyDTO>> countByIndustrySizeAndFounded() {
        HashMap<String, List<ICountCompanyDTO>> mapResponse = new HashMap<String, List<ICountCompanyDTO>>();

        mapResponse.put("countByIndustry", repository.countByIndustry());
        mapResponse.put("countByYearFounded", repository.countByFounded());
        mapResponse.put("countBySize", repository.countBySize());


        return mapResponse;
    }
}
