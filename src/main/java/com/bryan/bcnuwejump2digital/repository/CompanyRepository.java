package com.bryan.bcnuwejump2digital.repository;

import com.bryan.bcnuwejump2digital.dto.ICountCompanyDTO;
import com.bryan.bcnuwejump2digital.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Query(
            value = """
                    select * 
                    from company 
                    order by case
                    when size = '1-10' then 1
                    when size = '11-50' then 2
                    when size = '51-200' then 3
                    when size = '201-500' then 4
                    when size = '501-1000' then 5
                    when size = '1001-5000' then 6
                    when size = '5001-10000' then 7
                    else 8
                    end
                    asc
                    """,
            nativeQuery = true)
    List<Company> findAllAndOrderBySizeAsc();

    @Query(
            value = """
                    select * 
                    from company 
                    order by case
                    when size = '1-10' then 1
                    when size = '11-50' then 2
                    when size = '51-200' then 3
                    when size = '201-500' then 4
                    when size = '501-1000' then 5
                    when size = '1001-5000' then 6
                    when size = '5001-10000' then 7
                    else 8
                    end
                    desc
                    """,
            nativeQuery = true)
    List<Company> findAllAndOrderBySizeDesc();

    @Query(value = "SELECT * FROM COMPANY ORDER BY FOUNDED DESC NULLS LAST", nativeQuery = true)
    List<Company> findAllAndOrderByFoundedDesc();

    @Query(value = "SELECT * FROM COMPANY ORDER BY FOUNDED ASC NULLS LAST", nativeQuery = true)
    List<Company> findAllAndOrderByFoundedAsc();

    @Query(value = "select industry ,count (id) as counter FROM COMPANY WHERE INDUSTRY IS NOT NULL group by (industry) order by counter DESC NULLS LAST", nativeQuery = true)
    List<ICountCompanyDTO> countByIndustry();

    @Query(value = "select founded ,count (id) as counter FROM COMPANY WHERE founded IS NOT NULL group by (founded) order by counter DESC NULLS LAST", nativeQuery = true)
    List<ICountCompanyDTO> countByFounded();

    @Query(value = "select size ,count (id) as counter FROM COMPANY WHERE size IS NOT NULL group by (size) order by counter DESC NULLS LAST", nativeQuery = true)
    List<ICountCompanyDTO> countBySize();
}
