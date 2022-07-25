package project_java.project.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import project_java.project.dto.PerformanceRequest;
import project_java.project.mapper.PerformanceMapper;
import project_java.project.models.Performance;
import project_java.project.repositories.PerformanceRepository;
import project_java.project.services.PerformanceService;
import project_java.project.utils.DuplicateCustomerException;
import project_java.project.utils.ObjectNotFoundException;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PerformanceServiceTest {
    @Mock
    private PerformanceRepository performanceRepository;

    @InjectMocks
    private PerformanceService performanceService;

    @InjectMocks
    private PerformanceMapper performanceMapper;

    @Test
    @DisplayName("Add a new PerformanceHappyFlow")
    public void createPerformanceTest() throws ParseException  {

        //arrange
        PerformanceRequest performanceRequest = new PerformanceRequest("The Wall", 100, "25/02/2024-12:00:00", "25/02/2024-15:00:30",4);
        Performance performance = performanceMapper.performanceRequestToPerformance(performanceRequest);
        PerformanceRequest savedPerformanceRequest =new PerformanceRequest("The Wall", 100, "25/02/2024-12:00:00", "25/02/2024-15:00:30",4);
        Performance savedPerformance = performanceMapper.performanceRequestToPerformance(savedPerformanceRequest);
        when(performanceRepository.addPerformance(performance)).thenReturn(savedPerformance);

        //act
        Performance result = performanceService.addPerformance(performance);

        //assert
        assertEquals(performance.getName(), result.getName());
        assertEquals(performance.getTicketPrice(), result.getTicketPrice());
        assertEquals(performance.getStart(), result.getStart());
        assertEquals(performance.getEnd(), result.getEnd());
        assertEquals(performance.getCategoryId(), result.getCategoryId());
        verify(performanceRepository, Mockito.times((1))).addPerformance(performance);

    }






}
