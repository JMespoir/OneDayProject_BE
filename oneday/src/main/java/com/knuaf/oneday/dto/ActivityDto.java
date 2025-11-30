package com.knuaf.oneday.dto;

import com.knuaf.oneday.entity.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ActivityDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String category;
        private String title;
        private String detail;
        private String year;
    }

    @Getter
    @Builder // 1. 빌더 패턴 추가
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String category;
        private String title;
        private String detail;
        private String year;

        // 2. Entity -> DTO 변환 메서드 추가 (핵심!)
        // 이 메서드는 public이라 외부에서 접근 가능합니다.
        public static Response from(Activity activity) {
            return Response.builder()
                    .id(activity.getId())
                    .category(activity.getCategory())
                    .title(activity.getTitle())
                    .detail(activity.getDetail())
                    .year(activity.getYear())
                    .build();
        }
    }
}