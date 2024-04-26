package me.trinityfforce.esqueryserver.util;

import co.elastic.clients.elasticsearch._types.query_dsl.FuzzyQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;

public class ElasticsearchUtil {
    public static Supplier<Query> createSupplierQuery(String approximateProductName){
        return ()->Query.of(q->q.fuzzy(createFuzzyQuery(approximateProductName)));
    }


    public static FuzzyQuery createFuzzyQuery(String approximateProductName){
        val fuzzyQuery  = new FuzzyQuery.Builder();
        return  fuzzyQuery.field("class.name").value(approximateProductName).build();

    }
}
