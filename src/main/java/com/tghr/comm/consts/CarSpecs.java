package com.tghr.comm.consts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.tghr.car.model.Car;


public class CarSpecs {

    public enum SearchKey {
    	CARKIND("carKind"),  // 경차(L), 준중형(S), 중형(M), 대형(B), SUV(S), 기타(E) 
        FUEL("fuel"),
        NAME("carNm");

        private final String value;

        SearchKey(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static Specification<Car> searchWith(Map<SearchKey, Object> searchKeyword) {
        return (Specification<Car>) ((root, query, builder) -> {
            List<Predicate> predicate = getPredicateWithKeyword(searchKeyword, root, builder);
            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

    private static List<Predicate> getPredicateWithKeyword(Map<SearchKey, Object> searchKeyword, Root<Car> root, CriteriaBuilder builder) {
        List<Predicate> predicate = new ArrayList<>();
        for (SearchKey key : searchKeyword.keySet()) {
            switch (key) {
                case CARKIND:
                	predicate.add(builder.equal(
                            root.get(key.value),searchKeyword.get(key)));
                	 break;
                case FUEL:
                    predicate.add(builder.equal(
                            root.get(key.value), FUEL.valueOf(String.valueOf(searchKeyword.get(key)))));                   
                    break;
                case NAME:
                	predicate.add(builder.equal(
                            root.get(key.value),searchKeyword.get(key)));
//                    predicate.add(builder.greaterThan(
//                            root.get(key.value), Integer.valueOf(searchKeyword.get(key).toString())
//                    ));
                    break;
            }
        }
        return predicate;
    }
}
