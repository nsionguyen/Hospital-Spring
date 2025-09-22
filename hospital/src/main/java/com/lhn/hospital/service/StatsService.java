package com.lhn.hospital.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StatsService {
    List<Object[]> statsCountExaminedTotalAmount(Map <String,String> params);
    List<Object[]> statsDiagnosedCountExamined(Map <String,String> params);
    void timePredicate(CriteriaBuilder builder , Root<?> root, List<Predicate> predicates, Map<String, String> params, String timeFieldName);
}

