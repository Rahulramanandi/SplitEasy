package com.rahul.spliteasy.service.interfaces;

import com.rahul.spliteasy.persistence.dto.report.ReportDTO;

import java.util.UUID;
import java.util.List;

public interface ReportService {

    List<ReportDTO> generateReport(UUID groupId);

    String exportReport(UUID groupId, String fileType);
}
