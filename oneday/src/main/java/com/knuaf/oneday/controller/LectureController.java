package com.knuaf.oneday.controller;

import com.knuaf.oneday.dto.LectureResponseDto;
import com.knuaf.oneday.service.CourseService; // 또는 LectureService
import com.knuaf.oneday.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecture") // URL 경로 구분
@RequiredArgsConstructor
public class LectureController {

    private final CourseService courseService;
    private final LectureService lectureService;

    // GET /api/lecture/list?semester=2024-2&keyword=컴퓨터
    @GetMapping("/list")
    public ResponseEntity<List<LectureResponseDto>> getLectureList(
            @RequestParam int semester, // 필수 파라미터
            @RequestParam(required = false) String keyword // 선택 파라미터 (없을 수 있음)
    ) {
        List<LectureResponseDto> lectures = lectureService.getLectureList(semester, keyword);
        return ResponseEntity.ok(lectures);
    }
    // 학년별/학기별 권장(기초) 시간표 조회 API
    // GET /api/lecture/standard?grade=1&semester=1
    @GetMapping("/standard")
    public ResponseEntity<List<LectureResponseDto>> getStandardCurriculum(
            @RequestParam int grade,    // 학년 (1, 2, 3, 4)
            @RequestParam int semester // 학기 (1:1학기 2:여름계절 3:2학기 4:겨울게절)
    ) {
        List<LectureResponseDto> standardList = lectureService.getStandardCourses(grade, semester);
        return ResponseEntity.ok(standardList);
    }
}