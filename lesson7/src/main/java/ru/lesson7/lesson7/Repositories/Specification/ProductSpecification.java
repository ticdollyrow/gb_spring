package ru.lesson7.lesson7.Repositories.Specification;

import org.springframework.data.jpa.domain.Specification;
import ru.lesson7.lesson7.Model.Product;

public class ProductSpecification {
    public static Specification<Product> costGreaterOrElseThan(Float cost){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost));
    }

    public static Specification<Product> costLessThanOrEqualTo(Float cost){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost));
    }
}
