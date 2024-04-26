package me.trinityfforce.esqueryserver.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "sagopalgo.item")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private Long id;

    @Field(name = "class", type = FieldType.Auto)
    private InnerClass itemInfo;

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Getter
    public static class InnerClass {
        private String name;
        @Field(name = "start_price", type = FieldType.Integer)
        private Integer startPrice;
        @Field(name = "bid_unit", type = FieldType.Integer)
        private Integer bidUnit;
        @Field(name = "bid_count", type = FieldType.Integer)
        private Integer bidCount;
        @Field(name = "start_date", type = FieldType.Date)
        private LocalDate startDate;
        private String url;
        @Field(name = "highest_price", type = FieldType.Integer)
        private Integer highestPrice;
        @Field(name = "view_count", type = FieldType.Integer)
        private Integer viewCount;
        private Long category_id;
        @Field(name = "user_id", type = FieldType.Long)
        private Long userId;
        private String status;
        private LocalDateTime created_at;
        private LocalDateTime deleted_at;
        private LocalDateTime modified_at;
    }
}
