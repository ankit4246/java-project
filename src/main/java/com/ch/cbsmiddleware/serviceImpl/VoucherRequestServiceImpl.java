package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.AccountListRequest;
import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.AccountListResponse;
import com.ch.cbsmiddleware.dto.response.RequestVoucherData;
import com.ch.cbsmiddleware.models.TransactionDetail;
import com.ch.cbsmiddleware.repo.TransactionDetailRepo;
import com.ch.cbsmiddleware.service.VoucherRequestService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class VoucherRequestServiceImpl implements VoucherRequestService {

    private final TransactionDetailRepo transactionDetailRepo;
    private final MyBatisConfig myBatisConfig;

    @Override
    public RequestVoucherData requestVoucher(VoucherRequest voucherRequest) {


            SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(voucherRequest.getCbsClientCode());

            SqlSession session = factory.openSession();
            Map<String, Object> params = new HashMap<>();

            List<AccountListResponse> accounts = session.selectList("getAcountListByCustomerCode",params);

            session.close();




            TransactionDetail transactionDetail = transactionDetailRepo.findByTransactionId(voucherRequest.getTransactionId())
                .orElseThrow(RuntimeException::new);

        return RequestVoucherData.builder()
                .voucherNumber(transactionDetail.getVoucherNumber()).build();
    }
}
