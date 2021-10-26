package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.config.MyBatisConfig;
import com.ch.cbsmiddleware.dto.request.VoucherRequest;
import com.ch.cbsmiddleware.dto.response.RequestVoucherData;
import com.ch.cbsmiddleware.dto.response.VoucherData;
import com.ch.cbsmiddleware.models.Status;
import com.ch.cbsmiddleware.models.VoucherRequestLog;
import com.ch.cbsmiddleware.repo.VoucherRequestLogRepo;
import com.ch.cbsmiddleware.service.CsvFileWriter;
import com.ch.cbsmiddleware.service.VoucherRequestService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bimal on 9/26/21
 * @project cbs-middleware
 */
@Service
@RequiredArgsConstructor
public class VoucherRequestServiceImpl implements VoucherRequestService {

    private final VoucherRequestLogRepo voucherRequestLogRepo;
    private final CsvFileWriter csvFileWriter;
    private final MyBatisConfig myBatisConfig;

    @Override
    public RequestVoucherData requestVoucher(VoucherRequest request) {
        SqlSessionFactory factory = myBatisConfig.getSqlSessionFactory(request.getCbsClientCode());
        SqlSession session = factory.openSession();

        VoucherRequestLog voucherRequestLog = VoucherRequestLog.buildFromRequest(request);

        Map<String, Object> params = new HashMap<>();

        params.put("service", request.getService());
        params.put("mobileNumber", request.getMobileNumber());
        params.put("accountNumber", request.getAccountNumber());
        params.put("paymentAmount", request.getPaymentAmount());
        params.put("transactionTimestamp", request.getTransactionTimestamp());
        params.put("clientCommissionAmount", request.getClientCommissionAmount());
        params.put("customerCommissionAmount", request.getCustomerCommissionAmount());
        params.put("beneficiaryNumber", request.getBeneficiaryNumber());
        params.put("remarks", request.getRemarks());
        params.put("serviceCode", request.getServiceCode());
        params.put("serviceType", request.getServiceType());
        params.put("transactionId", 3545);
        params.put("bankName", request.getBankName());

        VoucherData voucherData = session.selectOne("requestVoucher", params);

        voucherRequestLog.setStatus(Status.COMPLETED);
        voucherRequestLog.setVoucherNumber(voucherData.getVoucherNumber());
        voucherRequestLog.setTransactionId(voucherData.getTransactionId());

        voucherRequestLogRepo.save(voucherRequestLog);
        csvFileWriter.writeVoucherRequest(voucherRequestLog);

        return RequestVoucherData.builder()
                .voucherNumber(voucherData.getVoucherNumber())
                .build();
    }
}
