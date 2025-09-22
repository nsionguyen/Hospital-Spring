//package com.lhn.hospital.service.impl;
//
//import com.lhn.hospital.repository.StatsRepository;
//import com.lhn.hospital.service.StatsService;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author LAPTOP
// */
//@Service
//public class StatsServiceImpl implements StatsService{
//
//    @Autowired
//    private StatsRepository statsRepository;
//
//    @Override
//    public List<Object[]> statsCountExaminedTotalAmount(Map<String, String> params) {
//        return statsRepository.statsCountExaminedTotalAmount(params);
//    }
//
//    @Override
//    public void timePredicate(CriteriaBuilder builder, Root<?> root, List<Predicate> predicates, Map<String, String> params, String timeFieldName) {
//        statsRepository.timePredicate(builder, root, predicates, params, timeFieldName);
//    }
//
//    @Override
//    public List<Object[]> statsDiagnosedCountExamined(Map<String, String> params) {
//        return statsRepository.statsDiagnosedCountExamined(params);
//    }
//
//}
