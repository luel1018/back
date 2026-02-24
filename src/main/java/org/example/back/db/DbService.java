package org.example.spring01.db;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    private final DbRepository dbRepository;

    public DbService(DbRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public void create(DbDto dto) {
        dbRepository.create(dto);
    }

    public DbDto read(int idx) {
        return dbRepository.read(idx);
    }

    public List<DbDto> list() {
        return dbRepository.list();
    }
}
