package com.ch.cbsmiddleware.serviceImpl;

import com.ch.cbsmiddleware.models.LogMetaData;
import com.ch.cbsmiddleware.repo.LogMetaDataRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author bimal on 10/4/21
 * @project cbs-middleware
 */
@Service
public class CsvFileNameGenerator {

    public String generate(LogMetaDataRepo logMetaDataRepo, String logType){
        int durationInDays = 7;

        LogMetaData logMetaData = LogMetaData.builder()
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(durationInDays))
                .logType(logType)
                .build();

        Optional<LogMetaData> optionalLogMetaData =
                logMetaDataRepo.findByLogType(logMetaData.getLogType());


        if (optionalLogMetaData.isPresent()){
            logMetaData.setId(optionalLogMetaData.get().getId());

            if(LocalDate.now().isBefore(optionalLogMetaData.get().getEndDate())) {
                logMetaData
                        .setStartDate(optionalLogMetaData.get().getStartDate())
                        .setEndDate(optionalLogMetaData.get().getEndDate());
            }
        }
        logMetaDataRepo.save(logMetaData);
        String csvPath = "src/main/resources/log/" + logMetaData.getStartDate() + "_" + logMetaData.getEndDate()+"_"+logMetaData.getLogType();

        return csvPath;
    }
}
