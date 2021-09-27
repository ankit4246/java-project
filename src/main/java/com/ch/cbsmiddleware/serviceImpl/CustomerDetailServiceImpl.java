package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.dto.request.CustomerDetailByCientCodeRequest;
import com.ch.cbsmiddleware.dto.request.CustomerDetailByCustomerCodeRequest;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByClientCodeResponse;
import com.ch.cbsmiddleware.dto.response.CustomerDetailByCustomerCodeResponse;
import com.ch.cbsmiddleware.service.CustomerDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project cbs-middleware
 * @Author mave on 9/26/21
 */
@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {

    @Override
    public CustomerDetailByCustomerCodeResponse getCustomerDetailByCustomerCode(CustomerDetailByCustomerCodeRequest customerDetailByCustomerCodeRequest) {
        CustomerDetailByCustomerCodeResponse customerDetailByCustomerCodeResponse = new CustomerDetailByCustomerCodeResponse(
                "cusCode103",
                "Manish Adhakari",
                "Thapa gau, Gokarneshwar",
                "98089736721",
                "branch103"
        );
        return customerDetailByCustomerCodeResponse;
    }

    @Override
    public List<CustomerDetailByClientCodeResponse> getCustomerDetailByClientCode(CustomerDetailByCientCodeRequest customerDetailByCientCodeRequest) {
        List<CustomerDetailByClientCodeResponse> customerDetailList = List.of(
                new CustomerDetailByClientCodeResponse(
                        "cusCode101",
                        "Binit Tripathi",
                        "Birgunj, Parsa",
                        "987323784937",
                        "branch101"
                ),
                new CustomerDetailByClientCodeResponse(
                        "cusCode102",
                        "Ajay Khadgi",
                        "Baneshwar, Kathmandu",
                        "998736491390",
                        "branch102"
                )
        );
          return customerDetailList;
    }
}
