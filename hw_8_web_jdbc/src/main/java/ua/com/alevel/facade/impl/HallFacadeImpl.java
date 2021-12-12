package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.hall.HallRequestDto;
import ua.com.alevel.dto.hall.HallResponseDto;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.facade.HallFacade;
import ua.com.alevel.sevice.HallService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallFacadeImpl implements HallFacade {

    private final HallService hallService;

    public HallFacadeImpl(HallService hallService) {
        this.hallService = hallService;
    }


    @Override
    public void create(HallRequestDto hallRequestDto) {
        Hall hall = new Hall();
        hall.setName(hallRequestDto.getName());
        hall.setNumOfSeats(hallRequestDto.getNumOfSeats());
        hallService.create(hall);
    }

    @Override
    public void update(HallRequestDto hallRequestDto, Long id) {
        Hall hall = hallService.findById(id);
        hall.setName(hallRequestDto.getName());
        hall.setNumOfSeats(hallRequestDto.getNumOfSeats());
        hallService.update(hall);
    }

    @Override
    public void delete(Long id) {
        hallService.delete(id);
    }

    @Override
    public HallResponseDto findById(Long id) {
        //TODO проверить на налл или даже опшинал
        Hall hall = hallService.findById(id);
        return new HallResponseDto(hall);
    }

    @Override
    public List<HallResponseDto> findAll() {
        return hallService.findAll()
                .stream()
                .map(HallResponseDto::new)
                .collect(Collectors.toList());
    }
}
