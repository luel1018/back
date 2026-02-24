package org.example.back.db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/db")
@RestController
public class DbController {
    private final DbService dbService;

    public DbController(DbService dbService) {
        this.dbService = dbService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody DbDto dto) {
        dbService.create(dto);

        return ResponseEntity.ok("성공");
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable int idx) {
        DbDto dto = dbService.read(idx);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<DbDto> dtoList = dbService.list();

        return ResponseEntity.ok(dtoList);
    }
}
