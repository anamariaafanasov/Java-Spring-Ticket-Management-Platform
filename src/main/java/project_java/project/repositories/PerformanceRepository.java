package project_java.project.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project_java.project.dto.PerformanceRequest;
import project_java.project.models.Performance;
import project_java.project.queries.PerformanceQueries;
import project_java.project.utils.ObjectNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PerformanceRepository {

    private JdbcTemplate jdbcTemplate;

    public PerformanceRepository(JdbcTemplate template){jdbcTemplate = template;}

    public Performance addPerformance(Performance performance){
        jdbcTemplate.update(PerformanceQueries.ADD_PERFORMANCE,performance.getName(),performance.getTicketPrice(),
                            performance.getStart(), performance.getEnd(), performance.getCategoryId());
        List <Performance> query = jdbcTemplate.query(PerformanceQueries.GET_PERFORMANCE_SQL, new BeanPropertyRowMapper<>(Performance.class));
        int last_id = query.get(query.size()-1).getId();
        performance.setId(last_id);
        return performance;
    }
    public List<Performance> getPerformances(){
        return jdbcTemplate.query(PerformanceQueries.GET_PERFORMANCE_SQL,new BeanPropertyRowMapper<>(Performance.class));
    }


    public List <Performance> getPerformancesByCategoryName(String category){
        List <Performance> query = jdbcTemplate.query(PerformanceQueries.GET_PERFORMANCES_BY_CATEGORY,new BeanPropertyRowMapper<>(Performance.class),category);
        if (query.size() != 0)
            return query;
        else
            return null;
    }

    public List <Performance> getPerformancesByRoomName(String room){
        List <Performance> query = jdbcTemplate.query(PerformanceQueries.GET_PERFORMANCES_BY_ROOM,new BeanPropertyRowMapper<>(Performance.class),room);
        if (query.size() != 0)
            return query;
        else
            throw new ObjectNotFoundException("The room" + room + "doesn't exist!!!");
    }

    public List<Performance> deletePerformanceById(int id){
        jdbcTemplate.update(PerformanceQueries.DELETE_PERFORMANCE,id);
        return jdbcTemplate.query(PerformanceQueries.GET_PERFORMANCE_SQL,new BeanPropertyRowMapper<>(Performance.class));
    }
}
